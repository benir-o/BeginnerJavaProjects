package BeginnerJavaProjects.ArrayList1;

/**
 * Used to test the methods of the MyArrayList class.
 *
 * @author Riley Simmons
 */
public class ArrayListTest
{
    public static void main(String[] args)
    {

        MyArrayList testArray = new MyArrayList();

        for (int i = 0; i < 10; i++)
        {
            testArray.add((int) Math.pow(i, 2));
        }

        System.out.println(testArray);

        testArray.add(3, "3rd Element");

        System.out.println(testArray);

        testArray.remove(3);
        System.out.println(testArray);

        System.out.println(testArray.contains(36));
        System.out.println(testArray.contains(35));

        System.out.println(testArray.isEmpty());
        testArray.clear();
        System.out.println(testArray.isEmpty());

        for (int i = 0; i < 10; i++)
        {
            testArray.add((int) Math.pow(2, i));
        }
        System.out.println(testArray.size());
        for (int i = 9; i >= 0; i--)
        {
            System.out.println(testArray.get(i));
        }

        System.out.println(testArray.size());

        testArray.remove(4);
        System.out.println(testArray);
        System.out.println(testArray.subList(3, 5));

        MyArrayList secondArray = new MyArrayList(4);
        testArray.addFrom(secondArray);
        System.out.println(testArray);

    }
}
