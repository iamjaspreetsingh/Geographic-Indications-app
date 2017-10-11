package com.jskgmail.geographicindicationspl;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Main22Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main22);

        ImageView imageView=(ImageView)findViewById(R.id.imageView);
TextView textView=(TextView)findViewById(R.id.textView11);
Button b=(Button)findViewById(R.id.button2);
        String nam=getIntent().getStringExtra("name");
        if(nam.equals("Darjeeling Tea")) {
            imageView.setImageResource(R.mipmap.gitean);
        textView.setText("Darjeeling tea is a tea from the Darjeeling district in West Bengal, India. It is available in black, green, white and oolong. When properly brewed, it yields a thin-bodied, light-coloured infusion with a floral aroma. The flavour can include a tinge of astringent tannic characteristics and a musky spiciness ");
           b.setVisibility(View.INVISIBLE);       }  else if(nam.equals("Kullu Shawl"))
        {  imageView.setImageResource(R.mipmap.ks);
           textView.setText("A Kullu shawl is a type of shawl made in Kullu, India, featuring various geometrical patterns and bright colors. Originally, indigenous Kulivi people would weave plain shawls, but following the arrival of craftspeople from Bushehar in the early 1940s, the trend of more patterned shawls came to rise.[1]");}
            else if(nam.equals("Mathura Peda")) {
            imageView.setImageResource(R.mipmap.peddd); b.setVisibility(View.VISIBLE);
            textView.setText("It is made of milk which is heated and stirred continuously, with added flavor and sugar. As a result, it can be considered a kind of caramel.");
        }else
        { imageView.setImageResource(R.mipmap.no);
        textView.setText("It is rustic and pockmarked exterior which is sweet and has juicy pulp.");b.setVisibility(View.INVISIBLE);}
        TextView t=(TextView)findViewById(R.id.textView3);
        t.setText(nam);

        Button des=(Button)findViewById(R.id.button2);
        des.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go();
            }
        });



    }
    void go()
    {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.design, null);



        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle(" Design ");
        alert.setIcon(R.drawable.ic_publish_black_24dp);
        // this is set the view from XML inside AlertDialog
        alert.setView(alertLayout);

        // disallow cancel of AlertDialog on click of back button and outside touch

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });


        alert.setPositiveButton("Done", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {


            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();


    }
}
