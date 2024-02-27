public class Wolf extends Predator{
    public Wolf(String _breed, String _name, String _character, Double _cost) {
        super(_breed, _name, _character, _cost);
    }
    @Override
    public void saySome()
    {
        System.out.println("Ауф!");
    }
}
