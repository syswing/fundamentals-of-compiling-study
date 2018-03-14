package parser;

import java.io.IOException;

import lexer.Lexer;
import lexer.Token;

public class Parser {
	private Lexer lex;
	public Token look;
	public Parser(Lexer l){
		lex = l;
		//move();
	}
	public void move() throws IOException{
		look = lex.scan();
	}
	
	
}
