package cl.ucn.disc.pa.kanto.pokedex.sort;

import cl.ucn.disc.pa.kanto.pokemon.Pokemon;

import java.util.Comparator;

public class PokemonAlphabeticalComparator implements Comparator<Pokemon> {

    @Override
    public int compare(Pokemon pokemonOne, Pokemon pokemonTwo) {

        char firstLetterPokemonOne = pokemonOne.getName()
                .charAt(0);

        char firstLetterPokemonTwo = pokemonOne.getName()
                .charAt(0);

        return Character.compare(firstLetterPokemonOne, firstLetterPokemonTwo);
    }

}
