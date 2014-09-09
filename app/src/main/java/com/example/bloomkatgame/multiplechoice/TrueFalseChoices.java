package com.example.bloomkatgame.multiplechoice;

/**
 * Created by Shirley on 9/4/2014.
 */
public class TrueFalseChoices {

    //This variable will hold a resource ID for a string . Later will be hold a resID for an image.
    private int imageQuestion;

    //This variable is for the image question.
    private boolean trueImageQuestion;

    //These varaibles are for the buttons choices.
    private boolean allButtons;

    public TrueFalseChoices(int question, boolean trueQuestion){
        imageQuestion = question;
        trueImageQuestion = trueQuestion;
    }

    //Created this method so that I can use it in MainActivity and create an array out of this.
    public void allButtonChoice(boolean buttons){
        allButtons = buttons;

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
