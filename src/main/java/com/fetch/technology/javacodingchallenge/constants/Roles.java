package com.fetch.technology.javacodingchallenge.constants;

public class Roles {
    public static final String PREFIX_ROLE = "ROLE_";

    public static final String ADMIN = "ADMIN";
    public static final String ROLE_ADMIN = PREFIX_ROLE + ADMIN;

    public static final String USER = "USER";
    public static final String ROLE_USER = PREFIX_ROLE + USER;

    public static final String ACTUATOR = "ACTUATOR";
    public static final String ROLE_ACTUATOR = PREFIX_ROLE + ACTUATOR;

    private Roles() {
        // no-op
    }
}
