package com.example.amanullah.myapplication18.database;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.amanullah.myapplication18.ListActivity1;
import com.example.amanullah.myapplication18.R;

/**
 * Created by AMANULLAH on 04-Dec-17.
 */

public class ResultActivity extends ActionBarActivity {

    private TextView name_Text;
    private TextView nickname_Text;
    private TextView phone_text;
    private TextView mobile_text;
    private TextView email_text;
    private TextView work_text;
    private TextView home_text;
    private TextView fb_text;
    private TextView roll_text;
    private TextView tweeter_text;
    ImageView imageViews;
    DatabaseHelper databaseHelper;

    private long _id;

    private DBManager dbManager;


    String id_;
    String name ;
    String nickname ;
    String phone ;
    String mobile ;
    String email ;
    String home ;
    String work;
    String fb ;
    String roll ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        //actionBar.setTitle("Edit Info");
        //actionBar.setSubtitle("  mytest");
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);}

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        dbManager = new DBManager(this);
        dbManager.open();
        imageViews= (ImageView) findViewById(R.id.header_img);
        //name_Text = (TextView) findViewById(R.id.text_extra);
        //nickname_Text = (TextView) findViewById(R.id.editText_name1e2);
        phone_text = (TextView) findViewById(R.id.text_phone);
        mobile_text = (TextView) findViewById(R.id.text_phone2);
        email_text = (TextView) findViewById(R.id.text_email);
        work_text = (TextView) findViewById(R.id.text_work);
        home_text = (TextView) findViewById(R.id.text_home);
        fb_text = (TextView) findViewById(R.id.text_fb);
        tweeter_text = (TextView) findViewById(R.id.text_tweeter);

        //updateBtn = (Button) findViewById(R.id.btn_update);
        //deleteBtn = (Button) findViewById(R.id.btn_delete);

        Intent intent = getIntent();
        id_ = intent.getStringExtra("id");
        name = intent.getStringExtra("id2");
         nickname = intent.getStringExtra("id3");
         phone = intent.getStringExtra("id4");
        mobile = intent.getStringExtra("id5");
         email = intent.getStringExtra("id6");
         home = intent.getStringExtra("id7");
         work = intent.getStringExtra("id8");
         fb = intent.getStringExtra("id9");
         roll = intent.getStringExtra("id10");

        _id = Long.parseLong(id_);

        actionBar.setTitle(name);
        //name_Text.setText(name);
        //nickname_Text.setText(nickname);
        phone_text.setText(phone);
        mobile_text.setText(mobile);
        email_text.setText(email);
        home_text.setText(home);
        work_text.setText(work);
        fb_text.setText(fb);
        tweeter_text.setText(roll);
        Bitmap m=databaseHelper.getImage(id_);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

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
            Intent modify_intent = new Intent(getApplicationContext(), ModifyActivity.class);
            modify_intent.putExtra("id", id_);
            modify_intent.putExtra("id2", name);
            modify_intent.putExtra("id3", nickname);
            modify_intent.putExtra("id4", phone);
            modify_intent.putExtra("id5", mobile);
            modify_intent.putExtra("id6", email);
            modify_intent.putExtra("id7", home);
            modify_intent.putExtra("id8", work);
            modify_intent.putExtra("id9", fb);
            modify_intent.putExtra("id10", roll);

            startActivity(modify_intent);

            //startActivity(new Intent(ResultActivity.this, Edit1.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void call(View view) {
        Toast.makeText(ResultActivity.this, "call", Toast.LENGTH_SHORT).show();
    }

    public void msg(View view) {
        Toast.makeText(ResultActivity.this, "msg", Toast.LENGTH_SHORT).show();
    }

    public void email(View view) {
        Toast.makeText(ResultActivity.this, "email", Toast.LENGTH_SHORT).show();
    }

    public void work(View view) {
        Toast.makeText(ResultActivity.this, "work", Toast.LENGTH_SHORT).show();
    }

    public void home(View view) {
        Toast.makeText(ResultActivity.this, "home", Toast.LENGTH_SHORT).show();
    }

    public void direction(View view) {
        Toast.makeText(ResultActivity.this, "direction", Toast.LENGTH_SHORT).show();
    }

    public void tweeter(View view) {
        Toast.makeText(ResultActivity.this, "Roll", Toast.LENGTH_SHORT).show();
    }

    public void facebook(View view) {
        Toast.makeText(ResultActivity.this, "Facebook", Toast.LENGTH_SHORT).show();
    }
}

