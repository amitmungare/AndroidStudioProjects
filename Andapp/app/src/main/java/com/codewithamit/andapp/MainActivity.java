package com.codewithamit.andapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int quantity=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {

        CheckBox WhippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkBox);
        boolean hasWhippedCream = WhippedCreamCheckBox.isChecked();

        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name =nameField.getText().toString();

        if(quantity>=1) {
            displayPrice(quantity * 5);
            display(quantity);
        }else{
            displayPrice(0);
            display(0);
        }

        if(hasWhippedCream==true){
            for(int i=1;i<=quantity;i++){
                displayPrice(quantity *5+i);
            }

        }else{
            displayPrice(quantity*5);
        }

        createDisplayContext(quantity);

        creatOrderSummary(hasWhippedCream);

        name_txt(name);


    }

    public void email_order(String name) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "order of :"+name);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    private String creatOrderSummary(boolean addWhippedCream){
        if(addWhippedCream ==true){
            TextView quantityTextview = (TextView) findViewById(R.id.textView8);
            quantityTextview.setText("Add whipped cream");
        }else{
            TextView quantityTextview = (TextView) findViewById(R.id.textView8);
            quantityTextview.setText("Do Not Add whipped cream");
        }
        return null;
    }

    private String name_txt(String name){
        TextView nameTxt = (TextView) findViewById(R.id.textView2);
        nameTxt.setText("Name: "+name);
        return null ;
    }

    private void createDisplayContext(int quantity) {
        TextView quantityTextview = (TextView) findViewById(R.id.textView3);
        quantityTextview.setText("Quantity: "+quantity);
    }

    private void display(int number) {
        TextView quantityTextview = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextview.setText(""+number);
    }


    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.textView4);
        priceTextView.setText("Total:$ "+NumberFormat.getCurrencyInstance().format(number));
    }

    public void increment(View view) {

        quantity++;
        display(quantity);
    }

    public void decrement(View view) {

        if(quantity >=1){
            quantity--;
            display(quantity);

        }else{
            display(0);
        }
    }

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.textView3);
        priceTextView.setText(message);
    }

}