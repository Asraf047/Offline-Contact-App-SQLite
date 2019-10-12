package com.example.amanullah.myapplication18;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by AMANULLAH on 21-Nov-17.
 */

public class ListActivity2 extends BaseAdapter {

    Context context;
    LayoutInflater layoutinflater;

    String[] name={"one","two","three","four","five","six","seven","eight","nine","ten",
            "one","two","three"};

    int[] rolls ={1,2,3,4,5,6,7,8,9,10,11,12,13};

    int[] img={R.drawable.wa,R.drawable.waa,R.drawable.wa,R.drawable.waaa,R.drawable.waaa,R.drawable.waaaa,R.drawable.waaaaa,
            R.drawable.wb,R.drawable.wbb,R.drawable.wbbbbb,R.drawable.wbbbb,R.drawable.wd,R.drawable.wdd};


    public ListActivity2(Context context){
        this.context=context;
        layoutinflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return img.length;
    }

    @Override
    public Object getItem(int position) {
        return img[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view=layoutinflater.inflate(R.layout.item_list_content,null);

        final ImageView imgview=(ImageView)view.findViewById(R.id.image);
        final TextView textimg=(TextView)view.findViewById(R.id.iroll);
        final TextView textroll=(TextView)view.findViewById(R.id.id1);

/*
        imgview.setImageResource(img[position]);
        final BitmapFactory.Options options=new BitmapFactory.Options();
        options.inSampleSize=16;
        Bitmap bm =BitmapFactory.decodeResource(context.getResources(),img[position],options);
        imgview.setImageBitmap(bm);
*/

        imgview.setImageBitmap(decodeSampleBitmapFromResource(context.getResources(),img[position],50,50));
        textimg.setText(name[position]);
        textroll.setText(String.valueOf(rolls[position]));

        final String textimgvalue=textimg.getText().toString();
        final String textrollvalue=textroll.getText().toString();

        view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(context,textimgvalue+"\n"+textrollvalue,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, ScrollingActivity.class);
                context.startActivity(intent);
            }
        });

        return view;
    }

    public static int calculateInSampleSize(BitmapFactory.Options options,int reqWidth,int reqHight){
        final int hight =options.outHeight;
        final int widht =options.outWidth;
        int inSampleSize=1;
        if(hight>reqHight || widht>reqWidth){
            final int halfHeight=hight/2;
            final int halfwidht=widht/2;
            while (halfHeight/inSampleSize>reqHight && halfwidht/inSampleSize>reqWidth){
                inSampleSize*=2;
            }
        }
        return inSampleSize;
    }

    public static Bitmap decodeSampleBitmapFromResource(Resources res,int resId,int reqWidth,int reqHight){
        final BitmapFactory.Options options=new BitmapFactory.Options();
        options.inJustDecodeBounds=true;
        BitmapFactory.decodeResource(res,resId,options);

        options.inSampleSize=calculateInSampleSize(options,reqWidth,reqHight);

        options.inJustDecodeBounds=false;
        return BitmapFactory.decodeResource(res,resId,options);
    }

}
