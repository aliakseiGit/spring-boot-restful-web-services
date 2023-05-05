package rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import rest.webservices.restfulwebservices.user.User;
import rest.webservices.restfulwebservices.user.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FilteringUserController {

    @Autowired
    private UserDaoService service;

    // GET /users
    @GetMapping("/users-filtering")
    public MappingJacksonValue retrieveAllUsers() {
        final List<User> users = service.findAll();

        //Dynamic filtering
		MappingJacksonValue mappingJacksonValue =  new MappingJacksonValue(users);
		SimpleBeanPropertyFilter filter =  SimpleBeanPropertyFilter.filterOutAllExcept("user_birthDate", "user_name");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("IgnoreUser_birthDateFilter", filter);
		mappingJacksonValue.setFilters(filterProvider);

        return mappingJacksonValue;
    }
}
