package com.jskgmail.geographicindicationspl;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private StorageReference mStorageRef;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:


                    return true;
                case R.id.navigation_dashboard:
                    Intent i=new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(i);
                    return true;
                case R.id.navigation_notifications:

                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mStorageRef = FirebaseStorage.getInstance().getReference();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Spinner spin=(Spinner)findViewById(R.id.spinner2);


        List<String> category1 = new ArrayList<String>();
        category1.add("Choice");
        category1.add("Popularity ");
        category1.add("Avg Customer rating ");
        category1.add("Price ");



        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, category1);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spin.setAdapter(dataAdapter1);

        spin.setSelection(0);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





















        StorageReference riversRef = mStorageRef.child("gitea.jpg");
        StorageReference riversRef3 = mStorageRef.child("ks.jpg");
        StorageReference riversRef4 = mStorageRef.child("no.jpg");
        StorageReference riversRef2 = mStorageRef.child("ped.jpg");
        final ProgressBar progress=(ProgressBar)findViewById(R.id.progressBar5) ;
        progress.setIndeterminate(true);
        riversRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                // Got the download URL for 'users/me/profile.png'
                progress.setIndeterminate(false);
                progress.setVisibility(View.GONE);
                 }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });

        riversRef2.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                // Got the download URL for 'users/me/profile.png'

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });
        riversRef3.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                // Got the download URL for 'users/me/profile.png'
                progress.setIndeterminate(false);
                progress.setVisibility(View.GONE);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });
        riversRef4.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                // Got the download URL for 'users/me/profile.png'
                progress.setIndeterminate(false);
                progress.setVisibility(View.GONE);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });

        ImageView imageView=(ImageView)findViewById(R.id.imageView6);
        Glide.with(getApplicationContext())
                .using(new FirebaseImageLoader())
                .load(riversRef)
                .into(imageView);


        ImageView imageView3=(ImageView)findViewById(R.id.imageView8);
        Glide.with(getApplicationContext())
                .using(new FirebaseImageLoader())
                .load(riversRef3)
                .into(imageView3);
        ImageView imageView4=(ImageView)findViewById(R.id.imageView9);
        Glide.with(getApplicationContext())
                .using(new FirebaseImageLoader())
                .load(riversRef4)
                .into(imageView4);
        ImageView imageView2=(ImageView)findViewById(R.id.imageView7);
        Glide.with(getApplicationContext())
                .using(new FirebaseImageLoader())
                .load(riversRef2)
                .into(imageView2);


    }



}
