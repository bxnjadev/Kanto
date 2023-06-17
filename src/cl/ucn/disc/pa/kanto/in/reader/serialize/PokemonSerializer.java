package cl.ucn.disc.pa.kanto.in.reader.serialize;

import cl.ucn.disc.pa.kanto.pokemon.Pokemon;

public interface PokemonSerializer<T> {

    Pokemon serialize(T adapter);

}
