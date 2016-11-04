import com.rmk.config.ApplicationConfig;
import com.rmk.config.DAOConfig;
import com.rmk.controller.StudentController;
import com.rmk.model.Student;
import com.rmk.service.StudentService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by RashMin on 29-10-2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class, DAOConfig.class})
public class TestStudent {

    @Autowired
    @Qualifier("studentservice")
    StudentService service;
    @Autowired
    @Qualifier("studentcontroller")
    StudentController controller;

    private final Logger logger = LoggerFactory.getLogger(TestStudent.class);




    @Test
    public void test1(){

        Student s1 = new Student();
        s1.setlName("lname1");
        s1.setfName("fname1");
        Student s2 = new Student();
        s2.setfName("fname2");
        s2.setlName("lname2");
        service.saveStudent(s1);
        service.saveStudent(s2);

        List<Student> result = controller.getAllStudents();
        if(result ==null || result.isEmpty()){
            logger.info("Empty");
        }else {
            for (Student student : result)
                logger.info(student.toString());
        }





    }


}
