package cl.ucn.disc.pa.kanto.in.reader;

import cl.ucn.disc.pa.kanto.in.reader.serialize.PokemonSerializer;
import cl.ucn.disc.pa.kanto.in.reader.serialize.StringPokemonSerializer;
import cl.ucn.disc.pa.kanto.pokemon.Pokemon;
import ucn.In;

import java.io.IOException;

public class CvsPokemonReader implements PokemonReader {

    private static final String SEPARATOR_CHARACTER = ",";
    private static final String EMPTY_STRING = "";
    private final In in;

    private final PokemonSerializer<String> stringPokemonSerializer;

    public CvsPokemonReader(String fileName) throws IOException {
        in = new In(fileName);

        stringPokemonSerializer = new StringPokemonSerializer(SEPARATOR_CHARACTER);
    }

    @Override
    public Pokemon read() {

        String line = in.readLine();

        if (line.equals(EMPTY_STRING)) {
            return null;
        }

        return stringPokemonSerializer.serialize(line);
    }

    @Override
    public boolean hasNext() {
        return in.hasNextLine();
    }

    @Override
    public void close() throws Exception {
        in.close();
    }

}
