package com.csc;

import java.util.ArrayList;

public class FuzzyFinder {
  
  public int linearSearch(ArrayList<Fuzzy> array){
    for(int i = 0; i < array.size(); i++){
      if(array.get(i).color.equals("gold")){
        return i;
      }
    }

    return -1; // return -1 if not found
  }

  public int binarySearch(ArrayList<Fuzzy> array){
    int l = 0;
    int r = array.size() - 1;

    while (l <= r){
      int m = l + (r - l) / 2; // "splitting" array
      int compare = array.get(m).color.compareTo("gold"); // checking to see if middle is gold fuzzy

      if(compare == 0){
        return m; 
      }
      else if (compare < 0){
        l = m + 1; // lessen bounds to 2nd half of split
      }
      else{
        r = m - 1; // lessen bounds to 1st half of split
      }
    }

    return -1;
  }


  public static void main(String args[]) {
    System.out.println("In addition to your search functions, you can write a main function if you wish!");
  }
}
