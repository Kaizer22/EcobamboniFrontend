package com.example.ecobambonifrontend.data.model;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class LoggedInUser {

    private int ID;
    private String login;
    private String displayName;
    private String password;
    private UserRole role;


    public LoggedInUser(String login, String displayName) {
        this.login = login;
        this.displayName = displayName;
    }

    public String getLogin() {
        return login;
    }

    public String getDisplayName() {
        return displayName;
    }

    public enum UserRole {
        ADMIN, DEFAULT_USER
    }
}
