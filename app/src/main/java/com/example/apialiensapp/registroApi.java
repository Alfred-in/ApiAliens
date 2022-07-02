package com.example.apialiensapp;

import com.example.apialiensapp.interfaces.peticiones;
import com.example.apialiensapp.model.Usuario;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class registroApi {
    public String error;
    public static String URL = "https://api-alien.herokuapp.com/";
    public static Retrofit varRetro;

    public void registrar(String usuario,String Nombre, String ApellidoPaterno, String ApellidoMaterno, String Correo, String Contrasenia, String Contrasenia2, String FechaNacimiento) {
        varRetro = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
        peticiones consApi = varRetro.create(peticiones.class);
        Usuario usu=new Usuario(usuario, Nombre, ApellidoPaterno, ApellidoMaterno, Correo, Contrasenia, FechaNacimiento);
        Call<Usuario> call = consApi.registrar(usu);
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                try {
                    if (response.isSuccessful()) {
                        Usuario m = response.body();
                        System.out.println(call);

                    }
                } catch (Exception ex) {
                    System.out.println("UWUn't " + ex);
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                error="¡Falló!";
            }
        });

    }
}