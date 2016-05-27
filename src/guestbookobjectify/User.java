package guestbookobjectify;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class User {

	@Id
	Long id;
	long range = 123456789L;
	private Map<String, Reponse> reponses = new HashMap<String, Reponse>();
	@Index
	private String name;

	public User() {
		this.name = "";

		Random r = new Random();
		id = (long) (r.nextDouble() * range);
	}

	public User(String name) {
		this.name = name;

		Random r = new Random();
		id = (long) (r.nextDouble() * range);
	}

	public Map<String, Reponse> getReponses() {
		return reponses;
	}

	public void setReponses(Map<String, Reponse> reponses) {
		this.reponses = reponses;
	}

}
