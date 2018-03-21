编译原理
- 词法分析
- 语法分析

非终结符index
***
程序:P		 	 	常量说明:C		无符号整数:U
字母:l		 	 	数字:D				标识符:I
变量说明:V	 	语句:S				赋值语句:ES
表达式:E	     	项:N					因子:F
加法运算符:A	乘法运算符:M	条件语句:T
条件:Q				关系运算符:X	 当循环语句:K
复合语句:O		常量定义:B
***
##ll1语法
* P->CS				P->S			select集有交集，提取左因子
   P->S				P->VS			 
   P->VS			P->CP'
* P->CVS			P'->S
*						P'->VS
						C->Const BB'
						B'->,BB'
						B'->null
						B->I=U
						U->DD'
						D'->DD'
						D'->null
						L->a|b|...|z
						D->0|1|2...|9
						I->LI'
						I'->LI'
						I'->DI'
						I'->null
						V->Var I V'
						V'->,I V'
						V'->null
						S->ES|T|K|O|null
						ES->I=E
						E->A'NN'
						N'->ANN'
						N'->null
						A'->null
						A'->A
						A->+|-
						N->FF'
						F'->MFF'
						F'->null
						F->I|U|(E)
						M->*|/
						T->if Q then ST'
						T'->else S
						T'->null
						Q->EXE
						X->==|<=|<|>|>=|<>
						K->while Q do S
						O->begin SS' end
						S'->;S S'
						S'->null  
##SELECT集		
* 	select(P->S)={id,if,while,begin,null,$}
* 	select(P->CP')={Const}
* 	select(P'->S)={id,if,while,begin,null,$}
* 	select(P->VS)={Var}
* 	select(P'->VS)={Var}
* 	select(C->Const BB')={Const}
* 	select(B'->,BB')={,}
* 	select(B->I=U)={id}
* 	select(B'->null)={$,null}
<!--<!--* 	select(U->DD')={0-9}-->
<!--* 	select(D'->DD')={0-9}-->
<!--* 	select(D'->null)={$,null}-->
<!--* 	select(L->a|b|c...|z)={a-z}-->
<!--* 	select(D->0|1|2...|9)={0-9}-->
<!--* 	select(I->LI')={a-z}-->
<!--* 	select(I'->LI')={a-z}-->
<!--* 	select(I'->DI')={0-9}-->
<!--* 	select(I'->null)={null,$,=}-->
* 	select(V->Var IV';)={Var}   Var a,b;
* 	select(V'->,IV')={,}
* 	select(V'->null)={;,null}  
* 	select(S->ES|T|K|O|null)={id,if,while,begin,null,end,;,$,else}
* 	select(ES->I=E)={id}
* 	select(E->A'NN')={+,-}
* 	select(E->NN')={(,a-z,0-9}
* 	select(N'->ANN')={+,-}
* 	select(N'->null)={null,),==,<=,>,<,>=,<>,do,then,;}/
* 	select(A'->null)={null,(,id,un}
* 	select(A'->A)={+,-}
* 	select(A->+|-)={+.-}
* 	select(N->FF')={(,a-z,0-9}
* 	select(F'->MFF')={*,/}
* 	select(F'->null)={null,+,-,),==,<=,>,<,>=,<>,do,then,;}/
* 	select(F->I|U|(E))={(,a-z,0-9}
* 	select(M->*|/)={ *,/}
* 	select(T->if Q then ST')={if}
* 	select(T'->else S)={else}
* 	select(T'->null)={null,$,;,else,end}  遗留问题
* 	select(Q->EXE)={+,-,0-9,a-z,(}
* 	select(X->==|<=|<|>|>=|<>)={==,<=,>,<,>=,<>}
* 	select(K->while Q do S)={while}
* 	select(O->begin SS' end)={begin}
* 	select(S'->;SS')={;}
* 	select(S'->null)={null,end}		