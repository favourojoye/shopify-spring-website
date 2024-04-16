package io.github.favourojoye.shopify.model;

public class Customer {
    //attributes
    //getter/setter
    private String firstName;
    private Long id;
    private String lastname;
    private String email;

    public Customer(String firstName, Long id, String lastname, String email) {
        this.firstName = firstName;
        this.id = id;
        this.lastname = lastname;
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
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
