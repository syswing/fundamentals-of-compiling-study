package lexer;

import java.io.*;
import java.util.*;

public class Lexer {
	public static int line = 1;
	char peek = ' ';
//	public Hashtable<String, Word> words = new Hashtable<String, Word>();
	public Map <String,Word> words = new HashMap<String,Word>();
	public Map <String,Token> temp = new HashMap<String,Token>();
	void reserve(Word w){
		words.put(w.lexeme, w);
	}//构造保留关键字的函数
	public Lexer(){
		reserve(new Word("if",Tag.IF));
		reserve(new Word("then",Tag.THEN));
		reserve(new Word("do",Tag.DO));
		reserve(new Word("while",Tag.WHILE));
		reserve(new Word("begin",Tag.BEGIN));
		reserve(new Word("end",Tag.END));
		reserve(new Word("Var",Tag.VAR));
		reserve(new Word("Const",Tag.CONST));
		reserve(new Word("else",Tag.ELSE));
	}//保留关键字
	void ReadChar()throws IOException{
		peek = (char)System.in.read();
	}
	boolean ReadChar(char c) throws IOException{
		ReadChar();
		if(peek!=c){
			return false;
		}
		peek=' ';
		return true;
	}//识别复合词法单元
	public Token scan() throws IOException{
		for(;;ReadChar()){
			if(peek==' '||peek=='\t'){
				continue;
			}else if(peek=='\n'){
				line++;
			}else{
				break;
			}
		}//开始读取字符，忽略空格，计算换行
		switch(peek){
		case '=':
			if(ReadChar('=')){
				temp.put("==", Word.eq);
				return Word.eq;
			}else{
				temp.put("=", new Token("=",'='));
				return new Token("=",'=');
			}
		case '<':
			if(ReadChar('=')){
				temp.put("<=", Word.le);
				return Word.le;
			}else if(ReadChar('>')){
				temp.put("<>", Word.ne);
				return Word.ne;
			}else{
				temp.put("<", new Token("<",'<'));
				return new Token("<",'<');
			}
		case '>':
			if(ReadChar('=')){
				temp.put(">=", Word.ge);
				return Word.ge;
			}else{
				temp.put(">", new Token(">",'>'));
				return new Token(">",'>');
			}
		}//这段判断，检测关系运算符，返回token类型
		if(Character.isDigit(peek)){
			int v = 0;
			do{
				v = 10 * v + Character.digit(peek, 10);
				ReadChar();
			}while(Character.isDigit(peek));//前一个比后一个权值＊10，从而获取数字的值value
			if(peek!='.'){
				if(peek==';')
				{
					line++;
					peek=' ';
					temp.put(""+v, new Number(v));
					return new Number(v);
				}
			}
		}//这段返回数字类型
		if(Character.isLetter(peek)){
			StringBuffer b = new StringBuffer();
			do{
				b.append(peek);
				ReadChar();
			}while(Character.isLetter(peek));
			String s = b.toString();
			Word w = (Word)words.get(s);
			if(w!=null){
				temp.put(s, w);
				return w;//如果是保留字，直接返回
			}else{
				w = new Word(s,Tag.ID);
				words.put(s, w);
				temp.put(s, w);
				return w;
			}//如果不是保留字，是变量放入哈希表
		}//这段判断字符串类型输入
		
		
		Token tok = new Token(""+peek,peek);
		temp.put(""+peek, tok);
		peek = ' ';
		return tok;
		//如果什么都不是保留并返回
		
	}//返回Token类型
}
