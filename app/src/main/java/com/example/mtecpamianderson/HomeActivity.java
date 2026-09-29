package com.example.mtecpamianderson;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {
    private Button btnSair;
    private TextView welcomeUser, emailInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_home);

        initComponents();

        SharedPreferences preferences = getSharedPreferences("login", MODE_PRIVATE);

        String nomeSalvo = preferences.getString("NomeSalvo", "Usuario");
        String emailSalvo = preferences.getString("EmailSalvo", "Nao informado");

        welcomeUser.setText(String.format("Ola, %s!", nomeSalvo));
        emailInfo.setText(String.format("Email: %s", emailSalvo));

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("login", 0);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("ManterLogado", false); // Tira o status de logado
                editor.apply();

                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void initComponents() {
        btnSair = findViewById(R.id.btnSair);
        welcomeUser = findViewById(R.id.welcomeUser);
        emailInfo = findViewById(R.id.emailInfo);
    }
}