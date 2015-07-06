package com.compilelab.obbstorage;

import com.jana.android.app.BasicManager;

public class AppManager extends BasicManager {

    protected static AppManager sInstance;

    public static AppManager getInstance() {
        if (sInstance == null) {
            sInstance = new AppManager();
        }
        return sInstance;
    }
}
