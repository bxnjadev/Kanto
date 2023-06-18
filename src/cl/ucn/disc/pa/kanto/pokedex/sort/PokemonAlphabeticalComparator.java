package cl.ucn.disc.pa.kanto.pokedex.sort;

import cl.ucn.disc.pa.kanto.pokemon.Pokemon;

import java.util.Comparator;

public class PokemonAlphabeticalComparator implements Comparator<Pokemon> {

    /**
     * Compare two pokemon object of a way alphabetical
     * @param pokemonOne the first Pokemon object
     * @param pokemonTwo the second Pokemon object
     * @return 1 if the first element is major, -1 if the second element is major, 0 if the two elementos has same first letter in name
     */

    @Override
    public int compare(Pokemon pokemonOne, Pokemon pokemonTwo) {
        //Using String class compare two pokemons
        return pokemonOne.getName().compareTo(pokemonTwo.getName());
    }

}
