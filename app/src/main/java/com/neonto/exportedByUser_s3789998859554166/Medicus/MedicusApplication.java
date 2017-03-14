package com.neonto.exportedByUser_s3789998859554166.Medicus;

import android.app.Application;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Timer;
import java.util.TimerTask;

public class MedicusApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppData.listDataDataSheet = new ListDataDataSheet(this);
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        
        if (level >= TRIM_MEMORY_RUNNING_LOW) {
            AppData.listDataDataSheet.releaseCachedData();
        }
    }
}
