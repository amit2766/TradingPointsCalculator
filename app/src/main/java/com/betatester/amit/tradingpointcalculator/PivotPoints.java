package com.betatester.amit.tradingpointcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class PivotPoints extends AppCompatActivity{

    private TextView tvValueClassicalR1;
    private TextView tvValueClassicalR2;
    private TextView tvValueClassicalR3;
    private TextView tvValueClassicalR4;
    private TextView tvValueClassicalS1;
    private TextView tvValueClassicalS2;
    private TextView tvValueClassicalS3;
    private TextView tvValueClassicalS4;
    private TextView tvValueFibonacciS1;
    private TextView tvValueFibonacciS2;
    private TextView tvValueFibonacciS3;
    private TextView tvValueFibonacciR1;
    private TextView tvValueFibonacciR2;
    private TextView tvValueFibonacciR3;
    private TextView tvValueWoodieS1;
    private TextView tvValueWoodieS2;
    private TextView tvValueWoodieS3;
    private TextView tvValueWoodieS4;
    private TextView tvValueWoodieR1;
    private TextView tvValueWoodieR2;
    private TextView tvValueWoodieR3;
    private TextView tvValueWoodieR4;
    private TextView tvValueCamarillaS1;
    private TextView tvValueCamarillaS2;
    private TextView tvValueCamarillaS3;
    private TextView tvValueCamarillaS4;
    private TextView tvValueCamarillaR1;
    private TextView tvValueCamarillaR2;
    private TextView tvValueCamarillaR3;
    private TextView tvValueCamarillaR4;


    private EditText etClose;
    private EditText etHigh;
    private EditText etLow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pivot_points);

        initializeTextViews();
        etLow.addTextChangedListener(new TextChangeListenerForEditText());
        etHigh.addTextChangedListener(new TextChangeListenerForEditText());
        etClose.addTextChangedListener(new TextChangeListenerForEditText());
    }

    private void initializeTextViews() {

        etHigh = findViewById(R.id.et_previous_high);
        etLow =  findViewById(R.id.et_previous_low);
        etClose =  findViewById(R.id.et_previous_close);

        tvValueClassicalR1 =  findViewById(R.id.tv_value_classical_r1);
        tvValueClassicalR2 =  findViewById(R.id.tv_value_classical_r2);
        tvValueClassicalR3 =  findViewById(R.id.tv_value_classical_r3);
        tvValueClassicalR4 =  findViewById(R.id.tv_value_classical_r4);
        tvValueClassicalS1 =  findViewById(R.id.tv_value_classical_s1);
        tvValueClassicalS2 =  findViewById(R.id.tv_value_classical_s2);
        tvValueClassicalS3 =  findViewById(R.id.tv_value_classical_s3);
        tvValueClassicalS4 =  findViewById(R.id.tv_value_classical_s4);
        tvValueWoodieR1 =  findViewById(R.id.tv_value_woodie_r1);
        tvValueWoodieR2 =  findViewById(R.id.tv_value_woodie_r2);
        tvValueWoodieR3 =  findViewById(R.id.tv_value_woodie_r3);
        tvValueWoodieR4 =  findViewById(R.id.tv_value_woodie_r4);
        tvValueWoodieS1 =  findViewById(R.id.tv_value_woodie_s1);
        tvValueWoodieS2 =  findViewById(R.id.tv_value_woodie_s2);
        tvValueWoodieS3 =  findViewById(R.id.tv_value_woodie_s3);
        tvValueWoodieS4 =  findViewById(R.id.tv_value_woodie_s4);
        tvValueFibonacciR1 =  findViewById(R.id.tv_value_fibonacci_r1);
        tvValueFibonacciR2 =  findViewById(R.id.tv_value_fibonacci_r2);
        tvValueFibonacciR3 =  findViewById(R.id.tv_value_fibonacci_r3);
        tvValueFibonacciS1 =  findViewById(R.id.tv_value_fibonacci_s1);
        tvValueFibonacciS2 =  findViewById(R.id.tv_value_fibonacci_s2);
        tvValueFibonacciS3 =  findViewById(R.id.tv_value_fibonacci_s3);
        tvValueCamarillaR1 =  findViewById(R.id.tv_value_camarilla_r1);
        tvValueCamarillaR2 =  findViewById(R.id.tv_value_camarilla_r2);
        tvValueCamarillaR3 =  findViewById(R.id.tv_value_camarilla_r3);
        tvValueCamarillaR4 =  findViewById(R.id.tv_value_camarilla_r4);
        tvValueCamarillaS1 =  findViewById(R.id.tv_value_camarilla_s1);
        tvValueCamarillaS2 =  findViewById(R.id.tv_value_camarilla_s2);
        tvValueCamarillaS3 =  findViewById(R.id.tv_value_camarilla_s3);
        tvValueCamarillaS4 =  findViewById(R.id.tv_value_camarilla_s4);
    }

    private void startCalculation() {
        resetAllTheLevels();
        double highValue = Double.valueOf(etHigh.getText().toString());
        double lowValue = Double.valueOf(etLow.getText().toString());
        double closeValue = Double.valueOf(etClose.getText().toString());
        calculateClassicalPivot(highValue, lowValue, closeValue);
        calculateFibonacciPivot(highValue, lowValue, closeValue);
        calculateWoodiePivot(highValue, lowValue, closeValue);
        calculateCamarillaPivot(highValue, lowValue, closeValue);
    }

    private void resetAllTheLevels() {

        tvValueClassicalR1.setText(R.string.default_price);
        tvValueClassicalR2.setText(R.string.default_price);
        tvValueClassicalR3.setText(R.string.default_price);
        tvValueClassicalR4.setText(R.string.default_price);
        tvValueClassicalS1.setText(R.string.default_price);
        tvValueClassicalS2.setText(R.string.default_price);
        tvValueClassicalS3.setText(R.string.default_price);
        tvValueClassicalS4.setText(R.string.default_price);
        tvValueFibonacciS1.setText(R.string.default_price);
        tvValueFibonacciS2.setText(R.string.default_price);
        tvValueFibonacciS3.setText(R.string.default_price);
        tvValueFibonacciR1.setText(R.string.default_price);
        tvValueFibonacciR2.setText(R.string.default_price);
        tvValueFibonacciR3.setText(R.string.default_price);
        tvValueWoodieS1.setText(R.string.default_price);
        tvValueWoodieS2.setText(R.string.default_price);
        tvValueWoodieS3.setText(R.string.default_price);
        tvValueWoodieS4.setText(R.string.default_price);
        tvValueWoodieR1.setText(R.string.default_price);
        tvValueWoodieR2.setText(R.string.default_price);
        tvValueWoodieR3.setText(R.string.default_price);
        tvValueWoodieR4.setText(R.string.default_price);
        tvValueCamarillaS1.setText(R.string.default_price);
        tvValueCamarillaS2.setText(R.string.default_price);
        tvValueCamarillaS3.setText(R.string.default_price);
        tvValueCamarillaS4.setText(R.string.default_price);
        tvValueCamarillaR1.setText(R.string.default_price);
        tvValueCamarillaR2.setText(R.string.default_price);
        tvValueCamarillaR3.setText(R.string.default_price);
        tvValueCamarillaR4.setText(R.string.default_price);

    }

    private void calculateCamarillaPivot(double high, double low, double close) {

        double r1, r2, r3, r4, pp, s1, s2, s3, s4, range;
        range = high - low;
        pp = (high + low + close) / 3.0;
        r1 = close + range * 1.1 / 12.0;
        s1 = close - range * 1.1 / 12.0;
        r2 = close + range * 1.1 / 6.0;
        s2 = close - range * 1.1 / 6.0;
        r3 = close + range * 1.1 / 4.0;
        s3 = close - range * 1.1 / 4.0;
        r4 = close + range * 1.1 / 2.0;
        s4 = close - range * 1.1 / 2.0;

        tvValueCamarillaR1.setText(String.format("%.2f",pp));
        tvValueCamarillaR1.setText(String.format("%.2f",r1));
        tvValueCamarillaR2.setText(String.format("%.2f",r2));
        tvValueCamarillaR3.setText(String.format("%.2f",r3));
        tvValueCamarillaR4.setText(String.format("%.2f",r4));
        tvValueCamarillaS1.setText(String.format("%.2f",s1));
        tvValueCamarillaS2.setText(String.format("%.2f",s2));
        tvValueCamarillaS3.setText(String.format("%.2f",s3));
        tvValueCamarillaS4.setText(String.format("%.2f",s4));
    }

    private void calculateWoodiePivot(double high, double low, double open) {

        double r1, r2, r3, r4, pp, s1, s2, s3, s4, range;
        range = high - low;


        pp = (high + low + 2 * open) / 4.0;
        r1 = 2 * pp - low;
        s1 = 2 * pp - high;
        r2 = pp + range;
        s2 = pp - range;
        r3 = high + 2 * (pp - low);
        s3 = low - 2 * (high - pp);
        r4 = r3 + range;
        s4 = s3 - range;

        tvValueWoodieR1.setText(String.format("%.2f",pp));
        tvValueWoodieR1.setText(String.format("%.2f",r1));
        tvValueWoodieR2.setText(String.format("%.2f",r2));
        tvValueWoodieR3.setText(String.format("%.2f",r3));
        tvValueWoodieR4.setText(String.format("%.2f",r4));
        tvValueWoodieS1.setText(String.format("%.2f",s1));
        tvValueWoodieS2.setText(String.format("%.2f",s2));
        tvValueWoodieS3.setText(String.format("%.2f",s3));
        tvValueWoodieS4.setText(String.format("%.2f",s4));
    }

    private void calculateFibonacciPivot(double high, double low, double close) {

        double r1, r2, r3, r4, pp, s1, s2, s3, s4, range;
        range = high - low;

        pp = (high + low + close) / 3.0;
        r1 = pp + 0.382 * range;
        s1 = pp - 0.382 * range;
        r2 = pp + 0.618 * range;
        s2 = pp - 0.618 * range;
        r3 = pp + range;
        s3 = pp - range;

        tvValueFibonacciR1.setText(String.format("%.2f",pp));
        tvValueFibonacciR1.setText(String.format("%.2f",r1));
        tvValueFibonacciR2.setText(String.format("%.2f",r2));
        tvValueFibonacciR3.setText(String.format("%.2f",r3));
        tvValueFibonacciS1.setText(String.format("%.2f",s1));
        tvValueFibonacciS2.setText(String.format("%.2f",s2));
        tvValueFibonacciS3.setText(String.format("%.2f",s3));

    }

    private void calculateClassicalPivot(double high, double low, double close) {
        double r1, r2, r3, r4, pp, s1, s2, s3, s4, range;

        pp = (high + low + close) / 3.0;
        r1 = pp * 2 - low;
        s1 = pp * 2 - high;
        r2 = pp + (high - low);
        s2 = pp - (high - low);
        r3 = pp * 2 + (high - 2 * low);
        s3 = pp * 2 - (2 * high - low);
        r4 = pp * 3 + (high - 3 * low);
        s4 = pp * 3 - (3 * high - low);

        tvValueClassicalR1.setText(String.format("%.2f",pp));
        tvValueClassicalR1.setText(String.format("%.2f",r1));
        tvValueClassicalR2.setText(String.format("%.2f",r2));
        tvValueClassicalR3.setText(String.format("%.2f",r3));
        tvValueClassicalR4.setText(String.format("%.2f",r4));
        tvValueClassicalS1.setText(String.format("%.2f",s1));
        tvValueClassicalS2.setText(String.format("%.2f",s2));
        tvValueClassicalS3.setText(String.format("%.2f",s3));
        tvValueClassicalS4.setText(String.format("%.2f",s4));

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
            if(  etClose.getText().toString().equals("")
                || etLow.getText().toString().equals("")
                || etHigh.getText().toString().equals("")){
                return;
            }

            if (Double.valueOf(etClose.getText().toString()) != 0
                    && Double.valueOf(etLow.getText().toString()) != 0
                    && Double.valueOf(etHigh.getText().toString()) != 0) {

                if (Double.valueOf(etClose.getText().toString()) >= Double.valueOf(etLow.getText().toString())
                        && Double.valueOf(etHigh.getText().toString()) >= Double.valueOf(etLow.getText().toString())
                        && Double.valueOf(etClose.getText().toString()) <= Double.valueOf(etHigh.getText().toString())) {
                    startCalculation();
                }
            }

        }
    }
}
