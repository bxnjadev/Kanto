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

}
