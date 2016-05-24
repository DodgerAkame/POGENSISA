package guestbookobjectify;

import java.util.Random;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Parent;
import com.googlecode.objectify.annotation.Unindex;

@Entity
public class Reponse {
	@Id
	private Long id;
	long range = 123456789L;
	@Unindex
	private String reponse;
	@Parent
	Key<Question> parent;

	private Reponse() {
	}



	public Reponse(String reponse) {
		this.reponse = reponse;
		Random r = new Random();
		id = (long) (r.nextDouble() * range);
		this.parent = Key.create(Question.class, this.id);
	}



	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	public Key<Question> getParent() {
		return parent;
	}

	public void setParent(Key<Question> parent) {
		this.parent = parent;
	}

}
