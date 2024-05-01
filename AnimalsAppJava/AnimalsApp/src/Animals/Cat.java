package Animals;

public class Cat extends PetAnimals{
    private static final String className = "Cat";

    public Cat(String name, String birthday) {
        super(name, birthday);
    }

    public String getAnimalClassName(){return className; }
}
