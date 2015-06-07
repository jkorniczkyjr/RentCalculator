package com.example.RentCalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MyActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void onButtonClick(View v) {

        // User Inputs
        EditText _purchasePrice =
                (EditText) findViewById(R.id.inputPurchasePrice);
        EditText _term = (EditText) findViewById(R.id.inputTerm);
        EditText _interest = (EditText) findViewById(R.id.inputInterest);
        EditText _downPayment= (EditText) findViewById(R.id.inputDownPayment);

        // Outputs
        TextView _monthlyRent =
                (TextView) findViewById(R.id.outputMonthlyPayment);

        Double purchasePrice, interest, monthlyRent, downPayment;
        Integer term;

        purchasePrice = Double.parseDouble(_purchasePrice.getText().toString());
        term = Integer.parseInt(_term.getText().toString());
        // Converts APR to Monthly Rate
        interest = Double.parseDouble(_interest.getText().toString()) / 1200;
        downPayment = Double.parseDouble(_downPayment.getText().toString());

        // Calculate Total Loan Amount
        purchasePrice -= downPayment;

        // Calculate Monthly Rent
        monthlyRent = purchasePrice *
                (interest * Math.pow(1 + interest, term)) /
                (Math.pow(1 + interest, term) - 1);

        //Converts variables to 2 Decimal Places
        DecimalFormat df = new DecimalFormat("#.##");

        // Output Monthly Rent
        _monthlyRent.setText("$" + df.format(monthlyRent));
    }
}
