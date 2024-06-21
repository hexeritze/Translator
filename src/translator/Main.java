package translator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import JavaLang.*;
import Languages.BasicLanguage;
import Languages.JavaLanguage;
import Languages.PascalLanguage;
import PascalLang.*;
import testing.*;
import testing.Token;

public class Main {

	public String ReadFromFile(String patch) {
		String text = null;
		File file = new File(patch);
		
		if(!file.exists()) {
			System.out.print("File don't exists");
			return null;
		}
		if(file.length() == 0) {
			System.out.print("File is clear");
			return null;
		}
		
		try{
			Scanner scanner = new Scanner(file);
			scanner.useDelimiter("\\Z");
			text = scanner.next();
			scanner.close();
		}
		catch (FileNotFoundException e) { }
    	return text;
	}
	
	public static void main(String[] args) {
		Translator translator = new Translator();
		ILanguage java = new JavaLanguage();
		ILanguage pascal = new PascalLanguage();
		translator.register("Java", java);
		translator.register("Pascal", pascal);
		
		java.register(new JavaClassTranslator());
		java.register(new JavaMainReader());
		java.register(new JavaForTranslator());
		java.register(new StringReader());
		java.register(new IntReader());
		java.register(new WhiteSpaceReader());
		java.register(new JavaVarTranslator());
		java.register(new JavaPrintTranslator());
		java.register(new JavaAssignTranslator());
		java.register(new JavaSemicolonTranslator());
		java.register(new WordReader("a"));
		java.register(new WordReader("("));
		java.register(new WordReader(")"));
		java.register(new WordReader("+"));
		java.register(new WordReader("<"));
		java.register(new WordReader("i"));
		
		pascal.register(new PascalProgramTranslator());
		pascal.register(new PascalForTranslator());
		pascal.register(new PascalPrintTranslator());
		pascal.register(new WhiteSpaceReader());
		pascal.register(new IntReader());
		pascal.register(new PascalVarTranslator());
		pascal.register(new PascalAssignTranslator());
		pascal.register(new PascalSemicolonTranslator());
		pascal.register(new WordReader("a"));
		pascal.register(new WordReader(":"));
		pascal.register(new WordReader("i"));
		pascal.register(new WordReader("+"));
		String code = "Program Main;\r\n"
				+ "	\r\n"
				+ "begin\r\n"
				+ "    var a: integer := 0;\r\n"
				+ "    for i := 1 to 10 do begin\r\n"
				+ "        a:= a + 1;\r\n"
				+ "    end;\r\n"
				+ "    writeln(a);\r\n"
				+ "end.";
		System.out.println(translator.translate(pascal, java, code));
		
	}
	

}
