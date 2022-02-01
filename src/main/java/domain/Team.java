package domain;

import com.github.javafaker.Faker;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Team {
    private final String name;
    private final List<String> players;

    public Team() {
        Faker faker = new Faker();
        Random random = new Random();
        this.name = faker.team().name();
        this.players = IntStream.range(0, random.nextInt(4) + 1)
                .mapToObj(index -> faker.name().firstName())
                .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public List<String> getPlayers() {
        return players;
    }
}
