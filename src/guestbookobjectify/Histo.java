package guestbookobjectify;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Histo {
	@Id
	Long id;
	
	private String name = "";
	@Index
	private int rang = 0;
	
	public Histo(){
	}

	public Histo(String name, int i){
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
}
