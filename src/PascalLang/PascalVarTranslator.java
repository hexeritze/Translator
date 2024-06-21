package PascalLang;

import testing.IReadable;
import testing.Token;

public class PascalVarTranslator implements IReadable{

	private String[] primitives = new String[] {"var","byte","integer","double","boolean","char","String"};
	
	public PascalVarTranslator() {};
	
	public Token tryGetToken(String s) {
		int count;
		for(var p : primitives) {
			if(s.startsWith(p)) {
				count = s.indexOf(" ");
			}
			else {
				continue;
			}
			Token token = new Token("Var",p);
			token.setSize(count);
			return token;
		}
		return null;
	}

}
