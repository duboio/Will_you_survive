package com.example.willyousurvive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.Toast;

public class Question11 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question11);
        radioMaison = findViewById(R.id.radioMaison);
        radioCamp = findViewById(R.id.radioCamp);
        radioBatiment = findViewById(R.id.radioBatiment);
        radioIle = findViewById(R.id.radioIle);
        radioVoiture = findViewById(R.id.radioVoiture);

        Bundle bundle = getIntent().getExtras();
        scoreTot = bundle.getInt("scoreTotal");
    }

    private RadioButton radioMaison ;
    private RadioButton radioCamp ;
    private RadioButton radioBatiment ;
    private RadioButton radioIle ;
    private RadioButton radioVoiture ;
    private int scoreTot ;

    public void retour(android.view.View v) {
        this.onBackPressed();
    }

    public void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void activityQuestion12(android.view.View v) {
        Intent intent = new Intent(this, Question12.class);
        int scoreRep = -1 ;
        if (radioMaison.isChecked()) {
            scoreRep = 7 ;
        }
        else if (radioCamp.isChecked()) {
            scoreRep = 6 ;
        }
        else if (radioBatiment.isChecked()) {
            scoreRep = 5 ;
        }
        else if (radioIle.isChecked()) {
            scoreRep = 2 ;
        }
        else if (radioVoiture.isChecked()) {
            scoreRep = 4 ;
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