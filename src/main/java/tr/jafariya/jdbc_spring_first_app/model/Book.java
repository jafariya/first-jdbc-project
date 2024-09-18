package tr.jafariya.jdbc_spring_first_app.model;

public class Book {
    private Long id;
    private String name;

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book(Long id, String name) {
        this.name = name;
        this.id = id;
    }

    public Book() {
    }
}
