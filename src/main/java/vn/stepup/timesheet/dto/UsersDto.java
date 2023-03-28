package vn.stepup.timesheet.dto;

import jdk.jshell.Snippet;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
 * A DTO for the {@link vn.stepup.timesheet.model.Users} entity
 */
@Builder
@Data
public class UsersDto implements Serializable {
    private final long employeeId;
    private final String fullName;
    private final String gender;
    private final String image;
    private final String email;
    private final Date dateOfBirth;
    private final String address;
    private final String phone;
    private final String namePosition;
    private final String nameDepartment;
}