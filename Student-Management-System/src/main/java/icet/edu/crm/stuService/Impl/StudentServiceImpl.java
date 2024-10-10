package icet.edu.crm.stuService.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import icet.edu.crm.dto.Student;
import icet.edu.crm.entity.StudentEntity;
import icet.edu.crm.repositary.StudentRepositary;
import icet.edu.crm.stuService.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    final StudentRepositary repositary;

    @Override
    public void addstudent(Student student) {
        StudentEntity studentEntity = new ObjectMapper().convertValue(student, StudentEntity.class);
        repositary.save(studentEntity);
    }

    @Override
    public List<Student> getall() {
        List<Student> studentsList = new ArrayList<>();
        List<StudentEntity> allEntityList = repositary.findAll();
        allEntityList.forEach(entity ->{
            studentsList.add(new ObjectMapper().convertValue(entity, Student.class));
        });
        return studentsList;
    }

    @Override
    public void deleteStudentById(Long id) {
        if(repositary.existsById(id)){
            repositary.deleteById(id);
        }
    }

    @Override
    public void updateEmployee(Student student) {
        if(repositary.findById(student.getId()).isPresent()){
            repositary.save(new ObjectMapper().convertValue(student ,  StudentEntity.class));
        }
    }

    @Override
    public Student findByName(String firstName) {
        return new ObjectMapper().convertValue(repositary.findByFirstName(firstName), Student.class);
    }
}
