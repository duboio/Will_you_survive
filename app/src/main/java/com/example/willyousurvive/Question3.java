package com.example.willyousurvive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.Toast;

public class Question3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);
        radioChampi = findViewById(R.id.radioChampi);
        radioConserve = findViewById(R.id.radioConserve);
        radioTrou = findViewById(R.id.radioTrou);
        radioPeche = findViewById(R.id.radioPeche);
        radioJeun = findViewById(R.id.radioJeun);

        Bundle bundle = getIntent().getExtras();
        scoreTot = bundle.getInt("scoreTotal");
    }

    private RadioButton radioChampi ;
    private RadioButton radioConserve ;
    private RadioButton radioTrou ;
    private RadioButton radioPeche ;
    private RadioButton radioJeun ;
    private int scoreTot ;

    public void retour(android.view.View v) {
        this.onBackPressed();
    }

    public void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void activityQuestion4(android.view.View v) {
        Intent intent = new Intent(this, Question4.class);
        int scoreRep = -1 ;
        if (radioChampi.isChecked()) {
            scoreRep = 5 ;
        }
        else if (radioConserve.isChecked()) {
            scoreRep = 4 ;
        }
        else if (radioPeche.isChecked()) {
            scoreRep = 7 ;
        }
        else if (radioTrou.isChecked()) {
            scoreRep = 6 ;
        }
        else if (radioJeun.isChecked()) {
            scoreRep = 0 ;
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