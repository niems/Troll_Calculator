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
        this.s_second_num = "#"; //while the value is '#',
        this.s_display_view = this.s_first_num; //display view default

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        TextView display_view = (TextView) findViewById( R.id.display_view ); //gets the display view to modify
        display_view.setText( this.s_display_view ); //current total displayed in view
    }

    public void numberClick( View view ){ //if the user presses a number
        try{
            TextView display_view = (TextView) findViewById( R.id.display_view ); //gets the display view to modify
            Button b = (Button) findViewById( view.getId() ); //button the user pressed


            if( !this.s_second_num.equals("#") ){ //the second number is to be inputted

                if( this.s_second_num.equals("0") || this.s_second_num.equals("0.0") ){
                    this.s_second_num = b.getText().toString(); //user entered. Needs to be overwritten
                }

                else{
                    this.s_second_num += b.getText().toString(); //concatenates current button number with the second number
                }

                this.s_display_view = this.s_first_num + " " + this.s_current_operator + " " + this.s_second_num; //current view to display
            }

            else{ //first number to be inputted

                if( this.s_first_num.equals("0") || this.s_first_num.equals("0.0") ){ //default value or user entered. Needs to be overwritten
                    this.s_first_num = b.getText().toString();
                }

                else{ //concatenates current button number with the first number
                    this.s_first_num += b.getText().toString();
                }

                this.s_display_view = this.s_first_num; //current view to display
            }

            display_view.setText( this.s_display_view ); //sets new display view

        }catch(Exception e){
            Toast.makeText(this, "An error has occurred in numberClick()", Toast.LENGTH_SHORT).show(); //displays error to user
        }
    }

    public void operatorClick( View view ){

        try{
            TextView display_view = (TextView) findViewById( R.id.display_view ); //used to modify the display view
            Button b = (Button) findViewById( view.getId() ); //button user pressed (the operator)


            //no computation to do since the second number has not been inputted yet
            //this also means the first number is done being inputted, so the second
            //number is ready for input
            if( this.s_second_num.equals("#") ){
                this.s_current_operator = b.getText().toString(); //new operator
                this.s_second_num = ""; //second number is ready for input

                this.s_display_view = this.s_first_num + " " + this.s_current_operator; //current view to display
            }

            else if( this.s_second_num.equals("") ){ //user is switching operator sign
                this.s_current_operator = b.getText().toString();

                this.s_display_view = this.s_first_num + " " + this.s_current_operator; //current view to display
            }

            //computation to be done since the second number exists
            else{
                double temp_total = 0; //used to do the computation of the two numbers

                switch( this.s_current_operator ){
                    case "+":
                        temp_total = Double.parseDouble( this.s_first_num ) + Double.parseDouble( this.s_second_num );
                        break;

                    case "-":
                        temp_total = Double.parseDouble( this.s_first_num ) - Double.parseDouble( this.s_second_num );
                        break;

                    case "x":
                        temp_total = Double.parseDouble( this.s_first_num ) * Double.parseDouble( this.s_second_num );
                        break;

                    case "/":
                        temp_total = Double.parseDouble( this.s_first_num ) / Double.parseDouble( this.s_second_num );
                        break;
                }

                this.s_first_num = Double.toString( temp_total ); //stores the computation in the first number
                this.s_second_num = ""; //reset to the second number being ready for input
                this.s_current_operator = b.getText().toString(); //sets the new operator

                this.s_display_view = this.s_first_num + " " + this.s_current_operator; //current view to display
            }

            display_view.setText( this.s_display_view ); //sets new display view

        }catch( Exception e ){
            Toast.makeText( this, "Operator - error in try block", Toast.LENGTH_SHORT ).show();
        }
    }

    //clears the operator and the current total
    public void clearTotal( View view ){
        try{
            TextView display_view = (TextView) findViewById( R.id.display_view ); //display view to modify

            Toast.makeText(this, "cleared display & values", Toast.LENGTH_SHORT).show(); //debugging

            //reset to default values
            this.s_first_num = "0.0";
            this.s_current_operator = "";
            this.s_second_num = "#";

            this.s_display_view = this.s_first_num;
            display_view.setText( this.s_display_view ); //sets new display view

        }catch(Exception e){
            Toast.makeText(this, "An error occurred in clearTotal()", Toast.LENGTH_SHORT).show(); //displays error message to user
        }
    }
}