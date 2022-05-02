package se.iths.graphqldemo220502.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.graphqldemo220502.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
