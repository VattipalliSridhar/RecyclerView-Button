package com.indiaapps.recycleviewtask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity
{

    RecyclerView recyclerView;

    private String[] fruitlist = new String[]{"Apples", "Oranges", "Potatoes", "Tomatoes","Grapes"};

    Custom_Adapter custom_adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        custom_adapter = new Custom_Adapter(MainActivity.this, fruitlist);
        recyclerView.setAdapter(custom_adapter);

    }
}
