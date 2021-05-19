package backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import backend.domain.response.PlayerListResponse;
import backend.domain.response.PlayerResponse;
import backend.helper.helper.JwtTokenUtil;
import backend.helper.helper.Regex;
import backend.model.Player;
import backend.repository.PlayerRepository;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public PlayerResponse login(Player player) {
        PlayerResponse playerResponse = new PlayerResponse();
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        String username = player.getUsernamePlayer();
        String password = player.getPasswordPlayer();

        if (playerRepository.findByUsernamePlayer(username) == null) {
            playerResponse.setCode("001");
            playerResponse.setMessage("Sai tài khoản !");
        } else if (!playerRepository.findByUsernamePlayer(username).getPasswordPlayer().equals(password)) {
            playerResponse.setCode("002");
            playerResponse.setMessage("Sai mật khẩu !");
        } else {
            Player infoPlayer = playerRepository.findByUsernamePlayer(username);
            String token = jwtTokenUtil.generateToken(infoPlayer);
            infoPlayer.setToken(token);
            playerRepository.save(infoPlayer);
            playerResponse.setCode("000");
            playerResponse.setMessage("Success !");
            playerResponse.setToken(token);
        }
        return playerResponse;
    }

    public PlayerResponse register(Player player) {
        PlayerResponse playerResponse = new PlayerResponse();
        String username = player.getUsernamePlayer();
        String password = player.getPasswordPlayer();

        if (playerRepository.findByUsernamePlayer(username) != null) {
            playerResponse.setCode("001");
            playerResponse.setMessage("Tài khoản đã tồn tại!");
        } else {
            playerRepository.save(player);
            playerResponse.setCode("000");
            playerResponse.setMessage("Success !");
        }
        return playerResponse;
    }

    public PlayerResponse logOut(String token) {
        PlayerResponse playerResponse = new PlayerResponse();
        token = token.replace("Bearer ", "");
        Player player = playerRepository.findByToken(token);
//        System.out.println(token);

        if (player == null) {
            playerResponse.setCode("004");
            playerResponse.setMessage("Your account was remove or not active !");
        } else {
            player.setToken("");
            playerRepository.save(player);
            playerResponse.setCode("000");
            playerResponse.setMessage("Success !");
        }
        return playerResponse;
    }

    public PlayerResponse findPlayerInfo(int playerId) {
        PlayerResponse playerResponse = new PlayerResponse();
        Player player = playerRepository.findByIdPlayer(playerId);
        if(player==null){
            playerResponse.setCode("201");
            playerResponse.setMessage("Không tìm thấy thông tin người chơi");
        }else {
            playerResponse.setCode("000");
            playerResponse.setMessage("success");
            playerResponse.setPlayer(player);
        }
        return playerResponse;
    }

    public PlayerListResponse getAllPlayer() {
        PlayerListResponse playerListResponse = new PlayerListResponse();
        List<Player> playerList = playerRepository.findAll();
        if (playerList != null) {
            playerListResponse.setCode("000");
            playerListResponse.setMessage("success");
            playerListResponse.setPlayerList(playerList);
        } else {
            playerListResponse.setCode("201");
            playerListResponse.setMessage("List null !");
        }
        return playerListResponse;
    }

    public PlayerResponse savePlayer(Player player) {
        PlayerResponse playerResponse = new PlayerResponse();
        Player oldPlayer = playerRepository.findByIdPlayer(player.getIdPlayer());
        if (player.getIdPlayer() == -1) {
            if (playerRepository.findByUsernamePlayer(player.getUsernamePlayer()) != null) {
                playerResponse.setCode("201");
                playerResponse.setMessage("Username already exists !");
            } else {
                playerRepository.save(player);
                Player newPlayer = playerRepository.findByUsernamePlayer(player.getUsernamePlayer());
                playerResponse.setCode("000");
                playerResponse.setMessage("Insert Player success");
                playerResponse.setPlayer(newPlayer);
            }

        } else {
            player.setPasswordPlayer(oldPlayer.getPasswordPlayer());
            player.setUsernamePlayer(oldPlayer.getUsernamePlayer());
            playerResponse.setCode("000");
            playerResponse.setMessage("Edit Player success");
            playerResponse.setPlayer(player);
            playerRepository.save(player);
        }
        return playerResponse;
    }

}
