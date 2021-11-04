package com.example.exemplomarvel.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.example.exemplomarvel.R;
import com.example.exemplomarvel.models.Comic;
import com.squareup.picasso.Picasso;

import java.util.Arrays;

public class SegundaActivity extends AppCompatActivity{

    private NumberPicker numberPicker;
    private Button buttonComprar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        Comic comic = (Comic) getIntent().getParcelableExtra("Comic");

        ImageView imageView = findViewById(R.id.image_comic);
        Picasso.get().load(comic.getThumbnail().getPath() + "." + comic.getThumbnail().getExtension())
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(imageView);

        TextView textTitle = findViewById(R.id.text_title_comic);
        textTitle.setText(comic.getTitle());

        TextView textDescription = findViewById(R.id.text_description_comic);
        textDescription.setText(comic.getDescription());

        TextView textPrice = findViewById(R.id.text_price_comic);
        textPrice.setText("Preço: U$ "+ String.valueOf(comic.getPrices().get(0).getPrice()));

        TextView textDescriptionComprar = findViewById(R.id.text_comics_value);
        textDescriptionComprar.setText("Escolha a quantidade que deseja comprar do quadrinho: "+ comic.getTitle());

        numberPicker = findViewById(R.id.number_picker);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(10);

        buttonComprar = findViewById(R.id.buttonComprar);
        buttonComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SegundaActivity.this, TerceiraActivity.class);
                intent.putExtra("Quantity", numberPicker.getValue());
                startActivity(intent);
            }
        });

    }

}