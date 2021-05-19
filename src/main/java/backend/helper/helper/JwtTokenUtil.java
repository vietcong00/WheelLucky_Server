package backend.helper.helper;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.RandomStringUtils;
import backend.model.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JwtTokenUtil {

    private String secret = RandomStringUtils.randomAlphanumeric(10);

    //generate token for player
    public String generateToken(Player player) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, player.getUsernamePlayer());
    }

    private String doGenerateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    public String getToken(List<String> cookie) {
        String token = null;
        for (String s : cookie) {
            if (s.indexOf("token=") >= 0) {
                int start = s.indexOf("token=");
                if(s.indexOf(';',start)>0){
                    token = s.substring(start,start+(s.indexOf(';',start)));
                }else {
                    token = s.substring(start + 6);
                }
                break;
            }
        }
        return token;
    }

}
