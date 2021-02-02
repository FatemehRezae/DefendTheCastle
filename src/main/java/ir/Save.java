package ir;

import java.io.*;
import java.util.Scanner;

public class Save {

    private String score ;
    private Writer wr;

        public void save(String string) {
            score = string;
            try {
                wr = new FileWriter("Score.txt");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            try {
                wr.write(String.valueOf(score));
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                wr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        public void load(){

            File file = new File("Score.txt");
            Scanner sc = null;
            try {
                sc = new Scanner(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            while (true) {
                assert sc != null;
                if (!sc.hasNextLine()) break;
                System.out.println(sc.nextLine());
            }
        }
}