package com.youbenzi.md2.markdown.builder;

import com.youbenzi.md2.markdown.BlockType;
import com.youbenzi.md2.markdown.MDToken;

public class QuoteBuilder extends ListBuilder{

	public QuoteBuilder(String content){
		super(content, BlockType.QUOTE);
	}

	@Override
	public int computeCharIndex(String str) {
		return str.indexOf(MDToken.QUOTE);
	}
}
