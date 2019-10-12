package com.example.amanullah.myapplication18;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

public class ListActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
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


        ListView list =(ListView)findViewById(R.id.list);

         ListActivity2 adapter=new ListActivity2(ListActivity1.this);

        list.setAdapter(adapter);



/*

// TODO:list view start..



        final ArrayList<String> mylist =new ArrayList<String>();

        mylist.add("0.one");
        mylist.add("1.two");
        mylist.add("2.three");
        mylist.add("3.four");
        mylist.add("4.one");
        mylist.add("5.two");
        mylist.add("6.three");
        mylist.add("7.four");
        mylist.add("8.one");
        mylist.add("9.two");
        mylist.add("10.three");
        mylist.add("11.four");
        mylist.add("12.one");
        mylist.add("13.two");
        mylist.add("14.three");
        mylist.add("15.four");

        //ArrayAdapter arrayAdapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, mylist);
        ListAdapter arrayAdapter1 = new ArrayAdapter<String>(this,R.layout.item_list_content,R.id.text1, mylist);
        list.setAdapter(arrayAdapter1);

        //final ArrayList<Integer> roll=new ArrayList<Integer>();
        //String[] rolls={"1","2","3"};

        Integer[] rol =new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        int[] img={R.drawable.wa,R.drawable.waa,R.drawable.wa,R.drawable.waaa,R.drawable.waaa,R.drawable.waaaa,R.drawable.waaaaa,
                R.drawable.wb,R.drawable.wbb,R.drawable.wbbbbb,R.drawable.wbbbb,R.drawable.wd,R.drawable.wdd};

        ListAdapter arrayAdapter2 = new ArrayAdapter<>(this,R.layout.item_list_content,R.id.roll, rol);
        list.setAdapter(arrayAdapter2);




//click command..
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Toast.makeText(getApplicationContext(), "Clicked On : " + mylist.get(position), Toast.LENGTH_SHORT).show();
                }  /*
                if(position==1) {
                    //Toast.makeText(getApplicationContext(), "Clicked On : " + mylist.get(position), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, ScrollingActivity.class);
                    startActivity(intent);
                }
                if(position==2) {
//TODO:primary storage picture folder er sob pic send kore...
                    Intent intent=null , chooser=null;
                    //Toast.makeText(getApplicationContext(), "Clicked On : " + mylist.get(position), Toast.LENGTH_SHORT).show();
                    //Intent intent = new Intent(context, MainActivitytab.class);
                    //startActivity(intent);
                    File pictures= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES); //storage/emulated/0/Pictures folder select kore
                    String[] listofpictures = pictures.list();  //Pictures folder theke sob file string_list e nilam..
                    Uri uri=null;
                    //Uri muri=Uri.parse("/storage/emulated/0/Pictures/"+R.Pictures.cse1);
                    ArrayList<Uri> arraylist = new ArrayList<Uri>();
                    for(String picture: listofpictures)
                    {
                        uri= Uri.parse("file://" + pictures.toString()+ "/" + picture);
                        //Toast.makeText(getApplicationContext(), "Clicked On : " + uri, Toast.LENGTH_LONG).show();
                        //uri= Uri.parse(pictures.toString()+ "/" + picture);
                        arraylist.add(uri);
                        //SimpleWebServer http=new SimpleWebServer();
                        //loadContent(uri);
                    }
                    intent = new Intent(Intent.ACTION_SEND_MULTIPLE);
                    intent.setType("image/*");
                    intent.putExtra(Intent.EXTRA_STREAM,arraylist);
                    chooser=Intent.createChooser(intent,"Send Multiple Image");
                    startActivity(chooser);
                }if(position==3) {
//TODO:build in multiple file picker...
                    //findViewById(R.id.pick_items).setOnClickListener(new View.OnClickListener() {
                    //@Override
                    // public void onClick(View view) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                        intent.addCategory(Intent.CATEGORY_OPENABLE);
                        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                        intent.setType("*/ /*");
                        startActivityForResult(intent, REQUEST_CODE);
                    } else {
                        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                        intent.setType("*//*");
                        startActivityForResult(intent, REQUEST_CODE);
                    }


                    // }
                    // });
                }
            }
        });

// TODO:list view finish..
*/


//            }
//        });
    }
}


