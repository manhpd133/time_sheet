package vn.stepup.timesheet.model;

import io.micrometer.common.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public enum RolesPermission {

    APPROVE_TIME_OF_REQUESTS("APPROVE_TIME_OF_REQUESTS"),
    MANAGE_EMPLOYEES("MANAGE_EMPLOYEES"),
    VIEW_TIME_LOGS("VIEW_TIME_LOGS");

    private static final Map<String,RolesPermission> STATUS_TYPE = new HashMap<>();

    private final String type;

    RolesPermission(String type) {
        this.type = type;
    }

    static {
        for (RolesPermission e : values()) {
            STATUS_TYPE.put(e.type.toLowerCase(), e);
        }
    }

    public static RolesPermission from(String type) {
        if (StringUtils.isBlank(type)) return null;

        return STATUS_TYPE.get(type.toLowerCase());
    }

    public String getType() {
        return this.type;
    }
}
