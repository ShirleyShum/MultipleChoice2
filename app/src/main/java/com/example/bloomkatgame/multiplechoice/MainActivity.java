package com.example.bloomkatgame.multiplechoice;

import android.media.Image;
import android.util.Log;


        import android.app.Activity;
// import android.support.v7.app.ActionBarActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.Gravity;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.lang.reflect.Array;
        import java.util.ArrayList;
        import java.util.Collections;
        import java.util.List;
        import java.util.Random;


public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    //Declaring button variables
    Button choiceButton1;
    Button choiceButton2;
    Button choiceButton3;
    Button choiceButton4;

    //declare isButtonCorrect outside of the function so that its values persist even after allButtonChoice() exits.
    Boolean[] isButtonCorrect = new Boolean[4];

    ImageView imageQuestion;

    //Make an array of four buttons.
    private static final int[] idButtonArray = {R.id.choice_button1,R.id.choice_button2, R.id.choice_button3, R.id.choice_button4};
    private Button[] buttonArray = new Button[idButtonArray.length];

    //The question that will be display.
    TrueFalseChoices[] questionKey = new TrueFalseChoices[]{
            new TrueFalseChoices(R.drawable.apple, true),
            new TrueFalseChoices(R.drawable.orange, true),
            new TrueFalseChoices(R.drawable.grape, true),
            new TrueFalseChoices(R.drawable.peach, true),
            new TrueFalseChoices(R.drawable.strawberry, true)
    };
/*
    //Create an array with AnswersChoiceOne constructor that holds choiceButton1 answers.
    AnswersChoiceOne[] answerKeyOne = new AnswersChoiceOne[]{
            new AnswersChoiceOne(R.string.answser_1, true),
            new AnswersChoiceOne(R.string.answser_2, false),
            new AnswersChoiceOne(R.string.answser_3, false),
            new AnswersChoiceOne(R.string.answser_4, false)
    };*/

    Button[] multiChoice = new Button[3];


    public void allButtonChoice(){
        //Assign each button an index in the array.
        //the array that will hold the four buttons.
        List<Button> multiChoice = new ArrayList<Button>();
        multiChoice.add(choiceButton1);
        multiChoice.add(choiceButton2);
        multiChoice.add(choiceButton3);
        multiChoice.add(choiceButton4);

        //buttonText is an array of Strings which contains the text for the four buttons
        //Arranging the buttons.
        String[] buttonTexts = new String[4];
        List<Integer> indexPermutation = new ArrayList<Integer>();
        for(int i = 0; i < 4; i++) {
            buttonTexts[i] = String.format("Button %d", i + 1);
            indexPermutation.add(i);
        }

        //Assign buttonText randomly to each button
        Collections.shuffle(indexPermutation);

        //
        for(int i = 0; i < 4; i++) {
            multiChoice.get(i).setText(buttonTexts[indexPermutation.get(i)]);
            //if a button gets the buttonTexts[0], then the corresponding element of isButtonCorrect gets set to true, otherwise it get set to false.
            isButtonCorrect[i] = indexPermutation.get(i) == 0;
        }


    }

    //update imageQuestion
    int currentIndex = 0;

    private void updateQuestion(){
        int question = questionKey[currentIndex].getImageQuestion();
        imageQuestion.setImageResource(question);
        currentIndex = (currentIndex + 1) % questionKey.length;
    }
/*
    //update imageAnswerOne
    int answerOneCurrentIndex = 0;

    private void updateAnswerOne(){
        int answerOne = answerKeyOne[answerOneCurrentIndex].getImageAnswerOne();
        choiceButton1.setText(answerOne);
        answerOneCurrentIndex = (answerOneCurrentIndex + 1) % answerKeyOne.length;
    }*/



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
        imageQuestion = (ImageView)findViewById(R.id.image_view);

        //wiring the buttons
        choiceButton1 = (Button)findViewById(R.id.choice_button1);

        choiceButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //each button handler checks its corresponding value in isButtonCorrect
                checkAnswer(isButtonCorrect[0]);
                updateQuestion();
                allButtonChoice();

            }
        });
        choiceButton2 = (Button)findViewById(R.id.choice_button2);
        choiceButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(isButtonCorrect[1]);
                allButtonChoice();

            }
        });

        choiceButton3 = (Button)findViewById(R.id.choice_button3);
        choiceButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(isButtonCorrect[2]);
                allButtonChoice();
            }
        });

        choiceButton4 = (Button)findViewById(R.id.choice_button4);
        choiceButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(isButtonCorrect[3]);
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
