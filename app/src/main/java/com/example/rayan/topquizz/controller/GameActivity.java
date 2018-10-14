package com.example.rayan.topquizz.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.rayan.topquizz.R;
import com.example.rayan.topquizz.model.Question;
import com.example.rayan.topquizz.model.QuestionBank;

import java.util.Arrays;

public class GameActivity extends AppCompatActivity {

   private TextView mQuestionText;
   private Button mAnswerBtn1;
   private Button mAnswerBtn2;
   private Button mAnswerBtn3;
   private Button mAnswerBtn4;

   private QuestionBank mQuestionBank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mQuestionBank= this.generateQuestions();


        mQuestionText = (TextView) findViewById(R.id.activity_game_question_text);
        mAnswerBtn1 = (Button) findViewById(R.id.activity_game_answer1_btn);
        mAnswerBtn2 = (Button) findViewById(R.id.activity_game_answer2_btn);
        mAnswerBtn3 = (Button) findViewById(R.id.activity_game_answer3_btn);
        mAnswerBtn4 = (Button) findViewById(R.id.activity_game_answer4_btn);
    }

    private QuestionBank generateQuestions(){
        Question question1 = new Question("What is the name of the current french president?",
                Arrays.asList("François Hollande", "Emmanuel Macron", "Jacques Chirac", "François Mitterand"),
                1);

        return new QuestionBank(Arrays.asList(question1));
    }

}
