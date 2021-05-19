package backend.controller;

import backend.domain.response.ItemCryptoWheelListResponse;
import backend.domain.response.ItemCryptoWheelResponse;
import backend.domain.response.PlayerResponse;
import backend.model.Player;
import backend.service.ItemCryptoWheelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/ItemCryptoWheel")
public class RestItemCryptoWheelController {

    @Autowired
    private ItemCryptoWheelService itemCryptoWheelService;

    @CrossOrigin(origins = "*")
    @GetMapping("/getallitemcryptowheel")
    public ResponseEntity<ItemCryptoWheelListResponse> getAllItemCryptoWheel() {
        return ResponseEntity.ok(itemCryptoWheelService.getAllItemCryptoWheel());
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/spin")
    public ResponseEntity<ItemCryptoWheelResponse> spin() {
        return ResponseEntity.ok(itemCryptoWheelService.spin());
    }
}
