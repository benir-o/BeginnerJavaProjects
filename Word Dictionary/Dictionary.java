import java.util.LinkedList;

/**
 * Creates a dictionary that can hold a large amount of words with multiple definitions.
 *
 * @author Riley Simmons
 */
public class Dictionary
{

    private static final int listSize = 50_000;
    private LinkedList<Word>[] wordList;

    /**
     * Initializes the LinkedList to hold Word type objects.
     */
    public Dictionary()
    {
        wordList = new LinkedList[listSize];
        for (int i = 0; i < wordList.length; i++)
        {
            wordList[i] = new LinkedList<Word>();
        }
    }

    /**
     * Adds a word and it's definition to the dictionary.
     *
     * @param word The word to be added to the dictionary.
     * @param description The description of the word.
     */
    public void add(String word, String description)
    {
        Word newWord = new Word(word, description);
        int h = hashCode(newWord);
        wordList[h].add(newWord);
    }

    /**
     * Uses hashing to find the specified word, and combine any definitions together if
     * the word has multiple definitions.
     *
     * @param word The word that is being searched for.
     * @return The Word object that has been retrieved from the word list.
     */
    public Word lookFor(String word)
    {
        Word lookWord = new Word(word, null); // Creates a dummy word
        int h = hashCode(lookWord);

        if (wordList[h].size() > 1) // In case the word has multiple definitions.
        {
            String newDef = "\n";
            for (int i = 0; i < wordList[h].size(); i++)
            {
                newDef += " * " + wordList[h].get(i).getDef() + "\n";
            }
            return new Word(word, newDef);
        }
        return wordList[h].get(0);
    }

    /**
     * Generated a hash code that can be used to uniquely identify a word, independent
     * of its definition.
     *
     * @param word The Word object to be hashed.
     * @return An integer that uniquely identifies the word.
     */
    static int hashCode(Word word)
    {
        int h = word.getWord().hashCode();
        if (h < 0)
        {
            h = -h;
        }
        if (h > listSize)
        {
            h%=listSize;
        }
        return h;
    }
}
