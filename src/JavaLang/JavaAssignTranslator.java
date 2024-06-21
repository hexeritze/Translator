package JavaLang;

import testing.IReadable;
import testing.Token;

public class JavaAssignTranslator implements IReadable{

	public Token tryGetToken(String s) {
		if(s.startsWith("=")) {
			Token token = new Token("assign", "=");
			token.setSize(1);
			return token;
		}
		return null;
	}

}
