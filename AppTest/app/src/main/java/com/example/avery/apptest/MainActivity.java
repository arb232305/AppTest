package com.example.avery.apptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Constants
    public static final boolean NUM_ENTERED = false;
    public static final String PLUS = " + ";
    public static final String MINUS = " - ";
    public static final String MULTIPLY = " * ";
    public static final String DIVIDE = " / ";
    public static final String POWER = " ^ ";
    //Used only for comparison logic, not used in display
    public static final String DELETE = "DELETE";
    public static final String CLEAR = "CLEAR";
    public static final String EQUALS = "EQUALS";

    //Variable
    String input = "";
    ArrayList<String> inputTokens = new ArrayList<String>();
    TextView displayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Array of buttons with integer labels "0, 1, 2, ... 9"
        Button[] numberButtons = new Button[10];
        for (int i = 0; i < numberButtons.length; i++) {
            //Get the id
            int id = getResources().getIdentifier("button" + i, "id", this.getPackageName());
            //Get the button from the id
            Button currentButton = findViewById(id);
            //Put the button in the array of number buttons
            numberButtons[i] = currentButton;

            //Create a final copy of i so that it can be used in the scope of onClick
            final int iCopy = i;
            //Set up click handling for the button
            currentButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    handleClick(iCopy);
                }
            });
        }

        //Get displayText
        displayText = findViewById(R.id.displayText);

        //Get all of the non-numbered buttons (operators, delete, clear, etc.)
        Button plusButton = findViewById(R.id.buttonPlus);
        Button minusButton = findViewById(R.id.buttonMinus);
        Button multiplyButton = findViewById(R.id.buttonMultiply);
        Button divideButton = findViewById(R.id.buttonDivide);
        Button powerButton = findViewById(R.id.buttonPower);
        Button deleteButton = findViewById(R.id.buttonDelete);
        Button clearButton = findViewById(R.id.buttonClear);
        Button equalsButton = findViewById(R.id.buttonEquals);

        //Set all non-numbered click handling
        //The click listeners simply pass the argument to the handleClick method
        plusButton.setOnClickListener(getClickListener(PLUS));
        minusButton.setOnClickListener(getClickListener(MINUS));
        multiplyButton.setOnClickListener(getClickListener(MULTIPLY));
        divideButton.setOnClickListener(getClickListener(DIVIDE));
        powerButton.setOnClickListener(getClickListener(POWER));
        deleteButton.setOnClickListener(getClickListener(DELETE));
        clearButton.setOnClickListener(getClickListener(CLEAR));
        equalsButton.setOnClickListener(getClickListener(EQUALS));
    }


    //Handled operator button presses
    public void handleClick(String clickValue){
        switch (clickValue){
            case EQUALS:
                break;
            //Clear deletes all input
            case CLEAR:
                //Clear the input and tokens list
                input = "";
                inputTokens.clear();
                //Update the display to reflect the clear
                displayText.setText(input);
                break;
            //Delete removes the last input
            case DELETE:
                break;
            case PLUS:
                break;
            case MINUS:
                break;
            case MULTIPLY:
            case DIVIDE:
                break;
            case POWER:
                break;
        }
    }

    //Overloaded method - if the argument is an integer, this version of the method is called
    //Handled integer button presses
    public void handleClick(int clickValue){
        //NOTE: Implementing data binding later one would reduce complexity

        //Convert clickValue to a string
        String clickValueString = clickValue + "";
        //Concatenate input with the clickValue
        input += clickValueString;
        //clickValue to token list
        inputTokens.add(clickValueString);
        //Update the display to input's value
        displayText.setText(input);
    }

    //Returns a clickListener which calls handleClick(clickValue) on click
    public View.OnClickListener getClickListener(String clickValue){
        final String clickCopy = clickValue;
        return (new View.OnClickListener() {
            public void onClick(View v) {
                handleClick(clickCopy);
            }
        });
    }

}

