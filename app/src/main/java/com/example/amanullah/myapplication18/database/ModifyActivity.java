package com.example.amanullah.myapplication18.database;



import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
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

public class ModifyActivity extends ActionBarActivity {

    private EditText name_Text;
    private EditText nickname_Text;
    private EditText phone_text;
    private EditText mobile_text;
    private EditText email_text;
    private EditText work_text;
    private EditText home_text;
    private EditText fb_text;
    private EditText roll_text;
    ImageView imageView11;
    Bitmap image_bitmap;

    public Button add_photo;

    private static final int PICK_FROM_GALLERY = 2;

    private long _id;

    private DBManager dbManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Modify Record");

        setContentView(R.layout.activity_edit1);

        dbManager = new DBManager(this);
        dbManager.open();

        image_bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.wpb);
        imageView11= (ImageView) findViewById(R.id.header_img2);
        name_Text = (EditText) findViewById(R.id.editText_name1e);
        nickname_Text = (EditText) findViewById(R.id.editText_name1e2);
        phone_text = (EditText) findViewById(R.id.editText_phonee);
        mobile_text = (EditText) findViewById(R.id.editText_mobilee);
        email_text = (EditText) findViewById(R.id.editText_emaile);
        work_text = (EditText) findViewById(R.id.editText_addresse2);
        home_text = (EditText) findViewById(R.id.editText_addresse1);
        fb_text = (EditText) findViewById(R.id.editText_fbe);
        roll_text = (EditText) findViewById(R.id.editText_rolle);

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


        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String name = intent.getStringExtra("id2");
        String nickname = intent.getStringExtra("id3");
        String phone = intent.getStringExtra("id4");
        String mobile = intent.getStringExtra("id5");
        String email = intent.getStringExtra("id6");
        String home = intent.getStringExtra("id7");
        String work = intent.getStringExtra("id8");
        String fb = intent.getStringExtra("id9");
        String roll = intent.getStringExtra("id10");

        _id = Long.parseLong(id);

        name_Text.setText(name);
        nickname_Text.setText(nickname);
        phone_text.setText(phone);
        mobile_text.setText(mobile);
        email_text.setText(email);
        home_text.setText(home);
        work_text.setText(work);
        fb_text.setText(fb);
        roll_text.setText(roll);

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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_scrolling_edit, menu);
        return true;
    }

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

            String title = name_Text.getText().toString();
            String desc = nickname_Text.getText().toString();
            String phone = phone_text.getText().toString();
            String mobile = mobile_text.getText().toString();
            String email = email_text.getText().toString();
            String home = home_text.getText().toString();
            String work = work_text.getText().toString();
            String fb = fb_text.getText().toString();
            String roll = roll_text.getText().toString();
            //final String desc = descEditText.getText().toString();


            dbManager.update(_id, title, desc,phone,mobile,email,home,work,fb,roll,image_bitmap);
            //dbManager.update(_id, title, desc);
            this.returnHome();

            //startActivity(new Intent(ScrollingActivity.this, Edit1.class));
            return true;
        }
        if (id == R.id.action_delete) {
            dbManager.delete(_id);
            this.returnHome();

            //startActivity(new Intent(ScrollingActivity.this, Edit1.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void returnHome() {
        Intent home_intent = new Intent(getApplicationContext(), ListActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(home_intent);
    }
}
