package backend.domain.response;

import backend.model.Player;

public class PlayerResponse extends BaseResponse {
    Player player;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

}
