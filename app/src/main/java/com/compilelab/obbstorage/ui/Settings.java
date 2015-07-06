package com.compilelab.obbstorage.ui;

import android.content.Context;

import com.jana.android.app.BasicSettings;
import com.jana.android.utils.Logger;

/**
 * Settings is the responsible for manipulating app settings for all different
 * states
 *
 * @author IslamSamak : islamsamak01@gmail.com
 */
public class Settings extends BasicSettings {

    private static Settings sInstance;

    protected Settings(Context context) {
        super(context);
    }

    public static Settings getInstance() {

        if (sInstance == null) {

            Logger.w("Settings is uninitialized");

            sInstance = new Settings(ImpApp.getApplication());

            sInstance.init(ImpApp.getApplication());
        }

        return sInstance;
    }

    public void init(Context context) {
        Logger.v("Settings.init()");

        if (sInstance != null) {
            Logger.w("Settings is already initialized.");
        }

        sInstance = new Settings(context);

        long now = System.currentTimeMillis();

        long initTime = getInitTime();

        long diff = initTime - now;

        if (initTime > now && diff <= 10000) {
            sInstance.loadDefaults();
        }
    }

    protected void loadDefaults() {
        sInstance.setInitTime(sInstance.getInitTime());
    }
}
