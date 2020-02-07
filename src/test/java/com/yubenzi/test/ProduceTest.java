package com.yubenzi.test;

import java.io.File;

import org.junit.Ignore;
import org.junit.Test;

import com.youbenzi.md2.export.FileFactory;
import com.youbenzi.md2.util.MDUtil;

public class ProduceTest {

    @Test
    public void test() {
    	long start = System.currentTimeMillis();
    	System.out.println("start:"+start);
        File file = new File(ProduceTest.class.getResource("/md_for_test.md").getFile());
        try {
            System.out.println(file.exists());
           // String[] strs = {"pdf","html","docx"};
            String[] strs = {"pdf","docx"};
            for (String s : strs) {
                File newFile = new File(file.getParentFile().getParentFile(), "tmp/test." + s);
                FileFactory.produce(file, newFile.getAbsolutePath());
                System.out.println(newFile.getAbsolutePath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("end:"+end);
        long cost = System.currentTimeMillis()-start;
        System.out.println("cost:"+cost);
//        System.out.println(MDUtil.markdown2Html("[**开源中国**](http://www.oschina.net)社区，是一个很不错的网站。欢迎上去查找开源软件，吐吐槽！"));
//        System.out.println(MDUtil.markdown2Html(file));
    }
}