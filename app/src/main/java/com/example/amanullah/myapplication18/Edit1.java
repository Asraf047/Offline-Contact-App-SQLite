package com.example.amanullah.myapplication18;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class Edit1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit1);



        ActionBar actionBar = getSupportActionBar(); // or getActionBar();
        //getSupportActionBar().setTitle("  app"); // set the top title
        actionBar.setTitle("Edit Info");
        //actionBar.setSubtitle("  mytest");
        //String title = actionBar.getTitle().toString(); // get the title
        //actionBar.hide();
        //actionBar.setBackgroundDrawable();
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        //getSupportActionBar().setDisplayUseLogoEnabled(true);

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }

    //Show manu option icon...
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling_edit, menu);
        return true;
    }

    //Manu item(Home button,Setting,...)action setting..
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            NavUtils.navigateUpTo(this, new Intent(this, ScrollingActivity.class));
            return true;
        }
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_right) {
            //startActivity(new Intent(ScrollingActivity.this, Edit1.class));
            return true;
        }
        if (id == R.id.action_delete) {
            //startActivity(new Intent(ScrollingActivity.this, Edit1.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
