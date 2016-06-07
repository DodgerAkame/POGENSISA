package guestbookobjectify;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Checking {
	@Id
	Long id;
	
	private String name = "";
	private List<Question> question = new ArrayList<Question>();
	@Index
	private int rang = 0;
	
	public Checking(){
	}

	public Checking(String name, int i){
		this.name=name;
		setRang(i);
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRang() {
		return rang;
	}

	public void setRang(int rang) {
		this.rang = rang;
	}

	public List<Question> getQuestion() {
		return question;
	}

	public void setQuestion(List<Question> question) {
		this.question = question;
	}
}
