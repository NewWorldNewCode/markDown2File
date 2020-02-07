package com.youbenzi.md2.markdown.builder;

import com.youbenzi.md2.markdown.BlockType;

public class OrderedListBuilder extends ListBuilder{

	public OrderedListBuilder(String content){
		super(content, BlockType.ORDERED_LIST);
	}
	
	@Override
	public int computeCharIndex(String str) {
		return str.indexOf(" ");
	}

}
