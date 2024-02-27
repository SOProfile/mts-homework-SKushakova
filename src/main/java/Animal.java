public interface Animal {
    public String getBreed();
    public String getName();
    public Double getCost();
    public String getCharacter();

    void returnAnimal(AbstractAnimal Animal);
    AbstractAnimal create(String _name, String _bread, String _character, Double _cost);
}
