package guestbookobjectify;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;


@Entity
public class Form {
	@Id
	Long id;
	private int nbquestions = 0;
	private Map<String, Question> liste = new HashMap<String, Question>();
	private String name = "";
	private String date;
	@Index
	private int rank = 0;
	private boolean isOpened;
	private int usersAnswered;

	public Form() {

	}

	public Form(String name, int i) {
		this.name = name;
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		this.date = dateFormat.format(cal.getTime());
		this.rank = i;
		this.isOpened = true;
		this.usersAnswered = 0;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public void addQuestion(String enonce, String questionType) {
		Key<Form> form = Key.create(Form.class, id);
		liste.put(enonce, new Question(enonce, questionType));
		nbquestions++;
	}

	public void addQuestion() {
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

	
	public void incr() {
		nbquestions++;
	}

	public List<Question> getListe() {
		Map<String, Question> buffer = getMap();
		return new ArrayList<Question>(buffer.values());
	}

	public boolean isOpened() {
		return isOpened;
	}

	public void setOpened(boolean isOpened) {
		this.isOpened = isOpened;
	}

	public int getUsersAnswered() {
		return usersAnswered;
	}

	public void setUsersAnswered(int usersAnswered) {
		this.usersAnswered = usersAnswered;
	}

}
