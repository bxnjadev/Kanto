package cl.ucn.disc.pa.kanto.pokemon;

import java.util.List;

/**
 * This class, contains the data of a pokemon
 */

public class Pokemon implements Showable {

    private final int id;
    private final String name;
    private final String stage;
    private final List<String> previousEvolution;
    private final List<String> nextEvolution;
    private final String kindOne;
    private final String kindTwo;

    /**
     * Main constructor for the Pokemon class
     * @param id the id
     * @param name the name
     * @param stage the  stage
     * @param previousEvolution the previous evolution Collection
     * @param nextEvolution the next evolution Collection
     * @param kindOne the kind one
     * @param kindTwo the kind two
     */

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

    /**
     * Get the Pokemon id
     * @return the Pokemon id
     */

    public int getId() {
        return this.id;
    }

    /**
     * Get the Pokemon Stage
     * @return the Pokemon Stage
     */

    public String getStage() {
        return this.stage;
    }

    /**
     * Get the Pokemon Name
     * @return the Name Pokemon
     */

    public String getName() {
        return this.name;
    }

    /**
     * Get the Previous Evolution
     * @return the Previous Evolution in a Collection
     */

    public List<String> getPreviousEvolution() {
        return this.previousEvolution;
    }

    /**
     * Get the Next Evolution
     * @return the Previous Next in a Collection
     */

    public List<String> getNextEvolution() {
        return this.nextEvolution;
    }

    /**
     * Get the kind one the Pokemon
     * @return the kind one
     */

    public String getKindOne() {
        return this.kindOne;
    }

    /**
     * Get the kind one the Pokemon
     * @return the kind two
     */

    public String getKindTwo() {
        return this.kindTwo;
    }

    /**
     * Show the properties of Pokemon
     */

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

        /**
         * Set the id at Pokemon
         * @param id the id
         * @return the builder
         */

        public PokemonBuilder id(int id) {
            this.id = id;
            return self();
        }

        /**
         * Set the name at Pokemon
         * @param name the name
         * @return the builder
         */

        public PokemonBuilder name(String name) {
            this.name = name;
            return self();
        }

        /**
         * Set the id at Pokemon
         * @param stage the stage
         * @return the builder
         */

        public PokemonBuilder stage(String stage) {
            this.stage = stage;
            return self();
        }

        /**
         * Set the previousEvolution at Pokemon
         * @param previousEvolution the previousEvolutionCollection
         * @return the builder
         */

        public PokemonBuilder previousEvolution(List<String> previousEvolution) {
            this.previousEvolution = previousEvolution;
            return self();
        }

        /**
         * Set the previousEvolution at Pokemon
         * @param nextEvolution the nextEvolutionCollection
         * @return the builder
         */

        public PokemonBuilder nextEvolution(List<String> nextEvolution) {
            this.nextEvolution = nextEvolution;
            return self();
        }

        /**
         * Set the kind one
         * @param kindOne the kind one
         * @return the builder
         */

        public PokemonBuilder kindOne(String kindOne) {
            this.kindOne = kindOne;
            return self();
        }

        /**
         * Set the kind two
         * @param kindTwo the kind two
         * @return the builder
         */

        public PokemonBuilder kindTwo(String kindTwo) {
            this.kindTwo = kindTwo;
            return self();
        }

        /**
         * Return the builder
         * @return the builder
         */

        private PokemonBuilder self() {
            return this;
        }

        /**
         * Construct the object Pokemon
         * @return the Pokemon instance
         */

        public Pokemon build() {
            //Using builder construct the class

            return new Pokemon(id, name, stage, previousEvolution, nextEvolution, kindOne, kindTwo);
        }

    }

}
