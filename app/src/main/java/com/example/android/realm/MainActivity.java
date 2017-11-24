package com.example.android.realm;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button addBtn = (Button) findViewById(R.id.add);
        Button displBtn = (Button) findViewById(R.id.display);

        addBtn.setOnClickListener(this);
        displBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        int id = view.getId();

        switch (id) {
            case R.id.add :
                Intent intent = new Intent(this,AddContact.class);
                startActivity(intent);
                break;
            case R.id.display :
                Intent intent1 = new Intent(this,DisplayActivity.class);
                startActivity(intent1);
        }
    }
}
