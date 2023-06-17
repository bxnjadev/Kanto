package cl.ucn.disc.pa.kanto.in.reader;

import cl.ucn.disc.pa.kanto.pokedex.Pokedex;
import cl.ucn.disc.pa.kanto.pokemon.Pokemon;

public interface PokemonReader extends AutoCloseable {

    Pokemon read();

    boolean hasNext();

}
