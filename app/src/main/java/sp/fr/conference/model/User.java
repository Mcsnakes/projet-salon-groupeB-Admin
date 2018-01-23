package sp.fr.conference.model;

/**
 * Created by Formation on 23/01/2018.
 */

public class User {

    private String firstName;
    private String name;
    private String mail;
    private Double id;

    public User() {
    }

    public User(String firstName, String name, String mail) {
        this.firstName = firstName;
        this.name = name;
        this.mail = mail;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getMail() {
        return mail;
    }

    public User setMail(String mail) {
        this.mail = mail;
        return this;
    }

    public Double getId() {
        return id;
    }

    public User setId(Double id) {
        this.id = id;
        return this;
    }
}