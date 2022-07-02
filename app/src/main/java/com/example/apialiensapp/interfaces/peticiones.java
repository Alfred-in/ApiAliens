package com.example.apialiensapp.interfaces;

import com.example.apialiensapp.model.Usuario;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface peticiones {
    @POST("aliens")
    Call<Usuario> registrar(@Body Usuario usuario);

    @POST("login")
    Call<Usuario> login(@Query("alien_correo") String correo,
                        @Query("alien_contrasenia") String contrasenia);


    /*@POST("verificarCredenciales")
    Call<Usuario> verificar(@Query("correo") String correo,
                            @Query("contrasenia") String contrasenia);

    @POST("recuperarContrasenia")
    Call<Usuario> recuperar(@Query("correo") String correo);

    @POST("codigo")
    Call<Usuario> codigo(@Query("codigo") String codigo);

    @POST("cambio/codigo")
    Call<Usuario> cambio(@Query("codigo") String codigo,
                         @Query("contrasenia") String contrasenia,
                         @Query("contrasenia2") String contrasenia2);*/
    /*"alien_usuario" : "rem",
"alien_nombre" : "Raul",
"alien_ap" : "Estrada",
"alien_am" : "Mejia",
"alien_correo" : "raul@upt.com",
"alien_contrasenia" : "123",
"alien_nac" : "20000814",
"alien_status" : "Activo"*/
}
