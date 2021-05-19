package backend.domain.response;

import backend.model.ItemCryptoWheelInfo;

public class ItemCryptoWheelResponse extends BaseResponse {
    ItemCryptoWheelInfo itemCryptoWheelInfo;

    public ItemCryptoWheelInfo getItemCryptoWheelInfo() {
        return itemCryptoWheelInfo;
    }

    public void setItemCryptoWheelInfo(ItemCryptoWheelInfo itemCryptoWheelInfo) {
        this.itemCryptoWheelInfo = itemCryptoWheelInfo;
    }
}
