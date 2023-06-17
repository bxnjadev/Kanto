package cl.ucn.disc.pa.kanto.pokedex;

import cl.ucn.disc.pa.kanto.in.reader.CvsPokemonReader;
import cl.ucn.disc.pa.kanto.in.reader.PokemonReader;
import cl.ucn.disc.pa.kanto.pokedex.sort.PokemonAlphabeticalComparator;
import cl.ucn.disc.pa.kanto.pokedex.sort.PokemonAscendingComparator;
import cl.ucn.disc.pa.kanto.pokemon.Pokemon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DefaultPokedex implements Pokedex {

    private static final String FILE_NAME = "kanto.txt";
    private static final String FIRST_EVOLUTION_PROPERTY = "Primera Evolución";
    private final List<Pokemon> comoundPokemon;

    public DefaultPokedex() throws IOException {
        comoundPokemon = new ArrayList<>();

        PokemonReader pokemonReader = new CvsPokemonReader(FILE_NAME);
        PokedexLoader pokedexLoader = new DefaultPokedexLoader(pokemonReader, comoundPokemon);

        pokedexLoader.load();
    }

    @Override
    public List<Pokemon> searchByRangeNumber(int firstLimit, int secondLimit) {

        List<Pokemon> pokemonInRange = new LinkedList<>();

        for (Pokemon pokemon : comoundPokemon) {
            int idPokemon = pokemon.getId();

            if (idPokemon > secondLimit) {
                break;
            }

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

    @Override
    public List<Pokemon> searchAllPokemon() {

        List<Pokemon> pokemonCompoundCopied = new ArrayList<>();
        Collections.copy(pokemonCompoundCopied, comoundPokemon);

        pokemonCompoundCopied.sort(
                new PokemonAlphabeticalComparator()
        );

        return pokemonCompoundCopied;
    }

    @Override
    public List<Pokemon> searchAllPokemonByFirstEvolution() {

        LinkedList<Pokemon> compound = new LinkedList<>();

        for (Pokemon pokemon : comoundPokemon) {
            if (pokemon.getStage().equals(FIRST_EVOLUTION_PROPERTY)) {
                compound.add(pokemon);
            }
        }

        return compound;
    }

    @Override
    public List<Pokemon> searchPokemonByType(String type) {

        List<Pokemon> pokemons = new ArrayList<>();

        for (Pokemon pokemon : comoundPokemon) {
            if(pokemon.getKindOne().equals(type) ||
            pokemon.getKindTwo().equals(type))
                pokemons.add(pokemon);
        }

        return pokemons;
    }

    @Override
    public Pokemon searchById(int id) {

        for (Pokemon pokemon : comoundPokemon) {
            if (pokemon.getId() == id) {
                return pokemon;
            }

        }

        return null;
    }

    @Override
    public Pokemon searchByName(String id) {

        for (Pokemon pokemon : comoundPokemon) {
            if (id.equals(pokemon.getName())) {
                return pokemon;
            }
        }

        return null;
    }

}
