package energy.dubhacks.reliefApp.model;


public class Resource {
    private Long id;

    private String name;
    private String description;
    private Integer quantity;

    // Constructors
    public Resource(String name) {
        this.name = name;
    }

    public Resource(String name, String description, Integer quantity) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public void setId(Long id) {
		this.id = id;
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

    // toString(), equals(), and hashCode() methods can be added as needed
}
