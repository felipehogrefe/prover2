

public class CompSentence extends Sentence{
	Sentence lSent;
	Sentence rSent;
	int opr; // 0: OR, 1: AND, 2: >, 3: <>
	
	public CompSentence(Sentence s0, Sentence s1, int i, boolean not) {
		this.lSent=s0;
		this.rSent=s1;
		this.opr=i;
		this.not=not;
	}
	
	CompSentence negateWImp() throws CloneNotSupportedException{
		CompSentence cs = (CompSentence) this.clone();
		cs.opr=1;
		cs.rSent=cs.rSent.negate();
		return cs;
	}
	
	CompSentence negateWBImp() throws CloneNotSupportedException{
		CompSentence cs = (CompSentence) this.clone();
		cs.opr = 1;
		cs.rSent=cs.rSent.negate();
		CompSentence csr = new CompSentence(this.rSent.clone(),this.lSent.clone().negate(),1,false);		
		CompSentence s = new CompSentence(cs,csr,0,false);
		return s;
	}

	int getOpr() {
		return this.opr;
	}
	
	void setOpr(int i) {
		this.opr = i;
	}

	public Sentence getLSent() {
		return this.lSent;
	}
	public Sentence getRSent() {
		return this.rSent;
	}

}
