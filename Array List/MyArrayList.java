
/**
 *  Used to create arrays that have more functionality, similar to an ArrayList.
 *
 * @author Riley Simmons
 */
public class MyArrayList
{
    private int size;
    private Object[] arr;

    /**
     * Defines an empty array to be used.
     */
    public MyArrayList()
    {
        arr = new Object[2];
    }

    public MyArrayList(int length)
    {
        arr = new Object[length];
    }

    /**
     * Appends a given object to the end of the array by creating a new array
     * that is larger, copying the old array, and then adding the new Object to the end.
     *
     * @param e Object to be placed at the end of the array.
     */
    public void add(Object e)
    {
        if (isFull()) {
            extend();
        }
        for (int i = 0; i < size; i++)
        {
            if (arr[i] == null) {
                arr[i] = e;
                return;
            }
        }
        size++;
    }

    /**
     * Adds a given object to the array by inserting it at a specific index. Uses the
     * overloaded add method to append items to a new list
     *
     * @param index The index for the object to be inserted at.
     * @param element The object that is being added to the array list.
     */
    public void add(int index, Object element)
    {
        if (isFull()) {
            extend();
        }
        if (0 <= index && index <= size)
        {
            for (int i = size - 1; i > index; i--)
            {
                arr[i] = arr[i - 1];
            }
            arr[index] = element;
        }
    }

    /**
     * Returns the array to size 0 with no elements.
     */
    public void clear()
    {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = null;
        }
    }

    /**
     * Checks through the array to see if the given object exists in the array.
     *
     * @param o Object to be checked against the array.
     * @return Returns true if object is present, false if not.
     */
    public boolean contains(Object o)
    {
        for (int i = 0; i < arr.length; i++)
        {
            if (o.equals(arr[i]))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Finds the element of the array at a given index.
     *
     * @param index The index to look in the array.
     * @return The object that exists at the specified index.
     */
    public Object get(int index)
    {
        return arr[index];
    }

    /**
     * Determines where an object is located within the array.
     *
     * @param o The object that is being searched for.
     * @return The index that that object exists at.
     */
    public int indexOf(Object o)
    {
        for (int i = 0; i < arr.length; i++)
        {
            if (o.equals(arr[i]))
            {
                return i;
            }
        }
        return -1;
    }

    /**
     * Checks if the current array has no elements.
     *
     * @return Returns true if the array has no elements, false if not.
     */
    public boolean isEmpty()
    {
        if (size() == 0) {return true;}
        return false;
    }

    /**
     * Searches through the array to find an object, and if it exists,
     * then remove it from the array.
     *
     * @param o The object that is to be removed from the list.
     * @return Whether the object was successfully removed from the array.
     */
    public boolean remove(Object o)
    {
        for (int i = 0; i < arr.length; i++)
        {
            if (o.equals(arr[i]))
            {
                remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Removes an element from the array at the specified index.
     *
     * @param index The index of the element that is to be removed from the array.
     */
    public void remove(int index)
    {
        arr[index] = null;
        for (int i = index; i < arr.length -1; i++) {
            arr[i] = arr[i + 1];
        }
    }

    /**
     * Creates a new MyArrayList that takes a section out of the current
     * array.
     *
     * @param start The start of the
     * @param end
     * @return
     */
    public MyArrayList subList(int start, int end)
    {
        MyArrayList subArr = new MyArrayList();
        for (int i = start; i >= end; i++)
        {
            subArr.add(arr[i]);
        }
        return subArr;
    }

    /**
     * Takes another MyArrayList and adds it to the current array list.
     *
     * @param list2 The list to be appended to the current array.
     * @return The
     */
    public MyArrayList addFrom(MyArrayList list2)
    {
        MyArrayList newArr = new MyArrayList();
        for (int i = 0; i < arr.length; i++)
        {
            newArr.add(arr[i]);
        }
        for (int i = 0; i < list2.size(); i++)
        {
            newArr.add(list2.get(i));
        }
        arr = newArr.arr;
        return newArr;
    }

    /**
     * Used to give a MyArrayList that has a list appended to the current list.
     *
     * @param list2 The list to be appended.
     * @return The combination of the two lists.
     */
    public MyArrayList add(MyArrayList list2)
    {
        MyArrayList newArr = new MyArrayList();
        for (int i = 0; i < arr.length; i++)
        {
            newArr.add(arr[i]);
        }
        for (int i = 0; i < list2.size(); i++)
        {
            newArr.add(list2.get(i));
        }
        return newArr;
    }

    private void extend() {
        Object[] newArr = new Object[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    private boolean isFull() {
        return size() == arr.length;
    }

    /**
     * Finds the size of the current array.
     *
     * @return The size of the current array / how many elements are in the array.
     */
    public int size()
    {
        int elementCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                elementCount += 1;
            }
        }
        return elementCount;
    }

    /**
     * Takes the raw array and puts it into a readable String object.
     *
     * @return The string output of the array and it's elements.
     */
    public String toString()
    {
        String outString = "[";
        for(int i = 0; i < arr.length; i++)
        {
            if (arr[i] != null) {
                outString += arr[i];
            } else {
                continue;
            }
            if (i < size() - 1)
            {
                outString += ", ";
            }
        }
        outString += "]";
        return outString;
    }
}
