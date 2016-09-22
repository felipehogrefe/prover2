

public class AtoSentence extends Sentence{
	String value;
	
	public AtoSentence(String value, boolean not){
		this.value = value;
		this.not = not;
	}
	
	void setValue(String i) {
		this.value=i;
	}
	
	String getValue() {
		return this.value;
	}

}
