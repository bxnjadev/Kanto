package cl.ucn.disc.pa.kanto.pokedex.sort;

import cl.ucn.disc.pa.kanto.pokemon.Pokemon;

import java.util.Comparator;

public class PokemonAscendingComparator implements Comparator<Pokemon> {

    @Override
    public int compare(Pokemon pokemonOne, Pokemon pokemonTwo) {
        return Integer.compare(pokemonOne.getId(), pokemonTwo.getId());
    }

}
