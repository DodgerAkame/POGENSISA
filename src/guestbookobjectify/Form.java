package guestbookobjectify;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Unindex;

@Index
@Entity
public class Form {
	@Id
	Long id;
	@Unindex
	private int nbquestions = 0;
	private Map<String, Question> liste = new HashMap<String, Question>();
	private String name = "";
	
	public Form(){
		
	}

	public Form(String name){
		this.name = name;
	}
	
	public void addQuestion(String enonce, String questionType) {
		Key<Form> form = Key.create(Form.class, id);
		liste.put(enonce, new Question(enonce, questionType));
		nbquestions++;
	}
	
	public void addQuestion(){
		Key<Form> form = Key.create(Form.class, id);
		liste.put("", new Question());
		nbquestions++;
	}

	public void removeQuestion(String enonce) {
		liste.remove(enonce);
		nbquestions--;
	}

	public void findQuestion(String enonce) {
		liste.get(enonce);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNbquestions() {
		return nbquestions;
	}

	public void setNbquestions(int nbquestions) {
		this.nbquestions = nbquestions;
	}

	public Map<String, Question> getMap() {
		return liste;
	}

	public void setMap(Map<String, Question> liste) {
		this.liste = liste;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*public com.googlecode.objectify.Key<Form> getKey() {
	    return new com.googlecode.objectify.Key<Form>(Form.class, id); 
	}
*/
	
	public void incr(){
		nbquestions++;
	}

	public List<Question> getListe(){
		Map<String, Question> buffer = getMap();
		return new ArrayList<Question>(buffer.values());
	}
	
	
}
