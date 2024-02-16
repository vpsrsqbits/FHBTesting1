package org.frenbenhealth;

import java.io.*;

public class UserIncrement {
    public String filePath = "src/main/resources/UserCount"; // Specify the path to your file
    public int readFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            return Integer.parseInt(line.trim());
        } catch (IOException e) {
            e.printStackTrace();
            return 0; // Default value if reading fails
        }
    }
    public void writeToFile(String filePath, int number) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(Integer.toString(number)); // Write the updated number as a string
            System.out.println("Number incremented and written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}