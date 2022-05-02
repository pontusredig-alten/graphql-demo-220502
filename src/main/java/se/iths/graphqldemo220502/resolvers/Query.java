package se.iths.graphqldemo220502.resolvers;

import graphql.kickstart.tools.GraphQLQueryResolver;
import se.iths.graphqldemo220502.entity.ItemEntity;
import se.iths.graphqldemo220502.entity.UserEntity;
import se.iths.graphqldemo220502.repository.ItemRepository;
import se.iths.graphqldemo220502.repository.UserRepository;

import javax.persistence.EntityNotFoundException;

public class Query implements GraphQLQueryResolver {

    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    public Query(ItemRepository itemRepository, UserRepository userRepository) {
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
    }

    public Iterable<ItemEntity> findAllItems() {
        return itemRepository.findAll();
    }

    public Iterable<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }

    public long countItems() {
        return itemRepository.count();
    }

    public long countUsers() {
        return userRepository.count();
    }

    public ItemEntity getItemById(Long id) {
        return itemRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

}
