package lexer;

public class Tag {
	public final static int 
	WHILE = 256, DO = 257, ELSE = 258, IF = 259, NUM = 260,
	EQ = 261,/* == */ GE = 262,/* >= */ NE = 263,/* <> */
	LE = 264,/* <= */ BEGIN = 265, END = 266, CONST = 267, VAR = 268,
	THEN = 269,ID = 270;
	//标志,要求在ASCII表外,以防在转化时出错 
}
