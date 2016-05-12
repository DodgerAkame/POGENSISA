package guestbookobjectify;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Unindex;

@Entity
@Index
public class Message {
	@Id
	Long id;
	@Unindex
	private String name;
	private String message;
	private String check;
	private List<String> checkboxes = new ArrayList<String>();

	public Message() {

	}

	public List<String> getCheckboxes() {
		return checkboxes;
	}

	public void setCheckboxes(List<String> checkboxes) {
		this.checkboxes = checkboxes;
	}

	public Message(String name, String message) {
		this.name = name;
		this.message = message;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String isCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

}
