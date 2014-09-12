package com.example.bloomkatgame.multiplechoice;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Random;


public class MainActivity extends ActionBarActivity {

    private static final String TAG = "MainActivity";

        //Declaring button variables
        Button choiceButton1;
        Button choiceButton2;
        Button choiceButton3;
        Button choiceButton4;

        TextView imageQuestion;

        TrueFalseChoices[] answerKey = new TrueFalseChoices[]{
                new TrueFalseChoices(R.string.question_1, true),
                new TrueFalseChoices(R.string.question_2, true),
                new TrueFalseChoices(R.string.question_3, true),
                new TrueFalseChoices(R.string.question_4, true),
                new TrueFalseChoices(R.string.question_5, true)
        };

    Button[] multiChoice = new Button[3];

        //Assign each button an index in the array.
        //the array that will hold the four buttons.
/*        private allButtonChoice[] multipleChoice = new allButtonChoice[]{
            new allButtonChoice(choiceButton1)
        }*/
        public void allButtonChoice(){
            //Button[] multiChoice = new Button[3];
            multiChoice = new Button[]{choiceButton1,choiceButton2,choiceButton3,choiceButton4};

            //to output shuffled array in an randomized order.
            //Random number generator.

            Random generateMultiChoice = new Random();

            for(int i = 0; i < multiChoice.length; i++){
                int randomPosition = generateMultiChoice.nextInt(multiChoice.length);
                Button temp = multiChoice[i];
                multiChoice[i] = multiChoice[randomPosition];
                multiChoice[randomPosition] = temp;
            }
            //return multiChoice;
            //set the positions to the buttons in order

            //(Button) multiChoice[0] = choiceButton1.setX(10);
/*            choiceButton1.setPadding(20,10,20,10);
            choiceButton2.setPadding(20,20,20,20);
            choiceButton3.setPadding(20,10,20,10);
            choiceButton4.setPadding(20,20,20,20);*/
/*
            choiceButton1.setX(13f) = generateMultiChoice.nextFloat(multiChoice.length);
            choiceButton1.setY(13f) = Math.random()* multiChoice.length;
            choiceButton2.setX(12f) = Math.random()* multiChoice.length;
            choiceButton2.setY(12f) = Math.random()* multiChoice.length;
*/
            choiceButton1.setX(10f);
            choiceButton1.setY(10f);
            choiceButton2.setX(10f);
            choiceButton2.setY(10f);
            choiceButton3.setX(10f);
            choiceButton3.setY(10f);
            choiceButton4.setX(10f);
            choiceButton4.setY(10f);



        }


        //update imageQuestion
        int currentIndex = 0;

        private void updateQuestion(){
            int question = answerKey[currentIndex].getImageQuestion();
            imageQuestion.setText(question);
            currentIndex = (currentIndex + 1) % answerKey.length;
        }

        //Check the answer of the imageQuestion
        private void checkAnswer(boolean userPressedTrue){
            boolean answerIsTrue = answerKey[currentIndex].isTrueQuestion();

            int imageResId = 0;

            if(userPressedTrue == answerIsTrue){
                imageResId = R.string.correct_toast;
            }else{
                imageResId = R.string.incorrect_toast;
            }
            Toast.makeText(this, imageResId, Toast.LENGTH_SHORT).show();
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate() called");
        setContentView(R.layout.activity_game);

        //wiring the imageQuestion
        imageQuestion = (TextView)findViewById(R.id.image_view);

        //wiring the buttons
        choiceButton1 = (Button)findViewById(R.id.choice_button1);

        choiceButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
                updateQuestion();
                allButtonChoice();
            }
        });
        choiceButton2 = (Button)findViewById(R.id.choice_button2);
        choiceButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        choiceButton3 = (Button)findViewById(R.id.choice_button3);
        choiceButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);

            }
        });

        choiceButton4 = (Button)findViewById(R.id.choice_button4);
        choiceButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });



        updateQuestion();
        allButtonChoice();



    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

/*    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }*/
}
