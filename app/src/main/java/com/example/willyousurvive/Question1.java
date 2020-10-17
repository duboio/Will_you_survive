package com.example.willyousurvive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.Toast;

public class Question1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);
        radioFemme = findViewById(R.id.radioFemme);
        radioHomme = findViewById(R.id.radioHomme);
    }

    private RadioButton radioHomme ;
    private RadioButton radioFemme ;

    public void retour(android.view.View v) {
        this.onBackPressed();
    }

    public void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void activityQuestion2(android.view.View v) {
        Intent intent = new Intent(this, Question2.class);
        int scoreTot = 0 ;
        int scoreRep = -1 ;
        if (radioFemme.isChecked()) {
            scoreRep = 5 ;
        }
        else if (radioHomme.isChecked()) {
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