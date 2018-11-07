package print;

import static print.RefactorScrambl.Scrambl;

public class Sout {
    public static void sout(int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        System.out.println(scrambl);
        System.out.println("Scrambl:");
        System.out.println(Scrambl(scrambl));
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.print("      ");
            for (int j = 0; j < 3; j++) {
                System.out.print(blue[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(orange[i][j] + " ");
            }
            for (int j = 0; j < 3; j++) {
                System.out.print(white[i][j] + " ");
            }
            for (int j = 0; j < 3; j++) {
                System.out.print(rad[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < 3; i++) {
            System.out.print("      ");
            for (int j = 0; j < 3; j++) {
                System.out.print(green[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < 3; i++) {
            System.out.print("      ");
            for (int j = 0; j < 3; j++) {
                System.out.print(yellow[i][j] + " ");
            }
            System.out.println();
        }
    }
}
