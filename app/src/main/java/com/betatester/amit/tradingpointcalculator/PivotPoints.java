package com.betatester.amit.tradingpointcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class PivotPoints extends AppCompatActivity implements View.OnClickListener {

    private Button btClassical;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pivot_points);

        btClassical = findViewById(R.id.bt_classical);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_classical:
                toggleButtonVisibility(View.GONE);
                break;

            case R.id.bt_calculate_classical:
                toggleResultView(View.VISIBLE);
                calculateClassicalPivot(1,2,3);
                calculateFibonacciPivot(1,2,3);
                calculateWoodiePivot(1,2,3);
                calculateCamarillaPivot(1,2,3);
                break;
        }
    }

    private void calculateCamarillaPivot(double high , double low , double close) {

        double r1,r2,r3,r4,pp,s1,s2,s3,s4, range;
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
    }

    private void calculateWoodiePivot(double high , double low , double open) {

        double r1,r2,r3,r4,pp,s1,s2,s3,s4, range;
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
    }

    private void calculateFibonacciPivot(double high , double low , double close) {

        double r1,r2,r3,r4,pp,s1,s2,s3,s4, range;
        range = high - low;

        pp = (high + low + close) / 3.0;
        r1 = pp + 0.382 * range;
        s1 = pp - 0.382 * range;
        r2 = pp + 0.618 * range;
        s2 = pp - 0.618 * range;
        r3 = pp + range;
        s3 = pp - range;

    }

    private void calculateClassicalPivot(double high , double low , double close) {
        // TODO: 7/8/2018 put classical pivot calculation
        toggleClassicalResultView(View.VISIBLE);
        double r1,r2,r3,r4,pp,s1,s2,s3,s4, range;

        pp = (high + low + close) / 3.0;
        r1 = pp * 2 - low;
        s1 = pp * 2 - high;
        r2 = pp + (high - low);
        s2 = pp - (high - low);
        r3 = pp * 2 + (high - 2 * low);
        s3 = pp * 2 - (2 * high - low);
        r4 = pp * 3 + (high - 3 * low);
        s4 = pp * 3 - (3 * high - low);

    }

    private void toggleClassicalResultView(int visible) {

    }

    private void toggleResultView(int visible) {
    }


    private void toggleButtonVisibility(int visiblity) {
        btClassical.setVisibility(visiblity);
    }


}
