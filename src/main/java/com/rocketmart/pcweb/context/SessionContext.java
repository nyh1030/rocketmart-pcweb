package com.rocketmart.pcweb.context;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value="session")
@Component("sessionContext")
public class SessionContext {

/*    static class Mgr {
        String mgrId;

        Mgr(String mgrId) {
            this.mgrId = mgrId;
        }
    }

    public void setMgr()

    public String getMgrId() {
        return mgr.getMgrId;
    }*/
}
