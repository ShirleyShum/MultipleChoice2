package com.example.bloomkatgame.multiplechoice;

/**
 * Created by Shirley on 9/16/2014.
 */
public class AnswersChoiceOne {
    //This variable will hold a resource ID for a string .
    private int imageAnswerOne;

    //This variable is for the image question.
    private boolean trueImageAnswerOne;

    private int assignButtonIndex;

    public AnswersChoiceOne(int answerOne, boolean trueAnswerOne){
        imageAnswerOne = answerOne;
        trueImageAnswerOne = trueAnswerOne;
    }

    public int getImageAnswerOne(){
        return imageAnswerOne;
    }

    public void setImageAnswerOne(int answerOne){
        imageAnswerOne = answerOne;
    }

    public boolean isTrueImageAnswerOne(){
        return trueImageAnswerOne;
    }

    public void setTrueImageAnswerOne(boolean trueAnswerOne){
        trueImageAnswerOne = trueAnswerOne;
    }
}
