

import java.util.ArrayList;

public class Database {
	ArrayList <Sentence> sentences;
	
	public Database(){
		this.sentences = new ArrayList<Sentence>();
	}
	
	public boolean addToDB(Sentence s){
		for(Sentence i : sentences){
			if(s.equals(i)){
				return false;
			}
		}
		sentences.add(s);
		return true;
	}
	
	public void search(Sentence s){
		boolean isTrue = false;
		this.expand();
		for(Sentence i : this.sentences){
			if(i.equals(s)){
				isTrue=true;
			}
		}
		if(isTrue){
			s.print();
			System.out.print(" verdadeiro");
		}else{
			s.print();
			System.out.print(" falso");
		}
		System.out.println();
		for(Sentence i : this.sentences){
			if(i.not){
				for(Sentence j : this.sentences){
					if(i.equals(j.negate())){
						System.out.print("Base inconsistente: ");
						i.print();
						System.out.print(" e ");
						j.print();
						System.out.print(" presentes.\n");
						
					}
				}
			}
		}	
	}
	
	public void expand(){
		boolean added = false;
		Sentence s0;
		Sentence s1;
		
		for(int i=0;i<sentences.size();i++){
			s0 = sentences.get(i);
			if(s0 instanceof CompSentence){
				//selecionamos uma sentenca e vamos tentar aplicar regras para criar novas sentencas 
				for(int j=0;j<sentences.size();j++){
					s1 = sentences.get(j);
					added=added||modPon(s0,s1);
					added=added||modTol(s0,s1);
					added=added||silDis(s0,s1);
					if(s1 instanceof CompSentence){
						//caso uma outra sentenca selecionada seja composta, tentamos aplicar silogismo hipotetico
						added=added||silHip(s0,s1);
					}
				}
			}
		}
		if(added){
			expand();
		}
	}
	
	public boolean modPon(Sentence s0, Sentence s1){
		boolean added = false;
		if(((CompSentence) s0).getLSent().equals(s1) && s0.getOpr()==2){
			//para uma sentenca do tipo P->Q, estamos procurando um P
			try {
				added = addToDB(((CompSentence) s0).getRSent().clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}
		return added;
	}
	
	public boolean modTol(Sentence s0, Sentence s1){
		boolean added = false;
		try {
			Sentence s2 = s1.clone();
			s2 = s2.negate();
			if(((CompSentence) s0).getRSent().equals(s2) && s0.getOpr()==2){
				//para uma sentenca do tipo P->Q, estamos procurando um ~Q
				added=addToDB(((CompSentence) s0).getLSent().clone().negate());
			}
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return added;
	}
	
	public boolean silHip(Sentence s0, Sentence s1){
		boolean added = false;
		if(((CompSentence) s0).getRSent().equals(((CompSentence) s1).getLSent()) && s0.getOpr()==2 && s1.getOpr()==2){
			CompSentence ns;
			try {
				ns = new CompSentence(((CompSentence) s0).getLSent().clone(),((CompSentence) s1).getRSent().clone(),2,false);
				added = addToDB(ns);
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}
		return added;
	}
	
	public boolean silDis(Sentence s0, Sentence s1){
		boolean added = false;
		try {
			Sentence s2 = ((CompSentence) s0).getLSent().clone();
			s2 = s2.negate();
			if(s2.equals(s1) && s0.getOpr()==0){
				//para uma sentenca do tipo P v Q, estamos procurando um ~P
				added = addToDB(((CompSentence) s0).getRSent().clone());
			}
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return added;
	}
	
	public void printDB(){
		for(Sentence i : sentences){
			System.out.println();
			i.print();
		}
	}
	
}
