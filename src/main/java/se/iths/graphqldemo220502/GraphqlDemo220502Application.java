package se.iths.graphqldemo220502;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import se.iths.graphqldemo220502.entity.ItemEntity;
import se.iths.graphqldemo220502.entity.UserEntity;
import se.iths.graphqldemo220502.repository.ItemRepository;
import se.iths.graphqldemo220502.repository.UserRepository;
import se.iths.graphqldemo220502.resolvers.ItemResolver;
import se.iths.graphqldemo220502.resolvers.Mutation;
import se.iths.graphqldemo220502.resolvers.Query;

@SpringBootApplication
public class GraphqlDemo220502Application {

    public static void main(String[] args) {
        SpringApplication.run(GraphqlDemo220502Application.class, args);
    }

    @Bean
    public ItemResolver userResolver(UserRepository userRepository) {
        return new ItemResolver(userRepository);
    }

    @Bean
    public Query query(UserRepository userRepository, ItemRepository itemRepository) {
        return new Query(itemRepository, userRepository);
    }

    @Bean
    public Mutation mutation(UserRepository userRepository, ItemRepository itemRepository) {
        return new Mutation(itemRepository, userRepository);
    }

    @Bean
    public CommandLineRunner demo(UserRepository userRepository, ItemRepository itemRepository) {
        return (args) -> {

            UserEntity user1 = new UserEntity("kalle", "anka", "kalle@ankeborg.se");
            UserEntity user2 = new UserEntity("klarabella", "ko", "klarabella@ankeborg.se");
            UserEntity user3 = new UserEntity("alexander", "lukas", "alex@ankeborg.se");
            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);


            ItemEntity item1 = new ItemEntity("Soffa", "Möbler", 1, 500.00, user1);
            ItemEntity item2 = new ItemEntity("DVD-spelare", "Hemelektronik", 1, 50.00, user1);
            ItemEntity item3 = new ItemEntity("Processen", "Böcker", 1, 75.00, user2);
            ItemEntity item4 = new ItemEntity("Kattlåda", "Husdjur", 1, 20.00, user2);
            ItemEntity item5 = new ItemEntity("Samlarbilder", "Memorabilia", 100, 950.00, user3);
            ItemEntity item6 = new ItemEntity("Vinterjacka", "Kläder", 1, 1300.00, user3);
            ItemEntity item7 = new ItemEntity("Elgitarr", "Musikinstrument", 1, 3500.00, user3);

            itemRepository.save(item1);
            itemRepository.save(item2);
            itemRepository.save(item3);
            itemRepository.save(item4);
            itemRepository.save(item5);
            itemRepository.save(item6);
            itemRepository.save(item7);


        };
    }

}
