package PascalLang;

import miniTranslators.BlockReader;

public class PascalProgramTranslator extends BlockReader{
	public PascalProgramTranslator() {
		setStartText(" ");
		setEndText(";");
		setStartSymbol("begin");
		setEndSymbol("end.");
		setName("Program");
		setBlock("main");
	}
	
}
