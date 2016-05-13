package guestbookobjectify;

import com.googlecode.objectify.annotation.*;

@Entity
@Index
public class Formulaire {
	@Id
	Long id;
	@Unindex
	private String name = "Formulaire";
	
	public Formulaire(){}
	
	public Formulaire(String name) {
		
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
