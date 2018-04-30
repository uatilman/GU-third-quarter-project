package ru.tilman.gb.patterns.ht3.users;

import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;
import java.util.Date;

public abstract class AuthorizedUser extends User {
    private long lastActivity;
    private UsersType userType;
    private String userName;

    public AuthorizedUser(UnAuthorizedUser unAuthorizedUser, UsersType userType) {
        this.cookies = unAuthorizedUser.getCookies();
        this.pageViews = getPageViews();
        this.lastActivity = new Date().getTime();
        this.userType = userType;
    }

    public AuthorizedUser(String userName) {
        this.userName = userName;
    }

    public UsersType getUserType() {
        return userType;
    }

    public void setUserType(UsersType userType) {
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(long lastActivity) {
        this.lastActivity = lastActivity;
    }
}
