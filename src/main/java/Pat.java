public class Pat extends AbstractAnimal {
    public Pat(String _breed, String _name, String _character, Double _cost) {
        super(_breed, _name, _character, _cost);
    }

    @Override
    public String getBreed() {
        return breed;
    }

    @Override
    public String getCharacter() {
        return character;
    }

    @Override
    public AbstractAnimal create(String _name, String _bread, String _character, Double _cost) {
        Pat pat = new Pat(_bread, _name, _character, _cost);
        pat.breed = _bread;
        pat.name = _name;
        pat.cost = _cost;
        pat.character = _character;
        return pat;
    }

    @Override
    public Double getCost() {
        return cost;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public void returnAnimal(AbstractAnimal Animal)
    {
        System.out.println("Порода: " + this.getBreed() + " Характер: " + this.getCharacter() + " Имя: "+ this.getName() + " Цена: " + this.getCost()+ " А еще я домашний <3");
    }
}
