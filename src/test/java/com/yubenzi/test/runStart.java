package com.yubenzi.test;

import java.io.File;
import java.util.List;

import com.markdown.dao.MarkdownDao;
import com.markdown.entity.Markdown;
import com.youbenzi.md2.export.FileFactory;

public class runStart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		MarkdownDao markdown = new MarkdownDao();
//    	List<Markdown> redsultsList = markdown.findUsers();
//    	for(Markdown tmp:redsultsList) {
//    		File file =new File(tmp.getContent());
    		try {
//  	          System.out.println(file.exists());
  	          String[] strs = {"pdf","html","docx"};
  	          String cotentString = "[This link](http://example.net/) has no title attribute.";
//  	          for (String s : strs) {
//  	              File newFile = new File(file.getParentFile().getParentFile(), "tmp/1." + s);
  	              FileFactory.produce(cotentString, "D:/2.pdf");
//  	              System.out.println(newFile.getAbsolutePath());
//  	          }
  	      } catch (Exception e) {
  	          e.printStackTrace();
  	      }
    	}
//	}

}
