package TextEngine;

import java.util.ArrayList;

/**
 * It includes all methods related to search.
 */
public interface Search extends Utilities {
    /**
     * It executes a binary search on a sorted method.
     * It executes even type of linear search after finding a word that match word variable value to be able to find amount of words that match it. "not on the entire content but until the checked word is not equals to word parameter value."
     * @param word a word that method looks for.
     * @param arrayUsedInSearch an string array list that could store the word.
     * @return -2 if array list is null OR -1 if it is empty OR 0 if the word is not exist OR larger number that refer to amount of words that is equals with the passed word.
     */
    default int binary(String word, ArrayList<String> arrayUsedInSearch){
        //In case arrayUsedInSearch is null
        if (arrayUsedInSearch == null){
            return -2;
        }else if (arrayUsedInSearch.size() == 0){ //In case arrayUsedInSearch is empty.
            return -1;
        }
        // Arranging the range that will be focused during search.
        int first = 0;
        int last = arrayUsedInSearch.size()-1;
        int middle = (first + last)/2;
        while (last >= first){
            //Checks the word we are looking for in the arrayList
            if (arrayUsedInSearch.get(middle).equals(word)){
                //Checks from the middle to the last word in the arrayList
                for (int i = middle; i <= last;i++){
                    if(!arrayUsedInSearch.get(i).equals(word)){
                        last = --i;
                        break;
                    }
                }
                // Checks from the middle to the first word in the arrayList
                for (int i = middle; i >= first; i--){
                    if (!arrayUsedInSearch.get(i).equals(word)){
                        first = ++i;
                        break;
                    }
                }
                // returning amount found words.
                return (last - first) + 1;
            }if (isXBeforeY(word,arrayUsedInSearch.get(middle))){           // Rearranging the the right edge of the focused area of the array in case word value should be before.
                last = middle-1;
            }else {                                                         // Rearranging the the left edge of the focused area of the array in case word value should be before.
                first = middle+1;
            }
            // Recalculate the middle index.
            middle = (last + first)/2;
        }
        return 0;
    }

    /**
     * It execute a linear search on a arrayList.
     * @param word a word that method looks for.
     * @param arrayUsedInSearch an string array list that could store the word.
     * @return -2 if array list is null OR -1 if it is empty OR 0 if the word is not exist OR larger number that refer to amount of words that is equals with the passed word.
     */
    default int linear(String word,ArrayList<String> arrayUsedInSearch){
        // In case arrayUsedInSearch is null
        if (arrayUsedInSearch == null ){
            return -2;
        }else if(arrayUsedInSearch.size() == 0){ // In case arrayUsedInSearch is empty.
            return -1;
        }
        // start counting.
        int found = 0;
        for (String usedInSearch : arrayUsedInSearch) {
            if (usedInSearch.equals(word)) {
                found++;
            }
        }
        return found;
    }
}