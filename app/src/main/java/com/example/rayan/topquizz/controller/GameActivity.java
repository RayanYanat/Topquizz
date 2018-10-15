package com.example.rayan.topquizz.controller;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rayan.topquizz.R;
import com.example.rayan.topquizz.model.Question;
import com.example.rayan.topquizz.model.QuestionBank;

import java.util.Arrays;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

   private TextView mQuestionText;
   private Button mAnswerBtn1;
   private Button mAnswerBtn2;
   private Button mAnswerBtn3;
   private Button mAnswerBtn4;

   private QuestionBank mQuestionBank;
   private Question mCurrentQuestion;

   private int mScore;
   private int mNumberOfQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mQuestionBank = this.generateQuestions();

        mScore = 0;
        mNumberOfQuestions = 4;


        mQuestionText = (TextView) findViewById(R.id.activity_game_question_text);
        mAnswerBtn1 = (Button) findViewById(R.id.activity_game_answer1_btn);
        mAnswerBtn2 = (Button) findViewById(R.id.activity_game_answer2_btn);
        mAnswerBtn3 = (Button) findViewById(R.id.activity_game_answer3_btn);
        mAnswerBtn4 = (Button) findViewById(R.id.activity_game_answer4_btn);

        // use the tag proprety to 'name' the button
        mAnswerBtn1.setTag(0);
        mAnswerBtn2.setTag(1);
        mAnswerBtn3.setTag(2);
        mAnswerBtn4.setTag(3);

        mAnswerBtn1.setOnClickListener(this);
        mAnswerBtn2.setOnClickListener(this);
        mAnswerBtn3.setOnClickListener(this);
        mAnswerBtn4.setOnClickListener(this);


        mCurrentQuestion = mQuestionBank.getQuestion();
        this.displayQuestion(mCurrentQuestion);
    }

    @Override
    public void onClick(View v) {
        int responseIndex = (int) v.getTag();

        if (responseIndex == mCurrentQuestion.getAnswerIndex()) {
            // Good answer
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
            mScore++;
        } else {
            // Wrong answer
            Toast.makeText(this, "Wrong answer!", Toast.LENGTH_SHORT).show();
        }

        if (--mNumberOfQuestions == 0) {
            // End the game
            endGame();
        } else {
            mCurrentQuestion = mQuestionBank.getQuestion();
            displayQuestion(mCurrentQuestion);
        }
    }

    private void endGame() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Well done!")
                .setMessage("Your score is " + mScore)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .create()
                .show();
    }


    /**
     * methode qui prend en paramétre une question et qui met à jour les différents champs d'interface graphique
     * @param question
     */
        private void displayQuestion(final Question question) {
            mQuestionText.setText(question.getQuestion());
            mAnswerBtn1.setText(question.getChoiceList().get(0));
            mAnswerBtn2.setText(question.getChoiceList().get(1));
            mAnswerBtn3.setText(question.getChoiceList().get(2));
            mAnswerBtn4.setText(question.getChoiceList().get(3));

    }

    private QuestionBank generateQuestions(){
        Question question1 = new Question("What is the name of the current french president?",
                Arrays.asList("François Hollande", "Emmanuel Macron", "Jacques Chirac", "François Mitterand"),
                1);

        Question question2 = new Question("How many countries are there in the European Union?",
                Arrays.asList("15", "24", "28", "32"),
                2);

        Question question3 = new Question("Who is the creator of the Android operating system?",
                Arrays.asList("Andy Rubin", "Steve Wozniak", "Jake Wharton", "Paul Smith"),
                0);

        Question question4 = new Question("When did the first man land on the moon?",
                Arrays.asList("1958", "1962", "1967", "1969"),
                3);

        Question question5 = new Question("What is the capital of Romania?",
                Arrays.asList("Bucarest", "Warsaw", "Budapest", "Berlin"),
                0);

        Question question6 = new Question("Who did the Mona Lisa paint?",
                Arrays.asList("Michelangelo", "Leonardo Da Vinci", "Raphael", "Carravagio"),
                1);



        return new QuestionBank(Arrays.asList(question1));
    }

}
