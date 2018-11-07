package cube_disassembly;

import java.util.Scanner;

public class Filling_in {
    public static void Filling_in(int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, Scanner sc){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                blue[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                orange[i][j] = sc.nextInt();
            }
            for (int j = 0; j < 3; j++) {
                white[i][j] = sc.nextInt();
            }
            for (int j = 0; j < 3; j++) {
                rad[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                green[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                yellow[i][j] = sc.nextInt();
            }
        }
    }
}
