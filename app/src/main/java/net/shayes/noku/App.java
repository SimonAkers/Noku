package net.shayes.noku;

import android.app.Application;

public class App extends Application {
    TVAppManager appManager;

    @Override
    public void onCreate() {
        super.onCreate();

        appManager = new TVAppManager(getApplicationContext());
    }

    public TVAppManager getAppManager() {
        return appManager;
    }
}
