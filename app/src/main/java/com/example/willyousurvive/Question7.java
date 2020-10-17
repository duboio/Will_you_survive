package com.example.willyousurvive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.Toast;

public class Question7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question7);
        radioLegende = findViewById(R.id.radioLegende);
        radio28Jours = findViewById(R.id.radio28Jours);
        radioSinges = findViewById(R.id.radioSinges);
        radioWallE = findViewById(R.id.radioWallE);
        radioRoute = findViewById(R.id.radioRoute);

        Bundle bundle = getIntent().getExtras();
        scoreTot = bundle.getInt("scoreTotal");
    }

    private RadioButton radioLegende ;
    private RadioButton radio28Jours ;
    private RadioButton radioSinges ;
    private RadioButton radioWallE ;
    private RadioButton radioRoute ;
    private int scoreTot ;

    public void retour(android.view.View v) {
        this.onBackPressed();
    }

    public void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void activityQuestion8(android.view.View v) {
        Intent intent = new Intent(this, Question8.class);
        int scoreRep = -1 ;
        if (radioLegende.isChecked()) {
            scoreRep = 6 ;
        }
        else if (radio28Jours.isChecked()) {
            scoreRep = 5 ;
        }
        else if (radioSinges.isChecked()) {
            scoreRep = 4 ;
        }
        else if (radioWallE.isChecked()) {
            scoreRep = 7 ;
        }
        else if (radioRoute.isChecked()) {
            scoreRep = 3 ;
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