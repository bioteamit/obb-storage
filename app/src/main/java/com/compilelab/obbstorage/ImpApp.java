package com.compilelab.obbstorage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.jana.android.app.AbstractApplication;
import com.jana.android.app.config.Configuration;

public class ImpApp extends AbstractApplication<AppManager> {

    public static void startActivity(Class<? extends Activity> cls,
                                     Bundle extras, int flags) {

        if (flags != -1) {
            flags |= Intent.FLAG_ACTIVITY_NEW_TASK;
        }

        flags = Intent.FLAG_ACTIVITY_NEW_TASK;

        startActivity(getApplication(), cls, extras, flags);
    }

    public static void startActivity(Context context,
                                     Class<? extends Activity> cls, Bundle extras, int flags) {

        Intent intent = new Intent(getApplication(), cls);

        if (extras != null) {
            intent.putExtras(extras);
        }

        if (flags != -1) {
            intent.addFlags(flags);
        }

        context.startActivity(intent);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        setAppManager(AppManager.getInstance());

        Configuration.Builder builder = new Configuration.Builder();
        Configuration configs = builder.build();
        AppManager.getInstance().init(configs);
    }

    @Override
    protected String getAppTag() {
        return "Obb-Storage";
    }
}
