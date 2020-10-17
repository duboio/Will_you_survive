package com.example.willyousurvive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.Toast;

public class Question9 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question9);
        radioGarrot = findViewById(R.id.radioGarrot);
        radioSecher = findViewById(R.id.radioSecher);
        radioCouper = findViewById(R.id.radioCouper);
        radioDésinfecter = findViewById(R.id.radioDésinfecter);
        radioArgile = findViewById(R.id.radioArgile);

        Bundle bundle = getIntent().getExtras();
        scoreTot = bundle.getInt("scoreTotal");
    }

    private RadioButton radioGarrot ;
    private RadioButton radioSecher ;
    private RadioButton radioCouper ;
    private RadioButton radioDésinfecter ;
    private RadioButton radioArgile ;
    private int scoreTot ;

    public void retour(android.view.View v) {
        this.onBackPressed();
    }

    public void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void activityQuestion10(android.view.View v) {
        Intent intent = new Intent(this, Question10.class);
        int scoreRep = -1 ;
        if (radioGarrot.isChecked()) {
            scoreRep = 1 ;
        }
        else if (radioSecher.isChecked()) {
            scoreRep = 0 ;
        }
        else if (radioCouper.isChecked()) {
            scoreRep = 1 ;
        }
        else if (radioDésinfecter.isChecked()) {
            scoreRep = 5 ;
        }
        else if (radioArgile.isChecked()) {
            scoreRep = 7 ;
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