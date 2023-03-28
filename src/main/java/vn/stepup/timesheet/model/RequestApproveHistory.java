package vn.stepup.timesheet.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "request_approve_history")
public class RequestApproveHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private long id;

    @Column(name = "time_log_change_request_id")
    private long timeLogChangeRequestId;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "time")
    private Timestamp time;

    @Column(name = "permission")
    private String permission;

    @Column(name = "status")
    private  LeaveRequestStatus status;

    @Column(name = "img", length = 500)
    private String img;

    @Column(name = "note")
    private String notes;

}
