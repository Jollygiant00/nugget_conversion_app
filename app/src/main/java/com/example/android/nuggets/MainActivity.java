package com.example.android.nuggets;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.android.nuggets";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Initialize custom toolbar
         */
        Toolbar myToolbar = findViewById(R.id.app_toolbar);
        setSupportActionBar(myToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);

        //MenuItem preferencesItem = menu.findItem(R.id.action_preferences);
        //MenuItem aboutItem = menu.findItem(R.id.action_about);

        return super.onCreateOptionsMenu(menu);
    }

    /**
     * @param view
     *
     * Create explicit intent to CalculateWeightToNuggets activity
     * Pass button id used to call method
     */
    public void startCalculator(View view) {
        int resId = view.getId();
        Intent intent = new Intent(MainActivity.this, CalculateWeightToNuggets.class);
        /**
         * set string to resource id
         */
        String selectedView = getResources().getResourceEntryName(resId);
        intent.putExtra(EXTRA_MESSAGE, selectedView);

        if (selectedView.equals("nuggetCalcButton")) {

        } else if (selectedView.equals("grapeCalcButton")) {
            setTheme(R.style.PurpleTheme);
        }

        startActivity(intent);
    }
}
