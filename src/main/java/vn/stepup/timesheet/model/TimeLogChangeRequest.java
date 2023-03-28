package vn.stepup.timesheet.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "time_log_change_request")
public class TimeLogChangeRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private long id;

    @Column(name = "user_time_log_id")
    private long userTimeLogId;

    @Column(name = "time_in_request")
    private Timestamp timeInRequest;

    @Column(name = "time_out_request")
    private Timestamp timeOutRequest;

    @Column(name = "description")
    private String description;

    @Column(name = "leave_type")
    private String leaveType;

    @Column(name = "user_id")
    private  long userId;

    @Column(name = "manager_id")
    private long managerId;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

}
