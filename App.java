// import java.util.Scanner;

// public class App {
//     public static void main(String[] args) {
//         // instantiating the object
//         Scanner userInputScanner = new Scanner(System.in);

//         // class obj
//         CaesarsCipher caesarsCipher = new CaesarsCipher();

//         // giving options to the user
//         System.out.println("WELCOME TO THE CAESAR'S CIPHER APPLICATION");
//         System.out.println("Choose the operation you would like to perform: \n1. Cipher/Encrypt text. \n2. Decipher/Decrypt text.");
//         int option = 0;
//         // catching the user exceptions
//         try {
//             option = Integer.parseInt(userInputScanner.next());
//         } catch (IllegalArgumentException e) {
//             // handle exception
//             System.out.println(e);
//         }
        
//         // evaluating the method based on the user input.
//         if(option == 1) {
//                 String message;
//                 int key;

//                 System.out.println("Enter the plain-text message.");
//                 message = userInputScanner.next();
//                 caesarsCipher.setMessage(message);

//                 System.out.println();
//                 System.out.println("Enter the key to encrypt.");
//                 key = Integer.parseInt(userInputScanner.next());
//                 caesarsCipher.setShift(key);

//                 // message="Hello World";
//                 // caesarsCipher.setMessage(message);
//                 // calling the cipher method
//                 String encryptedMsg = caesarsCipher.caesarCipher(caesarsCipher.getMessage(), caesarsCipher.getShift());
//                 // printing the encrypted msg
//                 System.out.println("The ciphered text is");
//                 System.out.println(encryptedMsg);
//         }else if(option == 2){
//                 System.out.println("Enter the encrypted message.");
//                 caesarsCipher.setMessage(userInputScanner.next());
//                 System.out.println("Enter the key to encrypt.(a ne)");
//                 caesarsCipher.setShift(Integer.parseInt(userInputScanner.next()));

//                 // calling the cipher method
//                 String decryptedMsg = caesarsCipher.caesarCipher(caesarsCipher.getMessage(), caesarsCipher.getShift());

//                 // printing the encrypted msg
//                 System.out.println(decryptedMsg);
//         }else{
//                 System.out.println("The option you entered is invalid.");
//         }
//     }
// }

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Get the plaintext message from the user
    System.out.print("Enter plaintext message: ");
    String plaintext = scanner.nextLine();

    // Get the key from the user
    System.out.print("Enter key (a positive integer): ");
    int key = scanner.nextInt();

    // Encrypt the plaintext using the Caesar cipher
    String ciphertext = encrypt(plaintext, key);

    // Output the encrypted message
    System.out.println("Encrypted message: " + ciphertext);
  }

  /**
   * Encrypts a plaintext message using the Caesar cipher with the given key.
   *
   * @param plaintext The plaintext message to encrypt.
   * @param key The key to use for the Caesar cipher.
   * @return The encrypted ciphertext.
   */
  public static String encrypt(String plaintext, int key) {
    // Create a new StringBuilder to hold the encrypted message
    StringBuilder ciphertext = new StringBuilder();

    // Loop through each character in the plaintext message
    for (int i = 0; i < plaintext.length(); i++) {
      char c = plaintext.charAt(i);

      // Check if the character is a letter
      if (Character.isLetter(c)) {
        // Get the ASCII code for the character
        int code = (int) c;

        // Shift the character by the key
        code = code + key;

        // Check if the character needs to be wrapped around to the beginning of the alphabet
        if (Character.isUpperCase(c) && code > (int) 'Z' || Character.isLowerCase(c) && code > (int) 'z') {
          code -= 26;
        }

        // Add the encrypted character to the ciphertext StringBuilder
        ciphertext.append((char) code);
      } else {
        // Add the non-letter character to the ciphertext StringBuilder
        ciphertext.append(c);
      }
    }

    // Return the encrypted ciphertext as a String
    return ciphertext.toString();
  }
}