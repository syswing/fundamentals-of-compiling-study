package lexer;

public class Word extends Token{
	public String lexeme="";
	public Word(String s,int tag) {
		super(s,tag);
		lexeme = s;
		// TODO Auto-generated constructor stub
	}
	public static final Word
		eq = new Word("==",Tag.EQ),
		ne = new Word("<>",Tag.NE),
		ge = new Word(">=",Tag.GE),
		le = new Word("<=",Tag.LE);
}//保留的word
