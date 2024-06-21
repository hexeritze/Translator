package PascalLang;

import miniTranslators.BlockReader;

public class PascalForTranslator extends BlockReader{
	public PascalForTranslator() {
		setStartText(" ");
		setEndText("do");
		setStartSymbol("begin");
		setEndSymbol("end;");
		setName("for");
		setBlock("for");
	}
}
