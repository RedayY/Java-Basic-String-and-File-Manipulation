/*
 * ----------------------------
 * Reday Ahmad Yahya
 * Student ID: M00531154
 * E-Mail: ry106@live.mdx.ac.uk
 * ----------------------------
 */

// Task 3

//Import 
//import java.util.Scanner;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Task3 {
    
    
    public static void main(String[] args) throws Exception
    {
        //scanner input = new Scanner(System.in);
        
        //creade Fileobjects for reading and writing and also creating a buffered reader object
        File newFile = new File("output.txt");
        FileReader file = new FileReader("sonnet3.txt");
        BufferedReader reader = new BufferedReader(file);
        
        // WRITING OOUTPUT TO FILE
     
        newFile.createNewFile();
     
        //Writing Objects
        FileWriter fileW = new FileWriter(newFile);
        BufferedWriter buffW = new BufferedWriter(fileW);
        
        //some variables for my string
        String beta = "";
        String line = reader.readLine();
        
        
        //building my string using buffered reader.
        while(line != null){
            String spacer = " ";
            beta += spacer += line;
            line = reader.readLine();
        }
        
        //closing both files
        reader.close();
        
        //removing certain symbols from string and storing it into new string
         String alpha = beta.replaceAll("([a-z]+)[?:!.,;]*", "$1");
         String text = alpha.replaceAll("\\p{P}" , "");
        
        
        
        // Output

        System.out.printf("A)");
        System.out.printf("%n");
        System.out.println("File analysed: sonnet3.txt");
        System.out.println("There were " + count_words(text) + " words and " + count_char(text) + " letters");
        System.out.println("There were " + even_word_count(text) + " even  words, and " + odd_word_count(text) + " odd words");
        System.out.printf("%n");
        
        //Output Storage
        buffW.write("Reday Yahya | M00531154 Task 2 Console Ooutput");
        buffW.newLine();
        buffW.newLine();
        buffW.write("A)");
        buffW.newLine();
        buffW.write("File analysed: sonnet1-a.txt");
        buffW.newLine();
        buffW.write("There were " + count_words(text) + " words and " + count_char(text) + " letters");
        buffW.newLine();
        buffW.write("There were " + even_word_count(text) + " even  words, and " + odd_word_count(text) + " odd words");
        buffW.newLine();

        
        
       //Sanitizing ' 
       String text_no_apos = text.replaceAll("'", "");
       
       
       
       //getting words and storing it into an array
       String upper_case_text = text_no_apos.toUpperCase();
       
       //store words into array
       String[] uc_word_array = upper_case_text.split(" ");
       
   
       
       //declaring even and uneven arraylist
       //Evenwordarray
       ArrayList<String> even_word_array = new ArrayList<String>();
       
       //UNevenwordarray
       ArrayList<String> uneven_word_array = new ArrayList<String>();
       
     //Storing into the arraylist 
     for (int i = 0; i < uc_word_array.length; i++){
         
           int jackson = uc_word_array[i].length() ;
           if (jackson % 2 == 0){
                 even_word_array.add(uc_word_array[i]);
           }
           else if (jackson %2 != 0) {
               uneven_word_array.add(uc_word_array[i]);
           }
        }
     
     // combining array list for..... word count
     ArrayList<String> Word_Array_list = new ArrayList<String>();
     Word_Array_list.addAll(uneven_word_array);
     Word_Array_list.addAll(even_word_array);
     Collections.sort(Word_Array_list);
     ArrayList<String> cheat_array = new ArrayList<String>();
     
     //hashset to get word count
     
     Set<String> wordcount = new HashSet<String>(Word_Array_list);
        for (String key : wordcount) {
        System.out.println(key + ": " + Collections.frequency(Word_Array_list, key));
        buffW.write(key + ": " + Collections.frequency(Word_Array_list, key));
        buffW.newLine();
        int temp_val = Collections.frequency(Word_Array_list, key);
        
        if(temp_val >= 4){
            cheat_array.add(key);
        }
        else {}
        
        }
        
        buffW.newLine();
        buffW.write("Words with more than 4 repeats");
        buffW.newLine();
        
        
        System.out.printf("%n");
        System.out.println("Words with more than 4 repeats");
        System.out.printf("%n");
     
        //Output Cheat Array ( If word repeats more than or equal )
        for (int i = 0; i < cheat_array.size(); i++){
            System.out.println(cheat_array.get(i));
            buffW.write(cheat_array.get(i));
            buffW.newLine();
        }
        
        System.out.printf("%n");
    //Cleaning and Sorting Even words array
    Set<String> hs_even = new HashSet<>();
        hs_even.addAll(even_word_array);
        even_word_array.clear();
        even_word_array.addAll(hs_even);
        Collections.sort(even_word_array);
     
    //Cleaning and Sorting Uneven Words Array
     Set<String> hs_uneven = new HashSet<>();
        hs_uneven.addAll(uneven_word_array);
        uneven_word_array.clear();
        uneven_word_array.addAll(hs_uneven);
        Collections.sort(uneven_word_array);

     System.out.println("Even Word Array:");
     System.out.printf("%n");
     
     //storage
     buffW.newLine();
     buffW.write("Even Word Array:");
     buffW.newLine();
     
     //Output Even word Array
     
     for (int i = 0; i < even_word_array.size(); i++){
         System.out.println(even_word_array.get(i));
         buffW.write(even_word_array.get(i));
         buffW.newLine();
          
     }

     System.out.printf("%n");
     System.out.println("Uneven Word Array:");
     System.out.printf("%n");
     
     //Storage bit
     buffW.newLine();
     buffW.write("Uneven Word Array:");
     buffW.newLine();
     
     
     //output uneven word array
     for (int i = 0; i < uneven_word_array.size(); i++){
         System.out.println(uneven_word_array.get(i));
         buffW.write(even_word_array.get(i));
         buffW.newLine();
     }
     
     System.out.printf("%n");
     
     buffW.newLine();
     file.close();
     buffW.close();
     
     System.out.println("File has been overwritten. Please check the output file in the root folder for console out");
 
    }
    
 
    

     public static int even_word_count(String str){
        
        String[] words_array = str.split(" ");

        int evenword_counter = 0;
        
        for (int j = 0; j < words_array.length; j++){
           int jackson = words_array[j].length() ;
           if (jackson % 2 == 0){
               ++evenword_counter;  
           }
        }
        return evenword_counter;
         
    }   
    
    
    
    public static int odd_word_count(String str){
        
        String[] words_array = str.split(" ");
        int strl_array = words_array.length;
        int oddword_counter = 0;
        
        for (int j = 0; j < words_array.length; j++){
           int jackson = words_array[j].length() ;
           if (jackson % 2 != 0){
               ++oddword_counter;
               
           }
        }
        return oddword_counter;
    }        
    
    public static int count_words(String str){
        StringTokenizer stringTok = new StringTokenizer(str);
        
        return stringTok.countTokens();
    }
    
    public static int count_char(String str){
        
        String no_spaces_str = str.replaceAll(" ", "");
        int string_len_count = no_spaces_str.length();
        
        return string_len_count;
    }
}
 
