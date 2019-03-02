package com.example.eurodollarcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText dollartext;
    private EditText eurotext;
    private Button ConvertDtoE;
    private Button ConvertEtoD;
    private static final float conversion = (float) 0.87;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dollartext = (EditText) findViewById(R.id.dollarstext);
        eurotext = (EditText) findViewById(R.id.eurostext);
        ConvertDtoE = (Button) findViewById(R.id.ConvertDtoE);
        ConvertDtoE.setOnClickListener(this);


        ConvertEtoD = (Button) findViewById(R.id.ConvertEtoD);
        ConvertEtoD.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ConvertDtoE:
                if (dollartext.getText().toString().compareTo("") != 0) {
                    float dollar_ = new Float(dollartext.getText().toString()).floatValue();
                    float euros_ = dollar_ * conversion;
                    eurotext.setText(new Float(euros_).toString());
                } else {

                    Toast.makeText(getApplicationContext(), "DollarTextfieldisempty" +
                            ":InsertavalidDollarValue", Toast.LENGTH_LONG).show();

                }
            case R.id.ConvertEtoD:
                if (eurotext.getText().toString().compareTo("") != 0) {
                    float euros_ = new Float(eurotext.getText().toString()).floatValue();
                    float dollars_ = euros_ * (1 / conversion);
                    dollartext.setText(new Float(dollars_).toString());

                } else {

                    Toast.makeText(getApplicationContext(), "EuroTextfieldisempty" +
                            ":InsertavalidEuroValue", Toast.LENGTH_LONG).show();


                }

        }
    }
}
