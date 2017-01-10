package com.example.josiah.budgetapp1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Josiah on 12/19/2016.
 */

public class BillAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    ArrayList<Bill> mDataSource;

    public BillAdapter(Context context, ArrayList<Bill> items) {
        mContext = context;
        mDataSource = items;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mDataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Get new xml for new view for more info on row item
        View rowView =

                mInflater.inflate(R.layout.list_item_bill, parent, false);


        //get elements for bill title, amount due, date due, and bill URL
        TextView titleTextView = (TextView) rowView.findViewById(R.id.bill_list_title);
        TextView amountDueTextView = (TextView) rowView.findViewById(R.id.bill_amount_due);
        TextView dateDueTextView = (TextView) rowView.findViewById(R.id.bill_date_due);
        ImageView statusImageView = (ImageView) rowView.findViewById(R.id.status_image_view);

        //populate elements with data
        Bill bill = (Bill) getItem(position);

        titleTextView.setText(bill.name);
        //convert double to string
        amountDueTextView.setText("$" + String.valueOf(bill.balanceDue));
        dateDueTextView.setText("**/" + String.valueOf(bill.dayDue));
        //set image based on if bill.paid boolean

        if (bill.paid == "yes"){
            statusImageView.setImageResource(R.drawable.paid);
        } else {
            statusImageView.setImageResource(R.drawable.unpaid);
        }

        return rowView;
    }
}
