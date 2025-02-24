/**
 * Defines a word along with its description, and allows operations on the word
 * and its description.
 */
public class Word
{

    private final String word;
    private String definition;

    /**
     * Initialize the word and definition with provided data.
     *
     * @param word An actual word.
     * @param definition The matching definition with the word.
     */
    public Word(String word, String definition)
    {
        this.word = word;
        this.definition = definition;
    }

    /**
     * Retrieves the assigned word.
     *
     * @return A word.
     */
    public String getWord() {
        return word;
    }

    /**
     * Retrieves the definition of the word.
     *
     * @return The definition of the word.
     */
    public String getDef() {
        return definition;
    }

    /**
     * Changes the definition of the word to a new set meaning.
     *
     * @param newDef The new definition of a word.
     */
    public void setDef(String newDef) {
        definition = newDef;
    }

    /**
     * Creates a formatted string representation of the word and it's definition.
     *
     * @return A word and it's definition, formatted.
     */
    public String toString()
    {
        String s = "Word: ";
        s += word + "\n";
        s += "Definition: " + definition;
        return s;
    }

}
