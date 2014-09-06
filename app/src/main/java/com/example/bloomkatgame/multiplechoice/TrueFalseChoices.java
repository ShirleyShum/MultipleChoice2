package com.example.bloomkatgame.multiplechoice;

/**
 * Created by Shirley on 9/4/2014.
 */
public class TrueFalseChoices {

    //This variable will hold a resource ID for a string . Later will be hold a resID for an image.
    private int imageQuestion;

    private boolean trueImageQuestion;

    public TrueFalseChoices(int question, boolean trueQuestion){
        imageQuestion = question;
        trueImageQuestion = trueQuestion;
    }

    public int getImageQuestion(){
        return imageQuestion;
    }

    public void setImageQuestion(int question){
        imageQuestion = question;
    }

    public boolean isTrueQuestion(){
        return trueImageQuestion;
    }

    public void setTrueImageQuestion(boolean trueQuestion){
        trueImageQuestion = trueQuestion;
    }

}
