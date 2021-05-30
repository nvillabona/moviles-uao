package com.example.screenlogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class StudentActivity extends AppCompatActivity {

    ListView listViewClass;

    // Lista que almacena todas clases de la base de datos de Firebase
    List<Class> Clases;

    FirebaseFirestore databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        // Metodo que encuentra por id
        findViews();
        // Metodo que valida con clic los item de la lista para desplegar Modal
        initListner();
    }

    //  Metodo que encuentra por id
    private void findViews() {

        // Referenciamos datos de firebase
        databaseReference = FirebaseFirestore.getInstance();

        // Instancias de la clase
        listViewClass = (ListView) findViewById(R.id.listViewClass);

        // Listado de objetos almacenados (Clases creadas)
        Clases = new ArrayList<>();
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseReference.collection("cursos")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {

                            // Borramos la lista previa de usuarios
                            Clases.clear();

                            for (QueryDocumentSnapshot document : task.getResult()) {
                                System.out.println("¡ENTRÉ!");

                                // Obtenemos las clases de la consola de Firebase
                                Class Class = document.toObject(Class.class);

                                // Agregamos clases a la lista
                                Clases.add(Class);
                                System.out.println("TAMAÑO -->" + Clases.size());
                            }

                            // Creamos un adaptador para mostrar las clases de la lista
                            SClassList ClassAdapter = new SClassList(StudentActivity.this, Clases);

                            // Agregamos al adaptador el listado a desplegar
                            listViewClass.setAdapter(ClassAdapter);

                        } else {
                            System.out.println("¡ALGO SALIÓ MAL!");
                        }
                    }
                });
    }

    private void initListner() {  // Método que valida el evento click

        //  Al dar click a un item de la lista de cursos
        listViewClass.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Validamos por id el item de la lista de cursos
                Class Clase = Clases.get(i);

                // Create a reference to the cities collection
                CollectionReference Profesores = databaseReference.collection("profesor");

                // Create a query against the collection.
                Query query = Profesores.whereEqualTo("codigo", Clase.getCodigoProfesor());

                query.get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        Teacher profesor = document.toObject(Teacher.class);
                                       // Toast.makeText(StudentActivity.this, profesor.getNombres(), Toast.LENGTH_LONG).show();

                                        /* Redirección a página */
                                        //Intent intencion = new Intent(StudentActivity.this, VideoPlayer.class);
                                        //startActivity(intencion);

                                        /* Redirección a página */
                                        /*Intent intencion = new Intent(StudentActivity.this, MapsActivity.class);
                                        startActivity(intencion);*/

                                        /* Redirección a página */
                                        Intent intencion = new Intent(StudentActivity.this, CourseTeachers.class);
                                        intencion.putExtra("teacherClass", profesor);
                                        intencion.putExtra("clase", Clase.getNombre()+"");
                                        startActivity(intencion);
                                    }
                                } else {
                                    System.out.println("¡ALGO SALIÓ MAL!");
                                }
                            }
                        });
            }
        });
    }
}