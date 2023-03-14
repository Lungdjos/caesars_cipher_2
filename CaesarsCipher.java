
public class CaesarsCipher{
    // class attributes
    private String message;
    private int shift;

    // getters and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

    // method that ciphers and deciphers the text
    public String caesarCipher(String message, int shift) {
        // initializing the class attributes
        this.message = message;
        this.shift = shift;
        StringBuilder result = new StringBuilder();
        // loop through each character in the text
        for (char c : message.toCharArray()) {
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

}