package cl.ucn.disc.pa.kanto.in.reader.serialize;

import cl.ucn.disc.pa.kanto.pokemon.Pokemon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringPokemonSerializer implements PokemonSerializer<String> {

    private final String separatorCharacter;

    public StringPokemonSerializer(String separatorCharacter) {
        this.separatorCharacter = separatorCharacter;
    }

    @Override
    public Pokemon serialize(String adapter) {
        List<String> nextEvolutions = new ArrayList<>();
        List<String> previousEvolutions = new ArrayList<>();

        String[] fields = adapter.split(separatorCharacter);
        String idString = fields[0].trim();

        int id = Integer.parseInt(idString);

        String name = fields[1].trim();

        System.out.println(name);

        String stage = fields[2].trim();

        switch (stage) {
            case "Basico" -> nextEvolutions.addAll(Arrays.asList(fields).subList(3, fields.length - 3));
            case "Primera Evolución" -> {

                String previousEvolution = fields[3];
                previousEvolutions.add(previousEvolution);
                if (!fields[4].equals(fields[fields.length - 2])) {
                    String nextEvolution = fields[4];

                    nextEvolutions.add(nextEvolution);
                }

            }
            case "Segunda Evolución" -> {

                String previousEvolutionOne = fields[3];
                String previousEvolutionTwo = fields[4];
                previousEvolutions.add(previousEvolutionOne);
                previousEvolutions.add(previousEvolutionTwo);

            }

        }

        String kindTwo = fields[fields.length - 1].trim();
        String kindOne = fields[fields.length - 2].trim();

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
