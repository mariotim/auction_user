package de.dbauction.user;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveCrudRepository<AuctionUser, Long> {
    Mono<AuctionUser> findByUsername(String username);
}
