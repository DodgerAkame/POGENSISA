package guestbookobjectify;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Parent;

@Entity
public class Question {

	@Id
	Long id;
	@Parent
	private Key<Form> parent;

	private String enonce;
	private QuestionType question;
	private int nbreponses = 2;
	private List<Reponse> reponses = new ArrayList<Reponse>();

	private enum QuestionType {
		CHECKBOX, TEXT_AREA, RADIO_BUTTON
	};

	private Question() {
	}

//	public Question(String enonce, String questionType, int nbreponses, Key<Form> parent) {
//		this.enonce = enonce;
//		this.nbreponses = nbreponses;
//		this.parent = parent;
//		
//		switch (questionType) {
//		case "checkbox":
//			this.question = QuestionType.CHECKBOX;
//			break;
//		case "text":
//			this.question = QuestionType.TEXT_AREA;
//			break;
//		case "radio":
//			this.question = QuestionType.RADIO_BUTTON;
//			break;
//		default:
//			this.question = QuestionType.CHECKBOX;
//			break;
//		}
//
//	}

	public Question(String enonce, String questionType, int nbreponses) {
		this.enonce = enonce;
		this.nbreponses = nbreponses;
		this.id = 123L;
		
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
	
	/*public void addReponse(String reponse) {
		Key<Question> question = Key.create(Question.class, id);
		reponses.add(new Reponse(reponse, question));
	}*/

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

	public String getQuestion() {
		String S = "";
		if (question == QuestionType.CHECKBOX) {
			S = "checkbox";
		} else if (question == QuestionType.RADIO_BUTTON) {
			S = "radio";
		} else if (question == QuestionType.TEXT_AREA) {
			S = "text";
		}
		return S;
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