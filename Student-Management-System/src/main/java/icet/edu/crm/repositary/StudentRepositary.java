package icet.edu.crm.repositary;

import icet.edu.crm.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepositary extends JpaRepository<StudentEntity , Long> {

    StudentEntity findByFirstName(String firstName);

}
