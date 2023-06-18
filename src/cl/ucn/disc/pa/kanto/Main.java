package cl.ucn.disc.pa.kanto;

import cl.ucn.disc.pa.kanto.pokedex.DefaultPokedex;
import cl.ucn.disc.pa.kanto.pokedex.Pokedex;
import cl.ucn.disc.pa.kanto.pokemon.Pokemon;
import ucn.StdIn;

import java.io.IOException;
import java.util.List;

/**
 * Benjamín Miranda O. 21544970K
 * Roberto Díaz A. 21288569K
 */

public class Main {

    private static boolean finish = false;

    public static void main(String[] args) throws IOException {

        //Create the pokedex class
        Pokedex pokedex = new DefaultPokedex();
        showMainMenu(pokedex);


    }

    /**
     * This function show the main menu
     *
     * @param pokedex the system Pokedex
     */

    public static void showMainMenu(Pokedex pokedex) {

        //This class show the options
        //Using a switch

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
                case "g":
                    finish = true;
                    break;
            }

            if (finish) {
                break;
            }
        }

    }

    /**
     * Show a collection pokemon in range
     *
     * @param pokedex the system Pokedex
     */

    public static void showPokemonInRange(Pokedex pokedex) {

        //For console is read int
        System.out.println("Ingresa el primer limite");
        int firstLimit = StdIn.readInt();

        //For console is read int
        System.out.println("Ingresa el segundo limite");
        int secondLimit = StdIn.readInt();

        //If the limit is negativo thow error
        if (firstLimit <= 0 && secondLimit <= 0) {
            throw new IllegalArgumentException("Los limites deben ser positivos");
        }

        //Check if the first limit is major that the second, in this case throw a error
        if (firstLimit > secondLimit) {
            throw new IllegalArgumentException("El segundo limite tiene que ser mayor que el primero");
        }

        //Search all pokemons in range y using programming functionaliterate about the pokemons
        pokedex.searchByRangeNumber(firstLimit, secondLimit)
                .forEach(Pokemon::show);

    }

    /**
     * Show the Pokemon in order Alphabetical
     *
     * @param pokedex the Pokedex system
     */

    public static void showPokemonAlphabetical(Pokedex pokedex) {

        //Search all pokemons y using programming functional iterate about the pokemons

        pokedex.searchAllPokemon().forEach(
                Pokemon::show
        );

    }

    /**
     * Show the Pokemon by type
     *
     * @param pokedex the Pokedex system
     */

    public static void showPokemonByType(Pokedex pokedex) {

        //Read the type for console
        System.out.println("Ingresa el tipo de pokemon que quieres elegir: ");
        String type = StdIn.readString();

        //Search all pokemons by type y using programming functional for iterate about the pokemons
        pokedex.searchPokemonByType(type).forEach(
                Pokemon::show
        );

    }

    /**
     * Show the Pokemon by the stage first evolution
     *
     * @param pokedex the Pokedex system
     */

    public static void showPokemonByFirstEvolution(Pokedex pokedex) {

        //Search all pokemons by type y using programming functional for iterate about the pokemons
        pokedex.searchAllPokemonByFirstEvolution().forEach(
                Pokemon::show
        );

    }

    /**
     * Search and show the Pokemon by name
     *
     * @param pokedex the Pokedex system
     */

    public static void searchByName(Pokedex pokedex) {

        //Read the name by console
        System.out.println("Ingresa el nombre: ");
        String name = StdIn.readString();

        //Get the pokemon
        Pokemon pokemon =
                pokedex.searchByName(name);

        //Check the pokemon is null
        if (pokemon == null) {
            //Show a message if the pokemon is null
            System.out.println("El pokemon no ha sido encontrado");
            return;
        }

        //Show the pokemon
        pokemon.show();
        showEvolutions(pokemon);

    }

    private static void showEvolutions(Pokemon pokemon) {
        //If the pokemon has next evolution
        if (pokemon.getNextEvolution().isEmpty()) {
            System.out.println("Este pokemon no tiene siguientes evoluciones.");
        } else {
            //Open the menu for navigate between evolutions
            navigateNextEvolution(pokemon.getNextEvolution());
        }

        if (pokemon.getPreviousEvolution().isEmpty()) {
            System.out.println("Este pokemon no tiene evoluciones anteriores.");
        } else {
            //Open the menu for navigate between evolutions
            navigatePreviousEvolution(pokemon.getPreviousEvolution());
        }

    }

    /**
     * Search and show a pokemon by id
     *
     * @param pokedex the Pokedex system
     */

    public static void searchById(Pokedex pokedex) {

        //Read a string by console
        System.out.println("Ingresa la id: ");
        int id = StdIn.readInt();
        Pokemon pokemon =
                pokedex.searchById(id);

        //Check the pokemon is null
        if (pokemon == null) {
            //If the pokemon is null warn it
            System.out.println("El pokemon no ha sido encontrado");
            return;
        }

        //Show the pokemon
        pokemon.show();
        showEvolutions(pokemon);

    }

    /**
     * Navigate between the next evolution of a Pokemon
     *
     * @param nextEvolution the collection nextEvolution
     */

    private static void navigateNextEvolution(List<String> nextEvolution) {
        //If the pokemon just a next evolution
        if (nextEvolution.size() == 1) {
            //Show the unique evolution
            System.out.println("Hay solo una evolución siguiente y es: ");
            System.out.println(nextEvolution.get(0));
        } else {

            int index = 0;
            while (index != -1) {

                //If the index is major the list warn it
                if (index > (nextEvolution.size() - 1)) {
                    System.out.println("Ya no hay mas que ver");
                    index = index - 1;
                    continue;
                }

                //Show the evolution
                System.out.println("Estas viendo la evolucion: ");
                System.out.println(nextEvolution.get(index));

                //Show all  options
                System.out.println("Navegacion: ");
                System.out.println("a) Siguiente");
                System.out.println("b) Anterior ");
                System.out.println("c) Salir");

                //Read for console option
                String option = StdIn.readString();

                //Using swtich for the menu
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
     *
     * @param previousEvolution the collection nextEvolution
     */

    private static void navigatePreviousEvolution(List<String> previousEvolution) {
        //If the previous evolution is unique show it
        if (previousEvolution.size() == 1) {
            System.out.println("Hay solo una evolución anterior y es ");
            System.out.println(previousEvolution.get(0));
        } else {

            int index = 0;
            while (index != -1) {

                //if there are no more evolutions warn it
                if (index > (previousEvolution.size() - 1)) {
                    System.out.println("Ya no hay mas que ver");
                    index = index - 1;
                    continue;
                }

                //Show evolution actal

                System.out.println("Estas viendo la evolucion: ");
                System.out.println(previousEvolution.get(index));

                //Show options

                System.out.println("Navegacion: ");
                System.out.println("a) Siguiente");
                System.out.println("b) Anterior ");
                System.out.println("c) Salir");

                //Read the option by console

                String option = StdIn.readString();

                //Using switch change the option

                switch (option) {
                    case "a" -> index--;
                    case "b" -> index++;
                    default -> index = -1;
                }
            }

        }
    }

}
