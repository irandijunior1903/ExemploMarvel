package com.example.exemplomarvel.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exemplomarvel.R;
import com.example.exemplomarvel.models.Comic;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private ItemComicClickListener itemComicClickListener;
    private List<Comic> comics;

    @Inject
    public CustomAdapter(ItemComicClickListener itemComicClickListener){
        this.itemComicClickListener = itemComicClickListener;
        comics = new ArrayList<>();

    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        private TextView textTitle;
        private TextView textDescription;
        private TextView textPrice;
        private TextView textRarity;
        private ImageView image;
        private Comic comic;

        public CustomViewHolder(View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
            textDescription = itemView.findViewById(R.id.textDescription);
            textPrice = itemView.findViewById(R.id.textPrice);
            textRarity = itemView.findViewById(R.id.textRarity);
            image = itemView.findViewById(R.id.image_comic);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Observable<Comic> observable = Observable.just(comic);
                    Observer<Comic> observer = new Observer<Comic>(){
                        @Override
                        public void onSubscribe(@NonNull Disposable d) {

                        }

                        @Override
                        public void onNext(@NonNull Comic comic) {
                            itemComicClickListener.onClickListener(comic);
                        }

                        @Override
                        public void onError(@NonNull Throwable e) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    };
                    observable.subscribe(observer);
                }
            });

        }

        public void bind(Comic comic){
            this.comic = comic;
            textTitle.setText(comic.getTitle());
            textDescription.setText(comic.getDescription());
            if(comic.isRaro()== true){
                textRarity.setText("Comic Raro");
            }
            textPrice.setText("Preço: U$ " + String.valueOf(String.format("%.2f", comic.getPrices().get(0).getPrice())));
            Picasso.get().load(comic.getThumbnail().getPath() + "." + comic.getThumbnail().getExtension())
                    .placeholder((R.drawable.ic_launcher_background))
                    .error(R.drawable.ic_launcher_background)
                    .into(image);
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
        holder.bind(comics.get(position));

    }

    @Override
    public int getItemCount() {
        return comics.size();

    }

    public void setComics(List<Comic> comics){
        this.comics = comics;
        notifyDataSetChanged();
    }

    public interface ItemComicClickListener{
        void onClickListener(Comic comic);
    }

}