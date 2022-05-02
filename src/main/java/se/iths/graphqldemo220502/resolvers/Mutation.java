package se.iths.graphqldemo220502.resolvers;

import graphql.kickstart.tools.GraphQLMutationResolver;
import se.iths.graphqldemo220502.entity.ItemEntity;
import se.iths.graphqldemo220502.entity.UserEntity;
import se.iths.graphqldemo220502.repository.ItemRepository;
import se.iths.graphqldemo220502.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

public class Mutation implements GraphQLMutationResolver {

    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    public Mutation(ItemRepository itemRepository, UserRepository userRepository) {
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
    }

    public UserEntity newUser(String firstName, String lastName, String email) {
        UserEntity user = new UserEntity(firstName, lastName, email);
        userRepository.save(user);
        return user;
    }

    public ItemEntity newItem(String name, String category, Integer quantity, Double price, Long userId) {

        ItemEntity item = new ItemEntity();
        Optional<UserEntity> foundUser = userRepository.findById(userId);

        foundUser.ifPresent(item::setUser);
        item.setName(name);
        item.setCategory(category);
        item.setQuantity(quantity);
        item.setPrice(price);

        itemRepository.save(item);
        return item;

    }

    public boolean deleteItem(Long id) {
        itemRepository.deleteById(id);
        return true;
    }

    public ItemEntity updateItemPrice(Double price, Long id) {
        ItemEntity item = itemRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        item.setPrice(price);
        itemRepository.save(item);
        return item;
    }

}
