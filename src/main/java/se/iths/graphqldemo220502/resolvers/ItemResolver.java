package se.iths.graphqldemo220502.resolvers;

import graphql.kickstart.tools.GraphQLResolver;
import se.iths.graphqldemo220502.entity.ItemEntity;
import se.iths.graphqldemo220502.entity.UserEntity;
import se.iths.graphqldemo220502.repository.UserRepository;

import java.util.Optional;

public class ItemResolver implements GraphQLResolver<ItemEntity> {

    private final UserRepository userRepository;

    public ItemResolver(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<UserEntity> getUser(ItemEntity item) {
        return userRepository.findById(item.getUser().getId());
    }

}
