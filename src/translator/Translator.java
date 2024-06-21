package translator;

import java.util.ArrayList;
import java.util.HashMap;

import Languages.BasicLanguage;
import testing.Token;

public class Translator {
	private HashMap<String,ILanguage> languages;
	
	public Translator() {
		languages = new HashMap<String, ILanguage>();
	}
	
	public void register(String name,ILanguage language) {
		languages.put(name,language);
	}
	public String translate(ILanguage language1,ILanguage language2, String source) {
		BasicLanguage.setLanguage(language1);
		ArrayList<Token> tokens = language1.tokenize(source);
		StringBuilder sb = new StringBuilder();
		BasicLanguage.setLanguage(language2);
		return language2.showCode(tokens, sb, "");
	}
}
