package guestbookobjectify;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Parent;

@Entity
public class Question {

	@Id
	Long id;
	long range = 123456789L;

	@Parent
	Key<Form> parent;

	private String enonce;
	private QuestionType question;
	private int nbreponses = 1;
	private List<Reponse> reponses = new ArrayList<Reponse>();
	private String categorie;

	private enum QuestionType {
		CHECKBOX, TEXT_AREA, RADIO_BUTTON
	};

	public Question() {
		Random r = new Random();
		id = (long) (r.nextDouble() * range);
		setCategorie("");
		enonce = "";
		question = QuestionType.CHECKBOX;
	}

	public Question(String enonce, String questionType, String categorie) {
		this.enonce = enonce;
		this.setCategorie(categorie);

		Random r = new Random();
		id = (long) (r.nextDouble() * range);

		this.parent = Key.create(Form.class, this.id);

		if(questionType.equals("checkbox")){
			this.question = QuestionType.CHECKBOX;
		} else if (questionType.equals("radio")) {
			this.question = QuestionType.RADIO_BUTTON;
		} else{
			this.question = QuestionType.TEXT_AREA;
		}
		

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

	public void setQuestion(String question) {
		if (question.equals("checkbox")) {
			this.question = QuestionType.CHECKBOX;
		} else if (question.equals("radio")) {
			this.question = QuestionType.RADIO_BUTTON;
		} else if (question.equals("checkbox")) {
			this.question = QuestionType.TEXT_AREA;
		}
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

	public void incrNbReponse() {
		nbreponses++;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

}