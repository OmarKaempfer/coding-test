package longestsequence;

import static longestsequence.ASCIIConstants.LOWERCASE_A_ASCII;

public class LongestSequenceFinder {

    public Tuple<Character, Integer> longestSequence(String text) {

        char lastChar = '\0';
        char currentLongest = '\0';
        int currentCount = 0;
        int currentMax = 0;

        for(char character : text.toCharArray()) {

            character = toLowerCase(character);
            if(lastChar != character) {
                currentCount = 0;
                lastChar = character;
            }
            currentCount++;

            if(currentMax == currentCount && character < currentLongest) {
                currentLongest = character;
            }

            if(currentMax < currentCount) {
                currentMax = currentCount;
                currentLongest = character;
            }
        }

        return new Tuple<>(currentLongest, currentMax);
    }

    private char toLowerCase(char character) {
        return character < LOWERCASE_A_ASCII ? (char) (character + 32) : character;
    }
}
