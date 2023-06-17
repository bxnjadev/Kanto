package cl.ucn.disc.pa.kanto.in.reader.serialize;

import cl.ucn.disc.pa.kanto.pokemon.Pokemon;

import java.util.Locale;

public class StringPokemonSerializer implements PokemonSerializer<String> {

    private String separatorCharacter;

    public StringPokemonSerializer(String separatorCharacter) {
        this.separatorCharacter = separatorCharacter;
    }

    @Override
    public Pokemon serialize(String adapter) {
        String[] fields = adapter.split(separatorCharacter);



        //return new Pokemon();
        return null;
    }

}
