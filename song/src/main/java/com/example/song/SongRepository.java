// Write your code here

package com.example.song;

import java.util.*;

public interface SongRepository {
    ArrayList<Song> getSongPlaylist();

    Song getSongById(int songId);

    Song addSong(Song song);

    Song updateSongById(int songId, Song song);

    void deleteSong(int songId);
}