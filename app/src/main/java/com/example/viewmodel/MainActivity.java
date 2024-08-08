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
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

public class MainActivity extends AppCompatActivity
{

    private UserViewModel userViewModel;
    private EditText birthYearEditText, nameEditText;
    private TextView messageTextView, apellido, genero;
    private Button calculateButton, sinmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameEditText);
        apellido = findViewById(R.id.apellido);
        genero = findViewById(R.id.genero);
        birthYearEditText = findViewById(R.id.birthYearEditText);
        messageTextView = findViewById(R.id.messageTextView);
        calculateButton = findViewById(R.id.calculateButton);
        sinmodel = findViewById(R.id.sinmodel);

        sinmodel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, SinViewModel.class);
                startActivity(intent);
            }
        });

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userViewModel.getMessage().observe(this, messageTextView::setText);

        calculateButton.setOnClickListener(view ->
        {
            String name = nameEditText.getText().toString().trim();
            String birthYearText = birthYearEditText.getText().toString().trim();
            String apellidoUs = apellido.getText().toString().trim();
            String generoUs = genero.getText().toString().trim();

            if (name.isEmpty() || birthYearText.isEmpty())
            {
                messageTextView.setText("Error: El Nombre o el año de nacimiento estan vacios ");
                return;
            }
            try
            {
                int birtYear = Integer.parseInt(birthYearText);

                userViewModel.setName(name);
                userViewModel.setBirthYear(birtYear);
                userViewModel.setApellido(apellidoUs);
                userViewModel.setGenero(generoUs);

            } catch (NumberFormatException e)
            {
                messageTextView.setText("Error: formato no valido");

            }

        });
    }
}