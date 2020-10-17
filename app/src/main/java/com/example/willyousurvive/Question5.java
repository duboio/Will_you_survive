package com.example.willyousurvive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.Toast;

public class Question5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);
        radioFuite = findViewById(R.id.radioFuite);
        radioCache = findViewById(R.id.radioCache);
        radioRencontre = findViewById(R.id.radioRencontre);
        radioHallucination = findViewById(R.id.radioHallucination);
        radioPiege = findViewById(R.id.radioPiege);

        Bundle bundle = getIntent().getExtras();
        scoreTot = bundle.getInt("scoreTotal");
    }

    private RadioButton radioFuite ;
    private RadioButton radioCache ;
    private RadioButton radioRencontre ;
    private RadioButton radioHallucination ;
    private RadioButton radioPiege ;
    private int scoreTot ;

    public void retour(android.view.View v) {
        this.onBackPressed();
    }

    public void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void activityQuestion6(android.view.View v) {
        Intent intent = new Intent(this, Question6.class);
        int scoreRep = -1 ;
        if (radioCache.isChecked()) {
            scoreRep = 5 ;
        }
        else if (radioFuite.isChecked()) {
            scoreRep = 3 ;
        }
        else if (radioRencontre.isChecked()) {
            scoreRep = 7 ;
        }
        else if (radioHallucination.isChecked()) {
            scoreRep = 3 ;
        }
        else if (radioPiege.isChecked()) {
            scoreRep = 5 ;
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