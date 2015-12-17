package com.besga.jonander.avisaaane;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseInstallation;

import java.io.IOException;
import java.util.Properties;

public class StarterApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Properties prop = new Properties();
        try {
            prop.load(getAssets().open("app.properties"));


        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Parse.initialize(this, prop.getProperty("ApplicationID"), prop.getProperty("ClientKey"));
        ParseInstallation.getCurrentInstallation().saveInBackground();




    }

}
