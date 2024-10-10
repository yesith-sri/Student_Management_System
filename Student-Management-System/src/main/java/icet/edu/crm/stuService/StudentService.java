package icet.edu.crm.stuService;

import icet.edu.crm.dto.Student;

import java.util.List;

public interface StudentService {
    void addstudent(Student student);

    List<Student> getall();

    void deleteStudentById(Long id);

    void updateEmployee(Student student);

    Student findByName(String firstName);
}
