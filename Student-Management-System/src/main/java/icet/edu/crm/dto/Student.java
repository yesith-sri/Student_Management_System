package icet.edu.crm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String stream;
}
