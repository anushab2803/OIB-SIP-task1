package com.example.unitconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputValue;
    private Spinner unitSpinner;
    private Button convertButton;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputValue = findViewById(R.id.input_value);
        unitSpinner = findViewById(R.id.unit_spinner);
        convertButton = findViewById(R.id.convert_button);
        resultText = findViewById(R.id.result_text);

        // Setup Spinner with unit options
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.units, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unitSpinner.setAdapter(adapter);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = inputValue.getText().toString();
                if (!input.isEmpty()) {
                    double value = Double.parseDouble(input);
                    String unit = unitSpinner.getSelectedItem().toString();
                    double result = convert(value, unit);
                    resultText.setText("Converted value: " + result);
                }
            }
        });
    }

    private double convert(double value, String unit) {
        switch (unit) {
            case "Centimeters to Meters":
                return value / 100;
            case "Grams to Kilograms":
                return value / 1000;
            case "Meters to Centimeters":
                return value * 100;
            case "Kilograms to Grams":
                return value * 1000;
            default:
                return 0;
        }
    }
}
