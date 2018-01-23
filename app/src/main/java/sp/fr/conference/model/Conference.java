package sp.fr.conference.model;

/**
 * Created by Formation on 23/01/2018.
 */

public class Conference {

    private String title;
    private String theme;
    private String description;
    private User user;
    private String statut;
    private String id;

    public Conference() {
    }

    public Conference(String title, String theme, String description, User user) {
        this.title = title;
        this.theme = theme;
        this.description = description;
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public Conference setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getTheme() {
        return theme;
    }

    public Conference setTheme(String theme) {
        this.theme = theme;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Conference setDescription(String description) {
        this.description = description;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Conference setUser(User user) {
        this.user = user;
        return this;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}