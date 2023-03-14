
public static String caesarCipher(String text, int shift) {
    StringBuilder result = new StringBuilder();
    // loop through each character in the text
    for (char c : text.toCharArray()) {
        // if the character is an uppercase letter
        if (Character.isUpperCase(c)) {
            // shift the character by the shift amount
            char shiftedChar = (char) (((int) c + shift - 65) % 26 + 65);
            result.append(shiftedChar);
        // if the character is a lowercase letter
        } else if (Character.isLowerCase(c)) {
            // shift the character by the shift amount
            char shiftedChar = (char) (((int) c + shift - 97) % 26 + 97);
            result.append(shiftedChar);
        } else {
            // if the character is not a letter, append it to the result unchanged
            result.append(c);
        }
    }
    return result.toString();
}


// Ecrypting Method
String message = "HELLO WORLD";
String encryptedMessage = caesarCipher(message, 3);
System.out.println(encryptedMessage); // prints "KHOOR ZRUOG"

// Decryption Method
String decryptedMessage = caesarCipher(encryptedMessage, -3);
System.out.println(decryptedMessage); // prints "HELLO WORLD"