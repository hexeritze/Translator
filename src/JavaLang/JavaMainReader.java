package JavaLang;

import java.util.ArrayList;
import java.util.Collections;

import Languages.JavaLanguage;
import miniTranslators.BlockReader;
import testing.IReadable;
import testing.Lexer;
import testing.Token;
import testing.WhiteSpaceReader;
import testing.WordReader;
import testing.basicClass;

public class JavaMainReader extends BlockReader {
	
	public JavaMainReader() {
		setStartText("(");
		setEndText(")");
		setStartSymbol("{");
		setEndSymbol("}");
		setName("public static void main(String[] args)");
		setBlock("main");
	}
	
}
