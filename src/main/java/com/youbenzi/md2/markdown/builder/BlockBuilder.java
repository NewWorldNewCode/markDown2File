package com.youbenzi.md2.markdown.builder;

import com.youbenzi.md2.markdown.Block;

/**
 * markdown语法块
 * @author yangyingqiang
 * 2015年4月22日 上午11:44:22
 */
public interface BlockBuilder {

	/**
	 * 创建语法块
	 * @return 结果
	 */
	public Block bulid();
	
	/**
	 * 检查内容是否属于当前语法块
	 * @return 结果
	 */
	public boolean isRightType();
}
