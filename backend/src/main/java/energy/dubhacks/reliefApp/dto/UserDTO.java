package energy.dubhacks.reliefApp.dto;

public class UserDTO {

    private String username;
    private String email;

    // Constructors
    public UserDTO() {
    }

    public UserDTO(String username, String email) {
        this.username = username;
        this.email = email;
    }

    // Getters and Setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    // toString() method can be added as needed
}
