package cl.ucn.disc.pa.kanto.pokedex;

import cl.ucn.disc.pa.kanto.pokemon.Pokemon;

import java.util.List;

public interface Pokedex {

    List<Pokemon> searchByRangeNumber(int firstLimit, int secondLimit);

    List<Pokemon> searchAllPokemon();

    List<Pokemon> searchAllPokemonByFirstEvolution();

    Pokemon searchById(int id);

    Pokemon searchByName(String id);

}
