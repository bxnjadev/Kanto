package cl.ucn.disc.pa.kanto.in.write;

import cl.ucn.disc.pa.kanto.pokedex.Pokedex;

public interface PokemonWriter extends AutoCloseable {

    Pokedex write();

}
