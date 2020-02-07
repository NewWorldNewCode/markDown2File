package com.youbenzi.md2.export;

import java.util.List;

import com.youbenzi.md2.markdown.Block;

public interface Decorator {
	
	public void beginWork(String outputFilePath);
	
	public void decorate(List<Block> list);
	
	public void afterWork(String outputFilePath);
	
}
