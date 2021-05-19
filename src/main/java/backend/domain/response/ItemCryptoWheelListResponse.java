package backend.domain.response;

import backend.model.ItemCryptoWheelInfo;

import java.util.List;

public class ItemCryptoWheelListResponse extends BaseResponse{
    private List<ItemCryptoWheelInfo> itemCryptoWheelInfoList;

    public List<ItemCryptoWheelInfo> getItemCryptoWheelInfoList() {
        return itemCryptoWheelInfoList;
    }

    public void setItemCryptoWheelInfoList(List<ItemCryptoWheelInfo> itemCryptoWheelInfoList) {
        this.itemCryptoWheelInfoList = itemCryptoWheelInfoList;
    }
}
