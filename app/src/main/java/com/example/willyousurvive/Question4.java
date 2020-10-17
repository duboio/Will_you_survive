package com.example.willyousurvive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.Toast;

public class Question4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);
        radioWhisky = findViewById(R.id.radioWhisky);
        radioBrico = findViewById(R.id.radioBrico);
        radioSA = findViewById(R.id.radioSA);
        radioPharma = findViewById(R.id.radioPharma);
        radioAlim = findViewById(R.id.radioAlim);

        Bundle bundle = getIntent().getExtras();
        scoreTot = bundle.getInt("scoreTotal");
    }

    private RadioButton radioWhisky ;
    private RadioButton radioBrico ;
    private RadioButton radioSA ;
    private RadioButton radioPharma ;
    private RadioButton radioAlim ;
    private int scoreTot ;

    public void retour(android.view.View v) {
        this.onBackPressed();
    }

    public void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void activityQuestion5(android.view.View v) {
        Intent intent = new Intent(this, Question5.class);
        int scoreRep = -1 ;
        if (radioWhisky.isChecked()) {
            scoreRep = 4 ;
        }
        else if (radioBrico.isChecked()) {
            scoreRep = 5 ;
        }
        else if (radioSA.isChecked()) {
            scoreRep = 0 ;
        }
        else if (radioPharma.isChecked()) {
            scoreRep = 6 ;
        }
        else if (radioAlim.isChecked()) {
            scoreRep = 7 ;
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