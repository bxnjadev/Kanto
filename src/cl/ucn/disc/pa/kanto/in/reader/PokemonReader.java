package cl.ucn.disc.pa.kanto.in.reader;

import cl.ucn.disc.pa.kanto.pokedex.Pokedex;

public interface PokemonReader extends AutoCloseable {

    Pokedex read();

    boolean hasNext();

}
