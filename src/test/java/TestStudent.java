import com.rmk.config.ApplicationConfig;
import com.rmk.config.DAOConfig;
import com.rmk.controller.StudentController;
import com.rmk.model.Student;
import com.rmk.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

        Student student = new Student();
        student.setfName("krishiv");
        student.setlName("mona");
        service.saveStudent(student);
        List<Student> result = controller.getAllStudents();
        if(result ==null || result.isEmpty()){
            logger.info("Empty");
        }else{
                logger.info(result.size()+"");


        }


    }
}
