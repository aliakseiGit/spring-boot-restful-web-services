package rest.webservices.restfulwebservices.course.jdbc;

import rest.webservices.restfulwebservices.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static String INSERT_QUERY_PS = "insert into course (id, name, author) " +
            "values(?, ?, ?)";

    private static String DELETE_QUERY_PS = "delete from course where id = ?";

    private static String SELECT_QUERY_PS = "select * from course where id = ?";

    public void insert(Course course){
        jdbcTemplate.update(INSERT_QUERY_PS, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(long id){
        jdbcTemplate.update(DELETE_QUERY_PS, id);
    }

    public Course selectById(long id){
        return jdbcTemplate.queryForObject(SELECT_QUERY_PS, new BeanPropertyRowMapper<>(Course.class), id);
    }


}
