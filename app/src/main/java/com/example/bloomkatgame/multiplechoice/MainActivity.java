package com.example.bloomkatgame.multiplechoice;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class MainActivity extends ActionBarActivity {

    private static final String TAG = "MainActivity";

        //Declaring button variables
        Button choiceButton1;
        Button choiceButton2;
        Button choiceButton3;
        Button choiceButton4;

        TextView imageQuestion;

        //Make an array of four buttons.
        private static final int[] idButtonArray = {R.id.choice_button1,R.id.choice_button2, R.id.choice_button3, R.id.choice_button4};
        private Button[] buttonArray = new Button[idButtonArray.length];

    //The question that will be display.
        TrueFalseChoices[] questionKey = new TrueFalseChoices[]{
                new TrueFalseChoices(R.string.question_1, true),
                new TrueFalseChoices(R.string.question_2, true),
                new TrueFalseChoices(R.string.question_3, true),
                new TrueFalseChoices(R.string.question_4, true),
                new TrueFalseChoices(R.string.question_5, true)
        };

        //Create an array with AnswersChoiceOne constructor that holds choiceButton1 answers.
        AnswersChoiceOne[] answerKeyOne = new AnswersChoiceOne[]{
                new AnswersChoiceOne(R.string.answser_1, true),
                new AnswersChoiceOne(R.string.answser_2, false),
                new AnswersChoiceOne(R.string.answser_3, false),
                new AnswersChoiceOne(R.string.answser_4, false)
        };

        Button[] multiChoice = new Button[3];

    //Assign each button an index in the array.
        //the array that will hold the four buttons.
        public void allButtonChoice(){



            //to output shuffled array in an randomized order.
            //Random number generator.
            Random generateMultiChoice = new Random();


/*            List<Integer> objects = new ArrayList<Integer>();
            objects.add(0);
            objects.add(1);
            objects.add(2);
            objects.add(3);

            //Shuffle collection
            Collections.shuffle(objects);

            List<Button> buttons = new ArrayList<Button>();
            buttons.add((Button)findViewById(R.id.choice_button1));
            buttons.add((Button)findViewById(R.id.choice_button2));
            buttons.add((Button)findViewById(R.id.choice_button3));
            buttons.add((Button)findViewById(R.id.choice_button4));

            for (int i = 0; i < objects.size(); i++) {
                buttons.get(i).setText(objects.get(i).toString());

            }*/


            //Make an arrayList that holds four buttons.
            List<Button> multiChoice = new ArrayList<Button>();
            multiChoice.add(choiceButton1);
            multiChoice.add(choiceButton2);
            multiChoice.add(choiceButton3);
            multiChoice.add(choiceButton4);

/*            //Make an arrayList that holds four buttons.
            List<Integer> multiChoice = new ArrayList<Integer>();
            multiChoice.add(R.id.choice_button1);
            multiChoice.add(R.id.choice_button2);
            multiChoice.add(R.id.choice_button3);
            multiChoice.add(R.id.choice_button4);*/

            //Shuffle collection
            Collections.shuffle(multiChoice);


            //Create an array of the possible coordinates.
            //Shuffle the array coordinates to the buttons using setLeft and setTop
            List<Integer> leftCoordinates = new ArrayList<Integer>();
            leftCoordinates.add(2);
            leftCoordinates.add(250);
            leftCoordinates.add(2);
            leftCoordinates.add(250);

            List<Integer> topCoordinates = new ArrayList<Integer>();
            topCoordinates.add(2);
            topCoordinates.add(2);
            topCoordinates.add(2);
            topCoordinates.add(2);

            for(int i = 0; i < multiChoice.size(); i++){
                multiChoice.get(i).setLeft(leftCoordinates.get(i));
                multiChoice.get(i).setTop(topCoordinates.get(i));
            }

        }

        //update imageQuestion
        int currentIndex = 0;

        private void updateQuestion(){
            int question = questionKey[currentIndex].getImageQuestion();
            imageQuestion.setText(question);
            currentIndex = (currentIndex + 1) % questionKey.length;
        }

        //update imageAnswerOne
        int answerOneCurrentIndex = 0;

        private void updateAnswerOne(){
            int answerOne = answerKeyOne[answerOneCurrentIndex].getImageAnswerOne();
            choiceButton1.setText(answerOne);
            answerOneCurrentIndex = (answerOneCurrentIndex + 1) % answerKeyOne.length;
        }



        //Check the answer of the imageQuestion
        private void checkAnswer(boolean userPressedTrue){
            boolean answerIsTrue = questionKey[currentIndex].isTrueQuestion();

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
                allButtonChoice();

            }
        });

        choiceButton3 = (Button)findViewById(R.id.choice_button3);
        choiceButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
                allButtonChoice();
            }
        });

        choiceButton4 = (Button)findViewById(R.id.choice_button4);
        choiceButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
                allButtonChoice();

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
