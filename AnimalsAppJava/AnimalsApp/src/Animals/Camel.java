package Animals;

public class Camel extends PackAnimals {
    private static final String className = "Camel";

    public Camel(String name, String birthday) {
        super(name, birthday);
    }

    public String getAnimalClassName(){return className; }
}
