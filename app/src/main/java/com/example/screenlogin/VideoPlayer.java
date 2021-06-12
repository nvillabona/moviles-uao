package com.example.screenlogin;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class VideoPlayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        VideoView videoView = findViewById(R.id.video_view);// Layout VideoView
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.intromono; // ruta del video
        Uri uri = Uri.parse(videoPath); //uri
        videoView.setVideoURI(uri); // seteamos uri al componente videoView
        MediaController mediaController = new MediaController(this); // Controladores del video
        videoView.setMediaController(mediaController); //
        mediaController.setAnchorView(videoView);
    }
}