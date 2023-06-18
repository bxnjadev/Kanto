package cl.ucn.disc.pa.kanto.in.reader;

import cl.ucn.disc.pa.kanto.in.reader.serialize.PokemonSerializer;
import cl.ucn.disc.pa.kanto.in.reader.serialize.StringPokemonSerializer;
import cl.ucn.disc.pa.kanto.pokemon.Pokemon;
import ucn.In;

import java.io.IOException;

/**
 * This class implement a way for read using cvs files
 */

public class CvsPokemonReader implements PokemonReader {

    private boolean hasNext = true;
    private static final String SEPARATOR_CHARACTER = ",";
    private static final String EMPTY_STRING = "";
    private final In in;

    private final PokemonSerializer<String> stringPokemonSerializer;

    /**
     * The main constructor
     * @param fileName the file name
     * @throws IOException throw exception if this error with the cvs file
     */

    public CvsPokemonReader(String fileName) throws IOException {
        in = new In(fileName);

        stringPokemonSerializer = new StringPokemonSerializer(SEPARATOR_CHARACTER);
    }

    @Override
    public Pokemon read() {

        //Get a new line
        String line = in.readLine();

        //if the line is null no read more
        if (line == null) {
            hasNext = false;
            return null;
        }

        //If the line is empty return a pokemom null
        if (line.equals(EMPTY_STRING)) {
            return null;
        }

        //serialize a pokemon and return it
        return stringPokemonSerializer.serialize(line);
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }

    @Override
    public void close() throws Exception {
        in.close();
    }

}
