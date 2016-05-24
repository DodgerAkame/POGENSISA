package guestbookobjectify;

import java.util.HashMap;
import java.util.Map;

public class ListeQuestion {

	private Map<Integer,Question> qs = new HashMap<Integer,Question>();
	
	public ListeQuestion(){
		
	}
	
	public void addQuestion(int i, Question q){
		qs.put(i, q);
	}
	
	public Map<Integer, Question> getMap(){
		return qs;
	}
	
	public Question getQuestionIndex(int i){
		return qs.get(i);
	}
}
