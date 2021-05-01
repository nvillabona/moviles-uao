package com.example.screenlogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Objetos de la vista
    private EditText TextEmail;
    private EditText TextPassword;
    private Button btnLogin;
    private ProgressDialog progressDialog;

    //Declaramos un objeto firebaseAuth
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Iniciamos el objeto firebaseAuth
        firebaseAuth = FirebaseAuth.getInstance();

        //Referenciamos los views
        TextEmail = (EditText) findViewById(R.id.TxtEmail);
        TextPassword = (EditText) findViewById(R.id.TxtPassword);
        btnLogin = (Button) findViewById(R.id.botonLogin);
        progressDialog = new ProgressDialog(this);

        //Asociamos un oyente al evento clic del botón
        btnLogin.setOnClickListener(this);
    }

    private void loguearUsuario(){

        //Obtenemos el email y la contraseña desde las cajas de texto
        final String email = TextEmail.getText().toString().trim();
        String password = TextPassword.getText().toString().trim();

        //Verificamos que las cajas de texto no esten vacías
        if (TextUtils.isEmpty(email)){
            Toast.makeText(this, "Se debe ingresar un email", Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "Se debe ingresar la contraseña", Toast.LENGTH_LONG).show();
            return;
        }

        progressDialog.setMessage("Realizando consulta en linea...");
        progressDialog.show();

        //Loguear usuario
        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>(){
                    public void onComplete(@NonNull Task<AuthResult> task){
                        //Chequeamos si sucedió
                        if(task.isSuccessful()){
                            int pos = email.indexOf("@");
                            String user = email.substring(0,pos);
                            Toast.makeText(MainActivity.this, "Bienvenido: " + user, Toast.LENGTH_LONG).show();

                            /* Redirección a página */
                            //Intent intencion = new Intent(getApplication(), WellcomeActivity.class);
                            //intencion.putExtra(WellcomeActivity.user, user);
                            //startActivity(intencion);
                        } else{
                            //Si se presenta una colisión..
                            if(task.getException() instanceof FirebaseAuthUserCollisionException){
                                Toast.makeText(MainActivity.this, "Este usuario ya existe", Toast.LENGTH_LONG).show();
                            } else{
                                Toast.makeText(MainActivity.this, "Usuario o contraseña incorrecta", Toast.LENGTH_LONG).show();
                            }
                        }
                        progressDialog.dismiss();
                    }
                });
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.botonLogin:
                //invocamos al método:
                loguearUsuario();
                break;
        }
    }
}