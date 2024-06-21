package PascalLang;

import testing.IReadable;
import testing.Token;

public class PascalAssignTranslator implements IReadable{

	public Token tryGetToken(String s) {
		if(s.startsWith(":=")) {
			Token token = new Token("assign", ":=");
			token.setSize(2);
			return token;
		}
		return null;
	}
}
