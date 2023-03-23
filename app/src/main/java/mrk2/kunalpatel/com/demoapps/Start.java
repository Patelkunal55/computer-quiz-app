package mrk2.kunalpatel.com.demoapps;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;


public class Start extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 4000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);





        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent l = new Intent(Start.this, Menu.class);
                startActivity(l);
                finish();

            }
        }, SPLASH_TIME_OUT);
    }
}

