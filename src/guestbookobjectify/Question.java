package guestbookobjectify;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Question {

	@Id
	private Long id;
	private String enonce;
	private QuestionType question;
	private int nbreponses;
	private Key<Form> parent;
	private List<Reponse> reponses = new ArrayList<Reponse>();

	private enum QuestionType {
		CHECKBOX, TEXT_AREA, RADIO_BUTTON
	};

	private Question() {

	}

	public Question(String enonce, String questionType, int nbreponses, Key<Form> parent) {
		this.enonce = enonce;
		this.nbreponses = nbreponses;
		this.parent = parent;
		
		switch (questionType) {
		case "checkbox":
			this.question = QuestionType.CHECKBOX;
			break;
		case "text":
			this.question = QuestionType.TEXT_AREA;
			break;
		case "radio":
			this.question = QuestionType.RADIO_BUTTON;
			break;
		default:
			this.question = QuestionType.CHECKBOX;
			break;
		}

	}
	
	public void addReponse(String reponse){
		Key<Question> question = Key.create(Question.class, id);
		reponses.add(new Reponse(reponse, question));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEnonce() {
		return enonce;
	}

	public void setEnonce(String enonce) {
		this.enonce = enonce;
	}

	public QuestionType getQuestion() {
		return question;
	}

	public void setQuestion(QuestionType question) {
		this.question = question;
	}

	public int getNbreponses() {
		return nbreponses;
	}

	public void setNbreponses(int nbreponses) {
		this.nbreponses = nbreponses;
	}

	public List<Reponse> getReponses() {
		return reponses;
	}

	public void setReponses(List<Reponse> reponses) {
		this.reponses = reponses;
	}

	
	
}
