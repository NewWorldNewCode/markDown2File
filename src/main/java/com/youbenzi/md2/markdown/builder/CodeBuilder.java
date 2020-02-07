package com.youbenzi.md2.markdown.builder;

import com.youbenzi.md2.markdown.Block;
import com.youbenzi.md2.markdown.BlockType;
import com.youbenzi.md2.markdown.ValuePart;

public class CodeBuilder implements BlockBuilder{

	private String content;
	public CodeBuilder(String content){
		this.content = content;
	}
	
	public Block bulid() {
		Block block = new Block();
		block.setType(BlockType.CODE);
		block.setValueParts(new ValuePart(content));
		return block;
	}

	public boolean isRightType() {
		return false;
	}

}
