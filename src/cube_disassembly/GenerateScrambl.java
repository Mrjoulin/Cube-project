package cube_disassembly;

import Cube_project.Main;
import print.Sout;

public class GenerateScrambl{
     public static void GenerateScrambl(int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        Main main = new Main();
        //Собранный куб
        for (int k = 0; k < 6; k++) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (k == 0) white[i][j] = k;
                    if (k == 1) green[i][j] = k;
                    if (k == 2) yellow[i][j] = k;
                    if (k == 3) blue[i][j] = k;
                    if (k == 4) orange[i][j] = k;
                    if (k == 5) rad[i][j] = k;
                }
            }
        }
        //Рандомная разборка куба
        int lastNumber = 0;
        int counter = 1;
        for (int i = 0; i < 50; i++) {
            int randomNumber = (int) Math.round(Math.random() * 11);
            if (randomNumber == 0) {
                if (randomNumber == lastNumber && counter == 2){
                    i--;
                    continue;
                }else {
                    if (randomNumber == lastNumber){
                        main.U(white, green, blue, orange, rad, scrambl);
                        counter++;
                        lastNumber = 0;
                    }else {
                        main.U(white, green, blue, orange, rad, scrambl);
                        counter = 1;
                        lastNumber = 0;
                    }
                }
            }
            if (randomNumber == 1) {
                if(randomNumber == lastNumber - 1){
                    i--;
                    continue;
                }else {
                    if (randomNumber == lastNumber && counter == 2){
                        i--;
                        continue;
                    }else {
                        if (randomNumber == lastNumber){
                            main.Ux(white, green, blue, orange, rad, scrambl);
                            counter++;
                            lastNumber = 1;
                        }else {
                            main.Ux(white, green, blue, orange, rad, scrambl);
                            counter = 1;
                            lastNumber = 1;
                        }
                    }
                }
            }
            if (randomNumber == 2) {
                if(randomNumber == lastNumber + 1){
                    i--;
                    continue;
                }else {
                    if (randomNumber == lastNumber && counter == 2){
                        i--;
                        continue;
                    }else {
                        if (randomNumber == lastNumber){
                            main.F(green, yellow, white, orange, rad, scrambl);
                            counter++;
                            lastNumber = 2;
                        }else {
                            main.F(green, yellow, white, orange, rad, scrambl);
                            counter = 1;
                            lastNumber = 2;
                        }
                    }
                }
            }
            if (randomNumber == 3) {
                if(randomNumber == lastNumber - 1){
                    i--;
                    continue;
                }else {
                    if (randomNumber == lastNumber && counter == 2){
                        i--;
                        continue;
                    }else {
                        if (randomNumber == lastNumber){
                            main.Fx(green, yellow, white, orange, rad, scrambl);
                            counter++;
                            lastNumber = 3;
                        }else {
                            main.Fx(green, yellow, white, orange, rad, scrambl);
                            counter = 1;
                            lastNumber = 3;
                        }
                    }
                }
            }
            if (randomNumber == 4) {
                if(randomNumber == lastNumber + 1){
                    i--;
                    continue;
                }else {
                    if (randomNumber == lastNumber && counter == 2){
                        i--;
                        continue;
                    }else {
                        if (randomNumber == lastNumber){
                            main.R(rad, yellow, white, green, blue, scrambl);
                            counter++;
                            lastNumber = 4;
                        }else {
                            main.R(rad, yellow, white, green, blue, scrambl);
                            counter = 1;
                            lastNumber = 4;
                        }
                    }
                }
            }
            if (randomNumber == 5) {
                if(randomNumber == lastNumber - 1){
                    i--;
                    continue;
                }else {
                    if (randomNumber == lastNumber && counter == 2){
                        i--;
                        continue;
                    }else {
                        if (randomNumber == lastNumber){
                            main.Rx(rad, yellow, white, green, blue, scrambl);
                            counter++;
                            lastNumber = 5;
                        }else {
                            main.Rx(rad, yellow, white, green, blue, scrambl);
                            counter = 1;
                            lastNumber = 5;
                        }
                    }
                }
            }
            if (randomNumber == 6) {
                if(randomNumber == lastNumber + 1){
                    i--;
                    continue;
                }else {
                    if (randomNumber == lastNumber && counter == 2){
                        i--;
                        continue;
                    }else {
                        if (randomNumber == lastNumber){
                            main.L(orange, yellow, white, blue, green, scrambl);
                            counter++;
                            lastNumber = 6;
                        }else {
                            main.L(orange, yellow, white, blue, green, scrambl);
                            counter = 1;
                            lastNumber = 6;
                        }
                    }
                }
            }
            if (randomNumber == 7) {
                if(randomNumber == lastNumber - 1){
                    i--;
                    continue;
                }else {
                    if (randomNumber == lastNumber && counter == 2){
                        i--;
                        continue;
                    }else {
                        if (randomNumber == lastNumber){
                            main.Lx(orange, yellow, white, blue, green, scrambl);
                            counter++;
                            lastNumber = 7;
                        }else {
                            main.Lx(orange, yellow, white, blue, green, scrambl);
                            counter = 1;
                            lastNumber = 7;
                        }
                    }
                }
            }
            if (randomNumber == 8) {
                if(randomNumber == lastNumber + 1){
                    i--;
                    continue;
                }else {
                    if (randomNumber == lastNumber && counter == 2){
                        i--;
                        continue;
                    }else {
                        if (randomNumber == lastNumber){
                            main.B(blue, yellow, white, rad, orange, scrambl);
                            counter++;
                            lastNumber = 8;
                        }else {
                            main.B(blue, yellow, white, rad, orange, scrambl);
                            counter = 1;
                            lastNumber = 8;
                        }
                    }
                }
            }
            if (randomNumber == 9) {
                if(randomNumber == lastNumber - 1){
                    i--;
                    continue;
                }else {
                    if (randomNumber == lastNumber && counter == 2){
                        i--;
                        continue;
                    }else {
                        if (randomNumber == lastNumber){
                            main.Bx(blue, yellow, white, rad, orange, scrambl);
                            counter++;
                            lastNumber = 9;
                        }else {
                            main.Bx(blue, yellow, white, rad, orange, scrambl);
                            counter = 1;
                            lastNumber = 9;
                        }
                    }
                }
            }
            if (randomNumber == 10) {
                if(randomNumber == lastNumber + 1){
                    i--;
                    continue;
                }else {
                    if (randomNumber == lastNumber && counter == 2){
                        i--;
                        continue;
                    }else {
                        if (randomNumber == lastNumber){
                            main.D(yellow, blue, green, orange, rad, scrambl);
                            counter++;
                            lastNumber = 10;
                        }else {
                            main.D(yellow, blue, green, orange, rad, scrambl);
                            counter = 1;
                            lastNumber = 10;
                        }
                    }
                }
            }
            if (randomNumber == 11) {
                if (randomNumber == lastNumber && counter == 2){
                    i--;
                }else {
                    if (randomNumber == lastNumber){
                        main.Dx(yellow, blue, green, orange, rad, scrambl);
                        counter++;
                        lastNumber = 11;
                    }else {
                        main.Dx(yellow, blue, green, orange, rad, scrambl);
                        counter = 1;
                        lastNumber = 11;
                    }
                }
            }
        }
        Sout.sout(white, green, yellow, blue, orange, rad, scrambl);
    }
}
