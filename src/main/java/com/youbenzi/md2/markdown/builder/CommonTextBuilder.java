package com.youbenzi.md2.markdown.builder;

import java.util.List;

import com.youbenzi.md2.markdown.Block;
import com.youbenzi.md2.markdown.BlockType;
import com.youbenzi.md2.markdown.MDAnalyzer;
import com.youbenzi.md2.markdown.ValuePart;

public class CommonTextBuilder implements BlockBuilder{

	private String content;
	public CommonTextBuilder(String content){
		this.content = content;
	}
	
	public Block bulid() {
		Block block = new Block();
		
		block.setType(BlockType.NONE);
		List<ValuePart> list = MDAnalyzer.analyzeTextLine(content);
		block.setValueParts(list);
		
		return block;
	}

	public boolean isRightType() {
		return true;
	}

}
