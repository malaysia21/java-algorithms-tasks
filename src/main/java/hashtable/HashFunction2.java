package hashtable;

import lombok.Data;

public class HashFunction2 {
    private WordList[] array;
    private int arraySize;
    private String[][] elementsToAdd = {
            { "ace", "Very good" },
            { "act", "Take action" },
            { "add", "Join (something) to something else" },
            { "age", "Grow old" },
            { "ago", "Before the present" }};

    public HashFunction2(int arraySize) {
        this.arraySize = arraySize;
        array = new WordList[arraySize];

        for(int i =0; i<arraySize; i++){
            array[i] = new WordList();
        }

        addElementToArray(elementsToAdd);
    }


    private void addElementToArray(String[][] elementsToAdd) {

        for (String[] strings : elementsToAdd) {
            String word = strings[0];
            String definition = strings[1];

            Word newWord = new Word(word, definition);
            insert(newWord);
        }
    }

    private void insert(Word newWord){
        String wordToHash = newWord.getWord();
        int hashKey = stringHashFunction(wordToHash);

        array[hashKey].insert(newWord, hashKey);
    }

    private Word find (String wordToFind){
        int hashKey = stringHashFunction(wordToFind);
        return array[hashKey].find(hashKey, wordToFind);
    }

    private void displayTheArray() {
        for (int i = 0; i < arraySize; i++) {
            System.out.println("theArray Index " + i);
            array[i].displayWordList();
        }
    }

    private int stringHashFunction(String wordToHash) {
        int hashKeyValue = 0;

        for (int i = 0; i<wordToHash.length(); i++) {
            int characterCode = wordToHash.charAt(i) - 96;
            int hashKeyValueTemp = hashKeyValue;
            hashKeyValue = (hashKeyValue * 27 + characterCode) % arraySize;

            System.out.println("Hash key value " + hashKeyValueTemp + " * 27 + CharacterCode " + characterCode + " % arraySize " + arraySize + " =" + hashKeyValue);

        }

        System.out.println();

        return hashKeyValue;
    }



    public static void main(String[] args) {
        HashFunction2 hashFunction = new HashFunction2(11);
        System.out.println(hashFunction.find("a"));
    }
}

@Data
class Word {

    private String word;
    private String definition;
    private int key;
    private Word next;

    Word(String word, String definition) {
        this.word = word;
        this.definition = definition;
    }

    @Override
    public String toString() {
        return word + " : " + definition;

    }
}

class WordList{
    private Word firstWord = null;

    void insert(Word newWord, int hashKey){
        Word previous = null;
        Word current = firstWord;
        newWord.setKey(hashKey);

        while(current != null && newWord.getKey() > current.getKey()){
            previous = current;
            current = current.getNext();
        }

        if(previous == null){
            firstWord = newWord;
        } else {
            previous.setNext(newWord);
            newWord.setNext(current);
        }
    }

    void displayWordList(){
        Word current = firstWord;
        while(current!= null){
            System.out.println(current);
            current = current.getNext();
        }
    }

    Word find (int hashKey, String wordToFind){
        Word current = firstWord;
        while(current!= null && current.getKey() <= hashKey){

            if(current.getWord().equals(wordToFind)){
                return current;
            }
            current = current.getNext();
        }

        return null;
    }


}