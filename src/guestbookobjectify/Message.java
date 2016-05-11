package guestbookobjectify;

import com.googlecode.objectify.annotation.*;

@Entity
@Index
public class Message {
	@Id
	Long id;
	@Unindex
	private String name;
	private String message;

	public Message() {

	}

	public Message(String name, String message) {
		this.name = name;
		this.message = message;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
