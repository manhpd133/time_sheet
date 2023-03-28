package vn.stepup.timesheet.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "authorized_network")
public class AuthorizedNetwork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private long id;

    @Column(name = "list_ip_wifi")
    private String ipWifi;

    @Column(name =  "location")
    private  String location;

    public long getEmployeeId() {
        return getEmployeeId();
    }
}
