package Languages;

import java.util.ArrayList;
import java.util.List;

import testing.IReadable;
import testing.Token;
import translator.ILanguage;

public abstract class BasicLanguage implements ILanguage{
	private ArrayList<IReadable> readers = new ArrayList<IReadable>();
	private static ILanguage language;
	public BasicLanguage() {};
	
	public static void setLanguage(ILanguage language) {
		BasicLanguage.language = language;
	}
	public static ILanguage getLanguage() {
		return BasicLanguage.language;
	}
	public ArrayList<Token> tokenize(String s) {
		ArrayList<Token> tokens = new ArrayList<Token>();
		while (s.length() !=0) {
			Token token = null;
			int len = 0;
			for (IReadable reader : language.getReaders()) {
				Token tmp = reader.tryGetToken(s);
				if (tmp == null)
					continue;
				if (len < tmp.getSize())
				{
					len = tmp.getSize();
					token = tmp;
				}
			}
			if (token == null)
				return null;
			tokens.add(token);
			s = s.substring(len);
		}
		return tokens;
	}
	
	public void register(IReadable reader) {
		readers.add(reader);
	}
	public ArrayList<IReadable> getReaders(){
		return readers;
	}
}
