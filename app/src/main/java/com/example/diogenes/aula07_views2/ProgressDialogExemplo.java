package com.example.diogenes.aula07_views2;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import static android.app.ProgressDialog.show;

public class ProgressDialogExemplo extends AppCompatActivity {

    private static final String URLLivro = "https://images.livrariasaraiva.com.br/imagemnet/imagem.aspx/?pro_id=5093597&qld=90&l=430&a=-1";
    private ProgressDialog dialog;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_progress_dialog);
        // Abre a janela com a barra de progresso
        /*dialog = new ProgressDialog(this);
        dialog.setTitle("Não seja um");
        dialog.setMessage("Buscando imagem, por aguarde...");
        dialog.setIndeterminate(false);
        dialog.setCancelable(true);
        dialog.show();*/

        dialog = ProgressDialog.show(this, "Não seja um", "Buscando imagem, por aguarde...", false, true);
        downloadImagem(URLLivro);
    }

    // Faz o download da imagem em uma nova Thread
    //Qualquer operação de IO deve iniciar uma Thread
    private void downloadImagem(final String urlImg) {
        new Thread() {
            @Override
            public void run() {
                try {
                    sleep(5000);
                    // Faz o download da imagem
                    URL url = new URL(urlImg);
                    InputStream in = url.openStream();
                    // Converte a InputStream do Java para Bitmap
                    final Bitmap imagem = BitmapFactory.decodeStream(in);
                    in.close();
                    // Atualiza a tela
                    atualizaImagem(imagem);
                } catch (IOException e) {
                    // Uma aplica��o real deveria tratar este erro
                    Log.e("Ebro", e.getMessage(), e);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private void atualizaImagem(final Bitmap imagem) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // Fecha a janela de progresso
                dialog.dismiss();
                ImageView imgView = (ImageView) findViewById(R.id.img);
                imgView.setImageBitmap(imagem);
            }
        });
    }
}
