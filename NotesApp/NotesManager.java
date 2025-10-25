import java.io.*;
import java.util.Scanner;

public class NotesManager {
    private static final String FILE_NAME = "notes.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Notes Manager =====");
            System.out.println("1. Write a new note");
            System.out.println("2. Read all notes");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    writeNote(sc);
                    break;
                case 2:
                    readNotes();
                    break;
                case 3:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 3);

        sc.close();
    }

    private static void writeNote(Scanner sc) {
        System.out.print("Enter your note: ");
        String note = sc.nextLine();

        FileWriter fw = null;
        try {
            fw = new FileWriter(FILE_NAME, true); // append mode
            fw.write(note + "\n");
            System.out.println("Note saved successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        } finally {
            if (fw != null) {
                try { fw.close(); } catch (IOException e) {}
            }
        }
    }

    private static void readNotes() {
        System.out.println("\n===== Saved Notes =====");

        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(FILE_NAME);
            br = new BufferedReader(fr);

            String line;
            boolean isEmpty = true;
            while ((line = br.readLine()) != null) {
                System.out.println("- " + line);
                isEmpty = false;
            }

            if (isEmpty) {
                System.out.println("(No notes found)");
            }
        } catch (FileNotFoundException e) {
            System.out.println("No notes file found. Write a note first!");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } finally {
            if (br != null) {
                try { br.close(); } catch (IOException e) {}
            }
            if (fr != null) {
                try { fr.close(); } catch (IOException e) {}
            }
        }
    }
}
