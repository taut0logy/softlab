package com.example.softlab;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNumber1, editTextNumber2;
    private Button buttonSubtract;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editTextNumber1 = findViewById(R.id.editTextText);
        editTextNumber2 = findViewById(R.id.editTextText2);
        buttonSubtract = findViewById(R.id.button);
        textViewResult = findViewById(R.id.textView3);

        // Set onClickListener for the subtract button
        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subtractNumbers();
            }
        });
    }

    // Method to perform subtraction
    private void subtractNumbers() {
        // Get numbers from EditText fields
        String number1Str = editTextNumber1.getText().toString();
        String number2Str = editTextNumber2.getText().toString();

        // Check if EditText fields are not empty
        if (!number1Str.isEmpty() && !number2Str.isEmpty()) {
            // Parse numbers from strings
            double number1 = Double.parseDouble(number1Str);
            double number2 = Double.parseDouble(number2Str);

            // Subtract numbers
            double result = number1 - number2;

            // Display result
            textViewResult.setText("Result: " + result);
        } else {
            // If EditText fields are empty, display error message
            textViewResult.setText("Please enter numbers in both fields");
        }
    }
}
