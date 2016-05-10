package com.example.niems.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends AppCompatActivity {

    private boolean b_first_execution; //true if this app was just opened and hasn't preformed any computations
    private String s_display_view; //computation that's displayed in the view
    private String s_current_operator; //current operator
    private String s_current_num; //current number the user is inputting
    private double d_current_total; //running total

    //new display
    private String s_first_num;
    private String s_second_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.b_first_execution = true;
        this.s_current_operator = "";
        this.d_current_total = 0; //current valid number that could have been through multiple computations (running total)
        this.s_current_num = Double.toString( this.d_current_total ); //current number the user is entering
        //this.s_display_view = this.s_current_num; //display view default

        //new var
        this.s_first_num = Double.toString( this.d_current_total );
        this.s_second_num = ""; //not used until later
        this.s_display_view = this.s_first_num; //display view default

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        TextView display_view = (TextView) findViewById( R.id.display_view ); //gets the display view to modify
        display_view.setText( this.s_display_view ); //current total displayed in view
    }

    public void numberClick( View view ){
        try{
            TextView display_view = (TextView) findViewById( R.id.display_view ); //gets the display view to modify
            Button b = (Button) findViewById( view.getId() ); //button the user pressed


            if( !this.s_second_num.equals("") ){ //the second number is to be inputted

            }

            else{ //first number to be inputted

            }

        }catch(Exception e){
            Toast.makeText(this, "An error has occurred in numberClick()", Toast.LENGTH_SHORT).show(); //displays error to user
        }
    }

    /*
    //when the user presses a number or the decimal point, it appears on the display view
    public void numberClick( View view ){


        try{
            TextView display_view = (TextView) findViewById( R.id.display_view ); //gets the display view to modify
            Button b = (Button) findViewById( view.getId() ); //reads in the current user input

            //put check for if there is already a decimal here. If there is, the decimal key has no effect.

            if( this.b_first_execution ) { //program just started

                Toast.makeText(this, "number - first execution", Toast.LENGTH_SHORT).show();

                this.s_current_num = b.getText().toString(); //overwrites the default display value
                this.d_current_total = Double.parseDouble( this.s_current_num ); //overwrites default total
                this.b_first_execution = false;

                this.s_display_view = this.s_current_num; //current view to display to the screen
            }

            else { //program has been running and computations have been preformed
                Toast.makeText(this, "number - combines string with current number displayed", Toast.LENGTH_SHORT).show();

                this.s_current_num = this.s_current_num + b.getText().toString();
                //this.d_current_total = Double.parseDouble( this.s_current_num );

                this.s_display_view = Double.toString( this.d_current_total ) + " " + this.s_current_operator + " " + this.s_current_num;
            }

            display_view.setText( this.s_display_view ); //current view
            //display_view.setText( Double.toString( this.d_current_total ) ); //current number is displayed on the main display view


        }catch(Exception e){
            Toast.makeText(this, "An error has occurred in numberClick()", Toast.LENGTH_SHORT).show(); //displays error message to user
        }
    }
    */

    /*when the user presses an operator button(+,-,*,/) the current string number is combined
    with the current total using the previous operator pressed if applicable. Otherwise,
    the current string number is set to the current total. After this, the new operator
    pressed overwrites the current operator.

    *this.s_current_num needs to be cleared when an operator is pressed
    *
    */
    public void operatorClick( View view ){
        TextView display_view = (TextView) findViewById( R.id.display_view ); //gets the display view to modify
        Button b = (Button) findViewById( view.getId() ); //gets the id of the operator pressed


        try{

            this.s_current_num = ""; //reset

            if( this.b_first_execution ){ //no commands have been executed

                this.s_current_operator = b.getText().toString(); //sets the new operator
                this.b_first_execution = false;
                Toast.makeText(this, "operator - first execution", Toast.LENGTH_SHORT).show();
            }

            //there is no operator and the program has executed before
            else if( this.s_current_operator.equals("") ){
                Toast.makeText(this, "operator - new operator", Toast.LENGTH_SHORT).show();
                this.s_current_operator = b.getText().toString(); //stores the new operator
            }

            else{
                //sets new operator after doing computation
                Toast.makeText(this, "operator - else statement", Toast.LENGTH_SHORT).show();

                switch( this.s_current_operator ){
                    case "+":
                        this.d_current_total = this.d_current_total + Double.parseDouble( this.s_current_num );
                        break;

                    case "-":
                        this.d_current_total = this.d_current_total - Double.parseDouble( this.s_current_num );
                        break;

                    case "*":
                        this.d_current_total = this.d_current_total * Double.parseDouble( this.s_current_num );
                        break;

                    case "/":
                        this.d_current_total = this.d_current_total / Double.parseDouble( this.s_current_num );
                        break;
                }

                this.s_current_operator = b.getText().toString(); //sets new operator


                //this.s_display_view = Double.toString( this.d_current_total ) + " " + this.s_current_operator;
               // display_view.setText( this.s_display_view );

                //display_view.setText( Double.toString( this.d_current_total ) );
            }

            this.s_display_view = Double.toString( this.d_current_total ) + " " + this.s_current_operator;
            display_view.setText( this.s_display_view );

        }catch(Exception e){
            Toast.makeText(this, "An error occurred in operatorClick()", Toast.LENGTH_SHORT).show(); //displays error message to user
        }
    }

    //clears the operator and the current total
    public void clearTotal( View view ){
        try{

            Toast.makeText(this, "cleared display & values", Toast.LENGTH_SHORT).show();

            TextView display_view = (TextView) findViewById( R.id.display_view );

            //resets all values
            this.s_current_operator = "";
            this.d_current_total = 0;
            this.s_current_num = Double.toString( this.d_current_total );
            this.b_first_execution = true;

            this.s_display_view = this.s_current_num;

            display_view.setText( this.s_display_view );

        }catch(Exception e){
            Toast.makeText(this, "An error occurred in clearTotal()", Toast.LENGTH_SHORT).show(); //displays error message to user
        }
    }
}