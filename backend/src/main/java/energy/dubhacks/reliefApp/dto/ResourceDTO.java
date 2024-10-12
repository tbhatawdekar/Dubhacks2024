package energy.dubhacks.reliefApp.dto;

public class ResourceDTO {

    private String name;
    private String description;
    private Integer quantity;

    // Constructors
    public ResourceDTO() {
    }

    public ResourceDTO(String name, String description, Integer quantity) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    // toString() method can be added as needed
}