package eg.edu.alexu.csd.datastructure.hangman.cs73;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Random;

import eg.edu.alexu.csd.datastructure.hangman.IHangman;

/**
 * @author mahmoud-pc
 */
public class Game implements IHangman {
  /**
   * the secret answer of the game.
   */
  private String secret;
  /**
   * the string being modified during the game that is shown to the user.
   */
  private String output;
  /**
   * The {@link Dictionary} from which a random word is chosen.
   */
  private ArrayList<String> dictionary = new ArrayList<>();
  /**
   * Maximum number of wrong guesses.
   */
  private int max = 0;

  /**
   * Set dictionary words to pick secret words from.
   * @param words
   *          an array of words
   */
  public final void setDictionary(final String[] words) {
    for (int i = 0; i < words.length; i++) {
      if (words[i] != null) {
        dictionary.add(words[i]);
      }
    }
  }

  /**
   * Pick a random secret word from dictionary and returns it.
   * @return secret word
   */
  public final String selectRandomSecretWord() {
    secret = new String();
    output = new String();
    Random rand = new Random();
    if (dictionary.size() == 0) {
      return null;
    }
    int index = rand.nextInt(dictionary.size());
    secret = dictionary.get(index);
    output = "";
    for (int i = 0; i < secret.length(); i++) {
      output = output + "-";
    }
    return secret;
  }

  /**
   * Receive a new user guess, and verify it against the secret word.
   * @param myChar
   *          case insensitive user guess. If c is NULL then ignore it and do no
   *          change
   * @return secret word with hidden characters (use ’-’ instead unsolved
   *         characters), or return NULL if user reached max wrong guesses
   */
  public final String guess(final Character myChar) {
    if (max <= 0 || dictionary.size() == 0) {
      return null;
    }
    if (myChar == null) {
      return output;
    }
    boolean change = false;
    char[] temp = new char[secret.length()];
    for (int i = 0; i < secret.length(); i++) {
      if (secret.charAt(i) == Character.toLowerCase(myChar)
          || secret.charAt(i) == Character.toUpperCase(myChar)) {
        temp[i] = secret.charAt(i);
        change = true;
      } else {
        temp[i] = output.charAt(i);
      }
    }
    output = new String(temp);
    if (!change) {
      max--;
    }
    if (max <= 0) {
      return null;
    }
    return output;
  }

  /**
   * Set the maximum number of wrong guesses.
   * @param myMax
   *          maximum number of wrong guesses, If is NULL, then assume it 0
   */
  public final void setMaxWrongGuesses(final Integer myMax) {
    if (myMax != null) {
      this.max = myMax;
    }
  }
}
