package com.youbenzi.md2.export.builder;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.youbenzi.md2.export.Decorator;
import com.youbenzi.md2.export.PDFDecorator5x;

public class PDFDecoratorBuilder5x implements DecoratorBuilder{

	public Decorator build() {
		return new PDFDecorator5x(new Document(PageSize.A4));
	}

}
