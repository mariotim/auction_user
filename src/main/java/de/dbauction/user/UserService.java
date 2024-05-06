package de.dbauction.user;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Value("@Value(\"${jwt.secret}\")")
    private String secret;
}
