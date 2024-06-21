package Languages;

import java.util.ArrayList;
import java.util.List;

import testing.IReadable;
import testing.Token;
import translator.ILanguage;

public class JavaLanguage extends BasicLanguage {
	
	private static ArrayList<IReadable> readers = new ArrayList<IReadable>();
	public JavaLanguage() {
	}
	@Override
	public String showCode(ArrayList<Token> tokens, StringBuilder builder, String prefix) {
		for(var token: tokens) {
			switch (token.getType()) {
			case ("main"):
				builder.append("Public class " + token.getText() +"\n");
				builder.append("{\n");
				builder.append("    public static void main(String[] args)\n");
				builder.append("    {\n");
				if(token.getChildTokens().size()!=0) {
					builder.append("    ");
					showCode(token.getChildTokens(),builder,prefix+"    ");
				}
				builder.append("    }\n");
				builder.append("}\n");
				break;
			case ("Var"):
				if(token.getText().equals("var"))
					break;
				else {
					builder.append(token.getText());
					break;
				}
			case ("for"):
				builder.append(prefix);
				builder.append("for(");
				String[] in = token.getText().split("[ :=]+");
				builder.append("int "+in[0]);
				builder.append(" = "+in[1]+"; ");
				if(in[2].equals("to")) {
					builder.append(in[0]+" < "+in[3]+"; ");
				}
				else {
					builder.append(in[0]+" > "+in[3]+"; ");
				}
				builder.append(in[0]+"++)");
				builder.append("{\n");
				if(token.getChildTokens().size()!=0) {
					builder.append(prefix);
					showCode(token.getChildTokens(),builder,prefix+"    ");
				}
				builder.append(prefix+"}\n");
				break;
			case("print"):
				builder.append(prefix);
				builder.append("System.out.println("+token.getText()+")");
				break;
			case("assign"):
				builder.append("=");
				break;
			case("keyword"):
				if(!token.getText().equals(":"))
					builder.append(token.getText());
				break;
			default:
				builder.append(token.getText());
				break;
			}
			
			
		}
		return builder.toString();
	};
	
}
