package backend.repository;

import backend.model.ItemCryptoWheelInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemCryptoWheelRepository extends JpaRepository<ItemCryptoWheelInfo,Integer> {
    ItemCryptoWheelInfo findByIdItem(int idItem);
    List<ItemCryptoWheelInfo> findAll();

}