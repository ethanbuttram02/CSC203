package LinkedListCode;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileReader {

    private String fileName;
    private Scanner scanner;

    public FileReader(String fileName){
        this.fileName = fileName;
    try {
        scanner = new Scanner(new File(fileName));
    }  catch (IOException e) {
            System.err.println("Issue opening file " + e.getMessage());
        }
    }


}



