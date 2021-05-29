package com.example.screenlogin;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;


public class CourseTeachers extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private TextView txtClase, txtNombres, txtHorario, txtCorreo, txtTelefono;
    YouTubePlayer player;

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

        YouTubePlayerView playerView = (YouTubePlayerView)findViewById(R.id.youTubePlayerView);
        playerView.initialize(DeveloperKey.DEVELOPER_KEY,this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean b) {
        this.player = player;
        if(!b){
            player.setPlayerStyle(YouTubePlayer.PlayerStyle.MINIMAL);
            player.loadVideo("PXj5QghExJA");
        }
    }
    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }
}