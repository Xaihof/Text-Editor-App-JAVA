package com.example.texteditorappjava;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.texteditorappjava.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    ArrayAdapter<String> adapterTextColor, adapterTextStyle, adapterTextFont, adapterTextAlign;

    String[] colorStringArray = {"Red", "Green", "Blue", "None"};
    String[] styleStringArray = {"Bold", "Italics", "Underline", "None"};
    String[] fontStringArray = {"madimi_one", "ojuju", "truculenta", "whisper", "None"};
    String[] alignStringArray = {"Left", "Right", "Center"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        /* Drop down code for text style. */
        adapterTextColor = new ArrayAdapter<>(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item, colorStringArray);
        binding.autoCompleteTextviewSelectColor.setAdapter(adapterTextColor);

        binding.autoCompleteTextviewSelectColor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String positionOfList = parent.getItemAtPosition(position).toString();

                switch (positionOfList) {
                    case "Red":
                        binding.editText.setTextColor(Color.RED);
                        break;
                    case "Blue":
                        binding.editText.setTextColor(Color.BLUE);
                        break;
                    case "Green":
                        binding.editText.setTextColor(Color.GREEN);
                        break;
                    case "None":
                        binding.editText.setTextColor(Color.BLACK);
                        break;
                }


            }
        });


        /* Drop down code for text style. */
        adapterTextStyle = new ArrayAdapter<>(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item, styleStringArray);
        binding.autoCompleteTextviewSelectStyle.setAdapter(adapterTextStyle);

        binding.autoCompleteTextviewSelectStyle.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String positionOfList = parent.getItemAtPosition(position).toString();

                SpannableString spannableString = new SpannableString(binding.editText.getText());


                switch (positionOfList) {
                    case "Bold":

                        spannableString.setSpan(new StyleSpan(Typeface.BOLD), 0, spannableString.length(), 0);
                        binding.editText.setText(spannableString);

                        break;
                    case "Italics":

                        spannableString.setSpan(new StyleSpan(Typeface.ITALIC), 0, spannableString.length(), 0);
                        binding.editText.setText(spannableString);

                        break;
                    case "Underline":

                        spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 0);
                        binding.editText.setText(spannableString);

                        break;
                    case "None":

                        binding.editText.setText(binding.editText.getText().toString());

                        break;
                }


            }
        });


        /* Drop down code for font. */
        adapterTextFont = new ArrayAdapter<>(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item, fontStringArray);
        binding.autoCompleteTextviewSelectFont.setAdapter(adapterTextFont);

        binding.autoCompleteTextviewSelectFont.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String positionOfList = parent.getItemAtPosition(position).toString();

                switch (positionOfList) {
                    case "madimi_one":
                        Typeface typeface = Typeface.createFromAsset(getAssets(), "madimi_one.ttf");
                        binding.editText.setTypeface(typeface);
                        break;
                    case "ojuju":
                        Typeface typeface1 = Typeface.createFromAsset(getAssets(), "ojuju.ttf");
                        binding.editText.setTypeface(typeface1);
                        break;
                    case "truculenta":
                        Typeface typeface2 = Typeface.createFromAsset(getAssets(), "truculenta.ttf");
                        binding.editText.setTypeface(typeface2);
                        break;
                    case "whisper":
                        Typeface typeface3 = Typeface.createFromAsset(getAssets(), "whisper.ttf");
                        binding.editText.setTypeface(typeface3);
                        break;
                    case "None":
                        Typeface nofont = Typeface.DEFAULT;
                        binding.editText.setTypeface(nofont);
                        break;
                }


            }
        });


        /* Drop down code for text alignment. */
        adapterTextAlign = new ArrayAdapter<>(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item, alignStringArray);
        binding.autoCompleteTextviewSelectAlignment.setAdapter(adapterTextAlign);

        binding.autoCompleteTextviewSelectAlignment.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String positionOfList = parent.getItemAtPosition(position).toString();
                SpannableString spannableString = new SpannableString(binding.editText.getText());


                switch (positionOfList) {
                    case "Left":
                        binding.editText.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                        binding.editText.setText(spannableString);
                        break;
                    case "Right":
                        binding.editText.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
                        binding.editText.setText(spannableString);
                        break;
                    case "Center":
                        binding.editText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                        binding.editText.setText(spannableString);
                        break;
                }


            }
        });

    }
}