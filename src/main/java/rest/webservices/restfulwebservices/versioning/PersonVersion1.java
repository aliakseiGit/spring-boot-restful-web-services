package rest.webservices.restfulwebservices.versioning;

public class PersonVersion1 {
    private String name;

    public PersonVersion1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
