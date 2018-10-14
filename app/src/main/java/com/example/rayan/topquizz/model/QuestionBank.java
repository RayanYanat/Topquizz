package com.example.rayan.topquizz.model;

import java.util.Collections;
import java.util.List;

public class QuestionBank {
    private List<Question> mQuestionList;
    private int mNextQuestionIndex;

    public QuestionBank (List<Question> questionList){
        mQuestionList = questionList;
        /**
         * mélange la liste de question
         */
        Collections.shuffle(mQuestionList);
        mNextQuestionIndex=0;

    }

    public Question getQuestion() {
        //les questions sont dans une boucles
        if (mNextQuestionIndex == mQuestionList.size()){
            mNextQuestionIndex = 0;
        }

        return mQuestionList.get(mNextQuestionIndex++);

    }

}
