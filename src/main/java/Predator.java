public class Predator extends AbstractAnimal{

    public Predator(String _breed, String _name, String _character, Double _cost) {
        super(_breed, _name, _character, _cost);
    }

    @Override
    public String getBreed() {
        return breed;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Double getCost() {
        return cost;
    }

    @Override
    public String getCharacter() {
        return character;
    }

    @Override
    public AbstractAnimal create(String _name, String _bread, String _character, Double _cost) {
        Predator predator = new Predator(_bread, _name, _character, _cost);
        predator.breed = _bread;
        predator.name = _name;
        predator.cost = _cost;
        predator.character = _character;
        return predator;
    }
    @Override
    public void returnAnimal(AbstractAnimal Animal)
    {
        System.out.println("Порода: " + this.getBreed() + " Характер: " + this.getCharacter() + " Имя: "+ this.getName() + " Цена: " + this.getCost() + " У меня нет дома ((");
    }
}

