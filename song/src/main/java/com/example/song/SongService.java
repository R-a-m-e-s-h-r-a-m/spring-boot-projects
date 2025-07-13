
package com.example.song;

import java.util.*;

import com.example.song.Song;
import com.example.song.SongRepository;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

// Don't modify the below code

public class SongService implements SongRepository {

    private int uniqueId = 6;
    private static HashMap<Integer, Song> playlist = new HashMap<>();

    public SongService() {
        playlist.put(1, new Song(1, "Butta Bomma", "Ramajogayya Sastry", "Armaan Malik", "Thaman S"));
        playlist.put(2, new Song(2, "Kathari Poovazhagi", "Vijay", "Benny Dayal, Swetha Mohan", "A.R. Rahman"));
        playlist.put(3, new Song(3, "Tum Hi Ho", "Mithoon", "Arijit Singh", "Mithoon"));
        playlist.put(4, new Song(4, "Vizhiyil", "Vairamuthu", "Unni Menon", "A.R. Rahman"));
        playlist.put(5, new Song(5, "Nenjame", "Panchu Arunachalam", "S.P.Balasubrahmanyam", "Ilaiyaraaja"));
    }

    @Override
    public ArrayList<Song> getSongPlaylist() {
        ArrayList<Song> songList = new ArrayList<>(playlist.values());
        return songList;
    }

    @Override
    public Song getSongById(int songId) {
        Song song = playlist.get(songId);
        if (song == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return song;

    }

    @Override
    public Song addSong(Song song) {
        song.setSongId(uniqueId);
        playlist.put(uniqueId++, song);
        return song;

    }

    @Override
    public Song updateSongById(int songId, Song song) {
        Song existingSong = playlist.get(songId);
        if (existingSong == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        if (song.getSongName() != null)
            existingSong.setSongName(song.getSongName());
        if (song.getLyricist() != null)
            existingSong.setLyricist(song.getLyricist());
        if (song.getSinger() != null)
            existingSong.setSinger(song.getSinger());
        if (song.getMusicDirector() != null)
            existingSong.setMusicDirector(song.getMusicDirector());
        return existingSong;
    }

    @Override
    public void deleteSong(int songId) {
        Song song = playlist.get(songId);
        if (song == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        else {
            playlist.remove(songId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

    }

}