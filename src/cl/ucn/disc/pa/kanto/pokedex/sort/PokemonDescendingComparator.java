package cl.ucn.disc.pa.kanto.pokedex.sort;

import cl.ucn.disc.pa.kanto.pokemon.Pokemon;

import java.util.Comparator;

public class PokemonDescendingComparator implements Comparator<Pokemon> {

    /**
     * Compare two pokemon object and select the minor by id
     * @param pokemonOne the first Pokemon object
     * @param pokemonTwo the second Pokemon object
     * @return 1 if the first element is major, -1 if the second element is major, 0 if the two elements are equals
     */

    @Override
    public int compare(Pokemon pokemonOne, Pokemon pokemonTwo) {

        int idPokemonOne = pokemonOne.getId();
        int idPokemonTwo = pokemonTwo.getId();

        if (idPokemonOne > idPokemonTwo) {
            return -1;
        }

        if (idPokemonOne < idPokemonTwo) {
            return 1;
        }

        return 0;
    }

}
