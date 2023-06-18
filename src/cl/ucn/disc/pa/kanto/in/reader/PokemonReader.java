package cl.ucn.disc.pa.kanto.in.reader;

import cl.ucn.disc.pa.kanto.pokemon.Pokemon;

public interface PokemonReader extends AutoCloseable {

    /**
     * Create a new instance Pokemon based a input
     * @return
     */

    Pokemon read();

    /**
     * Check if has next line
     * @return true if has a next line
     */

    boolean hasNext();

}
