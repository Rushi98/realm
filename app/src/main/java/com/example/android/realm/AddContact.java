package com.example.android.realm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.realm.Realm;

public class AddContact extends AppCompatActivity {


    Realm mydatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        final EditText nameET = (EditText) findViewById(R.id.nameEt);
        final EditText phoneET = (EditText) findViewById(R.id.phoneEt);
        final EditText emailET = (EditText) findViewById(R.id.emailEt);
        Button submitBtn = (Button) findViewById(R.id.submitBtn);

        mydatabase = Realm.getDefaultInstance();

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //display count everytime clicked
                Log.e("TAG",mydatabase.where(ContactItem.class).findAll().size() + " is the count");

                String name = nameET.getText().toString();
                String phone = phoneET.getText().toString();
                String email = emailET.getText().toString();

                //add to database
                mydatabase.beginTransaction();
                ContactItem ci = mydatabase.createObject(ContactItem.class);
                ci.setName(name);
                ci.setEmail(email);
                ci.setPhone(phone);
                mydatabase.commitTransaction();

            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mydatabase.close();
    }
}
