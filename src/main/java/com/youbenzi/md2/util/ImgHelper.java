package com.youbenzi.md2.util;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

//import org.apache.commons.httpclient.HttpClient;
//import org.apache.commons.httpclient.HttpStatus;
//import org.apache.commons.httpclient.methods.GetMethod;

public abstract class ImgHelper {

    public InputStream setImgByUrl(String url) {
        return setImgByUrl(url, true);
    }

    public InputStream setImgByUrl(String url, boolean getImgFromInternet) {
        if (!getImgFromInternet) {
            setIntoFile(null);
            return null;
        }
        HttpClient client = HttpClients.custom().build();
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2272.101 Safari/537.36");

        InputStream is = null;
        try {
            HttpResponse response = client.execute(httpGet);

            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                System.out.println("鏃犳硶鎶撳彇鍒板浘鐗囷紝鎶撳彇鍦板潃涓猴細" + url + ",鐘舵�佺爜涓猴細" + statusCode);
            } else {
                is = response.getEntity().getContent();
                setIntoFile(is);
            }
            return is;
        } catch (Exception e) {
            System.out.println("鏃犳硶鎶撳彇鍒板浘鐗囷紝鎶撳彇鍦板潃涓猴細" + url);
            System.out.println(e.getMessage());
            if (url.startsWith("https")) {
                System.out.println("鏀圭敤http鎶撳彇涓�娆″浘鐗�");
                url = url.replace("https", "http");
                setImgByUrl(url);
            } else {
                setIntoFile(null);
            }
        } finally {
            if (is != null) try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (httpGet != null) {
                httpGet.releaseConnection();
            }
        }
        return null;
    }

//	public InputStream setImgByUrl(String url, boolean getImgFromInternet){
//		if(!getImgFromInternet) {
//			setIntoFile(null);
//			return null;
//		}
//
//        HttpClient client = new HttpClient();
//        client.getParams().setSoTimeout(10000);	//鍥剧墖璇诲彇瓒呮椂鏃堕棿涓�10绉�
//        GetMethod method = null;
//        InputStream is = null;
//
//        try {
//        	method = new GetMethod(url);
//        	//浼鎴恈hrome娴忚鍣�
//        	method.addRequestHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2272.101 Safari/537.36");
//            int statusCode = client.executeMethod(method);
//            if(statusCode!=HttpStatus.SC_OK){
//            	System.out.println("鏃犳硶鎶撳彇鍒板浘鐗囷紝鎶撳彇鍦板潃涓猴細" + url + ",鐘舵�佺爜涓猴細"+statusCode);
//            }else{
//            	is = method.getResponseBodyAsStream();
//            	setIntoFile(is);
//            }
//            return is;
//        } catch (Exception e) {
//        	System.out.println("鏃犳硶鎶撳彇鍒板浘鐗囷紝鎶撳彇鍦板潃涓猴細" + url);
//        	System.out.println(e.getMessage());
//        	if(url.startsWith("https")){
//        		System.out.println("鏀圭敤http鎶撳彇涓�娆″浘鐗�");
//        		url = url.replace("https", "http");
//        		setImgByUrl(url);
//        	}else{
//        		setIntoFile(null);
//        	}
//        } finally{
//        	if(is!=null){
//        		try {
//					is.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//        	}
//        	if(method!=null){
//            	method.releaseConnection();
//        	}
//        }
//        return null;
//    }

    public int[] getImgWidthHeight(InputStream is) {
        int[] ia = new int[2];
        try {

            BufferedImage bi = ImageIO.read(is);
            ia[0] = bi.getWidth();
            ia[1] = bi.getHeight();

        } catch (Exception e) {

        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return ia;
    }

    public abstract void setIntoFile(InputStream is);
}
