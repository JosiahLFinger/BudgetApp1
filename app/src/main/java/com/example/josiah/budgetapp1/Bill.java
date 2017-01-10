package com.example.josiah.budgetapp1;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Josiah on 12/19/2016.
 */

public class Bill {

    public String name;
    public String url;
    public double balanceTotal;
    public double balanceDue;
    public int dayDue;
    public String paid; //was bill paid this month


    public static ArrayList<Bill> getBillsFromFile(String filename, Context context) {
        final ArrayList<Bill> billList = new ArrayList<>();

        try {
            //load data from file
            String jsonString = loadJsonFromAsset(filename, context);
            JSONObject json = new JSONObject(jsonString);
            JSONArray bills = json.getJSONArray("bills");

            for (int i = 0; i < bills.length(); i++) {
                Bill bill = new Bill();

                //Populate Bill with info from file
                bill.name = bills.getJSONObject(i).getString("name");
                bill.url = bills.getJSONObject(i).getString("url");
                bill.balanceTotal = bills.getJSONObject(i).getDouble("balanceTotal");
                bill.balanceDue = bills.getJSONObject(i).getDouble("balanceDue");
                bill.dayDue = bills.getJSONObject(i).getInt("dayDue");
                bill.paid = bills.getJSONObject(i).getString("paid");

                Log.d("TAG", "Bill " + (i + 1) + " added to list.");
                //Add bill to Bill list
                billList.add(bill);
            }

            Log.d("TAG", "The billList was made");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.d("TAG", "All Bills added to list");
        return billList;
    }

    private static String loadJsonFromAsset(String filename, Context context) {
        String json = null;

        try {
            InputStream is = context.getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        }
        catch (java.io.IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
