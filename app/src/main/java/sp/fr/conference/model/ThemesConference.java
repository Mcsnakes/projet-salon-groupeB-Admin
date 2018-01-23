package sp.fr.conference.model;

/**
 * Created by sebas on 22/01/2018.
 */

public class ThemesConference {

    private String name;
    private String id;

    public ThemesConference() {
    }

    public ThemesConference(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getId() {
        return id;
    }

    public ThemesConference setId(String id) {
        this.id = id;
        return this;
    }
}
