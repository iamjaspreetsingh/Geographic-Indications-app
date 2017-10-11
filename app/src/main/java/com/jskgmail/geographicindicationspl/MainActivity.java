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
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListViewAdapter lviewAdapter;
    private ArrayList<String> stringArrayList, stringArrayList1;
    private ArrayList<StorageReference> stringArrayList2;

    private static StorageReference mStorageRef;
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
                    Intent ii=new Intent(MainActivity.this,Main3Activity.class);
                    startActivity(ii);
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









        stringArrayList = new ArrayList<String>();


        stringArrayList1 = new ArrayList<String>();
        stringArrayList2 = new ArrayList<StorageReference>();


        ListView l=(ListView)findViewById(R.id.lv);




  StorageReference  riversRef = mStorageRef.child("gitea.jpg");
        StorageReference riversRef2 = mStorageRef.child("ks.jpg");
        StorageReference riversRef3 = mStorageRef.child("no.jpg");
        final StorageReference riversRef4 = mStorageRef.child("ped.jpg");
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

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });


        stringArrayList.add("Darjeeling Tea");
        stringArrayList1.add("Champagne of Teas ");
        stringArrayList2.add(riversRef);


        stringArrayList.add("Kullu Shawl");
        stringArrayList1.add("Designed both ends");
        stringArrayList2.add(riversRef2);



        stringArrayList.add("Nagpur Oranges");
        stringArrayList1.add("Direct from Orange City");
        stringArrayList2.add(riversRef3);

        stringArrayList.add("Mathura Peda");
        stringArrayList1.add("Sweet unique Delicacy of Karnataka");
        stringArrayList2.add(riversRef4);



        lviewAdapter = new ListViewAdapter(this, stringArrayList, stringArrayList1, stringArrayList2);
        l.setAdapter(lviewAdapter);

l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(MainActivity.this,Main22Activity.class);
        String ok;
        if(position==0) ok="Darjeeling Tea";
       else if(position==1) ok="Kullu Shawl";
        else if(position==2) ok="Mathura Peda";
        else  ok="Nagpur Orange";
        intent.putExtra("name",ok);
        startActivity(intent);

    }
});
    }



}
