

public class Sentence implements Cloneable{
	boolean not;
	
	public String toString(){
		String out = "";
		if(this.not){
			out+="~";
		}
		if(this instanceof AtoSentence){
			AtoSentence ato = (AtoSentence) this;
			out+=ato.getValue();
		}else{
			CompSentence aux = (CompSentence) this;
			out+="(";
			out+=aux.getLSent().toString();
			switch(aux.getOpr()){
				case 0:
					out+="v";
					break;
				case 1:
					out+="^";
					break;
				case 2:
					out+=">";
					break;
				case 3:
					out+="<>";
					break;
				default:
					break;
				}
			out+=aux.getRSent().toString();
			out+=")";
			}
		return out;		
		}
	
	public void print(){
		System.out.print(this.toString());
	}
	
	public boolean equals(Sentence s1){
		if(this.toString().equals(s1.toString())){
			return true;
		}
		return false;
	}
	
	public Sentence clone()	throws CloneNotSupportedException{
		Sentence s = (Sentence) super.clone();
		if(s instanceof CompSentence){
			CompSentence s1 = (CompSentence) s;
			if(s1.lSent instanceof CompSentence){
				CompSentence s2 = (CompSentence) s1.lSent;
				s1.lSent = new CompSentence(s2.lSent.clone(),s2.rSent.clone(),s2.opr,s2.not);
			}
			if(s1.rSent instanceof CompSentence){
				CompSentence s2 = (CompSentence) s1.rSent;
				s1.rSent = new CompSentence(s2.lSent.clone(),s2.rSent.clone(),s2.opr,s2.not);
			}
			s=s1;
		}		
		return s;	
	}
	


	void setOpr(int i) {}
	int getOpr() {
		return 0;
	}

	public Sentence negate(){
		Sentence s;
		try {
			s = (Sentence) this.clone();
			if(s instanceof AtoSentence){
				AtoSentence as = (AtoSentence) s;
				if(as.getValue().matches("[01]")){
					int i = Integer.parseInt(as.getValue());
					i = 1-i;
					as.setValue(i+"");
				}else{
					as.not=!as.not;
				}
				s=as;
			}else{
				CompSentence cs = (CompSentence) s;
				if(cs.opr==2){
					cs=cs.negateWImp();
				}else if(cs.opr==3){
					cs=cs.negateWBImp();
				}else{
					cs.opr=cs.opr^1;
					cs.lSent = cs.lSent.negate();
					cs.rSent = cs.rSent.negate();
				}
				s=cs;
			}
			return s;
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
