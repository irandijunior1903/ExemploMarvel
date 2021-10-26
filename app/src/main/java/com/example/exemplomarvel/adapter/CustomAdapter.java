package com.example.exemplomarvel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.exemplomarvel.R;
import com.example.exemplomarvel.models.Comic;
import com.example.exemplomarvel.models.ComicPrice;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<Comic> comics;

    public CustomAdapter(){
        comics = new ArrayList<>();
    }
    class CustomViewHolder extends RecyclerView.ViewHolder {
        private TextView textTitle;
        private TextView textDescription;
        private TextView textPrice;
        private ImageView image;

        public CustomViewHolder(View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
            textDescription = itemView.findViewById(R.id.textDescription);
            textPrice = itemView.findViewById(R.id.textPrice);
            image = itemView.findViewById(R.id.image);



        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_comics,
                parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.textTitle.setText(comics.get(position).getTitle());
        holder.textDescription.setText(comics.get(position).getDescription());
        holder.textPrice.setText("U$: " + String.valueOf(comics.get(position).getPrices().get(0).getPrice()));
        Picasso.get().load(comics.get(position).getThumbnail().getPath() + "." + comics.get(position).getThumbnail().getExtension())
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(holder.image);

    }

    @Override
    public int getItemCount() {
        return comics.size();

    }

    public void setComics(List<Comic> comics){
        this.comics = comics;
        notifyDataSetChanged();
    }



}