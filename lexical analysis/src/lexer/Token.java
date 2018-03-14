package lexer;

public class Token {
	public final int tag;
	public String w= "";
	public Token(String a,int t){
		tag = t;
		w = a;
		//System.out.println(w);
	}
	public String toString(){
		return ""+(char)tag;
	}
}
