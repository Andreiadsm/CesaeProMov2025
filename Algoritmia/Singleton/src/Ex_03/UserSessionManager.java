package Ex_03;

import Ex_02.Logger;

public class UserSessionManager {
    private static UserSessionManager instance;
    private int sessionToken;
    private String lastAccess;

    private UserSessionManager(int sessionToken, String lastAccess) {
        this.sessionToken = sessionToken;
        this.lastAccess = lastAccess;
    }

    public int getSessionToken() {
        return sessionToken;
    }

    public String getLastAccess() {
        return lastAccess;
    }
}

