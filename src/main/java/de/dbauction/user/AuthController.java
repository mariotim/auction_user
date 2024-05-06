package de.dbauction.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationService authService;
    private final UserRepository userRepository;

    public AuthController(AuthenticationService authService, UserRepository userRepository) {
        this.authService = authService;
        this.userRepository = userRepository;
    }

    @PostMapping(value = "/register", consumes = "application/json", produces = "application/json")
    public Mono<String> register(@RequestBody AuctionUser user) {
        return userRepository.save(user).thenReturn("User registered");
    }

    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
    public Mono<String> login(@RequestBody AuctionUser user) {
        return userRepository.findByUsername(user.getUsername())
                .filter(found -> found.getPassword().equals(user.getPassword()))
                .flatMap(found -> authService.generateToken(found.getId()))
                .switchIfEmpty(Mono.just("Invalid username or password"));
    }
}

