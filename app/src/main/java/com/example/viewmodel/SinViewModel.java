package com.example.viewmodel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SinViewModel extends AppCompatActivity
{
private EditText nombre, apellido, genero,edad;
private TextView resultado;
private Button calcular, atras;
private static final int a_actual = 2024;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sin_view_model);
       nombre = findViewById(R.id.nombre);
       apellido = findViewById(R.id.apellido);
       genero = findViewById(R.id.genero);
       edad = findViewById(R.id.edad);
       resultado = findViewById(R.id.resultado);
       calcular = findViewById(R.id.calcular);
       atras = findViewById(R.id.atras);

       atras.setOnClickListener(new View.OnClickListener()
       {
           @Override
           public void onClick(View v)
           {
               Intent intent = new Intent(SinViewModel.this, MainActivity.class);
               startActivity(intent);
           }
       });


       calcular.setOnClickListener(v -> {
           String nombreus = nombre.getText().toString().trim();
           String edadus = edad.getText().toString().trim();
           String apellidous = apellido.getText().toString().trim();
           String generous = genero.getText().toString().trim();
           int edad = Integer.parseInt(edadus);
           int ed = a_actual - edad;
           String result = nombreus + " " + apellidous + " usted tiene: " + ed + " años " + "\n" + " eres " + generous;
           resultado.setText(result);
       });
    }
}