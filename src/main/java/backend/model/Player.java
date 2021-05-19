package backend.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPlayer;

    @Column(name = "name_Player")
    private String namePlayer;

    @Column(name = "username_Player")
    private String usernamePlayer;

    @Column(name = "password_Player")
    private String passwordPlayer;

    @Column(name = "deviceid_Player")
    private String deviceidPlayer;

    @Column(name = "coin")
    private int coinPlayer;

    @Column(name = "token")
    private String token;

    public Player() {
    }

    public int getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(int idPlayer) {
        this.idPlayer = idPlayer;
    }

    public String getUsernamePlayer() {
        return usernamePlayer;
    }

    public void setUsernamePlayer(String usernamePlayer) {
        this.usernamePlayer = usernamePlayer;
    }

    public String getNamePlayer() {
        return namePlayer;
    }

    public void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }

    public String getPasswordPlayer() {
        return passwordPlayer;
    }

    public void setPasswordPlayer(String passwordPlayer) {
        this.passwordPlayer = passwordPlayer;
    }

    public String getDeviceidPlayer() {
        return deviceidPlayer;
    }

    public void setDeviceidPlayer(String deviceidPlayer) {
        this.deviceidPlayer = deviceidPlayer;
    }

    public int getCoinPlayer() {
        return coinPlayer;
    }

    public void setCoinPlayer(int coinPlayer) {
        this.coinPlayer = coinPlayer;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Player(int idPlayer, String namePlayer, String usernamePlayer, String passwordPlayer, String deviceidPlayer, int coinPlayer) {
        this.idPlayer = idPlayer;
        this.namePlayer = namePlayer;
        this.usernamePlayer = usernamePlayer;
        this.passwordPlayer = passwordPlayer;
        this.deviceidPlayer = deviceidPlayer;
        this.coinPlayer = coinPlayer;
    }
}
