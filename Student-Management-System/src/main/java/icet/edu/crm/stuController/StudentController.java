package icet.edu.crm.stuController;

import icet.edu.crm.dto.Student;
import icet.edu.crm.stuService.StudentService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stu-controller")
@RequiredArgsConstructor
@CrossOrigin
public class StudentController {

    final StudentService service;

    @PostMapping("/add-student")
    @ResponseStatus(HttpStatus.CREATED)
    public void addEmployee(@RequestBody Student student){
        service.addstudent(student);
    }

    @GetMapping("/get-Stu")
    public List<Student> getall(){
        return service.getall();
    }

    @DeleteMapping("/delete-Stu/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteStudent(@PathVariable Long id){
        service.deleteStudentById(id);
        return "Deleted";
    }

    @PostMapping("/update-Student")
    public void updateStudent(@RequestBody Student student){
        service.updateEmployee(student);

    }

    @GetMapping("/find-by-name/{firstName}")
    public Student findbyName(@PathVariable String firstName){
        return service.findByName(firstName);
    }

}
