package com.example.willyousurvive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.Toast;

public class Question13 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question13);
        radioRelax = findViewById(R.id.radioRelax);
        radioDesarmer = findViewById(R.id.radioDesarmer);
        radioNegocier = findViewById(R.id.radioNegocier);

        Bundle bundle = getIntent().getExtras();
        scoreTot = bundle.getInt("scoreTotal");
    }

    private RadioButton radioRelax ;
    private RadioButton radioDesarmer ;
    private RadioButton radioNegocier ;

    private int scoreTot ;

    public void retour(android.view.View v) {
        this.onBackPressed();
    }

    public void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void activityQuestion14(android.view.View v) {
        Intent intent = new Intent(this, Question14.class);
        int scoreRep = -1 ;
        if (radioRelax.isChecked()) {
            scoreRep = 1 ;
        }
        else if (radioDesarmer.isChecked()) {
            scoreRep = 0 ;
        }
        else if (radioNegocier.isChecked()) {
            scoreRep = 2 ;
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