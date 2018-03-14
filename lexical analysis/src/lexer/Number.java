package lexer;

public class Number extends Token{
	public final int value;
	public Number(int v) {
		super(""+v,Tag.NUM);
		value = v;
		// TODO 初始化标志，赋值数字对象
	}
	public String toStirng(){
		return ""+ value;
	}
}
