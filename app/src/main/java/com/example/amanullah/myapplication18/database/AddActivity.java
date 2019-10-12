package com.example.amanullah.myapplication18.database;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.amanullah.myapplication18.R;
import com.example.amanullah.myapplication18.ScrollingActivity;

public class AddActivity extends ActionBarActivity {


    private EditText subjectEditText;
    private EditText descEditText;
    private EditText phone_text;
    private EditText mobile_text;
    private EditText email_text;
    private EditText work_text;
    private EditText home_text;
    private EditText fb_text;
    private EditText roll_text;

    CollapsingToolbarLayout collapsingToolbar;
    ImageView imageView;
    ImageView imageView11;
    Bitmap image_bitmap;
    public Button add_photo;
    private static final int PICK_FROM_GALLERY = 2;

    private DBManager dbManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_edit1);


        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        imageView= (ImageView) findViewById(R.id.header_img);
        imageView11= (ImageView) findViewById(R.id.header_img2);
        image_bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.wpb);

        subjectEditText = (EditText) findViewById(R.id.editText_name1e);
        descEditText = (EditText) findViewById(R.id.editText_name1e2);
        phone_text = (EditText) findViewById(R.id.editText_phonee);
        mobile_text = (EditText) findViewById(R.id.editText_mobilee);
        email_text = (EditText) findViewById(R.id.editText_emaile);
        work_text = (EditText) findViewById(R.id.editText_addresse2);
        home_text = (EditText) findViewById(R.id.editText_addresse1);
        fb_text = (EditText) findViewById(R.id.editText_fbe);
        roll_text = (EditText) findViewById(R.id.editText_rolle);
        //descEditText = (EditText) findViewById(R.id.editText_name1e2);

        add_photo = (Button) findViewById(R.id.button_photo);
        add_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "click button", Toast.LENGTH_LONG).show();
                Intent intent = new Intent();
                //******call android default gallery
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                //******code for crop image
                intent.putExtra("crop", "true");
                intent.putExtra("aspectX", 0);
                intent.putExtra("aspectY", 0);
                intent.putExtra("outputX", 300);
                intent.putExtra("outputY", 300);
                try {
                    intent.putExtra("return-data", true);
                    startActivityForResult(Intent.createChooser(intent,"Complete action using"), PICK_FROM_GALLERY);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getApplicationContext(), "Exception", Toast.LENGTH_LONG).show();
                }
            }
        });

        dbManager = new DBManager(this);
        dbManager.open();
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

            final String name = subjectEditText.getText().toString();
            final String desc = descEditText.getText().toString();
            final String phone = phone_text.getText().toString();
            final String mobile = mobile_text.getText().toString();
            final String email = email_text.getText().toString();
            final String home = home_text.getText().toString();
            final String work = work_text.getText().toString();
            final String fb = fb_text.getText().toString();
            final String roll = roll_text.getText().toString();
            //final String desc = descEditText.getText().toString();

            //dbManager.insert(name, desc,phone);
            dbManager.insert(name, desc,phone,mobile,email,home,work,fb,roll,image_bitmap);

            Intent main = new Intent(AddActivity.this, ListActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            startActivity(main);

            //startActivity(new Intent(ScrollingActivity.this, Edit1.class));
            return true;
        }
        if (id == R.id.action_delete) {
            //startActivity(new Intent(ScrollingActivity.this, Edit1.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == PICK_FROM_GALLERY) {
                Bundle extras2 = data.getExtras();
                if (extras2 != null) {
                    image_bitmap = extras2.getParcelable("data");
                    //imageView.setImageBitmap(photo);
                    imageView11.setImageBitmap(image_bitmap);
                    //collapsingToolbar.setBackgroundResource(photo);
                }
            }
        } else {
            // report failure
            //Toast.makeText(getApplicationContext(), R.string.msg_failed_to_get_intent_data, Toast.LENGTH_LONG).show();
            Log.d(AddActivity.class.getSimpleName(), "Failed to get intent data, result code is " + resultCode);
        }
    }

}