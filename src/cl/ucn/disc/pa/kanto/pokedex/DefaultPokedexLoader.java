package cl.ucn.disc.pa.kanto.pokedex;

import cl.ucn.disc.pa.kanto.in.reader.PokemonReader;
import cl.ucn.disc.pa.kanto.pokemon.Pokemon;

import java.util.List;

public class DefaultPokedexLoader implements PokedexLoader {

    private final PokemonReader pokemonReader;
    private final List<Pokemon> compoundPokemon;

    public DefaultPokedexLoader(PokemonReader pokemonReader,
                                List<Pokemon> compoundPokemon) {
        this.pokemonReader = pokemonReader;
        this.compoundPokemon = compoundPokemon;
    }

    @Override
    public void load() {

        while (pokemonReader.hasNext()) {
            compoundPokemon.add(
                    pokemonReader.read()
            );
        }

    }

}
