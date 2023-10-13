package com.example.shashank.thuchanh;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Define your view variables
    private CheckBox checkBoxIphone;
    private CheckBox checkBoxAndroid;
    private CheckBox checkBoxWindowsPhone;
    private RadioGroup radioGroupGender;
    private RatingBar ratingBar;
    private ListView listView;
    private Spinner spinner;
    private Button displayButton;
    private TextView resultTextView;

    // Define your data arrays
    private String[] countries = {"VietNam", "China", "Malaysia"};
    private String[] universities = {"PTIT", "HUST", "BKA"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkBoxIphone = findViewById(R.id.checkBoxIphone);
        checkBoxAndroid = findViewById(R.id.checkBoxAndroid);
        checkBoxWindowsPhone = findViewById(R.id.checkBoxWindows);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        ratingBar = findViewById(R.id.ratingBar);
        listView = findViewById(R.id.listView);
        spinner = findViewById(R.id.spinner);
        displayButton = findViewById(R.id.displayButton);
        resultTextView = findViewById(R.id.resultTextView);
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, countries);
        listView.setAdapter(listViewAdapter);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, universities);
        spinner.setAdapter(spinnerAdapter);
        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displaySelectedChoices();
            }
        });
    }

    private void displaySelectedChoices() {
        StringBuilder result = new StringBuilder("Selected Choices:\n");

        if (checkBoxIphone.isChecked()) {
            result.append("iPhone\n");
        }
        if (checkBoxAndroid.isChecked()) {
            result.append("Android\n");
        }
        if (checkBoxWindowsPhone.isChecked()) {
            result.append("Windows Phone\n");
        }

        int selectedGenderId = radioGroupGender.getCheckedRadioButtonId();
        RadioButton selectedGenderButton = findViewById(selectedGenderId);
        if (selectedGenderButton != null) {
            result.append("Gender: ").append(selectedGenderButton.getText()).append("\n");
        }

        float rating = ratingBar.getRating();
        result.append("Rating: ").append(rating).append("\n");

        result.append("Selected Countries in ListView:\n");
        for (int i = 0; i < countries.length; i++) {
            if (listView.isItemChecked(i)) {
                result.append(countries[i]).append("\n");
            }
        }

        String selectedUniversity = spinner.getSelectedItem().toString();
        result.append("Selected University in Spinner: ").append(selectedUniversity);
        resultTextView.setText(result.toString());
    }
}