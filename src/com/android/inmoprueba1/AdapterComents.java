package com.android.inmoprueba1;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AdapterComents extends BaseAdapter {// seleccionar comentario

	protected Activity activity;
	protected ArrayList<ListarComents> items;

	public AdapterComents(Activity activity, ArrayList<ListarComents> items) {
		this.activity = activity;
		this.items = items;
	}

	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public Object getItem(int arg0) {
		return items.get(arg0);
	}

	@Override
	public long getItemId(int position) {
		return items.get(position).getid();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		// Generamos una convertView por motivos de eficiencia
		View v = convertView;

		// Asociamos el layout de la lista que hemos creado
		if (convertView == null) {
			LayoutInflater inf = (LayoutInflater) activity
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			v = inf.inflate(R.layout.listcoments, null);

		}

		// Creamos un objeto directivo
		ListarComents com = items.get(position);

		// Rellenamos el comentario
		TextView comentario = (TextView) v.findViewById(R.id.rescoments);
		TextView fecha = (TextView) v.findViewById(R.id.resfecha);
		fecha.setText(com.getFecha());
		comentario.setText(com.getComentario());

		// Retornamos la vista
		return v;
	}

}// end class
