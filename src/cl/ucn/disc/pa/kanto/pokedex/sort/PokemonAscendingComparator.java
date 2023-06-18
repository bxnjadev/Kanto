package cl.ucn.disc.pa.kanto.pokedex.sort;

import cl.ucn.disc.pa.kanto.pokemon.Pokemon;

import java.util.Comparator;

public class PokemonAscendingComparator implements Comparator<Pokemon> {

    /**
     * Compare two pokemon object and select the major by id
     * @param pokemonOne the first Pokemon object
     * @param pokemonTwo the second Pokemon object
     * @return 1 if the first element is major, -1 if the second element is major, 0 if the two elements are equals
     */

    @Override
    public int compare(Pokemon pokemonOne, Pokemon pokemonTwo) {
        return Integer.compare(pokemonOne.getId(), pokemonTwo.getId());
    }

}
