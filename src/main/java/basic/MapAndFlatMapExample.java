package basic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import domain.Team;

public class MapAndFlatMapExample {
    public static void main(String[] args) {
        List<Team> teams = Arrays.asList(new Team(), new Team());
        iterarSobreEquipo(teams);
        iterarSobreListasJugadores(teams);
        iterarSobreJugadores(teams);
        iterarSobreMultiplesPropiedadesLista(teams);
    }

    /*
     * Con strem.map() podemos iterar sobre los equipos
     * */
    public static void iterarSobreEquipo(List<Team> teams) {
        System.out.println("----------------------- Iterar sobre equipos ------------------------------");
        teams.stream()
                .map(Team::getName)
                .forEach(System.out::println);
    }

    /*
     * Con map() podemos iterar sobre las listas de jugadores, mas no con un jugador
     * en particular. En esta caso se imprime cada lista y en un segundo stream se
     * imprime el tamano de cada lista (size)
     * */
    public static void iterarSobreListasJugadores(List<Team> teams) {
        System.out.println("--------- Iterar sobre las listas (objeto lista) de jugadores ------------");
        teams.stream()
                .map(Team::getPlayers)
                .forEach(System.out::println);

        teams.stream()
                .map(team -> team.getPlayers().size())
                .forEach(System.out::println);
    }

    /*
     * Con flatMap() podemos iterar sobre cada elemento de las listas de jugadores
     * */
    public static void iterarSobreJugadores(List<Team> teams) {
        System.out.println("------------------ Iterar sobre los jugadores como tal -------------------");
        teams.stream()
                .flatMap(team -> team.getPlayers().stream())
                .map(player -> "Hello " + player)
                .forEach(System.out::println);
    }

    /*
     * Con map() podemos iterar sobre las listas de jugadores, mas no con un jugador
     * en particular. En esta caso se obtiene el tamano de cada lista (size)
     * */
    public static void iterarSobreMultiplesPropiedadesLista(List<Team> teams) {
        System.out.println("------------- Iterar sobre multiples propiedades lista ------------------");
        teams.stream()
                .map(team -> Stream.of(team.getPlayers().size(),team.getPlayers()))
                .forEach(tupla -> tupla.forEach(System.out::println));
    }
}
