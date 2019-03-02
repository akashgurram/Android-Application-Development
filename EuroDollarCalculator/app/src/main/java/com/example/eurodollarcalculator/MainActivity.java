package com.example.eurodollarcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{ //implements View.OnClickListener {
    private EditText dollartext;
    private EditText eurotext;
    private Button ConvertDtoE;
    private Button ConvertEtoD;
    private static final float conversion = (float) 0.87;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dollartext = (EditText)findViewById(R.id.dollarstext);
        eurotext = (EditText) findViewById(R.id.eurostext);
        ConvertDtoE = (Button) findViewById(R.id.ConvertDtoE);
        //ConvertDtoE.setOnClickListener(this);
        ConvertDtoE.setOnClickListener(new View.OnClickListener() {   //method to do the registration from app to android runtime.
            @Override                                //onclicklistener is an interface // an anonymous class
            public void onClick(View v) {

                if (dollartext.getText().toString().compareTo("")!=0)
                {
                    float dollar_ = new Float(dollartext.getText().toString()).floatValue();
                    float euros_ = dollar_* conversion;
                    eurotext.setText(new Float(euros_).toString());

                }
                else{

                    Toast.makeText(getApplicationContext(),"Dollar Text field is empty" +
                            ":Insert a valid Dollar Value",Toast.LENGTH_LONG).show();

                }

                //double dollars =  Double.valueOf(dollartext.getText().toString());
                //double euros = dollars * 0.87 ;
                //eurotext.setText(String.valueOf(euros));
            }
        });

        ConvertEtoD = (Button) findViewById(R.id.ConvertEtoD);
        ConvertEtoD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (eurotext.getText().toString().compareTo("")!=0)
                {
                    float euros_ = new Float(eurotext.getText().toString()).floatValue();
                    float dollars_ = euros_*(1/conversion);
                    dollartext.setText(new Float(dollars_).toString());

                }

                else{

                    Toast.makeText(getApplicationContext(),"Euro Text field is empty" +
                            ":Insert a valid Dollar Value",Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}
