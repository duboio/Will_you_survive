package com.example.willyousurvive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.Toast;

public class Question10 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question10);
        radioLibre = findViewById(R.id.radioLibre);
        radioPolygame = findViewById(R.id.radioPolygame);
        radioDictature = findViewById(R.id.radioDictature);
        radioPartage = findViewById(R.id.radioPartage);
        radioMadMax = findViewById(R.id.radioMadMax);

        Bundle bundle = getIntent().getExtras();
        scoreTot = bundle.getInt("scoreTotal");
    }

    private RadioButton radioLibre ;
    private RadioButton radioPolygame ;
    private RadioButton radioDictature ;
    private RadioButton radioPartage ;
    private RadioButton radioMadMax ;
    private int scoreTot ;

    public void retour(android.view.View v) {
        this.onBackPressed();
    }

    public void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void activityQuestion11(android.view.View v) {
        Intent intent = new Intent(this, Question11.class);
        int scoreRep = -1 ;
        if (radioLibre.isChecked()) {
            scoreRep = 3 ;
        }
        else if (radioPolygame.isChecked()) {
            scoreRep = 4 ;
        }
        else if (radioDictature.isChecked()) {
            scoreRep = 3 ;
        }
        else if (radioPartage.isChecked()) {
            scoreRep = 7 ;
        }
        else if (radioMadMax.isChecked()) {
            scoreRep = 5 ;
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