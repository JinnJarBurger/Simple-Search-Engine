package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try {
            SearchEngine se;
            Scanner sc = new Scanner(new File(args[1]));
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
