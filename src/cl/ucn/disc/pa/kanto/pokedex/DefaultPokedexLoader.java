package cl.ucn.disc.pa.kanto.pokedex;

import cl.ucn.disc.pa.kanto.in.reader.PokemonReader;
import cl.ucn.disc.pa.kanto.pokemon.Pokemon;

import java.util.List;

/**
 * This class is the main implementation of pokedex loader
 */

public class DefaultPokedexLoader implements PokedexLoader {

    private final PokemonReader pokemonReader;
    private final List<Pokemon> compoundPokemon;

    public DefaultPokedexLoader(PokemonReader pokemonReader,
                                List<Pokemon> compoundPokemon) {
        this.pokemonReader = pokemonReader;
        this.compoundPokemon = compoundPokemon;
    }

    /**
     * Load the pokemons
     */

    @Override
    public void load() {

        //Using while while pokemon reader has a pokemon for read
        while (pokemonReader.hasNext()) {

            //Serialize the pokemon
            Pokemon pokemon = pokemonReader.read();

            //if the pokemon is null
            if (pokemon == null) {
                continue;
            }

            //add the pokemon to compound pokemon
            compoundPokemon.add(
                    pokemon
            );

        }

    }

}
