package com.example.willyousurvive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.Toast;

public class Question12 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question12);
        radioEnceinte = findViewById(R.id.radioEnceinte);
        radioBanal = findViewById(R.id.radioBanal);
        radioEnfant = findViewById(R.id.radioEnfant);
        radioChien = findViewById(R.id.radioChien);
        radioBebe = findViewById(R.id.radioBebe);

        Bundle bundle = getIntent().getExtras();
        scoreTot = bundle.getInt("scoreTotal");
    }

    private RadioButton radioEnceinte ;
    private RadioButton radioBanal ;
    private RadioButton radioEnfant ;
    private RadioButton radioChien ;
    private RadioButton radioBebe ;
    private int scoreTot ;

    public void retour(android.view.View v) {
        this.onBackPressed();
    }

    public void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void activityQuestion13(android.view.View v) {
        Intent intent = new Intent(this, Question13.class);
        int scoreRep = -1 ;
        if (radioEnceinte.isChecked()) {
            scoreRep = 6 ;
        }
        else if (radioBanal.isChecked()) {
            scoreRep = 5 ;
        }
        else if (radioEnfant.isChecked()) {
            scoreRep = 4 ;
        }
        else if (radioChien.isChecked()) {
            scoreRep = 7 ;
        }
        else if (radioBebe.isChecked()) {
            scoreRep = 3 ;
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