package com.example.screenlogin;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class SClassList extends ArrayAdapter<Class>{

    private Activity context;
    //Lista de clases
    List<Class> Clases;

    // clase adpatadora para desplegar el listado de elementos almacenados en Firebase
    public SClassList(Activity context, List<Class> Clases) {
        super(context, R.layout.layout_class_list, Clases);
        this.context = context;
        this.Clases = Clases;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.layout_class_list, null, true);

        //Inicialización
        TextView tvNombreCurso = (TextView) listViewItem.findViewById(R.id.nombreCurso);
        TextView tvDescCurso = (TextView) listViewItem.findViewById(R.id.descripcionCurso);
        TextView tvFechasCurso = (TextView) listViewItem.findViewById(R.id.fechasCurso);
        TextView tvHorariosCurso = (TextView) listViewItem.findViewById(R.id.horariosCurso);

        //Obtener la posición del curso
        Class Class = Clases.get(position);

        //Asignar el nombre del curso
        tvNombreCurso.setText(Class.getNombre());

        //Asignar la descripción del curso
        tvDescCurso.setText(Class.getDescripcion());

        //Asignar la fecha del curso
        tvFechasCurso.setText(Class.getFechas());

        //Asignar el horario del curso
        tvHorariosCurso.setText(Class.getHorario());

        return listViewItem;
    }

}
