package com.example.apialiensapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class registrar extends AppCompatActivity {
    DatePickerDialog picker;
    EditText fechaNacimiento;
    Button btn_registrar;
    TextView txtIr;
    EditText edNombre, edApP, edApM, edCorreo, edCont1, edCont2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        txtIr = (TextView) findViewById(R.id.txt_irLogin);
        edNombre = (EditText) findViewById(R.id.in_nombre);
        edApP = (EditText) findViewById(R.id.in_apellidoP);
        edApM = (EditText) findViewById(R.id.in_apellidoM);
        edCorreo = (EditText) findViewById(R.id.in_correo);
        edCont1 = (EditText) findViewById(R.id.in_contrasenia1);
        edCont2 = (EditText) findViewById(R.id.in_contrasenia2);
        fechaNacimiento = (EditText) findViewById(R.id.in_fechaNacimieto);
        btn_registrar = (Button) findViewById(R.id.btn_Registrar);
        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registroApi rg = new registroApi();
                try {
                    if (!edNombre.getText().toString().equals("")
                            && !edApP.getText().toString().equals("")
                            && !edApM.getText().toString().equals("")
                            && !edCorreo.getText().toString().equals("")
                            && !edCont1.getText().toString().equals("")
                            && !edCont2.getText().toString().equals("")
                            && !fechaNacimiento.getText().toString().equals("")) {
                        if (edCont1.getText().toString().equals(edCont2.getText().toString())) {
                            String fecha = fechaNacimiento.getText().toString();
                            rg.registrar(edNombre.getText().toString(), edNombre.getText().toString(), edApP.getText().toString(), edApM.getText().toString(), edCorreo.getText().toString(), edCont1.getText().toString(), edCont2.getText().toString(), "20010813");
                            muestraToast(view, fecha);
                            Intent intent = new Intent(registrar.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            muestraToast(view, "Contraseñas incorrectas");
                        }
                    } else {
                        muestraToast(view, "llena correctamente todos los campos");
                    }

                } catch (Exception ex) {
                    muestraToast(view, "Error" + ex);
                }
            }
        });
        txtIr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(registrar.this, MainActivity.class);
                startActivity(intent);
            }
        });
        fechaNacimiento.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {

                    showDatePicker();
                    muestraToast(view, fechaNacimiento.getText().toString());
                }

            }
        });
    }

    public void muestraToast(View view, String mensaje) {
        Toast.makeText(this, "" + mensaje, Toast.LENGTH_SHORT).show();
    }

    public void showDatePicker() {
        final Calendar cldr = Calendar.getInstance();
        int day = cldr.get(Calendar.DAY_OF_MONTH);
        int month = cldr.get(Calendar.MONTH);
        int year = cldr.get(Calendar.YEAR);
        picker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                if (monthOfYear < 9) {
                    if (dayOfMonth < 9) {
                        fechaNacimiento.setText(year + "-0" + (monthOfYear + 1) + "-0" + dayOfMonth);
                    } else {
                        fechaNacimiento.setText(year + "-0" + (monthOfYear + 1) + "-" + dayOfMonth);
                    }
                } else {
                    if (dayOfMonth < 9) {
                        fechaNacimiento.setText(year + "-" + (monthOfYear + 1) + "-0" + dayOfMonth);
                    } else {
                        fechaNacimiento.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                    }

                }

            }
        }, year, month, day);
        picker.show();
    }
}