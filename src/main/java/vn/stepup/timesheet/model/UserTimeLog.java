package vn.stepup.timesheet.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.sql.Time;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "user_time_log")
public class UserTimeLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "employee_id")
    private long employeeId;

    @Column(name = "date")
    private java.sql.Date date;

    @Column(name = "check_in_time")
    private Time checkInTime;

    @Column(name = "check_out_time")
    private Time checkOutTime;

    @Column(name = "notes")
    private String notes;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

}
