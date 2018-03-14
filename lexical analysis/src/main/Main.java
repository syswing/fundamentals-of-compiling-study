package main;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import lexer.Lexer;
import lexer.Token;
import lexer.Word;
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Lexer lex = new Lexer(); 
		do{
			//temp.put((lex.scan().w),(lex.scan()));
			lex.scan();
		}while(Lexer.line<5);
		for (Map.Entry<String, Token> entry : lex.temp.entrySet()) {
			
			System.out.println("Key = " + entry.getKey() + ", Id = " + (entry.getValue()).tag);
				//System.out.println(((Word)entry.getValue()).lexeme);
		}
		System.out.println("\n" + "下面是保留字的输出");
		for (Entry<String, Word> entry : lex.words.entrySet()) {
			
			System.out.println("Key = " + entry.getKey() + ", Id = " + (entry.getValue()).tag);
				//System.out.println(((Word)entry.getValue()).lexeme);
		}
    } 
}


