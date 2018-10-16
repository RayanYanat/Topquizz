package com.example.rayan.topquizz.controller;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.rayan.topquizz.R;
import com.example.rayan.topquizz.model.User;

public class MainActivity extends AppCompatActivity {
    private TextView mGreetingText;
    private EditText mNameInput;
    private Button mPlayButton;
    private User mUser;
    public static final int GAME_ACTIVITY_REQUEST_CODE = 26;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (GAME_ACTIVITY_REQUEST_CODE == requestCode && RESULT_OK == resultCode) {
            // Fetch  the score from the Intent
            int score = data.getIntExtra(GameActivity.BUNDLE_EXTRA_SCORE, 0);
          }
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * referencement des éléments graphiques dans notre activité
         */
        mUser = new User();
        mGreetingText = (TextView) findViewById(R.id.activity_main_greeting_txt);
        mNameInput = (EditText) findViewById(R.id.activity_main_name_input);
        mPlayButton = (Button) findViewById(R.id.activity_main_play_btn);

        /**
         * desactive le bouton tant que l'utilisateur n'a pas saisi son prenom
         */
        mPlayButton.setEnabled(false);

        mNameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPlayButton.setEnabled(s.toString().length()!= 0);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        /**
         * permet d'etre notifié quand l'utilisateur appuie sur le bouton
         */
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * récupére et valorise le prénom de l'utilisateur
                 */
                String mFirstName = mNameInput.getText().toString();
                mUser.setFristName(mFirstName);
                //user clicked the button
                /**
                 * permet de lancer la seconde activité qd l'utilisateur click sur le bouton
                 */
                Intent gameActivityIntent = new Intent(MainActivity.this, GameActivity.class);
                startActivity(gameActivityIntent);
                /**
                 * demande a la classe GameActivity de renvoyer un resultat
                 */
                startActivityForResult(gameActivityIntent,GAME_ACTIVITY_REQUEST_CODE);

            }
        });


    }
}
