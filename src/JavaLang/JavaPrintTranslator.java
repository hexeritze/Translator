package JavaLang;

import testing.IReadable;
import testing.Token;

public class JavaPrintTranslator implements IReadable{

	public JavaPrintTranslator() {};
	
	public Token tryGetToken(String s) {
		int count = 0;
		if(s.startsWith("System.out.println")) {
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
