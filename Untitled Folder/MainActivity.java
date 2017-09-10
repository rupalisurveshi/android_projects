package com.example.android.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int quantity = 2 ;
    int price = 10 ;
    int topping = 15 ;
    int choco = 10 ;

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

    public void displayOrderSummary(int totalMoney, boolean whippedCream, boolean chocolate){
        int totalTopping = topping * quantity ;
        int totalChoco = choco * quantity ;
        int grandTotal = totalMoney + totalTopping + totalChoco;

        String stringMoney = Integer.toString(totalMoney);
        String stringTopping = Integer.toString(totalTopping);
        String stringChoco = Integer.toString(totalChoco);
        String stringTotal = Integer.toString(grandTotal) ;

        EditText nameTextView = (EditText) findViewById(R.id.customer_name_text_view);
        String customerName = nameTextView.getText().toString();

        String message = "Name: " + customerName + "\nAdd whipped cream topping: " + whippedCream + "\nAdd chocolate : " + chocolate + "\nQuantity: " + quantity + "\ncoffee charges: " + stringMoney + "\nTopping: " + stringTopping + "\nChocolate: " + stringChoco + "\nTotal: $" + stringTotal + "\nThank You!" ;

        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    public void submitOrder(View view){
        CheckBox whippedCreamChecked = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean isWhippedCream = whippedCreamChecked.isChecked();

        CheckBox chocolateChecked = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean isChocolate = chocolateChecked.isChecked();

        int total = quantity * price ;
        displayOrderSummary(total, isWhippedCream, isChocolate) ;
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
