package com.danielmankovsky;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    private Song findSong(String title){
        for (Song checkedSong : this.songs){
            if (checkedSong.getTitle().equals(title)) {
                return checkedSong;
            }
        }
        return null;
    }

    public boolean addSong (String title, double duration){
        if (findSong(title)==null){
            this.songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    public boolean addSongToPlayList (int trackNumber, List<Song> playlist){
        int index = trackNumber -1;
        if ((index>0)&&(index <= this.songs.size())){
            playlist.add(this.songs.get(trackNumber));
            return true;
        }
        return false;
    }

    public boolean addSongToPlayList (String title, List<Song> playlist){
        Song checkedSong = findSong(title);
        if (checkedSong != null){
            playlist.add(checkedSong);
            return true;
        }
        return false;
    }


}
