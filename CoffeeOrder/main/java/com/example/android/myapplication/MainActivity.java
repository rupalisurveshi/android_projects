package com.example.android.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

    public String displayOrderSummary(int totalMoney, boolean whippedCream, boolean chocolate){
        int totalTopping = topping * quantity ;
        int totalChoco = choco * quantity ;
        int grandTotal = totalMoney + totalTopping + totalChoco;

        EditText nameTextView = (EditText) findViewById(R.id.customer_name_text_view);
        String customerName = nameTextView.getText().toString();

        String message = "Name: " + customerName + "\nAdd whipped cream topping: " + whippedCream + "\nAdd chocolate : " + chocolate + "\nQuantity: " + quantity + "\nCoffee charges: " + totalMoney + "\nTopping: " + totalTopping + "\nChocolate: " + totalChoco + "\nTotal: $" + grandTotal + "\nThank You!" ;
        return(message) ;

    }

    public void submitOrder(View view){

        CheckBox whippedCreamChecked = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean isWhippedCream = whippedCreamChecked.isChecked();

        CheckBox chocolateChecked = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean isChocolate = chocolateChecked.isChecked();

        int total = quantity * price ;
        String message = displayOrderSummary(total, isWhippedCream, isChocolate) ;

//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        intent.setData(Uri.parse("geo:47.6,-122.3"));
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        }

        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
        String addresses = "abc@gmail.com, def@gmail.com" ;
        String  subject = "order summary" ;

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        //intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * This method icrements the quantity when + button is clicked.
     */
    public void incrementValue(View view) {
        if (quantity == 100) {
            Context context = getApplicationContext();
            CharSequence text = "You cannot have more than 100 coffees";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);

    }

    /**
     * This method decrements the quantity when - button is clicked.
     */
    public void decrementValue(View view) {
        if (quantity == 1) {
            Context context = getApplicationContext();
            CharSequence text = "You cannot have less than 1 coffees";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }
}
