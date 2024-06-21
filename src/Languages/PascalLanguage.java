package Languages;

import java.util.ArrayList;
import java.util.List;

import testing.IReadable;
import testing.Token;
import translator.ILanguage;

public class PascalLanguage extends BasicLanguage{

	private static ArrayList<IReadable> readers = new ArrayList<IReadable>();
	public PascalLanguage() {
	}
	@Override
	public String showCode(ArrayList<Token> tokens, StringBuilder builder, String prefix) {
		return null;
	}
	
	
}
