package ir.alirezabdn.wp7progressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import ir.alirezabdn.wp7progress.WP10ProgressBar;
import ir.alirezabdn.wp7progress.WP7ProgressBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final WP7ProgressBar wp7ProgressBar = findViewById(R.id.wp7progressBar);
        final WP10ProgressBar wp10ProgressBar = findViewById(R.id.wp10progressBar);
        wp10ProgressBar.setIndicatorRadius(5);

        findViewById(R.id.showWP7Btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wp7ProgressBar.showProgressBar();
            }
        });

        findViewById(R.id.hideWP7Btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wp7ProgressBar.hideProgressBar();
            }
        });

        findViewById(R.id.showWP10Btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wp10ProgressBar.showProgressBar();
            }
        });

        findViewById(R.id.hideWP10Btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wp10ProgressBar.hideProgressBar();
            }
        });
    }
}
