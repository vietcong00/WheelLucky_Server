package project3.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project3.backend.domain.response.PlayerListResponse;
import project3.backend.domain.response.PlayerResponse;
import project3.backend.model.Player;
import project3.backend.service.PlayerService;


@RestController
@RequestMapping("/player")
public class RestPlayerController {

    @Autowired
    private PlayerService playerService;

    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    public ResponseEntity<PlayerResponse> login(@RequestBody Player player) {
        return ResponseEntity.ok(playerService.login(player));
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/register")
    public ResponseEntity<PlayerResponse> register(@RequestBody Player player) {
        return ResponseEntity.ok(playerService.register(player));
    }

    @CrossOrigin(origins = "*")
    @RequestMapping("/logout")
    public ResponseEntity<PlayerResponse> logOut(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(playerService.logOut(token));
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/findplayerinfo/{playerId}")
    public ResponseEntity<PlayerResponse> findPlayerInfo(@PathVariable int playerId) {
        System.out.println(playerId);
        return ResponseEntity.ok(playerService.findPlayerInfo(playerId));
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/getallplayer")
    public ResponseEntity<PlayerListResponse> getAllUser() {
        return ResponseEntity.ok(playerService.getAllPlayer());
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/saveplayer")
    public ResponseEntity<PlayerResponse> saveUser(@RequestBody Player player) {
        return ResponseEntity.ok(playerService.savePlayer(player));
    }
}
