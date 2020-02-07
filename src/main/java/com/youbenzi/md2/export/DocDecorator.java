package com.youbenzi.md2.export;

import java.util.List;

import com.youbenzi.md2.markdown.Block;

public class DocDecorator implements Decorator{
	
	
	public void beginWork(String outputFilePath) {
	}
	
	public void decorate(List<Block> block) {
		throw new RuntimeException("暂未支持word doc文档的导出");
	}

	public void afterWork(String outputFilePath) {
		// TODO Auto-generated method stub
		
	}

}
