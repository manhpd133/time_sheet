package vn.stepup.timesheet.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link vn.stepup.timesheet.model.Users} entity
 */
@Data
public class UsersDto implements Serializable {
    private final String fullName;
    private final String image;
    private final String email;
    private final String namePosition;
    private final String nameDepartment;
    private final long leaveBalance;
}