package com.example.josiah.budgetapp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MyActivity";

    //create a listview
    private ListView mListView;

    Bill firstBill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Link ListView with
        mListView = (ListView) findViewById(R.id.bill_list_view);

        //Create a list of bills. Populate each bill with info from file
        final ArrayList<Bill> bills = Bill.getBillsFromFile("Bills.json", this);
        //Create a list for each bill's name
        String[] billNames = new String[bills.size()];

        for(int i = 0; i < bills.size(); i++) {
            //Populate string list of Bill's names
            Bill bill = bills.get(i);
            billNames[i] = bill.name;
            Log.d("TAG", "Bill " + (i + 1) + " name added");
        }
        Log.d("TAG", "Bill name list complete. " + bills.size() + " names added.");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, billNames);
        mListView.setAdapter(adapter);

    }
}
