package cl.ucn.disc.pa.kanto;

import cl.ucn.disc.pa.kanto.pokedex.DefaultPokedex;
import cl.ucn.disc.pa.kanto.pokedex.Pokedex;
import cl.ucn.disc.pa.kanto.pokemon.Pokemon;
import ucn.StdIn;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        Pokedex pokedex = new DefaultPokedex();
        showMainMenu(pokedex);


    }

    /**
     * This function show the main menu
     * @param pokedex the system Pokedex
     */

    public static void showMainMenu(Pokedex pokedex) {


        while (true) {
            System.out.println("Opciones: ");
            System.out.println("a) Desplegar pokemones dado un rango de número creciente");
            System.out.println("b) Desplegar todos los pokemones almacenados alfabeticamente");
            System.out.println("c) Desplegar los pokemone sdado un tipo particular");
            System.out.println("d) Desplegar los pokemones de la primera evolución");
            System.out.println("e) Buscar por nombre");
            System.out.println("f) Buscar por id");
            System.out.println("g) Salir");
            String option = StdIn.readString();

            switch (option) {
                case "a":
                    showPokemonInRange(pokedex);
                    break;
                case "b":
                    showPokemonAlphabetical(pokedex);
                    break;
                case "c":
                    showPokemonByType(pokedex);
                    break;
                case "d":
                    showPokemonByFirstEvolution(pokedex);
                    break;
                case "e":
                    searchByName(pokedex);
                    break;
                case "f":
                    searchById(pokedex);
                default:
                    break;
            }

        }

    }

    /**
     * Show a collection pokemon in range
     * @param pokedex the system Pokedex
     */

    public static void showPokemonInRange(Pokedex pokedex) {

        System.out.println("Ingresa el primer limite");
        int firstLimit = StdIn.readInt();

        System.out.println("Ingresa el segundo limite");
        int secondLimit = StdIn.readInt();

        if (firstLimit <= 0 && secondLimit <= 0) {
            throw new IllegalArgumentException("Los limites deben ser positivos");
        }

        if (firstLimit > secondLimit) {
            throw new IllegalArgumentException("El segundo limite tiene que ser mayor que el primero");
        }

        pokedex.searchByRangeNumber(firstLimit, secondLimit)
                .forEach(Pokemon::show);

    }

    /**
     * Show the Pokemon in order Alphabetical
     * @param pokedex the Pokedex system
     */

    public static void showPokemonAlphabetical(Pokedex pokedex) {

        pokedex.searchAllPokemon().forEach(
                Pokemon::show
        );

    }

    /**
     * Show the Pokemon by type
     * @param pokedex the Pokedex system
     */

    public static void showPokemonByType(Pokedex pokedex) {

        System.out.println("Ingresa el tipo de pokemon que quieres elegir: ");
        String type = StdIn.readString();

        pokedex.searchPokemonByType(type).forEach(
                Pokemon::show
        );

    }

    /**
     * Show the Pokemon by the stage first evolution
     * @param pokedex the Pokedex system
     */

    public static void showPokemonByFirstEvolution(Pokedex pokedex) {

        pokedex.searchAllPokemonByFirstEvolution().forEach(
                Pokemon::show
        );

    }

    /**
     * Search and show the Pokemon by name
     * @param pokedex the Pokedex system
     */

    public static void searchByName(Pokedex pokedex) {

        System.out.println("Ingresa el nombre: ");
        String name = StdIn.readString();
        Pokemon pokemon =
                pokedex.searchByName(name);

        if (pokemon == null) {
            System.out.println("El pokemon no ha sido encontrado");
            return;
        }

        pokemon.show();

        if (pokemon.getNextEvolution().isEmpty()) {
            System.out.println("Este pokemon no tiene siguientes evoluciones.");
        } else {
            navigateNextEvolution(pokemon.getNextEvolution());
        }

        if (pokemon.getPreviousEvolution().isEmpty()) {
            System.out.println("Este pokemon no tiene evoluciones anteriores.");
        } else {
            navigatePreviousEvolution(pokemon.getPreviousEvolution());
        }

    }

    /**
     * Search and show a pokemon by id
     * @param pokedex the Pokedex system
     */

    public static void searchById(Pokedex pokedex) {

        System.out.println("Ingresa la id: ");
        String id = StdIn.readString();
        Pokemon pokemon =
                pokedex.searchByName(id);

        if (pokemon == null) {
            System.out.println("El pokemon no ha sido encontrado");
            return;
        }

        pokemon.show();

    }

    /**
     * Navigate between the next evolution of a Pokemon
     * @param nextEvolution the collection nextEvolution
     */

    private static void navigateNextEvolution(List<String> nextEvolution) {
        if (nextEvolution.size() == 1) {
            System.out.println("Hay solo una evolución siguiente y es: ");
            System.out.println(nextEvolution.get(0));
        } else {

            int index = 0;
            while (index != -1) {

                if (index > (nextEvolution.size() - 1)) {
                    System.out.println("Ya no hay mas que ver");
                    index = index - 1;
                    continue;
                }

                System.out.println("Estas viendo la evolucion: ");
                System.out.println(nextEvolution.get(index));

                System.out.println("Navegacion: ");
                System.out.println("a) Siguiente");
                System.out.println("b) Anterior ");
                System.out.println("c) Salir");

                String option = StdIn.readString();

                switch (option) {
                    case "a" -> index++;
                    case "b" -> index--;
                    default -> index = -1;
                }
            }

        }
    }

    /**
     * Navigate between the previous evolution of a Pokemon
     * @param previousEvolution the collection nextEvolution
     */

    private static void navigatePreviousEvolution(List<String> previousEvolution) {
        if (previousEvolution.size() == 1) {
            System.out.println("Hay solo una evolución anterior y es ");
            System.out.println(previousEvolution.get(0));
        } else {

            int index = 0;
            while (index != -1) {

                if (index > (previousEvolution.size() - 1)) {
                    System.out.println("Ya no hay mas que ver");
                    index = index - 1;
                    continue;
                }

                System.out.println("Estas viendo la evolucion: ");
                System.out.println(previousEvolution.get(index));

                System.out.println("Navegacion: ");
                System.out.println("a) Siguiente");
                System.out.println("b) Anterior ");
                System.out.println("c) Salir");

                String option = StdIn.readString();

                switch (option) {
                    case "a" -> index--;
                    case "b" -> index++;
                    default -> index = -1;
                }
            }

        }
    }

}
