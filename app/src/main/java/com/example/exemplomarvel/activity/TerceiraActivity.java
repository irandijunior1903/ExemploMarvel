package com.example.exemplomarvel.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.exemplomarvel.R;

public class TerceiraActivity extends AppCompatActivity {

    private Button finalizarCompra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terceira);

        Bundle dadosCompra = getIntent().getExtras();

        TextView textQuantidade = findViewById(R.id.text_quantity_comic);
        int quantidade = dadosCompra.getInt("Quantity");
        textQuantidade.setText(String.valueOf("Quadrinhos selecionados: "+ quantidade));



        finalizarCompra = findViewById(R.id.buttonFinalizarCompra);
        finalizarCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TerceiraActivity.this, MainActivity.class);
                Toast.makeText(TerceiraActivity.this, "Compra feita com sucesso! Voltando a tela inicial...", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });




    }
}