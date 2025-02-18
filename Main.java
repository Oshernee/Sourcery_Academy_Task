import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> compress = new ArrayList<>(Arrays.asList(
            "aaaaaaaaaaaaabbcddd",
            "aaabb",
            "abc",
            ""
        ));
        
        List<String> decompress = new ArrayList<>(Arrays.asList(
            "a13b2c1d3",
            "a1b1c1",
            "a3b2",
            ""
        ));
        
        compressString(compress);
        decompressString(decompress);

        for (String s : compress) {
            System.out.println("Compressed - " + s);
        }

        for (String s : decompress) {
            System.out.println("Decompressed - " + s);
        }
    }

    // As we already have example data, we start off from a for loop to go through each string in the list
    // Then we create a StringBuilder object as when making a lot of changes to a string, it is better to use a StringBuilder object as Strings are immutable
    // And can get expensive when making a lot of changes, we then create a variable i to keep track of the current index
    // We then start a while loop to go through the string, we get the current character at index i and store it in currentChar
    // We then create a variable count to keep track of the number of times the current character appears and start another while loop
    // Which checks if the current character is the same as the character before it, if it is we increment count and continue
    // After the while loop ends, we append the current character and the count to the StringBuilder object
    // We then set the current string in the list to the StringBuilder object
    public static void compressString(List<String> data) {
        for (int index = 0; index < data.size(); index++) {
            String s = data.get(index);
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < s.length()) {
                char currentChar = s.charAt(i);
                int count = 0;
                while (i < s.length() && s.charAt(i) == currentChar) {
                    count++;
                    i++;
                }
                sb.append(currentChar).append(count);
            }
            data.set(index, sb.toString());
        }
    }

    // As we already have example data, we start off from a for loop to go through each string in the list
    // We get the string and then we create a StringBuilder object, we then start a for loop to go through each character in the string
    // We get the current character and the count, and then we go through a while loop to check if the current character is a digit
    // If it is we multiply the count by 10 and add the current digit to it, we then create a char array and fill it with the current character count times
    // We then append the char array to the StringBuilder object, and set the current string in the list to the StringBuilder object
    public static void decompressString(List<String> data) {
        for (int index = 0; index < data.size(); index++) {
            String s = data.get(index);
            StringBuilder sb = new StringBuilder(s.length());
            for (int i = 0; i < s.length(); ) {
                char c = s.charAt(i++);
                int count = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    count = count * 10 + (s.charAt(i++) - '0');
                }
                char[] repeated = new char[count];
                Arrays.fill(repeated, c);
                sb.append(repeated);
            }
            data.set(index, sb.toString());
        }
    }    
}
