package miniTranslators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import Languages.*;
import translator.ILanguage;
import testing.IReadable;
import testing.Token;

public abstract class BlockReader implements IReadable{
	
	private String name;
	protected String startBlock;
	protected String endBlock;
	protected String startText;
	protected String endText;
	protected String typeBlock;
	protected ArrayList<Token> childTokens = new ArrayList<Token>();

	
	public void setStartText(String start) {
		startText = start;
	}
	public void setEndText(String end) {
		endText = end;
	}
	public void setBlock(String type) {
		typeBlock = type;
	}
	public void setStartSymbol(String s) {
		startBlock = s;
	}
	public void setEndSymbol(String s) {
		endBlock = s;
	}
	
	public Token tryGetToken(String s) {
		int count;
		if(s.startsWith(getName())) {
			
			count = s.indexOf(startBlock);
			while(s.charAt(count)!='\n')
				count++;
			
		}
		else {
			return null;
		}
		
		if (s.length()<1) 
		{
				return null;
		}
		count+=2;
			while (count <s.length()) {
				Token token = null;
				int len = 0;
				if (!s.substring(count).startsWith(endBlock)) {
					for (IReadable reader : BasicLanguage.getLanguage().getReaders()) {
						Token tmp = reader.tryGetToken(s.substring(count));
						if (tmp == null)
							continue;
						if (len < tmp.getSize())
						{
							len = tmp.getSize();
							token = tmp;
						}
					}
					if (token == null) {
						return null;
					}
					childTokens.add(token);
					count += len;
				}
				else {
					
					if (s.substring(count).startsWith(endBlock) && ++count < s.length() ) {
						
						for(var i = 0; i<endBlock.length()-1;i++) {
							count++;
						}
						break;
					}
				}	
			}
			
			Token parentToken = new Token(typeBlock, s.substring(s.indexOf(startText)+startText.length(),s.indexOf(endText)));
			parentToken.setSize(count);
			parentToken.setChildTokens(childTokens);
			return parentToken;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Token> getChildTokens() {
		return childTokens;
	}
	public void setChildTokens(ArrayList<Token> childTokens) {
		this.childTokens = childTokens;
	}
}
