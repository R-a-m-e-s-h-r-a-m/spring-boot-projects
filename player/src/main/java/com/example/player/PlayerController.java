package com.example.player;

import java.util.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlayerController {
    PlayerService service = new PlayerService();

    @GetMapping("/players")
    public ArrayList<Player> getPlayers() {
        return service.getPlayers();
    }

    @GetMapping("/players/{playerId}")
    public Player getPlayersById(@PathVariable("playerId") int playerId) {
        return service.getPlayerById(playerId);
    }

    @PostMapping("/players")
    public Player addPlayer(@RequestBody Player player) {
        return service.addPlayer(player);
    }

    @PutMapping("/players/{playerId}")
    public Player updatePlayer(@PathVariable int playerId, @RequestBody Player player) {
        return service.updatePlayer(playerId, player);
    }

    @DeleteMapping("players/{playerId}")
    public void deletePlayer(@PathVariable("playerId") int playerId) {
        service.deletePlayer(playerId);
    }
}
