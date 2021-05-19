package backend.model;

import javax.persistence.*;

@Entity
@Table(name = "item_crypto_wheel_info")
public class ItemCryptoWheelInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idItem;

    @Column(name = "name_item")
    private String nameItem;

    @Column(name = "rate_item")
    private float rateItem;

    @Column(name = "number_remaining_item")
    private int numberRemainingItem;

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public float getRateItem() {
        return rateItem;
    }

    public void setRateItem(float rateItem) {
        this.rateItem = rateItem;
    }

    public int getNumberRemainingItem() {
        return numberRemainingItem;
    }

    public void setNumberRemainingItem(int numberRemainingItem) {
        this.numberRemainingItem = numberRemainingItem;
    }

    public ItemCryptoWheelInfo() {
    }

    public ItemCryptoWheelInfo(int idItem, String nameItem, float rateItem, int numberRemainingItem) {
        this.idItem = idItem;
        this.nameItem = nameItem;
        this.rateItem = rateItem;
        this.numberRemainingItem = numberRemainingItem;
    }
}
