package com.youbenzi.md2.markdown.builder;

import com.youbenzi.md2.markdown.BlockType;

public class UnorderedListBuilder extends ListBuilder{

	public UnorderedListBuilder(String content){
		super(content, BlockType.UNORDERED_LIST);
	}

	@Override
	public int computeCharIndex(String str) {
		return str.indexOf(" ");
	}
	
}
