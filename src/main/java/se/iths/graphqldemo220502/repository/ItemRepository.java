package se.iths.graphqldemo220502.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.graphqldemo220502.entity.ItemEntity;

@Repository
public interface ItemRepository extends CrudRepository<ItemEntity, Long> {

}
