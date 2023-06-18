package cl.ucn.disc.pa.kanto.in.reader.serialize;

import cl.ucn.disc.pa.kanto.pokemon.Pokemon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class has a way for read pokemons, using a String class
 */

public class StringPokemonSerializer implements PokemonSerializer<String> {

    private final String separatorCharacter;

    public StringPokemonSerializer(String separatorCharacter) {
        this.separatorCharacter = separatorCharacter;
    }

    /**
     * Convert a String a Pokemon
     * @param adapter the adapter string
     * @return the new Pokemon, be can bull
     */

    @Override
    public Pokemon serialize(String adapter) {
        //Creating the list
        List<String> nextEvolutions = new ArrayList<>();
        List<String> previousEvolutions = new ArrayList<>();

        //Separate the line based a character
        String[] fields = adapter.split(separatorCharacter);

        //Get the id
        String idString = fields[0].trim();

        //Convert the id to zero
        int id = Integer.parseInt(idString);

        //Get the name
        String name = fields[1].trim();


        //Get the stage
        String stage = fields[2].trim();

        //Get the evolutions
        switch (stage) {
            case "Basico" -> nextEvolutions.addAll(Arrays.asList(fields).subList(3, fields.length - 2));
            case "Primera Evolucion" -> {

                String previousEvolution = fields[3];
                previousEvolutions.add(previousEvolution);
                if (!fields[4].equals(fields[fields.length - 2])) {
                    String nextEvolution = fields[4];

                    nextEvolutions.add(nextEvolution);
                }

            }
            case "Segunda Evolucion" -> {

                String previousEvolutionOne = fields[3];
                String previousEvolutionTwo = fields[4];
                previousEvolutions.add(previousEvolutionOne);
                previousEvolutions.add(previousEvolutionTwo);

            }

        }

        String kindTwo = fields[fields.length - 1].trim();
        String kindOne = fields[fields.length - 2].trim();

        //Using builder construct new instance a pokemon
        return Pokemon.newBuilder()
                .id(id)
                .name(name)
                .kindOne(kindOne)
                .kindTwo(kindTwo)
                .stage(stage)
                .previousEvolution(previousEvolutions)
                .nextEvolution(nextEvolutions)
                .build();
    }

}
