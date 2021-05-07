package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try {
            SearchEngine se;
            // the bottom line is used when the file location and name is given as a second argument through command
            // line. If the input file needs to be mentioned directly then uncomment the second Scanner instance.
            Scanner sc = new Scanner(new File(args[1]));
            // Scanner sc = new Scanner(new File("File_Path\\inputFile.txt"));
            ArrayList<String> list = new ArrayList<>();
            while (sc.hasNext()) {
                list.add(sc.nextLine());
            }
            sc.close();
            se = new SearchEngine(list);
            se.run();
        } catch (FileNotFoundException e) {
            System.out.println("No such file found");
        }
    }
}
