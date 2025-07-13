package com.example.song;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.song.SongService;
import com.example.song.Song;

@RestController
public class SongController {
    SongService service = new SongService();

    @GetMapping("/songs")
    public ArrayList<Song> getSongs() {
        return service.getSongPlaylist();
    }

    @GetMapping("/songs/{songId}")
    public Song getSongById(@PathVariable("songId") int songId) {
        return service.getSongById(songId);
    }

    @PostMapping("/songs")
    public Song addSong(@RequestBody Song song) {
        return service.addSong(song);
    }

    @PutMapping("/songs/{songId}")
    public Song addSong(@PathVariable("songId") int songId, @RequestBody Song song) {
        return service.updateSongById(songId, song);
    }

    @DeleteMapping("/songs/{songId}")
    public void deleteSong(@PathVariable("songId") int songId) {
        service.deleteSong(songId);
    }

}