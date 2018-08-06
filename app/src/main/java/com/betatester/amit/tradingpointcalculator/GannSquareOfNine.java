package com.betatester.amit.tradingpointcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Math.floor;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class GannSquareOfNine extends AppCompatActivity {

    TextView tvValue11, tvValue22, tvValue33, tvValue44, tvValue55, tvValue66, tvValue77, tvValue41, tvValue42, tvValue43, tvValue45, tvValue46, tvValue47, tvValue14, tvValue24, tvValue34, tvValue54, tvValue64, tvValue74, tvValue71, tvValue62, tvValue53, tvValue35, tvValue26, tvValue17, tvSellBelow, tvBuyAbove;
    TextView tvSupport1, tvSupport2, tvSupport3, tvSupport4, tvResistance1, tvResistance2, tvResistance3, tvResistance4;

    double j1 = 0.125, j2 = 0.25, j3 = 0.375, j4 = 0.5, j5 = 0.625, j6 = 0.75, j7 = 0.875, j8 = 1;
    double buyAbove;
    double g4, e9, b6, c7, d8, e6, e7, e8, b9, c9, d9, f9, g9, h9, f8, g7, h6, d4, e4, c4, b4, f4, f10, g11, h12, e10, e11, e12, b12, c11, d10;
    double c6, c8, c10, g8, g10, g12, b8, b11, h7, h10, d7, d11, d12, f6, f7, f11;
    double support1, support2, support3, support4;
    double resistance1, resistance2, resistance3, resistance4;
    private EditText etCMP;
    private double sellBelow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gann_square_of_nine);

        initializeView();

    }

    private void initializeView() {
        etCMP = findViewById(R.id.et_cmp);
        etCMP.addTextChangedListener(new TextChangeListenerForEditText());

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

        tvSupport1 = findViewById(R.id.tv_value_gann__s1);
        tvSupport2 = findViewById(R.id.tv_value_gann__s2);
        tvSupport3 = findViewById(R.id.tv_value_gann__s3);
        tvSupport4 = findViewById(R.id.tv_value_gann__s4);
        tvResistance1 = findViewById(R.id.tv_value_gann__r1);
        tvResistance2 = findViewById(R.id.tv_value_gann__r2);
        tvResistance3 = findViewById(R.id.tv_value_gann__r3);
        tvResistance4 = findViewById(R.id.tv_value_gann__r4);

        tvBuyAbove= findViewById(R.id.tv_value_gann__buy_above);
        tvSellBelow = findViewById(R.id.tv_value_gann__sell_below);


    }

    private void calculateGannValues() {
        clearAllFields();

        d4 = Double.valueOf(etCMP.getText().toString());
        e4 = sqrt(d4);
        c4 = floor(e4);
        b4 = (c4 - 1);
        f4 = c4 + 1;
        g4 = f4 + 1;
        calculateGannValuesForView();
        fillGannValuesInView();
        calculateCMPQuadrent();
        calculateBuyAbove();
        calculateSellBelow();
        calculateResistance1();
        calculateResistance2();
        calculateResistance3();
        calculateResistance4();
        calculateSupport1();
        calculateSupport2();
        calculateSupport3();
        calculateSupport4();

    }

    private void calculateBuyAbove() {
        if (c10 != 0.0) {
            buyAbove = c9;
        }
        else if (c8 != 0.0) {
            buyAbove = c7;
        }
        else if (d7 != 0.0) {
            buyAbove = e7;
        }
        else if (f7 != 0.0) {
            buyAbove = g7;
        }
        else if (g8 != 0.0) {
            buyAbove = g9;
        }
        else if (g10 != 0.0) {
            buyAbove = g11;
        }
        else if (f11 != 0.0) {
            buyAbove = e11;
        }
        else if (d11 != 0.0) {
            buyAbove = c11;
        }
        else if (b11 != 0.0) {
            buyAbove = b9;
        }
        else if (b8 != 0.0) {
            buyAbove = b6;
        }
        else if (c6 != 0.0) {
            buyAbove = e6;
        }
        else if (f6 != 0.0) {
            buyAbove = h6;
        }
        else if (h7 != 0.0) {
            buyAbove = h9;
        }
        else if (h10 != 0.0) {
            buyAbove = h12;
        }
        else if (g12 != 0.0) {
            buyAbove = e12;
        }
        else if (d12 != 0.0) {
            buyAbove = b12;
        }
        tvBuyAbove.setText(roundOff(buyAbove));

    }

    private void calculateSellBelow() {
        if (c10 != 0.0) {
            sellBelow = d10;
        }
        if (c8 != 0.0) {
            sellBelow = c9;
        }
        if (d7 != 0.0) {
            sellBelow = c7;
        }
        if (f7 != 0.0) {
            sellBelow = e7;
        }
        if (g8 != 0.0) {
            sellBelow = g7;
        }
        if (g10 != 0.0) {
            sellBelow = g9;
        }
        if (f11 != 0.0) {
            sellBelow = g11;
        }
        if (d11 != 0.0) {
            sellBelow = e11;
        }
        if (b11 != 0.0) {
            sellBelow = c11;
        }
        if (b8 != 0.0) {
            sellBelow = b9;
        }
        if (c6 != 0.0) {
            sellBelow = b6;
        }
        if (f6 != 0.0) {
            sellBelow = e6;
        }
        if (h7 != 0.0) {
            sellBelow = h6;
        }
        if (h10 != 0.0) {
            sellBelow = h9;
        }
        if (g12 != 0.0) {
            sellBelow = h12;
        }
        if (d12 != 0.0) {
            sellBelow = e12;
        }

        tvSellBelow.setText(roundOff(sellBelow));
    }

    private void calculateSupport4() {
        if (c10 != 0.0) {
            support4 = f8;
        } else if (c8 != 0.0) {
            support4 = f9;
        } else if (d7 != 0.0) {
            support4 = f10;
        } else if (f7 != 0.0) {
            support4 = e10;
        } else if (g8 != 0.0) {
            support4 = d10;
        } else if (g10 != 0.0) {
            support4 = c9;
        } else if (f11 != 0.0) {
            support4 = c7;
        } else if (d11 != 0.0) {
            support4 = e7;
        } else if (b11 != 0.0) {
            support4 = g7;
        } else if (b8 != 0.0) {
            support4 = g9;
        } else if (c6 != 0.0) {
            support4 = g11;
        } else if (f6 != 0.0) {
            support4 = e11;
        } else if (h7 != 0.0) {
            support4 = c11;
        } else if (h10 != 0.0) {
            support4 = b9;
        } else if (g12 != 0.0) {
            support4 = b6;
        } else if (d12 != 0.0) {
            support4 = e6;
        }

        tvSupport4.setText(roundOff(support4));
    }

    private void calculateSupport3() {
        if (c10 != 0.0) {
            support3 = f9;
        } else if (c8 != 0.0) {
            support3 = f10;
        } else if (d7 != 0.0) {
            support3 = e10;
        } else if (f7 != 0.0) {
            support3 = d10;
        } else if (g8 != 0.0) {
            support3 = c9;
        } else if (g10 != 0.0) {
            support3 = c7;
        } else if (f11 != 0.0) {
            support3 = e7;
        } else if (d11 != 0.0) {
            support3 = g7;
        } else if (b11 != 0.0) {
            support3 = g9;
        } else if (b8 != 0.0) {
            support3 = g11;
        } else if (c6 != 0.0) {
            support3 = e11;
        } else if (f6 != 0.0) {
            support3 = c11;
        } else if (h7 != 0.0) {
            support3 = b9;
        } else if (h10 != 0.0) {
            support3 = b6;
        } else if (g12 != 0.0) {
            support3 = e6;
        } else if (d12 != 0.0) {
            support3 = h6;
        }

        tvSupport3.setText(roundOff(support3));
    }

    private void calculateSupport2() {
        if (c10 != 0.0) {
            support2 = f10;
        } else if (c8 != 0.0) {
            support2 = e10;
        } else if (d7 != 0.0) {
            support2 = d10;
        } else if (f7 != 0.0) {
            support2 = c9;
        } else if (g8 != 0.0) {
            support2 = c7;
        } else if (g10 != 0.0) {
            support2 = e7;
        } else if (f11 != 0.0) {
            support2 = g7;
        } else if (d11 != 0.0) {
            support2 = g9;
        } else if (b11 != 0.0) {
            support2 = g11;
        } else if (b8 != 0.0) {
            support2 = e11;
        } else if (c6 != 0.0) {
            support2 = c11;
        } else if (f6 != 0.0) {
            support2 = b9;
        } else if (h7 != 0.0) {
            support2 = b6;
        } else if (h10 != 0.0) {
            support2 = e6;
        } else if (g12 != 0.0) {
            support2 = h6;
        } else if (d12 != 0.0) {
            support2 = h9;
        }

        tvSupport2.setText(roundOff(support2));
    }

    private void calculateSupport1() {
        if (c10 != 0.0) {
            support1 = e10;
        } else if (c8 != 0.0) {
            support1 = d10;
        } else if (d7 != 0.0) {
            support1 = c9;
        } else if (f7 != 0.0) {
            support1 = c7;
        } else if (g8 != 0.0) {
            support1 = e7;
        } else if (g10 != 0.0) {
            support1 = g7;
        } else if (f11 != 0.0) {
            support1 = g9;
        } else if (d11 != 0.0) {
            support1 = g11;
        } else if (b11 != 0.0) {
            support1 = e11;
        } else if (b8 != 0.0) {
            support1 = c11;
        } else if (c6 != 0.0) {
            support1 = b9;
        } else if (f6 != 0.0) {
            support1 = b6;
        } else if (h7 != 0.0) {
            support1 = e6;
        } else if (h10 != 0.0) {
            support1 = h6;
        } else if (g12 != 0.0) {
            support1 = h9;
        } else if (d12 != 0.0) {
            support1 = h12;
        }

        tvSupport1.setText(roundOff(support1));
    }


    private void calculateResistance4() {
        if (c10 != 0.0) {
            resistance4 = g9;
        } else if (c8 != 0.0) {
            resistance4 = g11;
        } else if (d7 != 0.0) {
            resistance4 = e11;
        } else if (f7 != 0.0) {
            resistance4 = c11;
        } else if (g8 != 0.0) {
            resistance4 = b9;
        } else if (g10 != 0.0) {
            resistance4 = b6;
        } else if (f11 != 0.0) {
            resistance4 = e6;
        } else if (d11 != 0.0) {
            resistance4 = h6;
        } else if (b11 != 0.0) {
            resistance4 = h9;
        } else if (b8 != 0.0) {
            resistance4 = h12;
        } else if (c6 != 0.0) {
            resistance4 = e12;
        } else if (f6 != 0.0) {
            resistance4 = b12;
        } else if (h7 != 0.0) {
            resistance4 = b12;
        } else if (h10 != 0.0) {
            resistance4 = b12;
        } else if (g12 != 0.0) {
            resistance4 = b12;
        } else if (d12 != 0.0) {
            resistance4 = b12;
        }

        tvResistance4.setText(roundOff(resistance4));
    }

    private void calculateResistance3() {
        if (c10 != 0.0) {
            resistance3 = g7;
        } else if (c8 != 0.0) {
            resistance3 = g9;
        } else if (d7 != 0.0) {
            resistance3 = g11;
        } else if (f7 != 0.0) {
            resistance3 = e11;
        } else if (g8 != 0.0) {
            resistance3 = c11;
        } else if (g10 != 0.0) {
            resistance3 = b9;
        } else if (f11 != 0.0) {
            resistance3 = b6;
        } else if (d11 != 0.0) {
            resistance3 = e6;
        } else if (b11 != 0.0) {
            resistance3 = h6;
        } else if (b8 != 0.0) {
            resistance3 = h9;
        } else if (c6 != 0.0) {
            resistance3 = h12;
        } else if (f6 != 0.0) {
            resistance3 = e12;
        } else if (h7 != 0.0) {
            resistance3 = b12;
        } else if (h10 != 0.0) {
            resistance3 = b12;
        } else if (g12 != 0.0) {
            resistance3 = b12;
        } else if (d12 != 0.0) {
            resistance3 = b12;
        }

        tvResistance3.setText(roundOff(resistance3));
    }

    private void calculateResistance2() {
        if (c10 != 0.0) {
            resistance2 = e7;
        } else if (c8 != 0.0) {
            resistance2 = g7;
        } else if (d7 != 0.0) {
            resistance2 = g9;
        } else if (f7 != 0.0) {
            resistance2 = g11;
        } else if (g8 != 0.0) {
            resistance2 = e11;
        } else if (g10 != 0.0) {
            resistance2 = c11;
        } else if (f11 != 0.0) {
            resistance2 = b9;
        } else if (d11 != 0.0) {
            resistance2 = b6;
        } else if (b11 != 0.0) {
            resistance2 = e6;
        } else if (b8 != 0.0) {
            resistance2 = h6;
        } else if (c6 != 0.0) {
            resistance2 = h9;
        } else if (f6 != 0.0) {
            resistance2 = h12;
        } else if (h7 != 0.0) {
            resistance2 = e12;
        } else if (h10 != 0.0) {
            resistance2 = b12;
        } else if (g12 != 0.0) {
            resistance2 = b12;
        } else if (d12 != 0.0) {
            resistance2 = b12;
        }

        tvResistance2.setText(roundOff(resistance2));
    }

    private void calculateResistance1() {
        if (c10 != 0.0) {
            resistance1 = c7;
        } else if (c8 != 0.0) {
            resistance1 = e7;
        } else if (d7 != 0.0) {
            resistance1 = g7;
        } else if (f7 != 0.0) {
            resistance1 = g9;
        } else if (g8 != 0.0) {
            resistance1 = g11;
        } else if (g10 != 0.0) {
            resistance1 = e11;
        } else if (f11 != 0.0) {
            resistance1 = c11;
        } else if (d11 != 0.0) {
            resistance1 = b9;
        } else if (b11 != 0.0) {
            resistance1 = b6;
        } else if (b8 != 0.0) {
            resistance1 = e6;
        } else if (c6 != 0.0) {
            resistance1 = h6;
        } else if (f6 != 0.0) {
            resistance1 = h9;
        } else if (h7 != 0.0) {
            resistance1 = h12;
        } else if (h10 != 0.0) {
            resistance1 = e12;
        } else if (g12 != 0.0) {
            resistance1 = b12;
        } else if (d12 != 0.0) {
            resistance1 = b12;
        }
        tvResistance1.setText(roundOff(resistance1));
    }

    private void clearAllFields() {
        tvValue11.setText("0.0");
        tvValue22.setText("0.0");
        tvValue33.setText("0.0");
        tvValue44.setText("0.0");
        tvValue55.setText("0.0");
        tvValue66.setText("0.0");
        tvValue77.setText("0.0");
        tvValue41.setText("0.0");
        tvValue42.setText("0.0");
        tvValue43.setText("0.0");
        tvValue45.setText("0.0");
        tvValue46.setText("0.0");
        tvValue47.setText("0.0");
        tvValue14.setText("0.0");
        tvValue24.setText("0.0");
        tvValue34.setText("0.0");
        tvValue54.setText("0.0");
        tvValue64.setText("0.0");
        tvValue74.setText("0.0");
        tvValue71.setText("0.0");
        tvValue62.setText("0.0");
        tvValue53.setText("0.0");
        tvValue35.setText("0.0");
        tvValue26.setText("0.0");
        tvValue17.setText("0.0");
        tvSellBelow.setText("0.0");
        tvBuyAbove.setText("0.0");

        tvSupport1.setText("0.0");
        tvSupport2.setText("0.0");
        tvSupport3.setText("0.0");
        tvSupport4.setText("0.0");
        tvResistance1.setText("0.0");
        tvResistance2.setText("0.0");
        tvResistance3.setText("0.0");
        tvResistance4.setText("0.0");

        resistance1 = 0.0;
        resistance2 = 0.0;
        resistance3 = 0.0;
        resistance4 = 0.0;
        support1 = 0.0;
        support2 = 0.0;
        support3 = 0.0;
        support4 = 0.0;
        buyAbove = 0.0;
        sellBelow = 0.0;
        c6 = 0.0;
        c8 = 0.0;
        c10 = 0.0;
        g8 = 0.0;
        g10 = 0.0;
        g12 = 0.0;
        b8 = 0.0;
        b11 = 0.0;
        h7 = 0.0;
        h10 = 0.0;
        d7 = 0.0;
        d11 = 0.0;
        d12 = 0.0;
        f6 = 0.0;
        f7 = 0.0;
        f11 = 0.0;
        g4 = 0.0;
        e9 = 0.0;
        b6 = 0.0;
        c7 = 0.0;
        d8 = 0.0;
        e6 = 0.0;
        e7 = 0.0;
        e8 = 0.0;
        b9 = 0.0;
        c9 = 0.0;
        d9 = 0.0;
        f9 = 0.0;
        g9 = 0.0;
        h9 = 0.0;
        f8 = 0.0;
        g7 = 0.0;
        h6 = 0.0;
        d4 = 0.0;
        e4 = 0.0;
        c4 = 0.0;
        b4 = 0.0;
        f4 = 0.0;
        f10 = 0.0;
        g11 = 0.0;
        h12 = 0.0;
        e10 = 0.0;
        e11 = 0.0;
        e12 = 0.0;
        b12 = 0.0;
        c11 = 0.0;
        d10=0.0;

    }



    private void calculateCMPQuadrent() {
        //First quadrant
        if (d4 >= b9 && d4 < b6) {
            b8 = b4;
        }
        if (d4 >= c9 && d4 < c7) {
            c8 = b4;
        }
        if (d4 >= b6 && d4 < e6) {
            c6 = b4;
        }
        if (d4 >= c7 && d4 < e7) {
            d7 = b4;
        }

        //Second quadrant
        if (d4 >= e6 && d4 < b12) {
            f6 = b4;
        }
        if (d4 >= e7 && d4 < g7) {
            f7 = b4;
        }
        if (d4 >= h6 && d4 < h9) {
            h7 = b4;
        }
        if (d4 >= g7 && d4 < g9) {
            g8 = b4;
        }

        //Third quadrant
        if (d4 >= c11 && d4 < b9) {
            b11 = b4;
        }
        if (d4 >= d10 && d4 < c9) {
            c10 = b4;
        }
        if (d4 >= e11 && d4 < c11) {
            d11 = b4;
        }
        if (d4 >= e12 && d4 < b12) {
            d12 = b4;
        }

        //Fourth quadrant
        if (d4 >= g11 && d4 < e11) {
            f11 = b4;
        }
        if (d4 >= g9 && d4 < g11) {
            g10 = b4;
        }
        if (d4 >= e12 && d4 < h12) {
            g12 = b4;
        }
        if (d4 >= h9 && d4 < h12) {
            h10 = b4;
        }
    }

    private void calculateGannValuesForView() {

        e9 = pow(b4, 2);
        b6 = pow((f4 + j2), 2);
        c7 = pow((c4 + j2), 2);
        d8 = pow((b4 + j2), 2);
        f10 = pow((b4 + j6), 2);
        g11 = pow((c4 + j6), 2);
        h12 = pow((f4 + j6), 2);
        e6 = pow((f4 + j3), 2);
        e7 = pow((c4 + j3), 2);
        e8 = pow((b4 + j3), 2);
        e10 = pow((b4 + j7), 2);
        e11 = pow((c4 + j7), 2);
        e12 = pow((f4 + j7), 2);
        b9 = pow((f4 + j1), 2);
        c9 = pow((c4 + j1), 2);
        d9 = pow((b4 + j1), 2);
        f9 = pow((b4 + j5), 2);
        g9 = pow((c4 + j5), 2);
        h9 = pow((f4 + j5), 2);
        b12 = pow((f4 + j8), 2);
        c11 = pow((c4 + j8), 2);
        d10 = pow((b4 + j8), 2);
        f8 = pow((b4 + j4), 2);
        g7 = pow((c4 + j4), 2);
        h6 = pow((f4 + j4), 2);
    }

    private void fillGannValuesInView() {
        tvValue44.setText(roundOff(e9));

        tvValue11.setText(roundOff(b6));
        tvValue22.setText(roundOff(c7));
        tvValue33.setText(roundOff(d8));
        tvValue55.setText(roundOff(f10));
        tvValue66.setText(roundOff(g11));
        tvValue77.setText(roundOff(h12));
        tvValue14.setText(roundOff(e6));
        tvValue24.setText(roundOff(e7));
        tvValue34.setText(roundOff(e8));
        tvValue54.setText(roundOff(e10));
        tvValue64.setText(roundOff(e11));
        tvValue74.setText(roundOff(e12));
        tvValue41.setText(roundOff(b9));
        tvValue42.setText(roundOff(c9));
        tvValue43.setText(roundOff(d9));
        tvValue45.setText(roundOff(f9));
        tvValue46.setText(roundOff(g9));
        tvValue47.setText(roundOff(h9));
        tvValue71.setText(roundOff(b12));
        tvValue62.setText(roundOff(c11));
        tvValue53.setText(roundOff(d10));
        tvValue35.setText(roundOff(f8));
        tvValue26.setText(roundOff(g7));
        tvValue17.setText(roundOff(h6));
    }

    private String roundOff(double number) {
        return String.format("%.2f", number);

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

            if (etCMP.getText().toString().equals("") || Double.valueOf(etCMP.getText().toString()) == 0) {
                clearAllFields();
                return;
            }
            calculateGannValues();
        }
    }

}
