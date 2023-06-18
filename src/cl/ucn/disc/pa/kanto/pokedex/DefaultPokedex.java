package cl.ucn.disc.pa.kanto.pokedex;

import cl.ucn.disc.pa.kanto.in.reader.CvsPokemonReader;
import cl.ucn.disc.pa.kanto.in.reader.PokemonReader;
import cl.ucn.disc.pa.kanto.pokedex.sort.PokemonAlphabeticalComparator;
import cl.ucn.disc.pa.kanto.pokedex.sort.PokemonAscendingComparator;
import cl.ucn.disc.pa.kanto.pokedex.sort.PokemonDescendingComparator;
import cl.ucn.disc.pa.kanto.pokemon.Pokemon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * This class is the main implementation of Pokedex
 */

public class DefaultPokedex implements Pokedex {

    private static final String FILE_NAME = "kanto.txt";
    private static final String FIRST_EVOLUTION_PROPERTY = "Primera Evolucion";
    private final List<Pokemon> compoundPokemon;

    /**
     * Create of implementation of PokemonReader
     * @throws IOException trow exception if error in the read data
     */

    public DefaultPokedex() throws IOException {
        compoundPokemon = new ArrayList<>();

        PokemonReader pokemonReader = new CvsPokemonReader(FILE_NAME);
        PokedexLoader pokedexLoader = new DefaultPokedexLoader(pokemonReader, compoundPokemon);

        pokedexLoader.load();
    }

    /**
     * Get elements defined in a range number based a property id
     * @param firstLimit the first limit searched
     * @param secondLimit the last limit searched
     * @return a collection with objects Pokemons
     */

    @Override
    public List<Pokemon> searchByRangeNumber(int firstLimit, int secondLimit) {

        List<Pokemon> pokemonInRange = new LinkedList<>();

        for (Pokemon pokemon : compoundPokemon) {
            int idPokemon = pokemon.getId();

            if (idPokemon > firstLimit && idPokemon < secondLimit) {
                pokemonInRange.add(
                        pokemon
                );
            }

        }

        pokemonInRange.sort(
                new PokemonAscendingComparator()
        );
        return pokemonInRange;
    }

    /**
     * Get all Pokemons ordering alphabetical
     * @return a collection with objects Pokemons
     */

    @Override
    public List<Pokemon> searchAllPokemon() {

        List<Pokemon> pokemonCompoundCopied = new ArrayList<>(compoundPokemon);
        pokemonCompoundCopied.sort(
                new PokemonAlphabeticalComparator()
        );

        pokemonCompoundCopied.sort(new PokemonAlphabeticalComparator());

        return pokemonCompoundCopied;
    }

    /**
     * Get all Pokemons that her stage is first evolution
     * @return a collection with objects Pokemons
     */

    @Override
    public List<Pokemon> searchAllPokemonByFirstEvolution() {

        LinkedList<Pokemon> compound = new LinkedList<>();

        for (Pokemon pokemon : compoundPokemon) {
            if (pokemon.getStage().equals(FIRST_EVOLUTION_PROPERTY)) {
                compound.add(pokemon);
            }
        }

        compound.sort(new PokemonDescendingComparator());

        return compound;
    }

    /**
     * Search a pokemon by type
     * @param type the type searched
     * @return a collection with objects Pokemons
     */


    @Override
    public List<Pokemon> searchPokemonByType(String type) {

        List<Pokemon> pokemons = new ArrayList<>();

        for (Pokemon pokemon : compoundPokemon) {
            if (pokemon.getKindOne().equals(type) ||
                    pokemon.getKindTwo().equals(type))
                pokemons.add(pokemon);
        }

        return pokemons;
    }

    /**
     * Search a pokemon by id, can be null
     * @param id the id searched
     * @return the pokemon
     */

    @Override
    public Pokemon searchById(int id) {

        for (Pokemon pokemon : compoundPokemon) {
            if (pokemon.getId() == id) {
                return pokemon;
            }

        }

        return null;
    }

    /**
     * Search a pokemon by name, can be null
     * @param id the name searched
     * @return the pokemon
     */

    @Override
    public Pokemon searchByName(String id) {

        for (Pokemon pokemon : compoundPokemon) {
            if (id.equals(pokemon.getName())) {
                return pokemon;
            }
        }

        return null;
    }

}
