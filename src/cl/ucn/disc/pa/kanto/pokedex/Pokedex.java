package cl.ucn.disc.pa.kanto.pokedex;

import cl.ucn.disc.pa.kanto.pokemon.Pokemon;

import java.util.List;

public interface Pokedex {

    /**
     * Get elements defined in a range number based a property id
     * @param firstLimit the first limit searched
     * @param secondLimit the last limit searched
     * @return a collection with objects Pokemons
     */

    List<Pokemon> searchByRangeNumber(int firstLimit, int secondLimit);

    /**
     * Get all Pokemons ordering alphabetical
     * @return a collection with objects Pokemons
     */

    List<Pokemon> searchAllPokemon();

    /**
     * Get all Pokemons that her stage is first evolution
     * @return a collection with objects Pokemons
     */

    List<Pokemon> searchAllPokemonByFirstEvolution();

    /**
     * Search a pokemon by type
     * @param type the type searched
     * @return a collection with objects Pokemons
     */

    List<Pokemon> searchPokemonByType(String type);

    /**
     * Search a pokemon by id, can be null
     * @param id the id searched
     * @return the pokemon
     */

    Pokemon searchById(int id);

    /**
     * Search a pokemon by name, can be null
     * @param id the name searched
     * @return the pokemon
     */

    Pokemon searchByName(String id);

}
