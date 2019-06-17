package com.example.kittycam_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txt;
    ImageView imageView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView)findViewById(R.id.textView);
        imageView1 = (ImageView) findViewById(R.id.imageView);
        final Intent i = new Intent(MainActivity.this, menupage.class);
        Animation cat = AnimationUtils.loadAnimation(this,R.anim.mytrans);
        txt.startAnimation(cat);
        imageView1.startAnimation(cat);
        Thread start1 = new Thread(){
            public void run(){
                try {
                    sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();


                }
            }
        };
        start1.start();

    }


}
