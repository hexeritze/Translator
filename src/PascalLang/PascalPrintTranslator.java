package PascalLang;

import miniTranslators.BlockReader;
import testing.IReadable;
import testing.Token;

public class PascalPrintTranslator implements IReadable{
	public PascalPrintTranslator() {
	}

	public Token tryGetToken(String s) {
		int count = 0;
		if(s.startsWith("writeln")) {
			count = s.indexOf("(");
			while(s.charAt(count)!=';') {
				count++;
			}
			Token token = new Token("print",s.substring(s.indexOf("(")+1,s.indexOf(")")));
			token.setSize(count);
			return token;
		}
		return null;
	}
}
