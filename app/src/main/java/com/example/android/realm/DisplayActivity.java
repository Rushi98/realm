package com.example.android.realm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myDatabase.close();
    }

    Realm myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        //Initialise views
        Button showBtn = (Button) findViewById(R.id.show_button);

        final TextView nameTv = (TextView) findViewById(R.id.name_tv);
        final TextView emailTv = (TextView) findViewById(R.id.email_tv);
        final TextView phoneTv = (TextView) findViewById(R.id.phone_tv);

        //Get a reference to your realm database
        myDatabase = Realm.getDefaultInstance();

        //Create an empty list of data type ContactItem
        //Realm list is similar to List
        final RealmList<ContactItem> myList = new RealmList<>();

        //Now fetch result of query
        RealmResults<ContactItem> myRealmQueryResults = myDatabase.where(ContactItem.class).("name","key").findAll();

        //Add the result to ur list
        //RealmResults can also be used similar to RealmList but there are quite a lot of restrictions
        myList.addAll(myRealmQueryResults);

        //List is ready

        //add a listener to the button for click detection
        //opt 1 : showBtn.setOnClickListener(this); and implement View.OnClickListener, override the onClick method
        //opt 2
        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Button clicked, show first entry
                //Error will occur if list is empty
                nameTv.setText(myList.get(0).getName());
                phoneTv.setText(myList.get(0).getPhone());
                emailTv.setText(myList.get(0).getEmail());

                //Also show complete data in log
                for (int i = 0; i < myList.size(); i++) {
                    Log.e("my TAG", myList.get(i).toString());
                }

            }
        });


    }
}
