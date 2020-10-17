package com.example.willyousurvive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.Toast;

public class Question14 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question14);
        radioMoto = findViewById(R.id.radioMoto);
        radioAuto = findViewById(R.id.radioAuto);
        radioPied = findViewById(R.id.radioPied);
        radioTrottinette = findViewById(R.id.radioTrottinette);
        radioCheval = findViewById(R.id.radioCheval);

        Bundle bundle = getIntent().getExtras();
        scoreTot = bundle.getInt("scoreTotal");
    }

    private RadioButton radioMoto ;
    private RadioButton radioAuto ;
    private RadioButton radioPied ;
    private RadioButton radioTrottinette ;
    private RadioButton radioCheval ;
    private int scoreTot ;

    public void retour(android.view.View v) {
        this.onBackPressed();
    }

    public void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void activityQuestion15(android.view.View v) {
        Intent intent = new Intent(this, Question15.class);
        int scoreRep = -1 ;
        if (radioMoto.isChecked()) {
            scoreRep = 5 ;
        }
        else if (radioAuto.isChecked()) {
            scoreRep = 7 ;
        }
        else if (radioPied.isChecked()) {
            scoreRep = 1 ;
        }
        else if (radioTrottinette.isChecked()) {
            scoreRep = 4 ;
        }
        else if (radioCheval.isChecked()) {
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