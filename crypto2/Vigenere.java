import java.util.*;

public class Vigenere {
    private char[][] board;
    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private String plaintext;

    private void genBoard() {
        board = new char[alphabet.length()][alphabet.length()];
        for (int i = 0 ; i < alphabet.length() ; i++) {
            for (int j = 0 ; j < alphabet.length() ; j++) {
                board[i][j] = alphabet.charAt((j + i) % 26);
            }
        }
    }

    public Vigenere(String s) {
        genBoard();
        plaintext = s;
        for (int i = 0 ; i < 26 ; i++) {
            for (int j = 0 ; j < 26 ; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public String encrypt(String key) {
        StringBuilder cipherText = new StringBuilder();
        char[] plainArray = plaintext.toCharArray();
        char[] keyArray = key.toCharArray();
        for (int i = 0 ; i < plainArray.length ; i++) {
            cipherText.append(board[(int)keyArray[i % keyArray.length] - 97][indexOf(board[0], plainArray[i])]);
        }
        return cipherText.toString();
    }

    public int indexOf(char[] arr, char el) {
        for (int i = 0 ; i < arr.length ; i++) {
            if (arr[i] == el) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Vigenere tr1 = new Vigenere("attacktomorrowatdawn");
        System.out.println(tr1.encrypt("master"));
    }
}

