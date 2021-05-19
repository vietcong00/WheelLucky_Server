package backend.domain.response;

import backend.model.Player;

import java.util.List;

public class PlayerListResponse extends BaseResponse{
    private List<Player> playerList;

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }
}
