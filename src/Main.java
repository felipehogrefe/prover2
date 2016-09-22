public class Main {

	public static void main(String[] args) {

		AtoSentence s1 = new AtoSentence("A",false);//A
		AtoSentence s2 = new AtoSentence("B",false);//B
		AtoSentence s3 = new AtoSentence("C",false);//C
		CompSentence s4 = new CompSentence(s1,s2,2,false);//A>B
		CompSentence s5 = new CompSentence(s2,s3,2,false);//B>C
		CompSentence s6 = new CompSentence(s1,s5,1,false);//A^(B>C)
		AtoSentence s8 = (AtoSentence) s1.negate().negate();//~~A
		CompSentence s9 = new CompSentence(s1,s5,2,false);//A>(B>C)
		CompSentence s12 = new CompSentence(s1,s2,0,false);//(AvB)
		CompSentence s13 = new CompSentence(s1,s3,0,false);//(AvC)
		AtoSentence s14 = (AtoSentence) s1.negate();//~A
		CompSentence s15 = new CompSentence(s2,s3,1,false);//(B^C)
		CompSentence s16 = new CompSentence(s12,s13,1,false);//(AvB)^(AvC)
		CompSentence s18 = new CompSentence(s2,s1,2,false);//B>A
		CompSentence s19 = new CompSentence(s4,s18,2,false);//(A>B)>(B>A)
		CompSentence s21 = new CompSentence(s1,s2,3,false);//A<>B
		AtoSentence s22 = new AtoSentence("D",false);//D
		AtoSentence s23 = new AtoSentence("S",false);//S
		CompSentence s24 = new CompSentence(s23,s22,1,false);//(S^D)
		CompSentence s25 = new CompSentence(s1,s24,3,false);//A<>(S^D)
		CompSentence s26 = new CompSentence(s24,s1,2,false);//(S^D)>A
		AtoSentence s29 = (AtoSentence) s2.negate();//~B
		CompSentence s30 = new CompSentence(s29,s3,1,false);//~B^C
		CompSentence s33 = new CompSentence(s3,s8,1,false);//C^~A
		AtoSentence s34 = new AtoSentence("R",false);//R
		AtoSentence s35 = new AtoSentence("X",false);//X
		AtoSentence s36 = (AtoSentence) s22.negate();//~D
		CompSentence s37 = new CompSentence(s36,s34,2,false);//(~D>R)
		CompSentence s38 = new CompSentence(s22,s34,0,false);//(DvR)
		CompSentence s41 = new CompSentence(s1,s36,0,false);//(Av~D)
		CompSentence s43 = new CompSentence(s23,s22,2,false);//(S>D)
		CompSentence s45 = new CompSentence(s1,s35,2,false);//(A>X)
		AtoSentence s47 = new AtoSentence("P",false);//P
		AtoSentence s48 = new AtoSentence("T",false);//T
		AtoSentence s49 = (AtoSentence) s47.negate();//~P
		AtoSentence s50 = (AtoSentence) s48.negate();//~T
		CompSentence s51 = new CompSentence(s49,s50,0,false);//(~Pv~T)
		CompSentence s52 = new CompSentence(s48,s35,2,false);//(T>X)
		CompSentence s55 = new CompSentence(s35,s48,2,false);//(X>T)
		CompSentence s57 = new CompSentence(s35,s48,0,false);//(XvT)
		

		//TESTE 1:-------------------------------------------------------------------------
		Database t1 = new Database();
		t1.addToDB(s1);
		t1.addToDB(s4);
		t1.addToDB(s5);
		//t1.search(s3);
		//TESTE 2:-------------------------------------------------------------------------
		Database t2 = new Database();
		t2.addToDB(s2);
		t2.addToDB(s8);
		t2.addToDB(s9);
		//t2.search(s3);
		//TESTE 3:-------------------------------------------------------------------------
		Database t3 = new Database();
		t3.addToDB(s14);
		t3.addToDB(s16);
		//t3.search(s15);
		//TESTE 4:-------------------------------------------------------------------------
		Database t4 = new Database();
		t4.addToDB(s4);
		t4.addToDB(s19);
		//t4.search(s21);
		//TESTE 5:-------------------------------------------------------------------------
		Database t5 = new Database();
		t5.addToDB(s24);
		t5.addToDB(s25);
		t5.addToDB(s26);
		//t5.search(s1);
		//TESTE 6:-------------------------------------------------------------------------
		Database t6 = new Database();	
		t6.addToDB(s4);
		t6.addToDB(s29);
		t6.addToDB(s30);	
		//t6.search(s33);
		//TESTE 7:-------------------------------------------------------------------------
		Database t7 = new Database();		
		t7.addToDB(s23);
		t7.addToDB(s37);
		t7.addToDB(s38);
		t7.addToDB(s41);
		t7.addToDB(s43);
		t7.addToDB(s45);
		//t7.search(s35);
		//TESTE 8:-------------------------------------------------------------------------
		Database t8 = new Database();
		t8.addToDB(s50);
		t8.addToDB(s51);
		t8.addToDB(s52);
		t8.addToDB(s55);
		t8.addToDB(s57);
		t8.search(s35);
		//---------------------------------------------------------------------------------	
		
	}

}
