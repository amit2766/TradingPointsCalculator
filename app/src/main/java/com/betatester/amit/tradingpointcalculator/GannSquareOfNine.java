package com.betatester.amit.tradingpointcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Math.ceil;
import static java.lang.Math.floor;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class GannSquareOfNine extends AppCompatActivity {

    TextView tvValue11;
    TextView tvValue22;
    TextView tvValue33;
    TextView tvValue44;
    TextView tvValue55;
    TextView tvValue66;
    TextView tvValue77;
    TextView tvValue41;
    TextView tvValue42;
    TextView tvValue43;
    TextView tvValue45;
    TextView tvValue46;
    TextView tvValue47;
    TextView tvValue14;
    TextView tvValue24;
    TextView tvValue34;
    TextView tvValue54;
    TextView tvValue64;
    TextView tvValue74;
    TextView tvValue71;
    TextView tvValue62;
    TextView tvValue53;
    TextView tvValue35;
    TextView tvValue26;
    TextView tvValue17;
    private EditText etCMP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gann_square_of_nine);

        initializeView();

    }

    private void initializeView() {
        etCMP = findViewById(R.id.et_cmp);

        tvValue11 = findViewById(R.id.tv_value_1_1);
        tvValue22 = findViewById(R.id.tv_value_2_2);
        tvValue33 = findViewById(R.id.tv_value_3_3);
        tvValue44 = findViewById(R.id.tv_value_4_4);
        tvValue55 = findViewById(R.id.tv_value_5_5);
        tvValue66 = findViewById(R.id.tv_value_6_6);
        tvValue77 = findViewById(R.id.tv_value_7_7);
        tvValue41 = findViewById(R.id.tv_value_4_1);
        tvValue42 = findViewById(R.id.tv_value_4_2);
        tvValue43 = findViewById(R.id.tv_value_4_3);
        tvValue45 = findViewById(R.id.tv_value_4_5);
        tvValue46 = findViewById(R.id.tv_value_4_6);
        tvValue47 = findViewById(R.id.tv_value_4_7);
        tvValue14 = findViewById(R.id.tv_value_1_4);
        tvValue24 = findViewById(R.id.tv_value_2_4);
        tvValue34 = findViewById(R.id.tv_value_3_4);
        tvValue54 = findViewById(R.id.tv_value_5_4);
        tvValue64 = findViewById(R.id.tv_value_6_4);
        tvValue74 = findViewById(R.id.tv_value_7_4);
        tvValue71 = findViewById(R.id.tv_value_7_1);
        tvValue62 = findViewById(R.id.tv_value_6_2);
        tvValue53 = findViewById(R.id.tv_value_5_3);
        tvValue35 = findViewById(R.id.tv_value_3_5);
        tvValue26 = findViewById(R.id.tv_value_2_6);
        tvValue17 = findViewById(R.id.tv_value_1_7);


    }

    private void startCalculation() {

        double cmp = Double.valueOf(etCMP.getText().toString());

        double e4 = sqrt(cmp);
        double c4 = floor(e4);

        double b4 = (c4 - 1);

        double midValue = pow(b4,2);

        double v43 = pow((b4+.125),2);
        double v42 = pow(c4,2);

        double f4;
        if(c4==e4){
            f4= c4+1;
        } else {
            f4= ceil(c4);
        }
        double g4 = f4+1;

        double v41 = pow((f4+.125),2);
//        double v51 =

//        tvValue44.setText(roundOff(midValue));

    }

    private String roundOff(double number) {
        return String.format("%.2f",number);

    }

    public class TextChangeListenerForEditText implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (etCMP.getText().toString().equals("") || etCMP.getText().toString().equals("0")) {
                return;
            }
            startCalculation();
        }
    }
}
