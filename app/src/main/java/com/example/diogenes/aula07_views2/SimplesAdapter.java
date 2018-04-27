package com.example.diogenes.aula07_views2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class SimplesAdapter extends BaseAdapter {

    private String[] candidatos = new String[]{"Bolsonaro", "João", "Flávio", "Marina", "Ciro"};
    private Context context;

    public SimplesAdapter(Context context) {
        super();
        this.context = context;
    }

    @Override
    public int getCount() {
        return candidatos.length;
    }

    @Override
    public Object getItem(int position) {
        return candidatos[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String candidato = candidatos[position];

        View view = LayoutInflater.from(context).inflate(R.layout.adapter_simples
                , parent, false);

        TextView t = (TextView) view.findViewById(R.id.twAdapterSimples);
        t.setText(candidato);

        ImageView imageView = (ImageView) view.findViewById(R.id.ivAdapterSimples);
        if (position == 0){
            imageView.setImageResource(R.drawable.bolsonaro);
        }
        if (position == 3){
            imageView.setImageResource(R.drawable.marina);
        }







        return view;
    }

}
