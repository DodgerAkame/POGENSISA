package guestbookobjectify;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Parent;
import com.googlecode.objectify.annotation.Unindex;

@Entity
public class Reponse {
	@Id
	private Long id;
	@Unindex
	private String reponse;
	@Parent Key<Question> parent;

	private Reponse(){
	}
	
	public Reponse(String reponse, Key<Question> parent){
		this.reponse = reponse;
		this.parent = parent;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
