package com.samuelvialle.musicplayer;

import android.net.Uri;

public class ModelSong {

    private String songTitle;
    private String songAlbum;
    private String songDuration;
    private String songArtist;
    private Uri songCover;
    private Uri songUri;

    public ModelSong() {
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public String getSongAlbum() {
        return songAlbum;
    }

    public void setSongAlbum(String songAlbum) {
        this.songAlbum = songAlbum;
    }

    public String getSongDuration() {
        return songDuration;
    }

    public void setSongDuration(String songDuration) {
        this.songDuration = songDuration;
    }

    public String getSongArtist() {
        return songArtist;
    }

    public void setSongArtist(String songArtist) {
        this.songArtist = songArtist;
    }

    public Uri getSongCover() {
        return songCover;
    }

    public void setSongCover(Uri songCover) {
        this.songCover = songCover;
    }

    public Uri getSongUri() {
        return songUri;
    }

    public void setSongUri(Uri songUri) {
        this.songUri = songUri;
    }
}
