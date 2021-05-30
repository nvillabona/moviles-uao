package com.example.screenlogin;


import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;


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
        txtNombres.setText(profesor.getNombres() + " " + profesor.getApellidos());
        txtHorario.setText(profesor.getHorarios());
        txtCorreo.setText(profesor.getCorreo());
        txtTelefono.setText(profesor.getTelefono());

        //Toast.makeText(CourseTeachers.this, profesor.getNombres(), Toast.LENGTH_LONG).show();

        // Importación del video
        VideoView videoView = findViewById(R.id.vv1);// Layout VideoView
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.videouao; // ruta del video
        Uri uri = Uri.parse(videoPath); //uri
        videoView.setVideoURI(uri); // seteamos uri al componente videoView
        MediaController mediaController = new MediaController(this); // Controladores del video
        videoView.setMediaController(mediaController); //
        mediaController.setAnchorView(videoView);

    }


}