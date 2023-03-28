package vn.stepup.timesheet.model;

import io.micrometer.common.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public enum LeaveRequestStatus {

    APPROVED("APPROVED"),
    PENDING("PENDING"),
    REJECTED("REJECTED");

    private static final Map<String, LeaveRequestStatus> STATUS_TYPE = new HashMap<>();

    private final String type;

    LeaveRequestStatus(String type) {
        this.type = type;
    }

    static {
        for (LeaveRequestStatus e : values()) {
            STATUS_TYPE.put(e.type.toLowerCase(), e);
        }
    }

    public static LeaveRequestStatus from(String type) {
        if (StringUtils.isBlank(type)) return null;

        return STATUS_TYPE.get(type.toLowerCase());
    }

    public String getType() {
        return this.type;
    }
}
