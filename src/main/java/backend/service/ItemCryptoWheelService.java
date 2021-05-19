package backend.service;

import backend.domain.response.ItemCryptoWheelListResponse;
import backend.domain.response.ItemCryptoWheelResponse;
import backend.model.ItemCryptoWheelInfo;
import backend.repository.ItemCryptoWheelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ItemCryptoWheelService {

    @Autowired
    ItemCryptoWheelRepository itemCryptoWheelRepository;

    public ItemCryptoWheelListResponse getAllItemCryptoWheel() {
        ItemCryptoWheelListResponse itemCryptoWheelListResponse = new ItemCryptoWheelListResponse();
        List<ItemCryptoWheelInfo> itemCryptoWheelInfoList = itemCryptoWheelRepository.findAll();
        if (itemCryptoWheelInfoList != null) {
            itemCryptoWheelListResponse.setCode("000");
            itemCryptoWheelListResponse.setMessage("success");
            itemCryptoWheelListResponse.setItemCryptoWheelInfoList(itemCryptoWheelInfoList);
        } else {
            itemCryptoWheelListResponse.setCode("201");
            itemCryptoWheelListResponse.setMessage("List null !");
        }
        return itemCryptoWheelListResponse;
    }

    public ItemCryptoWheelResponse spin() {
        ItemCryptoWheelResponse itemCryptoWheelResponse = new ItemCryptoWheelResponse();
        Random generator = new Random();
        ItemCryptoWheelInfo item = new ItemCryptoWheelInfo();
        do {
            int idItem = generator.nextInt(itemCryptoWheelRepository.findAll().size()) + 1;
            item = itemCryptoWheelRepository.findByIdItem(idItem);
        } while (item.getNumberRemainingItem()<=0);
        item.setNumberRemainingItem(item.getNumberRemainingItem()-1);
        itemCryptoWheelRepository.save(item);
        itemCryptoWheelResponse.setCode("000");
        itemCryptoWheelResponse.setMessage("success");
        itemCryptoWheelResponse.setItemCryptoWheelInfo(item);

        return itemCryptoWheelResponse;
    }
}
