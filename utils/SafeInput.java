package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SafeInput {
    private Scanner scan;
    
    public SafeInput() {
        this.scan = new Scanner(System.in);
    }
    
    public int readInt() { //Read a int safely.
        while (true) {
            try {
                int value = scan.nextInt();
                scan.nextLine(); // cleans buffer
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Error: Enter a valid integer!");
                scan.nextLine(); // cleans buffer
            }
        }
    }
    
    public void close() {
        scan.close();
    }
}
