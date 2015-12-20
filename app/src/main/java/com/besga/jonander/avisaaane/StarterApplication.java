package com.besga.jonander.avisaaane;

import android.app.Application;
import android.content.Intent;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseInstallation;

import java.io.IOException;
import java.util.Properties;

public class StarterApplication extends Application {
    private final String TAG = "StarterApplication";

    @Override
    public void onCreate() {
        super.onCreate();

        Properties prop = new Properties();
        try {
            prop.load(getAssets().open("app.properties"));
        } catch (IOException ex) {
            Log.e(TAG, "File app.properties with ApplicationID and ClientKey not found", ex);
            Intent homeIntent = new Intent(Intent.ACTION_MAIN);
            homeIntent.addCategory(Intent.CATEGORY_HOME);
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(homeIntent);
        }
        String client_key = prop.getProperty("ClientKey");
        String app_id = prop.getProperty("ApplicationID");
        Log.d(TAG, "appid: '" + app_id + "' clientkey: '" + client_key + "'");
        Parse.initialize(this, app_id, client_key);
        ParseInstallation.getCurrentInstallation().saveInBackground();
    }

}
