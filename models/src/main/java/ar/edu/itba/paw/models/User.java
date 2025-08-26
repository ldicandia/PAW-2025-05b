package ar.edu.itba.paw.models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {
    private final long id;
    private final String username;

    public User(final long id, final String username) {
        this.id = id;
        this.username = username;
    }
}
