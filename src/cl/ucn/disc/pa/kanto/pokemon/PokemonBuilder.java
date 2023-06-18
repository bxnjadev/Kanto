package cl.ucn.disc.pa.kanto.pokemon;

import java.util.List;

public class PokemonBuilder {

    private int id;
    private String name;
    private String stage;
    private List<String> previousEvolution;
    private List<String> nextEvolution;
    private String kindOne;
    private String kindTwo;

    /**
     * Set the id at Pokemon
     *
     * @param id the id
     * @return the builder
     */

    public PokemonBuilder id(int id) {
        this.id = id;
        return self();
    }

    /**
     * Set the name at Pokemon
     *
     * @param name the name
     * @return the builder
     */

    public PokemonBuilder name(String name) {
        this.name = name;
        return self();
    }

    /**
     * Set the id at Pokemon
     *
     * @param stage the stage
     * @return the builder
     */

    public PokemonBuilder stage(String stage) {
        this.stage = stage;
        return self();
    }

    /**
     * Set the previousEvolution at Pokemon
     *
     * @param previousEvolution the previousEvolutionCollection
     * @return the builder
     */

    public PokemonBuilder previousEvolution(List<String> previousEvolution) {
        this.previousEvolution = previousEvolution;
        return self();
    }

    /**
     * Set the previousEvolution at Pokemon
     *
     * @param nextEvolution the nextEvolutionCollection
     * @return the builder
     */

    public PokemonBuilder nextEvolution(List<String> nextEvolution) {
        this.nextEvolution = nextEvolution;
        return self();
    }

    /**
     * Set the kind one
     *
     * @param kindOne the kind one
     * @return the builder
     */

    public PokemonBuilder kindOne(String kindOne) {
        this.kindOne = kindOne;
        return self();
    }

    /**
     * Set the kind two
     *
     * @param kindTwo the kind two
     * @return the builder
     */

    public PokemonBuilder kindTwo(String kindTwo) {
        this.kindTwo = kindTwo;
        return self();
    }

    /**
     * Return the builder
     *
     * @return the builder
     */

    private PokemonBuilder self() {
        return this;
    }

    /**
     * Construct the object Pokemon
     *
     * @return the Pokemon instance
     */

    public static PokemonBuilder newBuilder() {
        return new PokemonBuilder();
    }

    public Pokemon build() {
        //Using builder construct the class

        return new Pokemon(id, name, stage, previousEvolution, nextEvolution, kindOne, kindTwo);
    }

}
