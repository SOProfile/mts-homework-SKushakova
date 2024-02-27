abstract public class AbstractAnimal implements Animal{
    protected String breed;
    protected String name;
    protected String character;
    protected Double cost;

    protected AbstractAnimal(String breed, String name, String character, Double cost) {
        this.character = character;
        this.breed = breed;
        this.name = name;
        this.cost = cost;
    }
    protected void saySome()
    {
        System.out.println("Голос?");
    }
}
