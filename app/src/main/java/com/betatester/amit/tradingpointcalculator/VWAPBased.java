package com.betatester.amit.tradingpointcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class VWAPBased extends AppCompatActivity {

    double support1, support2, support3, support4, support5, support6, support7, support8;
    double resistance1, resistance2, resistance3, resistance4, resistance5, resistance6, resistance7, resistance8;
    private TextView tvSupport1, tvSupport2, tvSupport3, tvSupport4, tvSupport5,tvSupport6,tvSupport7,tvSupport8, tvResistance1, tvResistance2, tvResistance3, tvResistance4, tvResistance5
            ,tvResistance6,tvResistance7,tvResistance8;
    private EditText etVIX;
    private EditText etOpenPriceStock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vwapbased);

        initializeViews();

        etVIX.addTextChangedListener(new TextChangeListenerForEditText());


    }

    private void calculateVWAPBasedSR(double vix, double price) {

        double firstSd = price * vix / 955.24865;
        ;
        double l1 = 0.236, l2 = 0.382, l3 = 0.5, l4 = 0.618, l5 = 0.786, l6 = 0.888, l7 = 1.236, l8 = 1.618;

        support1 = price + l1 * firstSd;
        support2 = price + l2 * firstSd;
        support3 = price + l3 * firstSd;
        support4 = price + l4 * firstSd;
        support5 = price + l5 * firstSd;
        support6 = price + l6 * firstSd;
        support7 = price + l7 * firstSd;
        support8 = price + l8 * firstSd;

        resistance1 = price - l1 * firstSd;
        resistance2 = price - l2 * firstSd;
        resistance3 = price - l3 * firstSd;
        resistance4 = price - l4 * firstSd;
        resistance5 = price - l5 * firstSd;
        resistance6 = price - l6 * firstSd;
        resistance7 = price - l7 * firstSd;
        resistance8 = price - l8 * firstSd;

        tvSupport1.setText(roundOff(support1));
        tvSupport2.setText(roundOff(support2));
        tvSupport3.setText(roundOff(support3));
        tvSupport4.setText(roundOff(support4));
        tvSupport5.setText(roundOff(support5));
        tvSupport6.setText(roundOff(support6));
        tvSupport7.setText(roundOff(support7));
        tvSupport8.setText(roundOff(support8));
        tvResistance1.setText(roundOff(resistance1));
        tvResistance2.setText(roundOff(resistance2));
        tvResistance3.setText(roundOff(resistance3));
        tvResistance4.setText(roundOff(resistance4));
        tvResistance5.setText(roundOff(resistance5));
        tvResistance6.setText(roundOff(resistance6));
        tvResistance7.setText(roundOff(resistance7));
        tvResistance8.setText(roundOff(resistance8));

    }

    private void clearAllFields() {
        tvSupport1.setText(R.string.default_price);
        tvSupport2.setText(R.string.default_price);
        tvSupport3.setText(R.string.default_price);
        tvSupport4.setText(R.string.default_price);
        tvSupport5.setText(R.string.default_price);
        tvSupport6.setText(R.string.default_price);
        tvSupport7.setText(R.string.default_price);
        tvSupport8.setText(R.string.default_price);
        tvResistance1.setText(R.string.default_price);
        tvResistance2.setText(R.string.default_price);
        tvResistance3.setText(R.string.default_price);
        tvResistance4.setText(R.string.default_price);
        tvResistance5.setText(R.string.default_price);
        tvResistance6.setText(R.string.default_price);
        tvResistance7.setText(R.string.default_price);
        tvResistance8.setText(R.string.default_price);

    }

    private void initializeViews() {
        tvSupport1 = findViewById(R.id.tv_vwap_s1);
        tvSupport2 = findViewById(R.id.tv_vwap_s2);
        tvSupport3 = findViewById(R.id.tv_vwap_s3);
        tvSupport4 = findViewById(R.id.tv_vwap_s4);
        tvSupport5 = findViewById(R.id.tv_vwap_s5);
        tvSupport6 = findViewById(R.id.tv_vwap_s6);
        tvSupport7 = findViewById(R.id.tv_vwap_s7);
        tvSupport8 = findViewById(R.id.tv_vwap_s8);
        tvResistance1 = findViewById(R.id.tv_vwap_r1);
        tvResistance2 = findViewById(R.id.tv_vwap_r2);
        tvResistance3 = findViewById(R.id.tv_vwap_r3);
        tvResistance4 = findViewById(R.id.tv_vwap_r4);
        tvResistance5 = findViewById(R.id.tv_vwap_r5);
        tvResistance6 = findViewById(R.id.tv_vwap_r6);
        tvResistance7 = findViewById(R.id.tv_vwap_r7);
        tvResistance8 = findViewById(R.id.tv_vwap_r8);
        etOpenPriceStock = findViewById(R.id.et_curren_vix);
        etVIX = findViewById(R.id.et_open_price);

    }
    private String roundOff(double number) {
        return String.format("%.2f", number);

    }


    class TextChangeListenerForEditText implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if (Double.valueOf(etVIX.getText().toString()) != 0) {
                if (Double.valueOf(etOpenPriceStock.getText().toString()) != 0) {
                    clearAllFields();
                    calculateVWAPBasedSR(Double.valueOf(etVIX.getText().toString()), Double.valueOf(etOpenPriceStock.getText().toString()));
                }
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    }




}
