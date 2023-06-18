package cl.ucn.disc.pa.kanto.pokemon;

import java.util.List;

public class Pokemon implements Showable {

    private final int id;
    private final String name;
    private final String stage;
    private final List<String> previousEvolution;
    private final List<String> nextEvolution;
    private final String kindOne;
    private final String kindTwo;

    public Pokemon(int id, String name, String stage,
                   List<String> previousEvolution, List<String> nextEvolution,
                   String kindOne, String kindTwo) {
        this.id = id;
        this.name = name;
        this.stage = stage;
        this.previousEvolution = previousEvolution;
        this.nextEvolution = nextEvolution;
        this.kindOne = kindOne;
        this.kindTwo = kindTwo;
    }

    public int getId() {
        return this.id;
    }

    public String getStage() {
        return this.stage;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getPreviousEvolution() {
        return this.previousEvolution;
    }

    public List<String> getNextEvolution() {
        return this.nextEvolution;
    }

    public String getKindOne() {
        return this.kindOne;
    }

    public String getKindTwo() {
        return this.kindTwo;
    }

    @Override
    public void show() {

        StringBuilder nextEvolutionStringBuilder = new StringBuilder();

        for (String nextEvolutionElement : nextEvolution) {
            nextEvolutionStringBuilder.append(nextEvolutionElement).append(" ");
        }

        StringBuilder previousEvolutionStringBuilder = new StringBuilder();

        for (String previousEvolutionElement : previousEvolution) {
            previousEvolutionStringBuilder.append(previousEvolutionElement).append(" ");
        }


        System.out.println(" ");
        System.out.println("[----------- Pokemon: " + name + " -----------]");
        System.out.println("Id: " + id);
        System.out.println("Etapa: " + stage);
        System.out.println("Evoluciones anteriores: " + previousEvolutionStringBuilder.toString());
        System.out.println("Evoluciones siguientes: " + nextEvolutionStringBuilder.toString());
        System.out.println("Tipo {1}: " + kindOne);
        System.out.println("Tipo {2}: " + kindTwo);
        System.out.println("[---------------------------------------------]");
        System.out.println(" ");

    }

    public static PokemonBuilder newBuilder() {
        return new PokemonBuilder();
    }

    public static class PokemonBuilder {

        private int id;
        private String name;
        private String stage;
        private List<String> previousEvolution;
        private List<String> nextEvolution;
        private String kindOne;
        private String kindTwo;

        public PokemonBuilder id(int id) {
            this.id = id;
            return self();
        }

        public PokemonBuilder name(String name) {
            this.name = name;
            return self();
        }

        public PokemonBuilder stage(String stage) {
            this.stage = stage;
            return self();
        }

        public PokemonBuilder previousEvolution(List<String> previousEvolution) {
            this.previousEvolution = previousEvolution;
            return self();
        }

        public PokemonBuilder nextEvolution(List<String> nextEvolution) {
            this.nextEvolution = nextEvolution;
            return self();
        }

        public PokemonBuilder kindOne(String kindOne) {
            this.kindOne = kindOne;
            return self();
        }

        public PokemonBuilder kindTwo(String kindTwo) {
            this.kindTwo = kindTwo;
            return self();
        }

        private PokemonBuilder self() {
            return this;
        }

        public Pokemon build() {
            return new Pokemon(id, name, stage, previousEvolution, nextEvolution, kindOne, kindTwo);
        }

    }

}
