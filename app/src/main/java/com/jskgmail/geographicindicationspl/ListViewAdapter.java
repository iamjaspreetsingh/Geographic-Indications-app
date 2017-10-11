package com.jskgmail.geographicindicationspl;

/**
 * Created by JASPREET SINGH on 11-10-2017.
 */

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

class ListViewAdapter extends BaseAdapter {
    Activity context;
    ArrayList<String> title;
    ArrayList<String> description;
    ArrayList<StorageReference> per;


    public ListViewAdapter(MainActivity context, ArrayList<String> title, ArrayList<String> description, ArrayList<StorageReference> per)
    {
        super();
        this.context=context;
        this.title=title;
        this.description=description;
        this.per=per;

    }


    @Override
    public int getCount() {

        return title.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class ViewHolder{
        TextView txtviewtitle;
        TextView txtviewdesc;


        ImageView img;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        LayoutInflater inflater=context.getLayoutInflater();
        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.friend_item,null);
            holder=new ViewHolder();
            holder.txtviewtitle=(TextView)convertView.findViewById(R.id.textView);
            holder.txtviewdesc=(TextView)convertView.findViewById(R.id.textView2);
            holder.img=(ImageView)convertView.findViewById(R.id.imageView2);
            holder.txtviewtitle.setText(title.get(position));
            holder.txtviewdesc.setText(description.get(position));

            Glide.with(context)
                    .using(new FirebaseImageLoader())
                    .load(per.get(position))
                    .into(holder.img);



        }
        else{
            holder=(ViewHolder)convertView.getTag();
        }



        return convertView;

    }


}