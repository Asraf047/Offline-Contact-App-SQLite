package com.example.amanullah.myapplication18;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        // Show the Home button/Up button/back button in the action bar...
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            //actionBar.setDisplayUseLogoEnabled(true);
        }

        /*
        FrameLayout frameLayout= (FrameLayout) findViewById(R.id.row_call);
        LinearLayout linearLayout= (LinearLayout) findViewById(R.id.layout);
        TextView textView= (TextView) findViewById(R.id.text11);
        ListView listView= (ListView) findViewById(R.id.list);
        textView.setLongClickable(true);
        frameLayout.requestDisallowInterceptTouchEvent(true);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            public boolean onItemLongClick(AdapterView<?> arg0, View v, int index, long arg3) {

                Toast.makeText(ScrollingActivity.this, "Long clicked", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        */
    }

    //Show manu option icon...
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    //Manu item(Home button,Setting,...)action setting..
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            NavUtils.navigateUpTo(this, new Intent(this, ListActivity1.class));
            return true;
        }
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_edit) {
            startActivity(new Intent(ScrollingActivity.this, Edit1.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void call(View view) {
        Toast.makeText(ScrollingActivity.this, "call", Toast.LENGTH_SHORT).show();
    }

    public void msg(View view) {
        Toast.makeText(ScrollingActivity.this, "msg", Toast.LENGTH_SHORT).show();
    }

    public void email(View view) {
        Toast.makeText(ScrollingActivity.this, "email", Toast.LENGTH_SHORT).show();
    }

    public void work(View view) {
        Toast.makeText(ScrollingActivity.this, "work", Toast.LENGTH_SHORT).show();
    }

    public void home(View view) {
        Toast.makeText(ScrollingActivity.this, "home", Toast.LENGTH_SHORT).show();
    }

    public void direction(View view) {
        Toast.makeText(ScrollingActivity.this, "direction", Toast.LENGTH_SHORT).show();
    }


}