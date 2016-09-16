import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Chelsea on 4/28/2016.
 */

public class PasswordCrack {
    public static final int ASCII_START = 33;
    public static final int ASCII_END = 126;
    public static ArrayList<String> passwords;
    public static ArrayList<String> salts;
    public static ArrayList<String> users;
    public static jcrypt e;
    public static long startTime;

    public static void main(String[] args){
        startTime = System.currentTimeMillis();
        String inputFile1 = args[0];
        String inputFile2 = args[1];
        //do one word at a time, then check against all encrypted passwords
        e = new jcrypt();
        passwords = new ArrayList<String>();
        salts = new ArrayList<String>();
        users = new ArrayList<String>();
        //read passwords file
        Scanner pwd;
        try{
            pwd = new Scanner(new File(inputFile2));
        }
        catch(FileNotFoundException e){
            System.out.println("Password file not found.");
            return;
        }
        while(pwd.hasNextLine()){
            //parse it...
            String line = pwd.nextLine();
            String[] parts = line.split(":");
            users.add(parts[0]);
            passwords.add(parts[1]);
            salts.add(parts[1].substring(0,2));
            String first = parts[4].split(" ")[0];
            String last = parts[4].split(" ")[1];
            mangle(first);
            mangle(last);
        }
        Scanner dictionary;
        //get word
        try {
            dictionary = new Scanner(new File(inputFile1));
        }
        catch(FileNotFoundException e){
            System.out.println("Dictionary file not found.");
            return;
        }
        while(dictionary.hasNextLine()){
            String word = dictionary.nextLine();
            mangle(word);
        }

        //now do it again for append/prepend
        try {
            dictionary = new Scanner(new File(inputFile1));
        }
        catch(FileNotFoundException e){
            System.out.println("Dictionary file not found.");
            return;
        }
        while(dictionary.hasNextLine()){
            String word = dictionary.nextLine();
            mangleAP(word);
        }
        //now do it again for second mangle
        //now do it again for append/prepend
        try {
            dictionary = new Scanner(new File(inputFile1));
        }
        catch(FileNotFoundException e){
            System.out.println("Dictionary file not found.");
            return;
        }
        while(dictionary.hasNextLine()){
            String word = dictionary.nextLine();
            mangle2(word);
        }

    }

    public static int mangleAP(String word){
        int index = -1;
        for(int i = ASCII_START; i <= ASCII_END; i++){
            index = checkPasswords(prepend(word, (char) i));
            //im sorry this is incredibly ugly code but i'm too tired to make it better
            if(index > -1){
                System.out.println("Found password: " + prepend(word, (char) i));
                System.out.println("For user: " + users.get(index));
                System.out.println("In " + (System.currentTimeMillis() - startTime) / 1000 + " seconds\n");
                passwords.remove(index);
                salts.remove(index);
                users.remove(index);
                return index;
            }
            index = checkPasswords(append(word, (char) i));
            if(index > -1){
                System.out.println("Found password: " + append(word, (char) i));
                System.out.println("For user: " + users.get(index));
                System.out.println("In " + (System.currentTimeMillis() - startTime) / 1000 + " seconds\n");
                passwords.remove(index);
                salts.remove(index);
                users.remove(index);
                return index;
            }
        }
        return index;
    }

    public static int mangle(String word){
        int index = -1;
        index = checkPasswords(word);
        if(index > -1){
            System.out.println("Found password: " + word);
            System.out.println("For user: " + users.get(index));
            System.out.println("In " + (System.currentTimeMillis() - startTime) / 1000 + " seconds\n");
            passwords.remove(index);
            salts.remove(index);
            users.remove(index);
            return index;
        }
        //deleteFirst
        index = checkPasswords(deleteFirst(word));
        if(index > -1){
            System.out.println("Found password: " + deleteFirst(word));
            System.out.println("For user: " + users.get(index));
            System.out.println("In " + (System.currentTimeMillis() - startTime) / 1000 + " seconds\n");
            passwords.remove(index);
            salts.remove(index);
            users.remove(index);
            return index;
        }

        //deleteLast
        index = checkPasswords(deleteLast(word));
        if(index > -1){
            System.out.println("Found password: " + deleteLast(word));
            System.out.println("For user: " + users.get(index));
            System.out.println("In " + (System.currentTimeMillis() - startTime) / 1000 + " seconds\n");
            passwords.remove(index);
            salts.remove(index);
            users.remove(index);
            return index;
        }

        //reverse
        index = checkPasswords(reverse(word));
        if(index > -1){
            System.out.println("Found password: " + reverse(word));
            System.out.println("For user: " + users.get(index));
            System.out.println("In " + (System.currentTimeMillis() - startTime) / 1000 + " seconds\n");
            passwords.remove(index);
            salts.remove(index);
            users.remove(index);
            return index;
        }

        //duplicate
        //IM SORRY THIS CODE IS SO TERRIBLE
        index = checkPasswords(duplicate(word));
        if(index > -1){
            System.out.println("Found password: " + duplicate(word));
            System.out.println("For user: " + users.get(index));
            System.out.println("In " + (System.currentTimeMillis() - startTime) / 1000 + " seconds\n");
            passwords.remove(index);
            salts.remove(index);
            users.remove(index);
            return index;
        }

        //reflect1
        index = checkPasswords(reflect1(word));
        if(index > -1){
            System.out.println("Found password: " + reflect1(word));
            System.out.println("For user: " + users.get(index));
            System.out.println("In " + (System.currentTimeMillis() - startTime) / 1000 + " seconds\n");
            passwords.remove(index);
            salts.remove(index);
            users.remove(index);
            return index;
        }

        //reflect2
        index = checkPasswords(reflect2(word));
        if(index > -1){
            System.out.println("Found password: " + reflect2(word));
            System.out.println("For user: " + users.get(index));
            System.out.println("In " + (System.currentTimeMillis() - startTime) / 1000 + " seconds\n");
            passwords.remove(index);
            salts.remove(index);
            users.remove(index);
            return index;
        }

        //uppercase
        index = checkPasswords(uppercase(word));
        if(index > -1){
            System.out.println("Found password: " + uppercase(word));
            System.out.println("For user: " + users.get(index));
            System.out.println("In " + (System.currentTimeMillis() - startTime) / 1000 + " seconds\n");
            passwords.remove(index);
            salts.remove(index);
            users.remove(index);
            return index;
        }

        //lowercase
        index = checkPasswords(lowercase(word));
        if(index > -1){
            System.out.println("Found password: " + lowercase(word));
            System.out.println("For user: " + users.get(index));
            System.out.println("In " + (System.currentTimeMillis() - startTime) / 1000 + " seconds\n");
            passwords.remove(index);
            salts.remove(index);
            users.remove(index);
            return index;
        }

        //capitalize
        index = checkPasswords(capitalize(word));
        if(index > -1){
            System.out.println("Found password: " + capitalize(word));
            System.out.println("For user: " + users.get(index));
            System.out.println("In " + (System.currentTimeMillis() - startTime) / 1000 + " seconds\n");
            passwords.remove(index);
            salts.remove(index);
            users.remove(index);
            return index;
        }

        //ncapitalize
        index = checkPasswords(ncapitalize(word));
        if(index > -1){
            System.out.println("Found password: " + ncapitalize(word));
            System.out.println("For user: " + users.get(index));
            System.out.println("In " + (System.currentTimeMillis() - startTime) / 1000 + " seconds\n");
            passwords.remove(index);
            salts.remove(index);
            users.remove(index);
            return index;
        }

        //toggle1
        index = checkPasswords(toggle1(word));
        if(index > -1){
            System.out.println("Found password: " + toggle1(word));
            System.out.println("For user: " + users.get(index));
            System.out.println("In " + (System.currentTimeMillis() - startTime) / 1000 + " seconds\n");
            passwords.remove(index);
            salts.remove(index);
            users.remove(index);
            return index;
        }

        //toggle2
        index = checkPasswords(toggle2(word));
        if(index > -1){
            System.out.println("Found password: " + toggle2(word));
            System.out.println("For user: " + users.get(index));
            System.out.println("In " + (System.currentTimeMillis() - startTime) / 1000 + " seconds\n");
            passwords.remove(index);
            salts.remove(index);
            users.remove(index);
            return index;
        }

        return index;
    }

    public static int mangle2(String word){
        int index = -1;
        //deleteFirst
            index = mangle(deleteFirst(word));
            if (index > -1)
                return index;

        //deleteLast
            index = mangle(deleteLast(word));
            if (index > -1)
                return index;

        //reverse
            index = mangle(reverse(word));
            if (index > -1)
                return index;

        //duplicate
            index = mangle(duplicate(word));
            if (index > -1)
                return index;

        //reflect1
            index = mangle(reflect1(word));
            if (index > -1)
                return index;

        //reflect2
            index = mangle(reflect2(word));
            if (index > -1)
                return index;

        //uppercase
            index = mangle(uppercase(word));
            if (index > -1)
                return index;

        //lowercase
            index = mangle(lowercase(word));
            if (index > -1)
                return index;

        //capitalize
            index = mangle(capitalize(word));
            if (index > -1)
                return index;

        //ncapitalize
            index = mangle(ncapitalize(word));
            if (index > -1)
                return index;

        //toggle1
            index = mangle(toggle1(word));
            if (index > -1)
                return index;

        //toggle2
            index = mangle(toggle2(word));
            if (index > -1)
                return index;

        return index;
    }


    public static int checkPasswords(String testString){
        int index = -1;
        //return index in array of matching password
        for(int i = 0; i < passwords.size(); i++) {
            String salt = salts.get(i);
            String encryptedTest = e.crypt(salt, testString);
            if (encryptedTest.equals(passwords.get(i))) {
                index = i;
                return index;
            }
        }
        return index;
    }

    public static String prepend(String s, char c){
        return Character.toString(c).concat(s);
    }

    public static String append(String s, char c){
        return s.concat(Character.toString(c));
    }

    public static String deleteFirst(String s){
        return s.substring(1);
    }

    public static String deleteLast(String s){
        return s.substring(0, s.length() - 1);
    }

    public static String reverse(String s){
        String r = "";
        for(int i = s.length() - 1; i >= 0; i--){
            r = r.concat(Character.toString(s.charAt(i)));
        }
        return r;
    }

    public static String duplicate(String s){
        return s.concat(s);
    }
    public static String reflect1(String s){
        return s.concat(reverse(s));
    }

    public static String reflect2(String s){
        return reverse(s).concat(s);
    }

    public static String uppercase(String s){
        return s.toUpperCase();
    }

    public static String lowercase(String s){
        return s.toLowerCase();
    }

    public static String capitalize(String s){
        return Character.toString(s.toUpperCase().charAt(0)).concat(deleteFirst(s));
    }

    public static String ncapitalize(String s){
        return Character.toString(s.toLowerCase().charAt(0)).concat(deleteFirst(s).toUpperCase());
    }

    public static String toggle1(String s){
        String r = "";
        for(int i = 0; i < s.length(); i++){
            if(i % 2 == 0){
                r = r.concat(Character.toString(s.charAt(i)).toUpperCase());
            }
            else
                r = r.concat(Character.toString(s.charAt(i)).toLowerCase());
        }
        return r;
    }

    public static String toggle2(String s){
        String r = "";
        for(int i = 0; i < s.length(); i++){
            if(i % 2 == 1){
                r = r.concat(Character.toString(s.charAt(i)).toUpperCase());
            }
            else
                r = r.concat(Character.toString(s.charAt(i)).toLowerCase());
        }
        return r;
    }

}
