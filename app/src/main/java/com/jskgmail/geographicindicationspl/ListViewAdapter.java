package com.jskgmail.geographicindicationspl;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by JASPREET SINGH on 05-10-2017.
 */

class ListViewAdapter extends BaseAdapter {
    Activity context;
    ArrayList<String> title;
    ArrayList<String> description;
    ArrayList<String> per;
    ArrayList<String> perincdec;
    ArrayList<String> ch;

    public ListViewAdapter(MainActivity context, ArrayList<String> title, ArrayList<String> description, ArrayList<String> per, ArrayList<String> perincdec, ArrayList<String> ch)
    {
        super();
        this.context=context;
        this.title=title;
        this.description=description;
        this.per=per;
        this.perincdec=perincdec;
        this.ch=ch;
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
        TextView txtper;
        TextView txtperincde;

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
            holder.txtviewtitle=(TextView)convertView.findViewById(R.id.textView2);



            holder.txtviewdesc=(TextView)convertView.findViewById(R.id.textView3);

holder.img=(ImageView)convertView.findViewById(R.id.imageView);


        }
        else{
            holder=(ViewHolder)convertView.getTag();
        }
        holder.txtviewdesc.setText(description.get(position));

        holder.txtviewtitle.setText(title.get(position));



        notifyDataSetChanged();
        return convertView;

    }


}
