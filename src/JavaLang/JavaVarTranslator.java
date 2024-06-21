package JavaLang;

import testing.IReadable;
import testing.Token;

public class JavaVarTranslator implements IReadable{
	private String[] primitives = new String[] {"byte","integer","double","boolean","char","String"};
	public JavaVarTranslator() {
		
	}

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
