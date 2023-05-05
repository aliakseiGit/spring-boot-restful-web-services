package rest.webservices.restfulwebservices.course;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Fine!");
    }

//    @Autowired
//    private CourseSpringDataJpaRepository courseSpringDataJpaRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//        courseSpringDataJpaRepository.save(new Course(1, "Learn JDBC", "MF Lorry"));
//        courseSpringDataJpaRepository.save(new Course(2, "Learn AWS", "BL Todges"));
//        courseSpringDataJpaRepository.save(new Course(3, "Learn Azure", "AG Truman"));
//
//        courseSpringDataJpaRepository.deleteById(3l);
//
//        System.out.println(courseSpringDataJpaRepository.findById(2l));
//        System.out.println(courseSpringDataJpaRepository.findAll());
//        System.out.println(courseSpringDataJpaRepository.findByAuthor("MF Lorry"));
//    }


    //Using JPA repository
    /*
    @Autowired
    private CourseJpaRepository courseJpaRepository;

    @Override
    public void run(String... args) throws Exception {
        courseJpaRepository.insert(new Course(1, "Learn JDBC", "MF Lorry"));
        courseJpaRepository.insert(new Course(2, "Learn AWS", "BL Todges"));
        courseJpaRepository.insert(new Course(3, "Learn Azure", "AG Truman"));

        courseJpaRepository.deleteById(3);

        System.out.println(courseJpaRepository.findById(2));
    }
    */

    //Using JDBC repository
    /*
    @Autowired
    private CourseJdbcRepository courseJdbcRepository;

    @Override
    public void run(String... args) throws Exception {
        courseJdbcRepository.insert(new Course(1, "Learn JDBC", "MF Lorry"));
        courseJdbcRepository.insert(new Course(2, "Learn AWS", "BL Todges"));
        courseJdbcRepository.insert(new Course(3, "Learn Azure", "AG Truman"));

        courseJdbcRepository.deleteById(3);

        System.out.println(courseJdbcRepository.selectById(2));
    }
    */
}
