package com.example.diogenes.aula07_views2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AlertDialogExemplo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
    }

    public void exemploAlertOk(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.download);
        builder.setTitle("Atenção");
        builder.setMessage("Você vai conhecer sua realidade");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(), "Clicou em OK!", Toast.LENGTH_LONG).show();
                return;
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void exemploAlertYesNo(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.download);
        builder.setTitle("Atenção");
        builder.setMessage("Sua visão de mundo está correta com realidade");

        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(), "Então conhece o Olavo de Carvalho", Toast.LENGTH_LONG).show();
                return;
            }
        });

        builder.setNegativeButton("Não tenho certeza", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(),"Deveria conhecer o Olavo", Toast.LENGTH_LONG).show();
                return;
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void exemploAlertYesNoCancel(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.download);
        builder.setTitle("Atenção");
        builder.setMessage("Sua visão de mundo está correta com realidade");

        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(), "Já leu esse livro!", Toast.LENGTH_LONG).show();
                return;
            }
        });

        builder.setNegativeButton("Não tenho certeza", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(),"Leia esse livro meu filho", Toast.LENGTH_LONG).show();
                return;
            }
        });

        builder.setNeutralButton("Volte e permaneça na dúvida", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(),"Vai continuar no mundinho fantasioso", Toast.LENGTH_LONG).show();
                return;
            }
        });




        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
