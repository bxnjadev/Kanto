package cl.ucn.disc.pa.kanto.pokedex.sort;

import cl.ucn.disc.pa.kanto.pokemon.Pokemon;

import java.util.Comparator;

public class PokemonDescendingComparator implements Comparator<Pokemon> {

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
