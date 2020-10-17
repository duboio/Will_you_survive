package com.example.willyousurvive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.Toast;

public class Question6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question6);
        radioAbrege = findViewById(R.id.radioAbrege);
        radioDepouiller = findViewById(R.id.radioDepouiller);
        radioSoin = findViewById(R.id.radioSoin);
        radioIgnorer = findViewById(R.id.radioIgnorer);
        radioSang = findViewById(R.id.radioSang);

        Bundle bundle = getIntent().getExtras();
        scoreTot = bundle.getInt("scoreTotal");
    }

    private RadioButton radioAbrege ;
    private RadioButton radioDepouiller ;
    private RadioButton radioSoin ;
    private RadioButton radioIgnorer ;
    private RadioButton radioSang ;
    private int scoreTot ;

    public void retour(android.view.View v) {
        this.onBackPressed();
    }

    public void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void activityQuestion7(android.view.View v) {
        Intent intent = new Intent(this, Question7.class);
        int scoreRep = -1 ;
        if (radioAbrege.isChecked()) {
            scoreRep = 6 ;
        }
        else if (radioSoin.isChecked()) {
            scoreRep = 5 ;
        }
        else if (radioDepouiller.isChecked()) {
            scoreRep = 7 ;
        }
        else if (radioIgnorer.isChecked()) {
            scoreRep = 0 ;
        }
        else if (radioSang.isChecked()) {
            scoreRep = 4 ;
        }

        if (scoreRep == -1){
            toast("Veuillez sélectionner une réponse");
        }
        else {
            scoreTot = scoreTot + scoreRep ;
            intent.putExtra("scoreTotal", scoreTot) ; // ajout du couple nom/valeur dans le dictionnaire
            startActivity(intent);
        }

    }
}