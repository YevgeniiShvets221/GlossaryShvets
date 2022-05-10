package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.Map.Entry;



public class Main {

    private static TreeMap<Object, Object> sortedTextSegmentList;

    public static void main(String[] args, Object Comparator) throws IOException {

        String content = new String( Files.readAllBytes( Paths.get( "C://Users//Asus//Desktop//kohonen-oct//harry..txt" ) ) );
        content = content.toLowerCase( Locale.ROOT ).replaceAll( " [ ^A-Za-z]", "" );

        content = content.replaceAll( "\\p{P}", "" ); // replace all punctuations
        content = content.toLowerCase();
        String[] wordArr = content.split( " " ); // create list of words

        Map<String, Integer> wordCount = new TreeMap<>();

        // Collect the word count
        for (String word : wordArr) {
            if (!wordCount.containsKey( word )) {
                wordCount.put( word, 1 );
            } else {
                int count = wordCount.get( word );
                wordCount.put( word, count + 1 );
            }
        }

        Iterator<Entry<String, Integer>> iter = wordCount.entrySet().iterator();

        while (iter.hasNext()) {
            Entry<String, Integer> entry = iter.next();
            System.out.println( entry.getKey() + ": " + entry.getValue() );
        }

        List<Entry<Object, Object>> toSort = new ArrayList<>();
        for (Entry<Object, Object> objectObjectEntry : sortedTextSegmentList.entrySet()) {
            toSort.add( objectObjectEntry );
        }

        toSort.sort( Entry.<Object, Object>comparingByValue( getComparator( Comparator ) < T > Collections.reverseOrder() ) );
        LinkedHashMap<Object, Object> map = new LinkedHashMap<>();
        for (Entry<Object, Object> objectObjectEntry : toSort) {
            map.merge( objectObjectEntry.getKey(), objectObjectEntry.getValue(), (x, y) -> {
                throw new AssertionError();
            } );
        }
        class KFrequentNumbers {
            static void print_N_mostFrequentNumber(int[] arr, int n , int k) {

                Map<Integer, Integer> mp = new HashMap<Integer, Integer>();

                for (int i = 0; i < n; i++) {

                    mp.put( arr[i],
                            mp.getOrDefault( arr[i], 0 ) + 1 );
                }

                // Create a list from elements of HashMap
                List<Entry<Integer, Integer>> list = new ArrayList<Entry<Integer, Integer>>(
                        mp.entrySet() );

                // Sort the list
                Collections.sort( list, new Comparator<Entry<Integer, Integer>>() {
                    public int compare(
                            Entry<Integer, Integer> o1,
                            Entry<Integer, Integer> o2) {
                        if (o1.getValue() == o2.getValue())
                            return o2.getKey() - o1.getKey();
                        else
                            return o2.getValue()
                                    - o1.getValue();
                    }
                } );

                for (int i = 0; i < k; i++)
                    System.out.println( list.get( i ).getKey() );
            }


            public static void main(String[] args) {
                int arr[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
                int n = arr.length;
                int k = 2;

                print_N_mostFrequentNumber( arr, n, k );
            }


            private static Object getComparator(Object Comparator) {
                return Comparator;
            }
        }

        HashSet<String> lowercaseWords = new HashSet<>();
        HashMap<String,String> lowerToCap = new HashMap<>();


        String[] allWords = null;
        for(String word: allWords) {
            if (Character.isUpperCase(word.charAt(0))){
                lowerToCap.put(word.toLowerCase(),word);
            }
            else {
                lowercaseWords.add(word.toLowerCase( Locale.ROOT ));
            }
        }

//remove all the words that we've found as capitalized, only proper nouns will be left
        lowercaseWords.removeAll(lowerToCap.keySet());
        for(String properNounLower:lowercaseWords) {
            System.out.println("Proper Noun: "+ lowerToCap.get(properNounLower));
        }
        int n = 4;

        String names[] = allWords;
        String temp;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                if (names[i].compareTo(names[j]) > 0) {
                    temp = names[i];
                    names[i] = names[j];
                    names[j] = temp;
                }
            }
        }

        // print output array
        System.out.println( "The names in alphabetical order are: ");
        for (int i = 0; i < n; i++) {
            System.out.println(names[i]);
        }


        try
        {
            String filename= "C://Users//Asus//Desktop//kohonen-oct//harry..txt";
            FileWriter fw = new FileWriter(filename,true); //the true will append the new data
            FileWriter writer = new FileWriter("Shvets", true);
            writer.write(content);
            fw.write("add a line/n");//appends the string to the file
            fw.write( String.valueOf(names));
            fw.write( String.valueOf(wordArr));
            fw.close();
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }

    }

    private static Object getComparator(Object comparator) {
        return comparator;
    }
}