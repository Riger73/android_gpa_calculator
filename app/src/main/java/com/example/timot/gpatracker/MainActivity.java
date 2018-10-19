package com.example.timot.gpatracker;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void calculateGPAtotal() {
        final double HD_GRADE_VAL = 48.0;
        final double D_GRADE_VAL = 36.0;
        final double C_GRADE_VAL = 24.0;
        final double P_GRADE_VAL = 12.0;
        final double N_GRADE_VAL = 0.0;
        final double UNIT_LOAD_VAL = 12.0;

        int HDs = Integer.parseInt(tfNumberOfHighDistinctions.getText());
        int Ds = Integer.parseInt(tfNumberOfDistinctions.getText());
        int Cs = Integer.parseInt(tfNumberOfCredits.getText());
        int Ps = Integer.parseInt(tfNumberOfPasses.getText());
        int Ns = Integer.parseInt(tfNumberOfFails.getText());

        double GPA = ((HDs * HD_GRADE_VAL) + (Ds * D_GRADE_VAL) + (Cs * C_GRADE_VAL) +
                (Ps * P_GRADE_VAL) + (Ns * N_GRADE_VAL)) / ((HDs * UNIT_LOAD_VAL) +
                (Ds * UNIT_LOAD_VAL) + (Cs * UNIT_LOAD_VAL) + (Ps * UNIT_LOAD_VAL) +
                (Ns * UNIT_LOAD_VAL));
        mTextMessage.setText(String.format("%.2f", GPA));
    }
}

}
