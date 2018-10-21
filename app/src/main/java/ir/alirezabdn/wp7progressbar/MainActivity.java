package ir.alirezabdn.wp7progressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import ir.alirezabdn.wp7progress.WP7ProgressBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final WP7ProgressBar wp7ProgressBar = findViewById(R.id.pBar);

        findViewById(R.id.showBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wp7ProgressBar.showProgressBar();
            }
        });

        findViewById(R.id.hideBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wp7ProgressBar.hideProgressBar();
            }
        });
    }
}
