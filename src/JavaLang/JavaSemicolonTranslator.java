package JavaLang;

import testing.IReadable;
import testing.Token;

public class JavaSemicolonTranslator implements IReadable{

	public Token tryGetToken(String s) {
		if(s.startsWith(";")) {
			Token token = new Token("semicolon",";");
			token.setSize(1);
			return token;
		}
		return null;
	}

}
