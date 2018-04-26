package ru.tilman.gb.patterns.users;

import java.util.Date;

public abstract class AuthorizedUser extends User {
    private long lastActivity;
   private UsersType userType;

    public AuthorizedUser(UnAuthorizedUser unAuthorizedUser, UsersType userType) {
        this.cookies = unAuthorizedUser.getCookies();
        this.pageViews = getPageViews();
        this.lastActivity = new Date().getTime();
        this.userType = userType;
    }

    public long getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(long lastActivity) {
        this.lastActivity = lastActivity;
    }
}
