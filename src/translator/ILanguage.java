package translator;

import java.util.ArrayList;

import Languages.BasicLanguage;
import testing.IReadable;
import testing.Token;

public interface ILanguage {
	public void register(IReadable reader);
	public ArrayList<Token> tokenize(String s);
	public ArrayList<IReadable> getReaders();
	public String showCode(ArrayList<Token> tokens, StringBuilder builder,String prefix);
}
