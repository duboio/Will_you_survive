package com.example.willyousurvive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Question2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
        editAge = findViewById(R.id.editAge);

        Bundle bundle = getIntent().getExtras();
        scoreTot = bundle.getInt("scoreTotal");
    }

    private EditText editAge ;
    private int scoreTot ;

    public void retour(android.view.View v) {
        this.onBackPressed();
    }

    public void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void activityQuestion3(android.view.View v) {
        Intent intent = new Intent(this, Question3.class);
        int scoreRep = -1 ;

        if (editAge.getText().toString().isEmpty() == false) {
            if (Integer.parseInt(editAge.getText().toString()) > 0 & Integer.parseInt(editAge.getText().toString()) < 18) {
                scoreRep = 3 ;
            }
            else if (Integer.parseInt(editAge.getText().toString())<26) {
                scoreRep = 6 ;
            }
            else if (Integer.parseInt(editAge.getText().toString())<36) {
                scoreRep = 7 ;
            }
            else if (Integer.parseInt(editAge.getText().toString())<46) {
                scoreRep = 5 ;
            }
            else if (Integer.parseInt(editAge.getText().toString())<65) {
                scoreRep = 4 ;
            }
            else if (Integer.parseInt(editAge.getText().toString())<110) {
                scoreRep = 2 ;
            }
            else {
                scoreRep = -2;
            }

            if (scoreRep == -2) {
                toast("Euh... Houston on a un problème (attention à mettre un âge cohérent)");
            }
            else {
                scoreTot = scoreTot + scoreRep ;
                intent.putExtra("scoreTotal", scoreTot) ; // ajout du couple nom/valeur dans le dictionnaire
                startActivity(intent);
            }
        }

        else {
            toast("Veuillez sélectionner une réponse");
        }


    }
}