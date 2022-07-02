package com.example.apialiensapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.example.apialiensapp.interfaces.*;
import com.example.apialiensapp.model.*;

public class MainActivity extends AppCompatActivity {
    public static Retrofit varRetro;
    public String status;
    public Button  btn_login;
    public TextInputEditText txtCorreo;
    public TextInputEditText txtContrasenia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_login = (Button) findViewById(R.id.btn_Registrar);
        txtCorreo = (TextInputEditText) findViewById(R.id.in_correo);
        txtContrasenia = (TextInputEditText) findViewById(R.id.in_contrasenia1);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtCorreo.getText().toString().equals(null) && txtContrasenia.toString().equals(null)){
                    Toast.makeText(getApplicationContext(), "Llena los campos", Toast.LENGTH_LONG).show();
                }else{
                    varRetro = new Retrofit.Builder()
                            .baseUrl("https://api-alien.herokuapp.com/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                    peticiones peticion = varRetro.create(peticiones.class);
                    Usuario user = new Usuario();
                    user.setAlien_correo(txtCorreo.getText().toString());
                    user.setAlien_contrasenia(txtContrasenia.getText().toString());
                    Call<Usuario> login = peticion.login(user);
                    login.enqueue(new Callback<Usuario>() {
                        @Override
                        public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                            if (!response.isSuccessful()){
                                Toast.makeText(getApplicationContext(), "Error intentalo de nuevo", Toast.LENGTH_LONG).show();
                            }else{
                                Usuario usuario = response.body();
                                if  (usuario.getMensaje().equals(null) || usuario.getMensaje().equals("")){
                                     Toast.makeText(getApplicationContext(), "Bienvenido " , Toast.LENGTH_LONG).show();
                                }else{
                                    Toast.makeText(getApplicationContext(), usuario.getMensaje(), Toast.LENGTH_LONG).show();
                                }
                            }

                        }

                        @Override
                        public void onFailure(Call<Usuario> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Error algo salio mal", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });
    }
}