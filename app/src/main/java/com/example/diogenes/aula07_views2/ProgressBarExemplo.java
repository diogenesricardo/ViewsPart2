package com.example.diogenes.aula07_views2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class ProgressBarExemplo extends AppCompatActivity {

    private static final String TAG = "livro";
    private ProgressBar mProgress;
    private boolean alive = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar_exemplo);
        // Barra de Progresso
        mProgress = (ProgressBar) findViewById(R.id.barraProgresso);
        Button b = (Button) findViewById(R.id.btOK);
        b.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                alive = true;
                new Thread(new Runnable() {
                    public void run() {
                        for (int i = 0; i <= 100; i++) {
                            if(!alive) {
                                Log.d(TAG, "Fim Progress");
                                break;
                            }
                            final int progress = i;
                            // Atualiza a barra de progresso
                            runOnUiThread(new Runnable() {
                                public void run() {
                                    Log.d(TAG, ">> Progress: " + progress);
                                    mProgress.setProgress(progress);
                                }
                            });
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        Log.i(TAG, "Fim.");
                    }
                }).start();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        alive = false;
    }

    public void exemploPararTarefa(View view) {
        alive =false;
    }
}
