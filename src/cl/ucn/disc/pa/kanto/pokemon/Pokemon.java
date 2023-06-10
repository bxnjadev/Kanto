package cl.ucn.disc.pa.kanto.pokemon;

public class Pokemon implements Showable {

    private final String id;
    private final String name;
    private final String stage;
    private final String previousEvolution;
    private final String nextEvolution;
    private final String kindOne;
    private final String kindTwo;

    public Pokemon(String id, String name, String stage,
                   String previousEvolution, String nextEvolution,
                   String kindOne, String kindTwo) {
        this.id = id;
        this.name = name;
        this.stage = stage;
        this.previousEvolution = previousEvolution;
        this.nextEvolution = nextEvolution;
        this.kindOne = kindOne;
        this.kindTwo = kindTwo;
    }

    public String getId() {
        return this.id;
    }

    public String getStage() {
        return this.stage;
    }

    public String getName() {
        return this.name;
    }

    public String getPreviousEvolution() {
        return this.previousEvolution;
    }

    public String getNextEvolution() {
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
    }

}
