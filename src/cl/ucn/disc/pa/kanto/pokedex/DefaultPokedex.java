package cl.ucn.disc.pa.kanto.pokedex;

import cl.ucn.disc.pa.kanto.pokemon.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class DefaultPokedex implements Pokedex {

    private final List<Pokemon> comoundPokemon;

    public DefaultPokedex() {
        comoundPokemon = new ArrayList<>();
    }

    @Override
    public List<Pokemon> searchByRangeNumber(int firstLimit, int secondLimit) {
        return null;
    }

    @Override
    public List<Pokemon> searchAllPokemon() {
        return null;
    }

    @Override
    public List<Pokemon> searchAllPokemonByFirstEvolution() {
        return null;
    }

    @Override
    public Pokemon searchById(String id) {
        return null;
    }

    @Override
    public Pokemon searchByName(String id) {
        return null;
    }

}
