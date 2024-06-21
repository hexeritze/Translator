package JavaLang;

import miniTranslators.BlockReader;
import testing.IReadable;
import testing.Token;

public class JavaForTranslator extends BlockReader{
	public JavaForTranslator () {
		setStartText("(");
		setEndText(")");
		setStartSymbol("{");
		setEndSymbol("}");

		setName("for");
		setBlock("for");
	}

}
