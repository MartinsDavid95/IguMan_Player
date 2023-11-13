package com.samuelvialle.musicplayer;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ContentView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class AdapterSong extends RecyclerView.Adapter<AdapterSong.MyViewHolder> {

    private Context context;
    private ArrayList<ModelSong> songArrayList;

    public AdapterSong(Context context, ArrayList<ModelSong> songArrayList) {
        this.context = context;
        this.songArrayList = songArrayList;
    }

    @NonNull
    @Override
    public AdapterSong.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.item_song, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterSong.MyViewHolder holder, int position) {
        holder.title.setText(songArrayList.get(position).getSongTitle());
        holder.artist.setText(songArrayList.get(position).getSongArtist().trim());

        String album = songArrayList.get(position).getSongAlbum();
        holder.album.setText(album);

        Uri imgUri = songArrayList.get(position).getSongCover();

        // Méthode ultra basique
//        Glide.with(context)
//                // On load l'image depuis le chemin vers le dossier de stockage des cover
//                .load(imgUri)
//                // Emplacement où afficher l'image
//                .into(holder.cover);
        ///////

        Context context = holder.cover.getContext();

        // Méthode normale
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .error(R.drawable.ic_note_24_w)
                .placeholder(R.drawable.ic_note_24_w);

        Glide.with(context)
                .load(imgUri) // On applique les options de chargement
                .apply(options) // Resize et alignement au centre
                .fitCenter()// Resize pour que les images soient toutes à la même taille
                .override(150, 150) // Gestion des images dans le cache pour améliorer l'affichage
                .diskCacheStrategy(DiskCacheStrategy.ALL)// Emplacement où afficher l'image
                .into(holder.cover);
    }

    @Override
    public int getItemCount() {
        return songArrayList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title, artist, album;
        ImageView cover;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_title);
            artist = itemView.findViewById(R.id.tv_artist);
            album = itemView.findViewById(R.id.tv_album);
            cover = itemView.findViewById(R.id.iv_cover);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myOnItemClickListener.onItemClick(getAdapterPosition(), v);
                }
            });
        }
    }

    public interface myOnItemClickListener {
        void onItemClick(int position, View view);
    }

    public myOnItemClickListener myOnItemClickListener;

    public void setMyOnItemClickListener(myOnItemClickListener myOnItemClickListener){
        this.myOnItemClickListener = myOnItemClickListener;
    }










}
