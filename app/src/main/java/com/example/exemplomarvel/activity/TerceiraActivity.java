package com.example.exemplomarvel.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.exemplomarvel.R;
import com.example.exemplomarvel.models.Comic;

public class TerceiraActivity extends AppCompatActivity {

    private Button finalizarCompra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terceira);

        Comic comic = (Comic) getIntent().getParcelableExtra("comicComprar");

        TextView textValorTotal = findViewById(R.id.text_valor_pago_comic);
        textValorTotal.setText("Preço Total: U$ "+ String.valueOf(String.format("%.2f", comic.getPrices().get(0).getPrice())));

        EditText textCupom = findViewById(R.id.text_cupom);

        finalizarCompra = findViewById(R.id.buttonFinalizarCompra);
        finalizarCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cupom = textCupom.getText().toString();
                float valorComicComum = (float) (comic.getPrices().get(0).getPrice() * 0.90);
                float valorComicRaro = (float) (comic.getPrices().get(0).getPrice() * 0.75);
                if(!cupom.isEmpty() && cupom.contains("Cupom10") && comic.isRaro() == false){
                    textValorTotal.setText("Preço: U$ " + String.valueOf(String.format("%.2f", comic.getPrices().get(0).setPrice(valorComicComum))));
                    Intent intent = new Intent(TerceiraActivity.this, MainActivity.class);
                    Toast.makeText(TerceiraActivity.this, "Compra feita com sucesso! Voltando a tela inicial...", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                } else if(!cupom.isEmpty() && cupom.contains("Cupom25") && comic.isRaro() == true){
                    textValorTotal.setText("Preço: U$ " + String.valueOf(String.format("%.2f", comic.getPrices().get(0).setPrice(valorComicRaro))));
                    Intent intent = new Intent(TerceiraActivity.this, MainActivity.class);
                    Toast.makeText(TerceiraActivity.this, "Compra feita com sucesso! Voltando a tela inicial...", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                } else if(cupom.isEmpty()) {
                    Intent intent = new Intent(TerceiraActivity.this, MainActivity.class);
                    Toast.makeText(TerceiraActivity.this, "Compra feita com sucesso! Voltando a tela inicial...", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                } else {
                    Toast.makeText(TerceiraActivity.this, "Cupom inválido, tente novamente", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

}