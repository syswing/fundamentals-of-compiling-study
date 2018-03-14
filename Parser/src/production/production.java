package production;

import java.io.IOException;

import lexer.Lexer;
import parser.Parser;

public class production {
	public static Lexer lex = new Lexer();
	public static Parser p = new Parser(lex);
	public static int s;
	public production() throws IOException{
		p.move();
		//System.out.println(p.look.tag);
		s=p.look.tag;
		zhengxing z = new zhengxing(s) ;
		P(z);
	}
	public void P(zhengxing z) throws IOException{
		System.out.println("P");
		switch(z.getA()){
		case 267 :
			C(z);
			p(z); 
			break;
		case 268 :
			V(z);
			S(z); 
			break;
		case 265:S(z); break;
		case 259:S(z); break;
		case 256:S(z); break;
		case 270:S(z); break;
		default :System.out.println("P error"); break;
		}
	}
	public void p(zhengxing z) throws IOException{
		System.out.println("p");
		switch(z.getA()){
		case 270:S(z); break;
		case 259:S(z); break;
		case 256:S(z); break;
		case 265:S(z); break;
		case 268:
			V(z);
			S(z); break;
		default :System.out.println("p error"); break;
		}
	}
	public void C(zhengxing z) throws IOException{
		System.out.println("C");
		switch(z.getA()){
		case 267: 
			System.out.println("匹配Const");
			p.move();
			z.setA(p.look.tag);;
			B(z);
			b(z);
			break;
		default:System.out.println("C error"); break;
		}
	}
	public void V(zhengxing z) throws IOException{
		System.out.println("V");
		switch(z.getA()){
		case 268: 
			System.out.println("匹配Var");
			p.move();
			z.setA(p.look.tag);;
			I(z);
			v(z);
			if(z.getA() == 59){
				System.out.println("匹配;");
				p.move();
				z.setA(p.look.tag);;
			}else{
				System.out.println("V error");
			}
			break;
		default: System.out.println("V error"); break;
		}
	}
	public void S(zhengxing z) throws IOException{
		System.out.println("S");
		switch(z.getA()){
		case 270:
			ES(z);
			break;
		case 259:
			T(z);
			break;
		case 256:
			K(z);
			break;
		case 265:
			O(z);
			break;
		case 258:break;
		case 266:break;
		case 59:break;
		default:System.out.println("S error"); break;
		}
	}
	public void I(zhengxing z) throws IOException{
		System.out.println("I");
		switch(z.getA()){
		case 270:
			System.out.println("匹配id");
			p.move();
			z.setA(p.look.tag);;
			v(z);
			//匹配;
			break;
		default:System.out.println("I error"); break;
		}
	}
	public void v(zhengxing z) throws IOException{
		System.out.println("v");
		switch(z.getA()){
		case 44:
			System.out.println("匹配,");
			p.move();
			z.setA(p.look.tag);
			I(z);
			v(z);
			break;
		case 59:
			break;
		default:System.out.println("v error"); break;
		}
	}
	public void B(zhengxing z) throws IOException{
		System.out.println("B");
		switch(z.getA()){
		case 270:
			System.out.println("匹配id");
			p.move();
			z.setA(p.look.tag);;
			if(z.getA() == 61){
				System.out.println("匹配=");
				p.move();
				z.setA(p.look.tag);
			}
			if(z.getA() == 260){
				System.out.println("匹配num");
				p.move();
				z.setA(p.look.tag);;
				break;
			}
			System.out.println("I=U error");
			break;
		default : System.out.println("B error"); break;
		}
	}
	public void b(zhengxing z) throws IOException{
		System.out.println("b");
		switch(z.getA()){
		case 44:
			System.out.println("匹配,");
			p.move();
			z.setA(p.look.tag);
			B(z);
			b(z);
			break;
		default :System.out.println("b error"); break;
		}
	}
	public void ES(zhengxing z) throws IOException{
		System.out.println("ES");
		switch(z.getA()){
		case 270:
			System.out.println("匹配id");
			p.move();
			z.setA(p.look.tag);;
			if(z.getA() == 61){
				System.out.println("匹配=");
				p.move();
				z.setA(p.look.tag);;
				E(z);
				break;
			}
			System.out.println("ES error");
			break;
		default:System.out.println("ES error"); break;
		}
	}
	public void T(zhengxing z) throws IOException{
		System.out.println("T");
		switch(z.getA()){
		case 259:
			System.out.println("匹配if");
			p.move();
			z.setA(p.look.tag);
			Q(z);
			if(z.getA() == 269){
				System.out.println("匹配then");
				p.move();
				z.setA(p.look.tag);
				S(z);
				t(z);
				break;
			}else{
				System.out.println("T Error");
			}
			System.out.println("T Error");
			break;
		default:System.out.println("T Error"); break;
		}
	}
	public void K(zhengxing z) throws IOException{
		System.out.println("K");
		switch(z.getA()){
		case 256:
			System.out.println("匹配while");
			p.move();
			z.setA(p.look.tag);
			Q(z);
			if(z.getA() == 257){
				System.out.println("匹配do");
				p.move();
				z.setA(p.look.tag);
				S(z);
				break;
			}else{
				System.out.println("K Error");
			}
			System.out.println("K Error");
			break;
		default:System.out.println("K Error"); break;
		}
	}
	public void O(zhengxing z) throws IOException{
		System.out.println("O");
		switch(z.getA()){
		case 265:
			System.out.println("匹配begin");
			p.move();
			z.setA(p.look.tag);;
			S(z);
			s(z);
			if(z.getA() == 266){
				System.out.println("匹配end");
				p.move();
				z.setA(p.look.tag);
				break;
			}else{
				System.out.println("O Error");
			}
			System.out.println("O Error");
			break;
		default:System.out.println("O Error"); break;
		}
	}
	public void t(zhengxing z) throws IOException{
		System.out.println("t");
		switch(z.getA()){
		case 258:
			System.out.println("匹配else");
			p.move();
			z.setA(p.look.tag);
			S(z);
			break;
		//case  S语言的问题 if语句嵌套if语句时 select出现交集
		default:System.out.println("t Error");break;
		}
	}
	public void Q(zhengxing z) throws IOException{
		System.out.println("Q");
		switch(z.getA()){
		case 43:
			E(z);
			X(z);
			E(z);
			break;
		case 45:
			E(z);
			X(z);
			E(z);
			break;
		case 270:
			E(z);
			X(z);
			E(z);
			break;
		case 260:
			E(z);
			X(z);
			E(z);
			break;
		case 40:
			E(z);
			X(z);
			E(z);
			break;
		default:System.out.println("Q Error"); break;
		}
	}
	public void s(zhengxing z) throws IOException{
		System.out.println("s");
		switch(z.getA()){
		case 59:
			System.out.println("匹配;");
			p.move();
			z.setA(p.look.tag);
			S(z);
			s(z);
			break;
		case 266:
			break;
		default:System.out.println("s Error"); break;
		}
	}
	public void X(zhengxing z) throws IOException{
		System.out.println("X");
		switch(z.getA()){
		case 261:
			System.out.println("匹配==");
			p.move();
			z.setA(p.look.tag);
			break;
		case 262:
			System.out.println("匹配>=");
			p.move();
			z.setA(p.look.tag);
			break;
		case 263:
			System.out.println("匹配<>");
			p.move();
			z.setA(p.look.tag);
			break;
		case 264:
			System.out.println("匹配<=");
			p.move();
			z.setA(p.look.tag);
			break;
		case 60:
			System.out.println("匹配<");
			p.move();
			z.setA(p.look.tag);
			break;
		case 62:
			System.out.println("匹配>");
			p.move();
			z.setA(p.look.tag);
			break;
		default:System.out.println("X Error"); break;
		}
	}
	public void E(zhengxing z) throws IOException{
		System.out.println("E");
		switch(z.getA()){
		case 43:
			a(z);
			N(z);
			n(z);
			break;
		case 45:
			a(z);
			N(z);
			n(z);
			break;
		case 40:
			N(z);
			n(z);
			break;
		case 270:
			N(z);
			n(z);
			break;
		case 260:
			N(z);
			n(z);
			break;
		default:System.out.println("E error"); break;
		}
	}
	public void a(zhengxing z) throws IOException{
		System.out.println("a");
		switch(z.getA()){
		case 40:break;
		case 270:break;
		case 260:
			break;
		case 43:
			A(z);
			break;
		case 45:
			A(z);
			break;
		default:System.out.println("a Error"); break;
		}
	}
	public void N(zhengxing z) throws IOException{
		System.out.println("N");
		switch(z.getA()){
		case 40:
			F(z);
			f(z);
			break;
		case 270:
			F(z);
			f(z);
			break;
		case 260:
			F(z);
			f(z);
			break;
		default:System.out.println("N Error"); break;
		}
	}
	public void n(zhengxing z) throws IOException{
		System.out.println("n");
		switch (z.getA()){
		case 43:
			A(z);
			N(z);
			n(z);
			break;
		case 45: 
			A(z);
			N(z);
			n(z);
			break;
		case 41:break;
		case 261:break;
		case 262:break;
		case 263:break;
		case 264:break;
		case 60:break;
		case 62:break;
		case 257:break;
		case 269:break;
		case 59:break;
		default:System.out.println("n Error"); break;
		}
	}
	public void A(zhengxing z) throws IOException{
		System.out.println("A");
		switch (z.getA()){
		case 43:
			System.out.println("匹配 +");
			p.move();
			z.setA(p.look.tag);;
			break;
		case 45:
			System.out.println("匹配 -");
			p.move();
			z.setA(p.look.tag);;
			break;
		default:System.out.println("A Error"); break;
		}
	}
	public void F(zhengxing z) throws IOException{
		System.out.println("F");
		switch(z.getA()){
		case 40:
			System.out.println("匹配(");
			p.move();
			z.setA(p.look.tag);
			E(z);
			if(z.getA() == 41){
				System.out.println("匹配）");
				p.move();
				z.setA(p.look.tag);
				break;
			}else{
				System.out.println("F Error");
			}
			break;
		case 260:
			System.out.println("匹配num");
			p.move();
			z.setA(p.look.tag);
			break;
		case 270:
			System.out.println("匹配id");
			p.move();
			z.setA(p.look.tag);
			break;
		default:System.out.println("F Error"); break;
		}
	}
	public void f(zhengxing z) throws IOException{
		System.out.println("f");
		switch(z.getA()){
		case 42:
			M(z);
			F(z);
			f(z);
			break;
		case 47:
			M(z);
			F(z);
			f(z);
			break;
		case 43:break;
		case 45:break;
		case 41:break;
		case 60:break;
		case 62:break;
		case 261:break;
		case 262:break;
		case 263:break;
		case 264:break;
		case 257:break;
		case 269:break;
		case 59: break;
		default:System.out.println("f Error"); break;
		}
	}
	public void M(zhengxing z) throws IOException{
		System.out.println("M");
		switch(z.getA()){
		case 42:
			System.out.println("匹配*");
			p.move();
			z.setA(p.look.tag);;
			break;
		case 47:
			System.out.println("匹配/");
			p.move();
			z.setA(p.look.tag);;
			break;
		default:System.out.println("M Error"); break;
		}
	}
}
