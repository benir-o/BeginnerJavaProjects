public class WordTest
{
    public static void main(String[] args)
    {
        Dictionary d = new Dictionary();
        d.add("Root Beer", "A tasty fizzy drink");
        d.add("Club Soda", "A super fizzy water drink");
        d.add("Root Beer", "A drink made from sassafras");

        System.out.println(d.lookFor("Root Beer"));
        System.out.println(d.lookFor("Club Soda"));
    }
}