package com.example.amanullah.myapplication18.database;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.amanullah.myapplication18.R;

public class ListActivity extends ActionBarActivity {

    private DBManager dbManager;

    private ListView listView;

    private SimpleCursorAdapter adapter;

    final String[] from = new String[] { DatabaseHelper._ID, DatabaseHelper.NAME, DatabaseHelper.NICK_NAME ,DatabaseHelper.PHONE,
            DatabaseHelper.MOBILE,DatabaseHelper.EMAIL,DatabaseHelper.HOME,DatabaseHelper.WORK,DatabaseHelper.FB,
            DatabaseHelper.ROLL,DatabaseHelper.IMG};

    final int[] to = new int[] { R.id.id1, R.id.iname, R.id.inickname ,R.id.iphone, R.id.imobile, R.id.iemail ,
            R.id.ihome, R.id.iwork, R.id.ifb, R.id.iroll };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list);

        dbManager = new DBManager(this);
        dbManager.open();
        Cursor cursor = dbManager.fetch();

        listView = (ListView) findViewById(R.id.list);
        //listView.setEmptyView(findViewById(R.id.empty));

        //add elements to the list from the query results that are returned in an Cursor Object
        adapter = new SimpleCursorAdapter(this, R.layout.item_list_content, cursor, from, to, 0);
        adapter.notifyDataSetChanged();

        listView.setAdapter(adapter);

        // OnCLickListiner For List Items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {
                TextView idTextView = (TextView) view.findViewById(R.id.id1);
                TextView inameTextView = (TextView) view.findViewById(R.id.iname);
                TextView inicknameTextView = (TextView) view.findViewById(R.id.inickname);
                TextView iphoneTextView = (TextView) view.findViewById(R.id.iphone);
                TextView imobileTextView = (TextView) view.findViewById(R.id.imobile);
                TextView iemailTextView = (TextView) view.findViewById(R.id.iemail);
                TextView ihomeTextView = (TextView) view.findViewById(R.id.ihome);
                TextView iworkTextView = (TextView) view.findViewById(R.id.iwork);
                TextView ifbTextView = (TextView) view.findViewById(R.id.ifb);
                TextView irollTextView = (TextView) view.findViewById(R.id.iroll);

                String id = idTextView.getText().toString();
                String id2 = inameTextView.getText().toString();
                String id3 = inicknameTextView.getText().toString();
                String id4 = iphoneTextView.getText().toString();
                String id5 = imobileTextView.getText().toString();
                String id6 = iemailTextView.getText().toString();
                String id7 = ihomeTextView.getText().toString();
                String id8 = iworkTextView.getText().toString();
                String id9 = ifbTextView.getText().toString();
                String id10 = irollTextView.getText().toString();

                Intent modify_intent = new Intent(getApplicationContext(), ResultActivity.class);
                modify_intent.putExtra("id", id);
                modify_intent.putExtra("id2", id2);
                modify_intent.putExtra("id3", id3);
                modify_intent.putExtra("id4", id4);
                modify_intent.putExtra("id5", id5);
                modify_intent.putExtra("id6", id6);
                modify_intent.putExtra("id7", id7);
                modify_intent.putExtra("id8", id8);
                modify_intent.putExtra("id9", id9);
                modify_intent.putExtra("id10", id10);

                startActivity(modify_intent);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                final Context context = getApplicationContext();
                Intent intent = new Intent(context, AddActivity.class);
                startActivity(intent);
            }
        });
    }


}