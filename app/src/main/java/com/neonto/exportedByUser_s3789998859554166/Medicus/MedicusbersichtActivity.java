/*
 * This package name is autogenerated by Neonto Studio
 * when using 'Open in Android Studio'.
 * 
 * To change the package name, use 'Export' instead.
 */

package com.neonto.exportedByUser_s3789998859554166.Medicus;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.neonto.exportedByUser_s3789998859554166.Medicus.R;

public class MedicusbersichtActivity extends android.support.v7.app.ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_medicusbersicht);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new MedicusbersichtFragment())
                    .commit();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
