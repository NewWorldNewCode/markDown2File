package com.youbenzi.md2.export.builder;

import com.youbenzi.md2.export.Decorator;
import com.youbenzi.md2.export.HTMLDecorator;

public class HTMLDecoratorBuilder implements DecoratorBuilder{

	public Decorator build() {
		return new HTMLDecorator();
	}

}
