package com.example.willyousurvive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;

public class Resultat extends AppCompatActivity {

    private static final String APP_TAG = "" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);
        resultatLabel = findViewById(R.id.resultatLabel);
        texteLabel = findViewById(R.id.texteLabel);

        Bundle bundle = getIntent().getExtras();
        scoreTot = bundle.getInt("scoreTotal");

        resultatLabel.setText(Integer.toString(scoreTot) + "/100");

        if (scoreTot<21) {
            texteLabel.setText("C'est étonnant que même sans apocalypse tu sois toujours en vie !");
        }
        else if (scoreTot<41) {
            texteLabel.setText("Profites ");
        }
        else if (scoreTot<61) {
            texteLabel.setText("Le score est entre 41 et 60");
        }
        else if (scoreTot<81) {
            texteLabel.setText("Le score est entre 61 et 80");
        }
        else {
            texteLabel.setText("Le score est supérieur à 80");
        }
        historic();
    }

    private TextView resultatLabel ;
    private TextView texteLabel;
    private int scoreTot ;

    public void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void mail(android.view.View v) {

        Log.i("Send email", "");
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setData(Uri.parse("mailto:"));
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT, "Résultats WYS");
        i.putExtra(Intent.EXTRA_TEXT   , "Voici les résultats de ton test Will You Survive : " + scoreTot + "/100.");
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
            Log.i("Finish sending email", "");
        } catch (android.content.ActivityNotFoundException ex) {
           toast("There are no email clients installed.");
        }

    }

    private void historic() {
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File fileout = new File(folder, "WYS_historic.txt");
        if (fileout.exists()) {
            try (FileOutputStream fos = new FileOutputStream(fileout, true)) {
                PrintStream ps = new PrintStream(fos);
                ps.println("Historique (" + (new Date()) + ") score = " + scoreTot);
                ps.close();
            } catch (FileNotFoundException e) {
                Log.e(APP_TAG, "File not found", e);
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
                Log.e(APP_TAG, "Error I/O", e);
            }
        }
        else {
            try (FileOutputStream fos = new FileOutputStream(fileout)) {
                PrintStream ps = new PrintStream(fos);
                ps.println("Start of my historic");
                ps.println("Historique (" + (new Date()) + ") score = " + scoreTot);
                ps.close();
            } catch (FileNotFoundException e) {
                Log.e(APP_TAG, "File not found", e);
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
                Log.e(APP_TAG, "Error I/O", e);
            }
        }
    }
    public void quit(android.view.View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //this will clear all the stack
        intent.putExtra("Exit", true);
        startActivity(intent);
        finish();

    }

}