package io.github.favourojoye.shopify.model;

public class Customer {
    //attributes
    //getter/setter
    private String firstName;
    private Long id;
    private String Lastname;
    private String email;

    public Customer(String firstName, Long id, String lastname, String email) {
        this.firstName = firstName;
        this.id = id;
        Lastname = lastname;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
