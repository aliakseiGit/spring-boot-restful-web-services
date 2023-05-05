package rest.webservices.restfulwebservices.versioning;

public class PersonVersion2 {
    private FullName fullName;

    public PersonVersion2(FullName fullName) {
        this.fullName = fullName;
    }

    public FullName getName() {
        return fullName;
    }

    public void setName(FullName fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "UserVersion2{" +
                "name=" + fullName +
                '}';
    }
}

