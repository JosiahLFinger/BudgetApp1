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
        BillAdapter adapter = new BillAdapter(this, bills);
        mListView.setAdapter(adapter);

    }
}
