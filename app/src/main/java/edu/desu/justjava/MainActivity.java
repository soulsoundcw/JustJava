package edu.desu.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    int quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = calculatePrice();
        String message = createOrderSummary(price);
        displayMessage(message);
    }
    public void increment(View view) {
        quantity= quantity + 1;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        quantity = quantity-1;
        displayQuantity(quantity);
    }

    public String createOrderSummary(int price){
        String message="Name: Kaptain Kunal\nQuantity: "+quantity+"\nTotal: "+ NumberFormat.getCurrencyInstance().format(price) +"\nThank You!";
        return message;
    }

    /**
     * This method displays the given quantity value on the screen.
     */

    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(message);
    }

    /**
     * Calculates the price of the order based on the current quantity.
     *
     * @return the price
     */
    //private int calculatePrice(int quantity) {
    //int price = quantity * 5;
    //return price;
    //}

    /**
     * Calculates the price of the order.
     *
     * @param quantity is the number of cups of coffee ordered
     */
    private int calculatePrice() {
        return quantity * 5;
    }
}