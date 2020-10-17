package com.example.willyousurvive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.Toast;

public class Question8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question8);
        radioRepeupler = findViewById(R.id.radioRepeupler);
        radioCapote = findViewById(R.id.radioCapote);
        radioBlond = findViewById(R.id.radioBlond);
        radioSeparation = findViewById(R.id.radioSeparation);
        radioSacrifier = findViewById(R.id.radioSacrifier);

        Bundle bundle = getIntent().getExtras();
        scoreTot = bundle.getInt("scoreTotal");
    }

    private RadioButton radioRepeupler ;
    private RadioButton radioCapote ;
    private RadioButton radioBlond ;
    private RadioButton radioSeparation ;
    private RadioButton radioSacrifier ;
    private int scoreTot ;

    public void retour(android.view.View v) {
        this.onBackPressed();
    }

    public void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void activityQuestion9(android.view.View v) {
        Intent intent = new Intent(this, Question9.class);
        int scoreRep = -1 ;
        if (radioRepeupler.isChecked()) {
            scoreRep = 6 ;
        }
        else if (radioCapote.isChecked()) {
            scoreRep = 3 ;
        }
        else if (radioBlond.isChecked()) {
            scoreRep = 2 ;
        }
        else if (radioSeparation.isChecked()) {
            scoreRep = 5 ;
        }
        else if (radioSacrifier.isChecked()) {
            scoreRep = 7 ;
        }

        if (scoreRep == -1){
            toast("Veuillez sélectionner une réponse");
        }
        else {
            scoreTot = scoreTot + scoreRep ;
            //toast(Integer.toString(scoreTot));
            intent.putExtra("scoreTotal", scoreTot) ; // ajout du couple nom/valeur dans le dictionnaire
            startActivity(intent);
        }

    }
}