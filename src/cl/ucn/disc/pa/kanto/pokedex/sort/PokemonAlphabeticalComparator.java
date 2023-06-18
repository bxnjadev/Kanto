package cl.ucn.disc.pa.kanto.pokedex.sort;

import cl.ucn.disc.pa.kanto.pokemon.Pokemon;

import java.util.Comparator;

public class PokemonAlphabeticalComparator implements Comparator<Pokemon> {

    @Override
    public int compare(Pokemon pokemonOne, Pokemon pokemonTwo) {

        if (pokemonOne == null || pokemonTwo == null) {
            return 0;
        }

        char firstLetterPokemonOne = pokemonOne.getName()
                .charAt(0);

        char firstLetterPokemonTwo = pokemonTwo.getName()
                .charAt(0);

        return Character.compare(firstLetterPokemonOne, firstLetterPokemonTwo);
    }

}
