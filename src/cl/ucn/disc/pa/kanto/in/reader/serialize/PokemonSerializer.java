package cl.ucn.disc.pa.kanto.in.reader.serialize;

import cl.ucn.disc.pa.kanto.pokemon.Pokemon;

public interface PokemonSerializer<T> {

    /**
     * Convert adapter to object Pokemon
     * @param adapter the generic adapter
     * @return The Pokemon
     */

    Pokemon serialize(T adapter);

}
