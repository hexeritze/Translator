package JavaLang;

import miniTranslators.BlockReader;

public class JavaClassTranslator extends BlockReader{
	
	public JavaClassTranslator() {
		setStartText("class");
		setEndText("\n");
		setStartSymbol("{");
		setEndSymbol("}");
		setName("public class");
		setBlock("class");
	}
}
