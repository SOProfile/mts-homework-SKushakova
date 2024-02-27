public class RandomValueGenerator {
    public String getRandomName()
    {
        String[] names = new String[]{"Имя1", "Имя2", "Имя3", "Имя4"};
        int nameIndex = (int)Math.floor(Math.random() * names.length);
        String name = names[nameIndex];
        return name;
    }
    public String getRandomBread()
    {
        String[] breads = new String[]{"Порода1", "Порода2"};
        int breadIndex = (int)Math.floor(Math.random() * breads.length);
        String bread = breads[breadIndex];
        return bread;
    }
    public String getRandomCharacter()
    {
        String[] characters = new String[]{"Злой", "Добрый", "Пассивно-агрессивный"};
        int characterIndex = (int)Math.floor(Math.random() * characters.length);
        String character = characters[characterIndex];
        return character;
    }
    public Double getRandomCost()
    {
        Double[] costs = new Double[]{Double.valueOf(1), Double.valueOf(355), Double.valueOf(400), Double.valueOf(500)};
        int costIndex = (int)Math.floor(Math.random() * costs.length);
        Double cost = costs[costIndex];
        return cost;
    }
}
