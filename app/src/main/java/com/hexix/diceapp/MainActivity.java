package com.hexix.diceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnRollTheDice=findViewById(R.id.btnRollTheDice);
        final ImageView imgDice1=findViewById(R.id.imgDice1);
        final ImageView imgDice2=findViewById(R.id.imgDice2);

        final MediaPlayer mp =MediaPlayer.create(this,R.raw.dice_sound);

        final int[] diceImages={R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,
                R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};

        btnRollTheDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Log.i("My dice app","Dice rolled!!");
                Random rand=new Random();
                int digit=rand.nextInt(6);
                //Log.i("Dice app", Integer.toString(digit));
                imgDice1.setImageResource(diceImages[digit]);
                digit=rand.nextInt(6);
                //Log.i("Dice app", Integer.toString(digit));
                imgDice2.setImageResource(diceImages[digit]);
                YoYo.with(Techniques.Swing)
                        .duration(400)
                        .repeat(0)
                        .playOn(imgDice1);
                YoYo.with(Techniques.Swing)
                        .duration(400)
                        .repeat(0)
                        .playOn(imgDice2);

                mp.start();

            }
        });
    }
}
