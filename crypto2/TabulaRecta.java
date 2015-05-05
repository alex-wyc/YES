import java.util.*;

public class TabulaRecta {
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

    public TabulaRecta(String s) {
        genBoard();
        plaintext = s;
        for (int i = 0 ; i < 26 ; i++) {
            for (int j = 0 ; j < 26 ; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public String encrypt() {
        StringBuilder cipherText = new StringBuilder();
        char[] plainArray = plaintext.toCharArray();
        System.out.println(Arrays.toString(plainArray));
        for (int i = 0 ; i < plainArray.length ; i++) {
            cipherText.append(board[(i + 1) % board.length][indexOf(board[0], plainArray[i])]);
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
        TabulaRecta tr1 = new TabulaRecta("hello");
        System.out.println(tr1.encrypt());
    }
}

