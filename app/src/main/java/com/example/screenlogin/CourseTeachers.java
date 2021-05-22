package com.example.screenlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class CourseTeachers extends AppCompatActivity {

    private TextView txtClase, txtNombres, txtHorario, txtCorreo, txtTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_teachers);

        txtClase = (TextView) findViewById(R.id.tvNombreClase);
        txtNombres = (TextView) findViewById(R.id.tvNombreProfesor);
        txtHorario = (TextView) findViewById(R.id.tvHorariosAs);
        txtCorreo = (TextView) findViewById(R.id.tvCorreo);
        txtTelefono = (TextView) findViewById(R.id.tvTeléfono);

        // Leo el profesor y la clase que me mandan desde StudentActivity
        Teacher profesor = (Teacher) getIntent().getSerializableExtra("teacherClass");
        String clase = getIntent().getStringExtra("clase");

        txtClase.setText(clase);
        txtNombres.setText("Profesor: "+ profesor.getNombres() + " " + profesor.getApellidos());
        txtHorario.setText("Horario de atención: " + profesor.getHorarios());
        txtCorreo.setText("Correo: " + profesor.getCorreo());
        txtTelefono.setText("Contacto: " + profesor.getTelefono());

        //Toast.makeText(CourseTeachers.this, profesor.getNombres(), Toast.LENGTH_LONG).show();
    }
}