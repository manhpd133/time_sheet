package vn.stepup.timesheet.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id", "employee_id"})
})
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private long id;

    @Column(name = "employee_id")
    private long employeeId;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "gender",length = 5)
    private String gender;

    @Column(name = "image", length = 500)
    private String image;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "address")
    private String address;

    @Column(name = "phone", length = 12)
    private String phone;

    @Column(name ="name_position")
    private String namePosition;

    @Column(name ="name_department")
    private String nameDepartment;

    @Column(name = "leave_balance")
    private long leaveBalance;

    @Column(name = "created_at")
    private Date CreatedAt;

    @Column(name = "updated_at")
    private Date updatedAt;

}
