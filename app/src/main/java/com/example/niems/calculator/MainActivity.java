package com.example.niems.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int troll_num; //number of times this activity has changed the text on the user
    private String[] troll_text; //the different variations the text goes through
    private String troll_current_message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.troll_num = 0;
        this.troll_text = new String[5];

        this.troll_current_message = "Do not press";
        this.troll_text[0] = "did I not just tell you to leave that alone?";
        this.troll_text[1] = "please don't touch my button...";
        this.troll_text[2] = "pervert.";
        this.troll_text[3] = "hey, how about FUCK OFF!";
        this.troll_text[4] = "FINE. you win.";


        TextView troll_view = (TextView) findViewById( R.id.troll );
        troll_view.setText( this.troll_current_message );


    }

    public void troll(View view){
        //calls calculator to start activity after the troll loop

        TextView troll_text = (TextView) findViewById( R.id.troll );

        //sets the current message as the new troll, displayed to the user

        if( this.troll_num < this.troll_text.length ){
            this.troll_current_message = this.troll_text[ this.troll_num ];
            troll_text.setText( this.troll_current_message ); //displays new troll on screen
        }

        this.troll_num++; //next troll

        if( this.troll_num == this.troll_text.length){
            startCalculator( view );
        }

    }

    public void startCalculator(View view){
        Intent intent = new Intent( this, Calculator.class );

        startActivity( intent );
    }
}
