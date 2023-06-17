package cl.ucn.disc.pa.kanto;

import cl.ucn.disc.pa.kanto.pokedex.DefaultPokedex;
import cl.ucn.disc.pa.kanto.pokedex.Pokedex;
import cl.ucn.disc.pa.kanto.pokemon.Pokemon;
import ucn.StdIn;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {



        Pokedex pokedex = new DefaultPokedex();
        showMainMenu(pokedex);

    }

    public static void showMainMenu(Pokedex pokedex) {
        System.out.println("Opciones: ");
        System.out.println("a) Desplegar pokemones dado un rango de número creciente");
        System.out.println("b) Desplegar todos los pokemones almacenados alfabeticamente");
        System.out.println("c) Desplegar los pokemone sdado un tipo particular");
        System.out.println("d) Desplegar los pokemones de la primera evolución");
        System.out.println("e) Buscar por nombre");
        System.out.println("f) Buscar por id");
        System.out.println("g) Salir");

        while (true) {
            String option = StdIn.readString();

            switch (option) {
                case "a":
                    showPokemonInRange(pokedex);
                case "b":
                    showPokemonAlphabetical(pokedex);
                case "c":
                    showPokemonByType(pokedex);
                case "d":
                    showPokemonByFirstEvolution(pokedex);
                case "e":
                    searchByName(pokedex);
                case "f":


                default:
                    break;
            }

        }

    }

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

    public static void showPokemonAlphabetical(Pokedex pokedex) {

        pokedex.searchAllPokemon().forEach(
                Pokemon::show
        );

    }

    public static void showPokemonByType(Pokedex pokedex) {

        System.out.println("Ingresa el pokemon que quieres elegir: ");
        String type = StdIn.readString();

        pokedex.searchPokemonByType(type).forEach(
                Pokemon::show
        );

    }

    public static void showPokemonByFirstEvolution(Pokedex pokedex) {

        pokedex.searchAllPokemonByFirstEvolution().forEach(
                Pokemon::show
        );

    }

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

    }

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

}
