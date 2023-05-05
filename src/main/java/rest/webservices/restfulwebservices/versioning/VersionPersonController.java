package rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionPersonController {
    @GetMapping("/v1/person")
    public PersonVersion1 getFirstVersionOfPerson(){
        return new PersonVersion1("Bob Charlie");
    }

    @GetMapping("/v2/person")
    public PersonVersion2 getSecondVersionOfPerson(){
        return new PersonVersion2(new FullName("Bob", "Charlie"));
    }


    @GetMapping(path = "/person", params = "version=1")
    public PersonVersion1 getFirstVersionOfPersonRequestParameter(){
        return new PersonVersion1("Bob Charlie");
    }

    @GetMapping(path = "/person", params = "version=2")
    public PersonVersion2 getSecondVersionOfPersonRequestParameter(){
        return new PersonVersion2(new FullName("Bob", "Charlie"));
    }

    @GetMapping(path = "/person", headers = "X-API-VERSION=1")
    public PersonVersion1 getFirstVersionOfPersonRequestHeader(){
        return new PersonVersion1("Bob Charlie");
    }

    @GetMapping(path = "/person", headers = "X-API-VERSION=2")
    public PersonVersion2 getSecondVersionOfPersonRequestHeader(){
        return new PersonVersion2(new FullName("Bob", "Charlie"));
    }

    @GetMapping(path = "/person", produces = "application/vnd.company.app-v1+json")
    public PersonVersion1 getFirstVersionOfPersonAcceptHeader(){
        return new PersonVersion1("Bob Charlie");
    }

}
