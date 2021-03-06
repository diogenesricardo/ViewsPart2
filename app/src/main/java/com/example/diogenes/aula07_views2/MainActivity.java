package com.example.diogenes.aula07_views2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void exemploProgressDialog(View view) {
        Intent i = new Intent(this, ProgressDialogExemplo.class);
        startActivity(i);
    }

    public void exemploProgressBar(View view) {
        Intent i = new Intent(this, ProgressBarExemplo.class);
        startActivity(i);
    }

    public void exemploAlertDialog(View view) {
        Intent i = new Intent(this, AlertDialogExemplo.class);
        startActivity(i);
    }

    public void exemploListView(View view) {
        Intent i = new Intent(this, ListViewExemplo.class);
        startActivity(i);
    }
}
