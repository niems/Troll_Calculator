package com.example.niems.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends AppCompatActivity {

    private String current_operator; //current operator
    private String current_num; //current number the user is inputting
    private double current_computation; //running total

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.current_operator = "";
        this.current_computation = 0;
        this.current_num = "";

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
    }

    //when the user presses a number or the decimal point, it appears on the display view
    public void numberClick( View view ){

        try{
            TextView display_view = (TextView) findViewById( R.id.display_view ); //gets the display view to modify
            Button b = (Button) findViewById( view.getId() ); //reads in the current user input

            this.current_num = this.current_num + b.getText().toString();
            display_view.setText( this.current_num ); //current number is displayed on the main display view


        }catch(Exception e){
            Toast.makeText(this, "An error has occurred", Toast.LENGTH_SHORT).show(); //displays error message to user
        }
    }

    //user presses an operator button. The current number is saved as a double, and the current
    //operator is switched
    public void operatorClick( View view ){

        /*
        try{
            TextView display_view = (TextView) findViewById( R.id.display_view ); //used to modify display view if valid number
            Button operator_symbol = (Button) findViewById( view.getId() ); //gets id of the current operator
            String result = "";

            this.current_operator = operator_symbol.getText().toString(); //operator clicked is the new operator used

            if( validNumber() ){ //if true, the number is valid and is stored

                result = Double.toString( this.current_computation );

                switch( this.current_operator ){
                    case "+":
                        this.current_computation = this.current_computation + Double.parseDouble( this.current_num );
                        result += " + ";
                        break;

                    case "-":
                        this.current_computation = this.current_computation - Double.parseDouble( this.current_num );
                        result += " - ";
                        break;

                    case "*":
                        this.current_computation = this.current_computation * Double.parseDouble( this.current_num );
                        result += " * ";
                        break;

                    case "/":
                        this.current_computation = this.current_computation / Double.parseDouble( this.current_num );
                        result += " / ";
                        break;
                }

                result += this.current_num;

                //update textview here
                display_view.setText( result );
            }


        }catch(Exception e){
            e.printStackTrace();
        }
        */
    }

    public boolean validNumber(){ //returns true if the number is valid
        boolean valid = true; //false if the current number is not valid
        int decimal_occurrences = 0;

        for(int i = 0; i < this.current_num.length(); i++){ //loops through the whole string

            if( this.current_num.charAt(i) == '.' ){
                decimal_occurrences++;

                if( decimal_occurrences > 1){ //number has too many decimals in it
                    valid = false;
                    break;
                }
            }
        }

        return valid;
    }
}