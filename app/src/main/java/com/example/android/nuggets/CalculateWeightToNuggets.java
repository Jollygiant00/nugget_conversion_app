package com.example.android.nuggets;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CalculateWeightToNuggets extends AppCompatActivity {

    EditText mUserWeightInput;
    TextView mNuggetOutput;
    double unitOutput = 0;
    private static final String TAG = "CalculateWeightActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_weight_to_nuggets);
        Button bCalcButton = findViewById(R.id.calcButton);

        Intent intent = getIntent();
        final String selectedOutputUnit = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        Toolbar myToolbar = findViewById(R.id.app_toolbar);
        setSupportActionBar(myToolbar);

        if(getSupportActionBar() != null) {
            if(selectedOutputUnit.equals("nuggetCalcButton")) {
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(ContextCompat
                        .getColor(this, R.color.nuggetPrimaryColorDark)));
                bCalcButton.setBackgroundColor(ContextCompat
                        .getColor(this, R.color.nuggetPrimaryColor));
            }else if(selectedOutputUnit.equals("grapeCalcButton")) {
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(ContextCompat
                        .getColor(this, R.color.grapesPrimaryColorDark)));
                bCalcButton.setBackgroundColor(ContextCompat
                        .getColor(this, R.color.grapesPrimaryColor));
            }
        } else {
            Log.e(TAG, "get support action bar error");
        }

        final Spinner selectedUnits = findViewById(R.id.inputUnits);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.unit_weight, android.R.layout.simple_spinner_item);
        selectedUnits.setSelection(1);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectedUnits.setAdapter(adapter);


        bCalcButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                int userInputInteger;
                String unitConversion = selectedUnits.getSelectedItem().toString();
                //TODO clear null value error
                String userInputString = mUserWeightInput.getText().toString();

                if (userInputString.isEmpty()) {
                    userInputInteger = 0;
                    Context context = getApplicationContext();
                    CharSequence text = "Please add weight";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {
                    userInputInteger = Integer.parseInt(userInputString);
                }


                switch (selectedOutputUnit) {
                    case ("nuggetCalcButton"):
                        unitOutput = 70.0;
                        break;
                    case ("grapeCalcButton"):
                        unitOutput = 2.4;
                        break;
                    default:
                        unitOutput = 0;
                        break;
                }
                ConvertUserInput nuggetObject = new ConvertUserInput();
                String objectOutput = nuggetObject.convertUserInput(userInputInteger,
                                                            unitConversion,
                                                            unitOutput);

                mNuggetOutput.setText(objectOutput);
            }
        });
    }
}

