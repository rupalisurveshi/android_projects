package com.example.android.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int quantity = 2 ;
    int price = 10 ;
    int topping = 15 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayQuantity(quantity);
    }

    public void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        String data = Integer.toString(number);
        quantityTextView.setText(data);
    }

    public void displayOrderSummary(int totalMoney, boolean whippedCream){
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        String stringMoney = Integer.toString(totalMoney);
        int totalTopping = topping * quantity ;
        String stringTopping = Integer.toString(totalTopping);
        int grandTotal = totalMoney + totalTopping ;
        String stringTotal = Integer.toString(grandTotal) ;
        String message = "Name: Rupali\n" + "Add whipped cream topping: " + whippedCream +"\nQuantity: " + quantity + "\ncoffe charges: " + stringMoney + "\nTopping: " + stringTopping + "\nTotal: $" + stringTotal + "\nThank You!" ;
        priceTextView.setText(message);
    }

    public void submitOrder(View view){
        CheckBox checked = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean isWhippedCream = checked.isChecked();
        int total = quantity * price ;
        displayOrderSummary(total, isWhippedCream) ;
    }

    /**
     * This method icrements the quantity when + button is clicked.
     */
    public void incrementValue(View view) {
        quantity = quantity + 1 ;
        displayQuantity(quantity);
    }

    /**
     * This method decrements the quantity when - button is clicked.
     */
    public void decrementValue(View view) {
        quantity = quantity - 1 ;
        displayQuantity(quantity);
    }
}
