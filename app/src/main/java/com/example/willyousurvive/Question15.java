package com.example.willyousurvive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.Toast;

public class Question15 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question15);
        radioSolo = findViewById(R.id.radioSolo);
        radioTirer = findViewById(R.id.radioTirer);
        radioPlan = findViewById(R.id.radioPlan);
        radioGroupe = findViewById(R.id.radioGroupe);
        radioMort = findViewById(R.id.radioMort);

        Bundle bundle = getIntent().getExtras();
        scoreTot = bundle.getInt("scoreTotal");
    }

    private RadioButton radioSolo ;
    private RadioButton radioTirer ;
    private RadioButton radioPlan ;
    private RadioButton radioGroupe ;
    private RadioButton radioMort ;
    private int scoreTot ;

    public void retour(android.view.View v) {
        this.onBackPressed();
    }

    public void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void activityResultat(android.view.View v) {
        Intent intent = new Intent(this, Resultat.class);
        int scoreRep = -1 ;
        if (radioSolo.isChecked()) {
            scoreRep = 4 ;
        }
        else if (radioTirer.isChecked()) {
            scoreRep = 6 ;
        }
        else if (radioPlan.isChecked()) {
            scoreRep = 5 ;
        }
        else if (radioGroupe.isChecked()) {
            scoreRep = 7 ;
        }
        else if (radioMort.isChecked()) {
            scoreRep = 0 ;
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