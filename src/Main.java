import com.sun.xml.internal.bind.v2.TODO;

import java.util.Scanner;

public class Main {
    /*
         0 - белый
         1 - зелёный
         2 - жёлтый
         3 - синий
         4 - оранжевый
         5 - красный

         Вызов методов для поворотов грани:

         U(white, green, blue, orange, rad, scrambl);
         Ux(white, green, blue, orange, rad, scrambl);
         F(green, yellow, white, orange, rad, scrambl);
         Fx(green, yellow, white, orange, rad, scrambl);
         R(rad, yellow, white, green, blue, scrambl);
         Rx(rad, yellow, white, green, blue, scrambl);
         L(orange, yellow, white, blue, green, scrambl);
         Lx(orange, yellow, white, blue, green, scrambl);
         B(blue, yellow, white, rad, orange, scrambl);
         Bx(blue, yellow, white, rad, orange, scrambl);
         D(yellow, blue, green, orange, rad, scrambl);
         Dx(yellow, blue, green, orange, rad, scrambl);
         */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Стороны куба
        StringBuilder scrambl = new StringBuilder();
        int[][] white = new int[3][3];
        int[][] green = new int[3][3];
        int[][] yellow = new int[3][3];
        int[][] blue = new int[3][3];
        int[][] orange = new int[3][3];
        int[][] rad = new int[3][3];
        //Массив рёбер
        int[][] edge = new int[12][2];
        //Массив углов
        int[][] corners = new int[8][3];
        //Разборка куба
        System.out.println("Введите 0 - сли хотите сами ввести разборку, или 1 - если хотите автоматическую разборку");
        int nextInt = sc.nextInt();
        if (nextInt == 0){
            Filling_in(white, green, yellow, blue, orange, rad, sc);
        }else {
            GenerateScrambl(white, green, yellow, blue, orange, rad, scrambl);
            scrambl = new StringBuilder();
        }
        //Заполнение массива рёбер
        Updateedge(white, green, yellow, blue, orange, rad, edge);
        //Заполнение массива углов
        Updatecorners(white, green, yellow, blue, orange, rad, corners);
        //Сборка куба
        //Жёлтый крест:
        cross(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
        //F2L
        F2L_orange_blue(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
        F2L_orange_green(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
        F2L_rad_blue(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
        F2L_rad_green(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
        //OLL
        OLL(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
        //PLL
        PLL(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
        //Конец сборки
        sout(white, green, yellow, blue, orange, rad, scrambl);
    }
    //Разборка куба
    //Ввод разборки с клавиатуры:
    private static void Filling_in(int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, Scanner sc){
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
    //Автоматическая разборка:
    private static void GenerateScrambl(int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
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
                if(randomNumber == lastNumber + 1){
                    i--;
                    continue;
                }else {
                    if (randomNumber == lastNumber && counter == 2){
                        i--;
                        continue;
                    }else {
                        if (randomNumber == lastNumber){
                            U(white, green, blue, orange, rad, scrambl);
                            counter++;
                            lastNumber = 0;
                        }else {
                            U(white, green, blue, orange, rad, scrambl);
                            counter = 1;
                            lastNumber = 0;
                        }
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
                            Ux(white, green, blue, orange, rad, scrambl);
                            counter++;
                            lastNumber = 1;
                        }else {
                            Ux(white, green, blue, orange, rad, scrambl);
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
                            F(green, yellow, white, orange, rad, scrambl);
                            counter++;
                            lastNumber = 2;
                        }else {
                            F(green, yellow, white, orange, rad, scrambl);
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
                            Fx(green, yellow, white, orange, rad, scrambl);
                            counter++;
                            lastNumber = 3;
                        }else {
                            Fx(green, yellow, white, orange, rad, scrambl);
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
                            R(rad, yellow, white, green, blue, scrambl);
                            counter++;
                            lastNumber = 4;
                        }else {
                            R(rad, yellow, white, green, blue, scrambl);
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
                            Rx(rad, yellow, white, green, blue, scrambl);
                            counter++;
                            lastNumber = 5;
                        }else {
                            Rx(rad, yellow, white, green, blue, scrambl);
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
                            L(orange, yellow, white, blue, green, scrambl);
                            counter++;
                            lastNumber = 6;
                        }else {
                            L(orange, yellow, white, blue, green, scrambl);
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
                            Lx(orange, yellow, white, blue, green, scrambl);
                            counter++;
                            lastNumber = 7;
                        }else {
                            Lx(orange, yellow, white, blue, green, scrambl);
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
                            B(blue, yellow, white, rad, orange, scrambl);
                            counter++;
                            lastNumber = 8;
                        }else {
                            B(blue, yellow, white, rad, orange, scrambl);
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
                            Bx(blue, yellow, white, rad, orange, scrambl);
                            counter++;
                            lastNumber = 9;
                        }else {
                            Bx(blue, yellow, white, rad, orange, scrambl);
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
                            D(yellow, blue, green, orange, rad, scrambl);
                            counter++;
                            lastNumber = 10;
                        }else {
                            D(yellow, blue, green, orange, rad, scrambl);
                            counter = 1;
                            lastNumber = 10;
                        }
                    }
                }
            }
            if (randomNumber == 11) {
                if(randomNumber == lastNumber - 1){
                    i--;
                }else {
                    if (randomNumber == lastNumber && counter == 2){
                        i--;
                    }else {
                        if (randomNumber == lastNumber){
                            Dx(yellow, blue, green, orange, rad, scrambl);
                            counter++;
                            lastNumber = 11;
                        }else {
                            Dx(yellow, blue, green, orange, rad, scrambl);
                            counter = 1;
                            lastNumber = 11;
                        }
                    }
                }
            }
        }
        sout(white, green, yellow, blue, orange, rad, scrambl);

    }
    //Обновление массива рёбер и углов
    private static void Updateedge(int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, int[][] edge){
        edge[0][0] = white[0][1]; edge[0][1] = blue[2][1];
        edge[1][0] = white[1][2]; edge[1][1] = rad[1][0];
        edge[2][0] = white[2][1]; edge[2][1] = green[0][1];
        edge[3][0] = white[1][0]; edge[3][1] = orange[1][2];
        edge[4][0] = green[1][0]; edge[4][1] = orange[2][1];
        edge[5][0] = green[1][2]; edge[5][1] = rad[2][1];
        edge[6][0] = green[2][1]; edge[6][1] = yellow[0][1];
        edge[7][0] = yellow[1][0]; edge[7][1] = orange[1][0];
        edge[8][0] = yellow[1][2]; edge[8][1] = rad[1][2];
        edge[9][0] = yellow[2][1]; edge[9][1] = blue[0][1];
        edge[10][0] = orange[0][1]; edge[10][1] = blue[1][0];
        edge[11][0] = rad[0][1]; edge[11][1] = blue[1][2];
    }
    private static void Updatecorners(int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, int[][] corners){
        corners[0][0] = white[0][0];
        corners[0][1] = orange[0][2];
        corners[0][2] = blue[2][0];

        corners[1][0] = white[0][2];
        corners[1][1] = blue[2][2];
        corners[1][2] = rad[0][0];

        corners[2][0] = white[2][0];
        corners[2][1] = green[0][0];
        corners[2][2] = orange[2][2];

        corners[3][0] = white[2][2];
        corners[3][1] = rad[2][0];
        corners[3][2] = green[0][2];

        corners[4][0] = yellow[0][0];
        corners[4][1] = orange[2][0];
        corners[4][2] = green[2][0];

        corners[5][0] = yellow[0][2];
        corners[5][1] = green[2][2];
        corners[5][2] = rad[2][2];

        corners[6][0] = yellow[2][0];
        corners[6][1] = blue[0][0];
        corners[6][2] = orange[0][0];

        corners[7][0] = yellow[2][2];
        corners[7][1] = rad[0][2];
        corners[7][2] = blue[0][2];
    }
    //Сборка куба
    //Крест:
    private static void cross(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        for (int i = 0; i < 4; i++) {
            if (edge[6][1] == 2 & edge[7][0] == 2 & edge[8][0] == 2 & edge[9][0] == 2){//если все рёбра уже на местах
                //Рассположение рёбер в правильном порядке
                for (int j = 0; j < 4; j++) {
                    int l = 0;
                    if (edge[7][1] == 4)l++;
                    if (edge[6][0] == 1)l++;
                    if (edge[8][1] == 5)l++;
                    if (edge[9][1] == 3)l++;
                    if (l == 4){
                        break;
                    }else {
                        if (l == 2){
                            if (edge[7][1] == 4 && edge[6][0] == 1){//совпали оранжевый и зелёный
                                //убрать Updateedge после каждого действия, оставить только в конце
                                Rx(rad, yellow, white, green, blue, scrambl);
                                Dx(yellow, blue, green, orange, rad, scrambl);
                                R(rad, yellow, white, green, blue, scrambl);
                                D(yellow, blue, green, orange, rad, scrambl);
                                Rx(rad, yellow, white, green, blue, scrambl);
                                Updateedge(white, green, yellow, blue, orange, rad, edge);
                                break;
                            }
                            if (edge[7][1] == 4 && edge[8][1] == 5){//совпали оранжевый и красный
                                F(green, yellow, white, orange, rad, scrambl);
                                D(yellow, blue, green, orange, rad, scrambl);
                                D(yellow, blue, green, orange, rad, scrambl);
                                Fx(green, yellow, white, orange, rad, scrambl);
                                D(yellow, blue, green, orange, rad, scrambl);
                                D(yellow, blue, green, orange, rad, scrambl);
                                F(green, yellow, white, orange, rad, scrambl);
                                Updateedge(white, green, yellow, blue, orange, rad, edge);
                                break;
                            }
                            if (edge[7][1] == 4 && edge[9][1] == 3){//совпали оранжевый и синий
                                Rx(rad, yellow, white, green, blue, scrambl);
                                D(yellow, blue, green, orange, rad, scrambl);
                                R(rad, yellow, white, green, blue, scrambl);
                                Dx(yellow, blue, green, orange, rad, scrambl);
                                Rx(rad, yellow, white, green, blue, scrambl);
                                Updateedge(white, green, yellow, blue, orange, rad, edge);
                                break;
                            }
                            if (edge[6][0] == 1 && edge[8][1] == 5){//совпали зелёный и крассный
                                L(orange, yellow, white, blue, green, scrambl);
                                D(yellow, blue, green, orange, rad, scrambl);
                                Lx(orange, yellow, white, blue, green, scrambl);
                                Dx(yellow, blue, green, orange, rad, scrambl);
                                L(orange, yellow, white, blue, green, scrambl);
                                Updateedge(white, green, yellow, blue, orange, rad, edge);
                                break;
                            }
                            if (edge[6][0] == 1 && edge[9][1] == 3){//совпали зелёный и синий
                                R(rad, yellow, white, green, blue, scrambl);
                                D(yellow, blue, green, orange, rad, scrambl);
                                D(yellow, blue, green, orange, rad, scrambl);
                                Rx(rad, yellow, white, green, blue, scrambl);
                                D(yellow, blue, green, orange, rad, scrambl);
                                D(yellow, blue, green, orange, rad, scrambl);
                                R(rad, yellow, white, green, blue, scrambl);
                                Updateedge(white, green, yellow, blue, orange, rad, edge);
                                break;
                            }
                            if (edge[8][1] == 5 && edge[9][1] == 3){//совпали красный и синий
                                F(green, yellow, white, orange, rad, scrambl);
                                D(yellow, blue, green, orange, rad, scrambl);
                                Fx(green, yellow, white, orange, rad, scrambl);
                                Dx(yellow, blue, green, orange, rad, scrambl);
                                F(green, yellow, white, orange, rad, scrambl);
                                Updateedge(white, green, yellow, blue, orange, rad, edge);
                                break;
                            }
                        }else {
                            D(yellow, blue, green, orange, rad, scrambl);
                            Updateedge(white, green, yellow, blue, orange, rad, edge);
                        }
                    }
                }
                break;
            }else {
                //Жёлтое ребро на верхнем слое
                if (edge[0][0] == 2) {
                    for (int j = 0; j < 3; j++) {
                        if (edge[9][0] == 2) {
                            D(yellow, blue, green, orange, rad, scrambl);//если D больше 3 написать Dx
                        } else {
                            break;
                        }
                    }
                    B(blue, yellow, white, rad, orange, scrambl);
                    B(blue, yellow, white, rad, orange, scrambl);
                    Updateedge(white, green, yellow, blue, orange, rad, edge);
                }
                if (edge[1][0] == 2) {
                    for (int j = 0; j < 3; j++) {
                        if (edge[8][0] == 2) {
                            D(yellow, blue, green, orange, rad, scrambl);//если D больше 3 написать Dx
                        } else {
                            break;
                        }
                    }
                    R(rad, yellow, white, green, blue, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    Updateedge(white, green, yellow, blue, orange, rad, edge);
                }
                if (edge[2][0] == 2) {
                    for (int j = 0; j < 3; j++) {
                        if (edge[6][1] == 2) {
                            D(yellow, blue, green, orange, rad, scrambl);//если D больше 3 написать Dx
                        } else {
                            break;
                        }
                    }
                    F(green, yellow, white, orange, rad, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    Updateedge(white, green, yellow, blue, orange, rad, edge);
                }
                if (edge[3][0] == 2) {
                    for (int j = 0; j < 3; j++) {
                        if (edge[7][0] == 2) {
                            D(yellow, blue, green, orange, rad, scrambl);//если D больше 3 написать Dx
                        } else {
                            break;
                        }
                    }
                    L(orange, yellow, white, blue, green, scrambl);
                    L(orange, yellow, white, blue, green, scrambl);
                    Updateedge(white, green, yellow, blue, orange, rad, edge);
                }
                //Жёлтое ребро с боку на верхнем слое
                if (edge[0][1] == 2) {
                    for (int j = 0; j < 2; j++) {
                        if (edge[8][0] != 2 || edge[7][0] != 2) {
                            if (edge[8][0] != 2) {//жёлто-красное
                                Bx(blue, yellow, white, rad, orange, scrambl);
                                R(rad, yellow, white, green, blue, scrambl);
                                B(blue, yellow, white, rad, orange, scrambl);
                                Updateedge(white, green, yellow, blue, orange, rad, edge);
                            } else {
                                if (edge[7][0] != 2) {//жёлто-оранжевый
                                    B(blue, yellow, white, rad, orange, scrambl);
                                    Lx(orange, yellow, white, blue, green, scrambl);
                                    Bx(blue, yellow, white, rad, orange, scrambl);
                                    Updateedge(white, green, yellow, blue, orange, rad, edge);
                                }
                            }
                            break;
                        } else {
                            D(yellow, blue, green, orange, rad, scrambl);
                            Updateedge(white, green, yellow, blue, orange, rad, edge);
                        }
                    }
                }
                if (edge[1][1] == 2) {
                    for (int j = 0; j < 2; j++) {
                        if (edge[9][0] != 2 || edge[6][1] != 2) {
                            if (edge[9][0] != 2) {//жёлто-синее
                                R(rad, yellow, white, green, blue, scrambl);
                                Bx(blue, yellow, white, rad, orange, scrambl);
                                Rx(rad, yellow, white, green, blue, scrambl);
                                Updateedge(white, green, yellow, blue, orange, rad, edge);
                            } else {
                                if (edge[6][1] != 2) {//жёлто-зелёное
                                    Rx(rad, yellow, white, green, blue, scrambl);
                                    F(green, yellow, white, orange, rad, scrambl);
                                    R(rad, yellow, white, green, blue, scrambl);
                                    Updateedge(white, green, yellow, blue, orange, rad, edge);
                                }
                            }
                            break;
                        } else {
                            D(yellow, blue, green, orange, rad, scrambl);
                            Updateedge(white, green, yellow, blue, orange, rad, edge);
                        }
                    }
                }
                if (edge[2][1] == 2) {
                    for (int j = 0; j < 2; j++) {
                        if (edge[8][0] != 2 || edge[7][0] != 2) {
                            if (edge[8][0] != 2) {//жёлто-красное
                                F(green, yellow, white, orange, rad, scrambl);
                                Rx(rad, yellow, white, green, blue, scrambl);
                                Fx(green, yellow, white, orange, rad, scrambl);
                                Updateedge(white, green, yellow, blue, orange, rad, edge);
                            } else {
                                if (edge[7][0] != 2) {//жёлто-оранжевый
                                    Fx(green, yellow, white, orange, rad, scrambl);
                                    L(orange, yellow, white, blue, green, scrambl);
                                    F(green, yellow, white, orange, rad, scrambl);
                                    Updateedge(white, green, yellow, blue, orange, rad, edge);
                                }
                            }
                            break;
                        } else {
                            D(yellow, blue, green, orange, rad, scrambl);
                            Updateedge(white, green, yellow, blue, orange, rad, edge);
                        }
                    }
                }
                if (edge[3][1] == 2) {
                    for (int j = 0; j < 2; j++) {
                        if (edge[8][0] != 2 || edge[7][0] != 2) {
                            if (edge[9][0] != 2) {//жёлто-синее
                                Lx(orange, yellow, white, blue, green, scrambl);
                                B(blue, yellow, white, rad, orange, scrambl);
                                L(orange, yellow, white, blue, green, scrambl);
                                Updateedge(white, green, yellow, blue, orange, rad, edge);
                            } else {
                                if (edge[6][1] != 2) {//жёлто-зелёный
                                    L(orange, yellow, white, blue, green, scrambl);
                                    Fx(green, yellow, white, orange, rad, scrambl);
                                    Lx(orange, yellow, white, blue, green, scrambl);
                                    Updateedge(white, green, yellow, blue, orange, rad, edge);
                                }
                            }
                            break;
                        } else {
                            D(yellow, blue, green, orange, rad, scrambl);
                            Updateedge(white, green, yellow, blue, orange, rad, edge);
                        }
                    }
                }
                //Жёлтый находится на среднем слое
                if (edge[4][0] == 2) {
                    for (int j = 0; j < 3; j++) {
                        if (edge[7][0] == 2) {//жёлто-оранжевый
                            D(yellow, blue, green, orange, rad, scrambl);//если D больше 3 написать Dx
                        } else {
                            break;
                        }
                    }
                    L(orange, yellow, white, blue, green, scrambl);
                    Updateedge(white, green, yellow, blue, orange, rad, edge);
                }
                if (edge[10][1] == 2) {
                    for (int j = 0; j < 3; j++) {
                        if (edge[7][0] == 2) {//жёлто-оранжевый
                            D(yellow, blue, green, orange, rad, scrambl);//если D больше 3 написать Dx
                        } else {
                            break;
                        }
                    }
                    Lx(orange, yellow, white, blue, green, scrambl);
                    Updateedge(white, green, yellow, blue, orange, rad, edge);
                }
                if (edge[4][1] == 2) {
                    for (int j = 0; j < 3; j++) {
                        if (edge[6][1] == 2) {//жёлто-зелёный
                            D(yellow, blue, green, orange, rad, scrambl);//если D больше 3 написать Dx
                        } else {
                            break;
                        }
                    }
                    Fx(green, yellow, white, orange, rad, scrambl);
                    Updateedge(white, green, yellow, blue, orange, rad, edge);
                }

                if (edge[5][1] == 2) {
                    for (int j = 0; j < 3; j++) {
                        if (edge[6][1] == 2) {//жёлто-зелёный
                            D(yellow, blue, green, orange, rad, scrambl);//если D больше 3 написать Dx
                        } else {
                            break;
                        }
                    }
                    F(green, yellow, white, orange, rad, scrambl);
                    Updateedge(white, green, yellow, blue, orange, rad, edge);
                }
                if (edge[5][0] == 2) {
                    for (int j = 0; j < 3; j++) {
                        if (edge[8][0] == 2) {//жёлто-красное
                            D(yellow, blue, green, orange, rad, scrambl);//если D больше 3 написать Dx
                        } else {
                            break;
                        }
                    }
                    Rx(rad, yellow, white, green, blue, scrambl);
                    Updateedge(white, green, yellow, blue, orange, rad, edge);
                }
                if (edge[11][1] == 2) {
                    for (int j = 0; j < 3; j++) {
                        if (edge[8][0] == 2) {//жёлто-красное
                            D(yellow, blue, green, orange, rad, scrambl);//если D больше 3 написать Dx
                        } else {
                            break;
                        }
                    }
                    R(rad, yellow, white, green, blue, scrambl);
                    Updateedge(white, green, yellow, blue, orange, rad, edge);
                }
                if (edge[10][0] == 2) {
                    for (int j = 0; j < 3; j++) {
                        if (edge[9][0] == 2) {//жёлто-синие
                            D(yellow, blue, green, orange, rad, scrambl);//если D больше 3 написать Dx
                        } else {
                            break;
                        }
                    }
                    B(blue, yellow, white, rad, orange, scrambl);
                    Updateedge(white, green, yellow, blue, orange, rad, edge);
                }
                if (edge[11][0] == 2) {
                    for (int j = 0; j < 3; j++) {
                        if (edge[9][0] == 2) {//жёлто-синие
                            D(yellow, blue, green, orange, rad, scrambl);//если D больше 3 написать Dx
                        } else {
                            break;
                        }
                    }
                    Bx(blue, yellow, white, rad, orange, scrambl);
                    Updateedge(white, green, yellow, blue, orange, rad, edge);
                }
                //Жёлтый находится на нижнем слое с боку
                if (edge[9][1] == 2) {//Жёлто-синее
                    B(blue, yellow, white, rad, orange, scrambl);
                    Dx(yellow, blue, green, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    Updateedge(white, green, yellow, blue, orange, rad, edge);
                }
                if (edge[8][1] == 2) {//Жёлто-красное
                    R(rad, yellow, white, green, blue, scrambl);
                    Dx(yellow, blue, green, orange, rad, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    Updateedge(white, green, yellow, blue, orange, rad, edge);
                }
                if (edge[6][0] == 2) {//Жёлто-зелёное
                    F(green, yellow, white, orange, rad, scrambl);
                    Dx(yellow, blue, green, orange, rad, scrambl);
                    L(orange, yellow, white, blue, green, scrambl);
                    Updateedge(white, green, yellow, blue, orange, rad, edge);
                }
                if (edge[7][1] == 2) {//Жёлто-оранжевое
                    L(orange, yellow, white, blue, green, scrambl);
                    Dx(yellow, blue, green, orange, rad, scrambl);
                    B(blue, yellow, white, rad, orange, scrambl);
                    Updateedge(white, green, yellow, blue, orange, rad, edge);
                }
            }
        }
        Updatecorners(white, green, yellow, blue, orange, rad, corners);
    }
    //F2L:
    private static int[] findF2L_orange_blue(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad){
        //Находим жёлто-сине-оранжевый угол и сине-оранжевое ребро
        int[] l = new int[7];
        int i;
        int j;
        int one = 2;
        int two = 3;
        int three = 4;
        Updatecorners(white, green, yellow, blue, orange, rad, corners);
        Updateedge(white, green, yellow, blue, orange, rad, edge);
        for (i = 0; i < 8; i++) {
            if ((corners[i][0] == one && corners[i][1] == two && corners[i][2] == three) ||
                    (corners[i][0] == two && corners[i][1] == three && corners[i][2] == one) ||
                    (corners[i][0] == three && corners[i][1] == one && corners[i][2] == two)){
                for (j = 0; j < 12; j++) {
                    if ((edge[j][0] == two && edge[j][1] == three) || (edge[j][0] == three && edge[j][1] == two)){
                        if (corners[i][0] == one && corners[i][1] == two && corners[i][2] == three && edge[j][0] == two && edge[j][1] == three){
                            int[] p = new int[7];
                            p[0] = i;
                            p[1] = j;
                            p[2] = one;
                            p[3] = two;
                            p[4] = three;
                            p[5] = two;
                            p[6] = three;
                            return p;
                        }
                        if (corners[i][0] == one && corners[i][1] == two && corners[i][2] == three && edge[j][0] == three && edge[j][1] == two){
                            int[] p = new int[7];
                            p[0] = i;
                            p[1] = j;
                            p[2] = one;
                            p[3] = two;
                            p[4] = three;
                            p[5] = three;
                            p[6] = two;
                            return p;
                        }
                        if (corners[i][0] == three && corners[i][1] == one && corners[i][2] == two && edge[j][0] == two && edge[j][1] == three){
                            int[] p = new int[7];
                            p[0] = i;
                            p[1] = j;
                            p[2] = three;
                            p[3] = one;
                            p[4] = two;
                            p[5] = two;
                            p[6] = three;
                            return p;
                        }
                        if (corners[i][0] == three && corners[i][1] == one && corners[i][2] == two && edge[j][0] == three && edge[j][1] == two){
                            int[] p = new int[7];
                            p[0] = i;
                            p[1] = j;
                            p[2] = three;
                            p[3] = one;
                            p[4] = two;
                            p[5] = three;
                            p[6] = two;
                            return p;
                        }
                        if (corners[i][0] == two && corners[i][1] == three && corners[i][2] == one && edge[j][0] == two && edge[j][1] == three){
                            int[] p = new int[7];
                            p[0] = i;
                            p[1] = j;
                            p[2] = two;
                            p[3] = three;
                            p[4] = one;
                            p[5] = two;
                            p[6] = three;
                            return p;
                        }
                        if (corners[i][0] == two && corners[i][1] == three && corners[i][2] == one && edge[j][0] == three && edge[j][1] == two){
                            int[] p = new int[7];
                            p[0] = i;
                            p[1] = j;
                            p[2] = two;
                            p[3] = three;
                            p[4] = one;
                            p[5] = three;
                            p[6] = two;
                            return p;
                        }
                    }

                }
            }
        }
        return l;
    }
    private static void F2L_orange_blue(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl) {
        int[] p = findF2L_orange_blue(edge, corners, white, green, yellow, blue, orange, rad);
        int i = p[0];
        int j = p[1];
        int one = p[2];
        int two = p[3];
        int three = p[4];
        int four = p[5];
        int five = p[6];
        if(i == 6 && j == 10 && one == 2 && two == 3 && three == 4 && four == 4 && five == 3){
            return;
        }
        //i - рассположение угла; j - рассположение ребра; one,two,three - цвет угла по часовой;four,five - цвет ребра сверху вниз
        //сделать скрамбл
        if (j == 4 || j == 5 || j == 10 || j == 11){//Если ребро находится на среднем слое, просто достаём его оттуда
            if (j == 4){
                Lx(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                Updateedge(white, green, yellow, blue, orange, rad, edge);
                Updatecorners(white, green, yellow, blue, orange, rad, corners);

            }
            if (j == 5){
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Updateedge(white, green, yellow, blue, orange, rad, edge);
                Updatecorners(white, green, yellow, blue, orange, rad, corners);
            }
            if (j == 10){
                L(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Lx(orange, yellow, white, blue, green, scrambl);
                Updateedge(white, green, yellow, blue, orange, rad, edge);
                Updatecorners(white, green, yellow, blue, orange, rad, corners);
            }
            if (j == 11){
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Updateedge(white, green, yellow, blue, orange, rad, edge);
                Updatecorners(white, green, yellow, blue, orange, rad, corners);
            }
            p = findF2L_orange_blue(edge, corners, white, green, yellow, blue, orange, rad);
            i = p[0];
            j = p[1];
            one = p[2];
            two = p[3];
            three = p[4];
            four = p[5];
            five = p[6];
        }
        if (i < 4 && j < 4) {//ребро и угол находится сверху
            for (int k = 0; k < 4; k++) {
                if ((i == 3 && j == 2) && one == 4 && two == 2 && three == 3 && four == 4 && five == 3) {//правая пара
                    U(white, green, blue, orange, rad, scrambl);
                    couple_orange_blue_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 1) && one == 3 && two == 4 && three == 2 && four == 3 && five == 4) {//левая пара
                    Ux(white, green, blue, orange, rad, scrambl);
                    couple_orange_blue_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 3) && one == 3 && two == 4 && three == 2 && four == 4 && five == 3) {//левая трёхходовка
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    tripod_orange_blue_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if (i == 3 && j == 0 && one == 4 && two == 2 && three == 3 && four == 3 && five == 4) {//правая трёхходовка
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    tripod_orange_blue_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 0) && one == 4 && two == 2 && three == 3 && four == 4 && five == 3) {
                    U(white, green, blue, orange, rad, scrambl);
                    Fx(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    couple_orange_blue_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 3) && one == 3 && two == 4 && three == 2 && four == 3 && five == 4) {//левая трёхходовка
                    Ux(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    couple_orange_blue_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 3) && one == 4 && two == 2 && three == 3 && four == 4 && five == 3) {
                    U(white, green, blue, orange, rad, scrambl);
                    Fx(green, yellow, white, orange, rad, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    couple_orange_blue_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 0) && one == 3 && two == 4 && three == 2 && four == 3 && five == 4) {//левая трёхходовка
                    Ux(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    couple_orange_blue_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 0) && one == 3 && two == 4 && three == 2 && four == 4 && five == 3) {//левая трёхходовка
                    Ux(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    tripod_orange_blue_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 3) && one == 4 && two == 2 && three == 3 && four == 3 && five == 4) {
                    U(white, green, blue, orange, rad, scrambl);
                    Fx(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    tripod_orange_blue_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 2) && one == 4 && two == 2 && three == 3 && four == 3 && five == 4) {//правая пара
                    R(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    couple_orange_blue_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 1) && one == 3 && two == 4 && three == 2 && four == 4 && five == 3) {//левая пара
                    Fx(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Fx(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    couple_orange_blue_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 2) && one == 3 && two == 4 && three == 2 && four == 4 && five == 3) {//левая пара
                    Fx(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Fx(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    couple_orange_blue_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 1) && one == 4 && two == 2 && three == 3 && four == 3 && five == 4) {//левая пара
                    R(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    couple_orange_blue_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 2) && one == 3 && two == 4 && three == 2 && four == 3 && five == 4) {//левая пара
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    couple_orange_blue_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 1) && one == 4 && two == 2 && three == 3 && four == 4 && five == 3) {//левая пара
                    R(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    tripod_orange_blue_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 2) && one == 2 && two == 3 && three == 4 && four == 4 && five == 3) {//левая пара
                    Fx(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    tripod_orange_blue_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 1) && one == 2 && two == 3 && three == 4 && four == 3 && five == 4) {//левая пара
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    tripod_orange_blue_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 1 && j == 2) && one == 2 && two == 3 && three == 4 && four == 4 && five == 3) {//левая пара
                    R(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    couple_orange_blue_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 2 && j == 1) && one == 2 && two == 3 && three == 4 && four == 3 && five == 4) {//левая пара
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    couple_orange_blue_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 0 && j == 1) && one == 2 && two == 3 && three == 4 && four == 3 && five == 4) {//левая пара
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    couple_orange_blue_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 0 && j == 2) && one == 2 && two == 3 && three == 4 && four == 4 && five == 3) {//левая пара
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    tripod_orange_blue_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 1) && one == 2 && two == 3 && three == 4 && four == 4 && five == 3) {//левая пара
                    F(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    Fx(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    couple_orange_blue_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 2) && one == 2 && two == 3 && three == 4 && four == 3 && five == 4) {//левая пара
                    R(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    couple_orange_blue_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                U(white, green, blue, orange, rad, scrambl);
                Updateedge(white, green, yellow, blue, orange, rad, edge);
                Updatecorners(white, green, yellow, blue, orange, rad, corners);
                p = findF2L_orange_blue(edge, corners, white, green, yellow, blue, orange, rad);
                i = p[0];
                j = p[1];
                one = p[2];
                two = p[3];
                three = p[4];
                four = p[5];
                five = p[6];
            }
        }
        if (i > 3 && j < 4) {
            for (int k = 0; k < 4; k++) {
                if (i == 5) {//угол в своём слоте, ребро сверху
                    for (int m = 0; m < 4; m++) {
                        if (j == 1 && one == 2 && two == 3 && three == 4 && four == 3 && five == 4) {
                            Ux(white, green, blue, orange, rad, scrambl);
                            Fx(green, yellow, white, orange, rad, scrambl);
                            U(white, green, blue, orange, rad, scrambl);
                            F(green, yellow, white, orange, rad, scrambl);
                            Ux(white, green, blue, orange, rad, scrambl);
                            for (int l = 0; l < k; l++) {
                                if (k == 3) {
                                    D(yellow, blue, green, orange, rad, scrambl);
                                    break;
                                } else Dx(yellow, blue, green, orange, rad, scrambl);
                            }
                            couple_orange_blue_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                            break;
                        }
                        if (j == 2 && one == 2 && two == 3 && three == 4 && four == 4 && five == 3) {
                            U(white, green, blue, orange, rad, scrambl);
                            R(rad, yellow, white, green, blue, scrambl);
                            Ux(white, green, blue, orange, rad, scrambl);
                            Rx(rad, yellow, white, green, blue, scrambl);
                            U(white, green, blue, orange, rad, scrambl);
                            for (int l = 0; l < k; l++) {
                                if (k == 3) {
                                    D(yellow, blue, green, orange, rad, scrambl);
                                    break;
                                } else Dx(yellow, blue, green, orange, rad, scrambl);
                            }
                            couple_orange_blue_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                            break;
                        }
                        if (j == 2 && one == 3 && two == 4 && three == 2 && four == 4 && five == 3) {
                            R(rad, yellow, white, green, blue, scrambl);
                            U(white, green, blue, orange, rad, scrambl);
                            Rx(rad, yellow, white, green, blue, scrambl);
                            for (int l = 0; l < k; l++) {
                                if (k == 3) {
                                    D(yellow, blue, green, orange, rad, scrambl);
                                    break;
                                } else Dx(yellow, blue, green, orange, rad, scrambl);
                            }
                            couple_orange_blue_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                            break;
                        }
                        if (j == 1 && one == 4 && two == 2 && three == 3 && four == 3 && five == 4) {
                            R(rad, yellow, white, green, blue, scrambl);
                            Ux(white, green, blue, orange, rad, scrambl);
                            Rx(rad, yellow, white, green, blue, scrambl);
                            Ux(white, green, blue, orange, rad, scrambl);
                            for (int l = 0; l < k; l++) {
                                if (k == 3) {
                                    D(yellow, blue, green, orange, rad, scrambl);
                                    break;
                                } else Dx(yellow, blue, green, orange, rad, scrambl);
                            }
                            couple_orange_blue_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                            break;
                        }
                        if (j == 2 && one == 4 && two == 2 && three == 3 && four == 4 && five == 3) {
                            Fx(green, yellow, white, orange, rad, scrambl);
                            Ux(white, green, blue, orange, rad, scrambl);
                            F(green, yellow, white, orange, rad, scrambl);
                            Ux(white, green, blue, orange, rad, scrambl);
                            for (int l = 0; l < k; l++) {
                                if (k == 3) {
                                    D(yellow, blue, green, orange, rad, scrambl);
                                    break;
                                } else Dx(yellow, blue, green, orange, rad, scrambl);
                            }
                            tripod_orange_blue_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                            break;
                        }
                        if (j == 1 && one == 3 && two == 4 && three == 2 && four == 3 && five == 4) {
                            R(rad, yellow, white, green, blue, scrambl);
                            U(white, green, blue, orange, rad, scrambl);
                            Rx(rad, yellow, white, green, blue, scrambl);
                            U(white, green, blue, orange, rad, scrambl);
                            for (int l = 0; l < k; l++) {
                                if (k == 3) {
                                    D(yellow, blue, green, orange, rad, scrambl);
                                    break;
                                } else Dx(yellow, blue, green, orange, rad, scrambl);
                            }
                            tripod_orange_blue_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                            break;
                        }
                        U(white, green, blue, orange, rad, scrambl);
                        Updateedge(white, green, yellow, blue, orange, rad, edge);
                        Updatecorners(white, green, yellow, blue, orange, rad, corners);
                        p = findF2L_orange_blue(edge, corners, white, green, yellow, blue, orange, rad);
                        j = p[1];
                        one = p[2];
                        two = p[3];
                        three = p[4];
                        four = p[5];
                        five = p[6];
                    }
                    break;
                } else {
                    D(yellow, blue, green, orange, rad, scrambl);
                    Updateedge(white, green, yellow, blue, orange, rad, edge);
                    Updatecorners(white, green, yellow, blue, orange, rad, corners);
                    p = findF2L_orange_blue(edge, corners, white, green, yellow, blue, orange, rad);
                    i = p[0];
                    j = p[1];
                    one = p[2];
                    two = p[3];
                    three = p[4];
                    four = p[5];
                    five = p[6];
                }
            }
        }
    }
    private static int[] findF2L_orange_green(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad){
        //Находим жёлто-зелёно-оранжевый угол и зелёно-оранжевое ребро
        int[] l = new int[7];
        int i;
        int j;
        int one = 2;
        int two = 4;
        int three = 1;
        Updatecorners(white, green, yellow, blue, orange, rad, corners);
        Updateedge(white, green, yellow, blue, orange, rad, edge);
        for (i = 0; i < 8; i++) {
            if ((corners[i][0] == one && corners[i][1] == two && corners[i][2] == three) ||
                    (corners[i][0] == two && corners[i][1] == three && corners[i][2] == one) ||
                    (corners[i][0] == three && corners[i][1] == one && corners[i][2] == two)){
                for (j = 0; j < 12; j++) {
                    if ((edge[j][0] == two && edge[j][1] == three) || (edge[j][0] == three && edge[j][1] == two)){
                        if (corners[i][0] == one && corners[i][1] == two && corners[i][2] == three && edge[j][0] == two && edge[j][1] == three){
                            int[] p = new int[7];
                            p[0] = i;
                            p[1] = j;
                            p[2] = one;
                            p[3] = two;
                            p[4] = three;
                            p[5] = two;
                            p[6] = three;
                            return p;
                        }
                        if (corners[i][0] == one && corners[i][1] == two && corners[i][2] == three && edge[j][0] == three && edge[j][1] == two){
                            int[] p = new int[7];
                            p[0] = i;
                            p[1] = j;
                            p[2] = one;
                            p[3] = two;
                            p[4] = three;
                            p[5] = three;
                            p[6] = two;
                            return p;
                        }
                        if (corners[i][0] == three && corners[i][1] == one && corners[i][2] == two && edge[j][0] == two && edge[j][1] == three){
                            int[] p = new int[7];
                            p[0] = i;
                            p[1] = j;
                            p[2] = three;
                            p[3] = one;
                            p[4] = two;
                            p[5] = two;
                            p[6] = three;
                            return p;
                        }
                        if (corners[i][0] == three && corners[i][1] == one && corners[i][2] == two && edge[j][0] == three && edge[j][1] == two){
                            int[] p = new int[7];
                            p[0] = i;
                            p[1] = j;
                            p[2] = three;
                            p[3] = one;
                            p[4] = two;
                            p[5] = three;
                            p[6] = two;
                            return p;
                        }
                        if (corners[i][0] == two && corners[i][1] == three && corners[i][2] == one && edge[j][0] == two && edge[j][1] == three){
                            int[] p = new int[7];
                            p[0] = i;
                            p[1] = j;
                            p[2] = two;
                            p[3] = three;
                            p[4] = one;
                            p[5] = two;
                            p[6] = three;
                            return p;
                        }
                        if (corners[i][0] == two && corners[i][1] == three && corners[i][2] == one && edge[j][0] == three && edge[j][1] == two){
                            int[] p = new int[7];
                            p[0] = i;
                            p[1] = j;
                            p[2] = two;
                            p[3] = three;
                            p[4] = one;
                            p[5] = three;
                            p[6] = two;
                            return p;
                        }
                    }

                }
            }
        }
        return l;
    }
    private static void F2L_orange_green(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl) {
        int[] p = findF2L_orange_green(edge, corners, white, green, yellow, blue, orange, rad);
        int i = p[0];
        int j = p[1];
        int one = p[2];
        int two = p[3];
        int three = p[4];
        int four = p[5];
        int five = p[6];
        if (i == 4 && j == 4 && one == 2 && two == 4 && three == 1 && four == 1 && five == 4){
            return;
        }
        //i - рассположение угла; j - рассположение ребра; one,two,three - цвет угла по часовой;four,five - цвет ребра сверху вниз
        //сделать скрамбл
        if (j == 4 || j == 5 || j == 11){//Если ребро находится на среднем слое, просто достаём его оттуда
            if (j == 4){
                Lx(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                Updateedge(white, green, yellow, blue, orange, rad, edge);
                Updatecorners(white, green, yellow, blue, orange, rad, corners);

            }
            if (j == 5){
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Updateedge(white, green, yellow, blue, orange, rad, edge);
                Updatecorners(white, green, yellow, blue, orange, rad, corners);
            }
            if (j == 11){
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Updateedge(white, green, yellow, blue, orange, rad, edge);
                Updatecorners(white, green, yellow, blue, orange, rad, corners);
            }
            p = findF2L_orange_green(edge, corners, white, green, yellow, blue, orange, rad);
            i = p[0];
            j = p[1];
            one = p[2];
            two = p[3];
            three = p[4];
            four = p[5];
            five = p[6];
        }
        if (i < 4 && j < 4) {//ребро и угол находится сверху
            for (int k = 0; k < 4; k++) {
                if ((i == 3 && j == 2) && one == 1 && two == 2 && three == 4 && four == 1 && five == 4) {//правая пара
                    couple_green_orange_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 1) && one == 4 && two == 1 && three == 2 && four == 4 && five == 1) {//левая пара
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    couple_green_orange_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 3) && one == 4 && two == 1 && three == 2 && four == 1 && five == 4) {//левая трёхходовка
                    U(white, green, blue, orange, rad, scrambl);
                    tripod_green_orange_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if (i == 3 && j == 0 && one == 1 && two == 2 && three == 4 && four == 4 && five == 1) {//правая трёхходовка
                    U(white, green, blue, orange, rad, scrambl);
                    tripod_green_orange_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 0) && one == 1 && two == 2 && three == 4 && four == 1 && five == 4) {
                    U(white, green, blue, orange, rad, scrambl);
                    Fx(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    couple_green_orange_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 3) && one == 4 && two == 1 && three == 2 && four == 4 && five == 1) {//левая трёхходовка
                    Ux(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    couple_green_orange_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 3) && one == 1 && two == 2 && three == 4 && four == 1 && five == 4) {
                    U(white, green, blue, orange, rad, scrambl);
                    Fx(green, yellow, white, orange, rad, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    couple_green_orange_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 0) && one == 4 && two == 1 && three == 2 && four == 4 && five == 1) {//левая трёхходовка
                    Ux(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    couple_green_orange_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 0) && one == 4 && two == 1 && three == 2 && four == 1 && five == 4) {//левая трёхходовка
                    Ux(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    tripod_green_orange_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 3) && one == 1 && two == 2 && three == 4 && four == 4 && five == 1) {
                    U(white, green, blue, orange, rad, scrambl);
                    Fx(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    tripod_green_orange_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 2) && one == 1 && two == 2 && three == 4 && four == 4 && five == 1) {//правая пара
                    R(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    couple_green_orange_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 1) && one == 4 && two == 1 && three == 2 && four == 1 && five == 4) {//левая пара
                    Fx(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Fx(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    couple_green_orange_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 2) && one == 4 && two == 1 && three == 2 && four == 1 && five == 4) {//левая пара
                    Fx(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Fx(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    couple_green_orange_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 1) && one == 1 && two == 2 && three == 4 && four == 4 && five == 1) {//левая пара
                    R(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    couple_green_orange_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 2) && one == 4 && two == 1 && three == 2 && four == 4 && five == 1) {//левая пара
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    couple_green_orange_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 1) && one == 1 && two == 2 && three == 4 && four == 1 && five == 4) {//левая пара
                    R(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    tripod_green_orange_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 2) && one == 2 && two == 4 && three == 1 && four == 1 && five == 4) {//левая пара
                    Fx(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    tripod_green_orange_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 1) && one == 2 && two == 4 && three == 1 && four == 4 && five == 1) {//левая пара
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    tripod_green_orange_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 1 && j == 2) && one == 2 && two == 4 && three == 1 && four == 1 && five == 4) {//левая пара
                    R(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    couple_orange_blue_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 2 && j == 1) && one == 2 && two == 4 && three == 1 && four == 4 && five == 1) {//левая пара
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    couple_green_orange_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 0 && j == 1) && one == 2 && two == 4 && three == 1 && four == 4 && five == 1) {//левая пара
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    couple_green_orange_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 0 && j == 2) && one == 2 && two == 4 && three == 1 && four == 1 && five == 4) {//левая пара
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    tripod_green_orange_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 1) && one == 2 && two == 4 && three == 1 && four == 1 && five == 4) {//левая пара
                    F(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    Fx(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    couple_green_orange_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 2) && one == 2 && two == 4 && three == 1 && four == 4 && five == 1) {//левая пара
                    R(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    couple_green_orange_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                U(white, green, blue, orange, rad, scrambl);
                Updateedge(white, green, yellow, blue, orange, rad, edge);
                Updatecorners(white, green, yellow, blue, orange, rad, corners);
                p = findF2L_orange_green(edge, corners, white, green, yellow, blue, orange, rad);
                i = p[0];
                j = p[1];
                one = p[2];
                two = p[3];
                three = p[4];
                four = p[5];
                five = p[6];
            }
        }
        if (i > 3 && j < 4) {
            for (int k = 0; k < 4; k++) {
                if (i == 5) {//угол в своём слоте, ребро сверху
                    for (int m = 0; m < 4; m++) {
                        if (j == 1 && one == 2 && two == 4 && three == 1 && four == 4 && five == 1) {
                            Ux(white, green, blue, orange, rad, scrambl);
                            Fx(green, yellow, white, orange, rad, scrambl);
                            U(white, green, blue, orange, rad, scrambl);
                            F(green, yellow, white, orange, rad, scrambl);
                            U(white, green, blue, orange, rad, scrambl);
                            U(white, green, blue, orange, rad, scrambl);
                            for (int l = 0; l < k; l++) {
                                if (k == 3) {
                                    D(yellow, blue, green, orange, rad, scrambl);
                                    break;
                                } else Dx(yellow, blue, green, orange, rad, scrambl);
                            }
                            couple_green_orange_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                            break;
                        }
                        if (j == 2 && one == 2 && two == 4 && three == 1 && four == 1 && five == 4) {
                            U(white, green, blue, orange, rad, scrambl);
                            R(rad, yellow, white, green, blue, scrambl);
                            Ux(white, green, blue, orange, rad, scrambl);
                            Rx(rad, yellow, white, green, blue, scrambl);
                            for (int l = 0; l < k; l++) {
                                if (k == 3) {
                                    D(yellow, blue, green, orange, rad, scrambl);
                                    break;
                                } else Dx(yellow, blue, green, orange, rad, scrambl);
                            }
                            couple_green_orange_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                            break;
                        }
                        if (j == 2 && one == 4 && two == 1 && three == 2 && four == 1 && five == 4) {
                            R(rad, yellow, white, green, blue, scrambl);
                            U(white, green, blue, orange, rad, scrambl);
                            Rx(rad, yellow, white, green, blue, scrambl);
                            Ux(white, green, blue, orange, rad, scrambl);
                            for (int l = 0; l < k; l++) {
                                if (k == 3) {
                                    D(yellow, blue, green, orange, rad, scrambl);
                                    break;
                                } else Dx(yellow, blue, green, orange, rad, scrambl);
                            }
                            couple_green_orange_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                            break;
                        }
                        if (j == 1 && one == 1 && two == 2 && three == 4 && four == 4 && five == 1) {
                            R(rad, yellow, white, green, blue, scrambl);
                            Ux(white, green, blue, orange, rad, scrambl);
                            Rx(rad, yellow, white, green, blue, scrambl);
                            U(white, green, blue, orange, rad, scrambl);
                            U(white, green, blue, orange, rad, scrambl);
                            for (int l = 0; l < k; l++) {
                                if (k == 3) {
                                    D(yellow, blue, green, orange, rad, scrambl);
                                    break;
                                } else Dx(yellow, blue, green, orange, rad, scrambl);
                            }
                            couple_green_orange_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                            break;
                        }
                        if (j == 2 && one == 1 && two == 2 && three == 4 && four == 1 && five == 4) {
                            Fx(green, yellow, white, orange, rad, scrambl);
                            Ux(white, green, blue, orange, rad, scrambl);
                            F(green, yellow, white, orange, rad, scrambl);
                            U(white, green, blue, orange, rad, scrambl);
                            U(white, green, blue, orange, rad, scrambl);
                            for (int l = 0; l < k; l++) {
                                if (k == 3) {
                                    D(yellow, blue, green, orange, rad, scrambl);
                                    break;
                                } else Dx(yellow, blue, green, orange, rad, scrambl);
                            }
                            tripod_green_orange_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                            break;
                        }
                        if (j == 1 && one == 4 && two == 1 && three == 2 && four == 4 && five == 1) {
                            R(rad, yellow, white, green, blue, scrambl);
                            U(white, green, blue, orange, rad, scrambl);
                            Rx(rad, yellow, white, green, blue, scrambl);
                            for (int l = 0; l < k; l++) {
                                if (k == 3) {
                                    D(yellow, blue, green, orange, rad, scrambl);
                                    break;
                                } else Dx(yellow, blue, green, orange, rad, scrambl);
                            }
                            tripod_green_orange_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                            break;
                        }
                        U(white, green, blue, orange, rad, scrambl);
                        Updateedge(white, green, yellow, blue, orange, rad, edge);
                        Updatecorners(white, green, yellow, blue, orange, rad, corners);
                        p = findF2L_orange_green(edge, corners, white, green, yellow, blue, orange, rad);
                        j = p[1];
                        one = p[2];
                        two = p[3];
                        three = p[4];
                        four = p[5];
                        five = p[6];
                    }
                    break;
                } else {
                    D(yellow, blue, green, orange, rad, scrambl);
                    Updateedge(white, green, yellow, blue, orange, rad, edge);
                    Updatecorners(white, green, yellow, blue, orange, rad, corners);
                    p = findF2L_orange_green(edge, corners, white, green, yellow, blue, orange, rad);
                    i = p[0];
                    j = p[1];
                    one = p[2];
                    two = p[3];
                    three = p[4];
                    four = p[5];
                    five = p[6];
                }
            }
        }
    }
    private static int[] findF2L_rad_blue(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad){
        //Находим жёлто-сине-оранжевый угол и сине-оранжевое ребро
        int[] l = new int[7];
        int i;
        int j;
        int one = 2;
        int two = 5;
        int three = 3;
        Updatecorners(white, green, yellow, blue, orange, rad, corners);
        Updateedge(white, green, yellow, blue, orange, rad, edge);
        for (i = 0; i < 8; i++) {
            if ((corners[i][0] == one && corners[i][1] == two && corners[i][2] == three) ||
                    (corners[i][0] == two && corners[i][1] == three && corners[i][2] == one) ||
                    (corners[i][0] == three && corners[i][1] == one && corners[i][2] == two)){
                for (j = 0; j < 12; j++) {
                    if ((edge[j][0] == two && edge[j][1] == three) || (edge[j][0] == three && edge[j][1] == two)){
                        if (corners[i][0] == one && corners[i][1] == two && corners[i][2] == three && edge[j][0] == two && edge[j][1] == three){
                            int[] p = new int[7];
                            p[0] = i;
                            p[1] = j;
                            p[2] = one;
                            p[3] = two;
                            p[4] = three;
                            p[5] = two;
                            p[6] = three;
                            return p;
                        }
                        if (corners[i][0] == one && corners[i][1] == two && corners[i][2] == three && edge[j][0] == three && edge[j][1] == two){
                            int[] p = new int[7];
                            p[0] = i;
                            p[1] = j;
                            p[2] = one;
                            p[3] = two;
                            p[4] = three;
                            p[5] = three;
                            p[6] = two;
                            return p;
                        }
                        if (corners[i][0] == three && corners[i][1] == one && corners[i][2] == two && edge[j][0] == two && edge[j][1] == three){
                            int[] p = new int[7];
                            p[0] = i;
                            p[1] = j;
                            p[2] = three;
                            p[3] = one;
                            p[4] = two;
                            p[5] = two;
                            p[6] = three;
                            return p;
                        }
                        if (corners[i][0] == three && corners[i][1] == one && corners[i][2] == two && edge[j][0] == three && edge[j][1] == two){
                            int[] p = new int[7];
                            p[0] = i;
                            p[1] = j;
                            p[2] = three;
                            p[3] = one;
                            p[4] = two;
                            p[5] = three;
                            p[6] = two;
                            return p;
                        }
                        if (corners[i][0] == two && corners[i][1] == three && corners[i][2] == one && edge[j][0] == two && edge[j][1] == three){
                            int[] p = new int[7];
                            p[0] = i;
                            p[1] = j;
                            p[2] = two;
                            p[3] = three;
                            p[4] = one;
                            p[5] = two;
                            p[6] = three;
                            return p;
                        }
                        if (corners[i][0] == two && corners[i][1] == three && corners[i][2] == one && edge[j][0] == three && edge[j][1] == two){
                            int[] p = new int[7];
                            p[0] = i;
                            p[1] = j;
                            p[2] = two;
                            p[3] = three;
                            p[4] = one;
                            p[5] = three;
                            p[6] = two;
                            return p;
                        }
                    }

                }
            }
        }
        return l;
    }
    private static void F2L_rad_blue(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl) {
        int[] p = findF2L_rad_blue(edge, corners, white, green, yellow, blue, orange, rad);
        int i = p[0];
        int j = p[1];
        int one = p[2];
        int two = p[3];
        int three = p[4];
        int four = p[5];
        int five = p[6];
        if(i == 7 && j == 11 && one == 2 && two == 5 && three == 3 && four == 5 && five == 3){
            return;
        }
        //i - рассположение угла; j - рассположение ребра; one,two,three - цвет угла по часовой;four,five - цвет ребра сверху вниз
        //сделать скрамбл
        if (j == 5 || j == 11){//Если ребро находится на среднем слое, просто достаём его оттуда
            if (j == 5){
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Updateedge(white, green, yellow, blue, orange, rad, edge);
                Updatecorners(white, green, yellow, blue, orange, rad, corners);
            }
            if (j == 11){
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Updateedge(white, green, yellow, blue, orange, rad, edge);
                Updatecorners(white, green, yellow, blue, orange, rad, corners);
            }
            p = findF2L_rad_blue(edge, corners, white, green, yellow, blue, orange, rad);
            i = p[0];
            j = p[1];
            one = p[2];
            two = p[3];
            three = p[4];
            four = p[5];
            five = p[6];
        }
        if (i < 4 && j < 4) {//ребро и угол находится сверху
            for (int k = 0; k < 4; k++) {
                if ((i == 3 && j == 2) && one == 3 && two == 2 && three == 5 && four == 3 && five == 5) {//правая пара
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    couple_blue_rad_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 1) && one == 5 && two == 3 && three == 2 && four == 5 && five == 3) {//левая пара
                    couple_blue_rad_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 3) && one == 5 && two == 3 && three == 2 && four == 3 && five == 5) {//левая трёхходовка
                    Ux(white, green, blue, orange, rad, scrambl);
                    tripod_blue_rad_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if (i == 3 && j == 0 && one == 3 && two == 2 && three == 5 && four == 5 && five == 3) {//правая трёхходовка
                    Ux(white, green, blue, orange, rad, scrambl);
                    tripod_blue_rad_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 0) && one == 3 && two == 2 && three == 5 && four == 3 && five == 5) {
                    U(white, green, blue, orange, rad, scrambl);
                    Fx(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    couple_blue_rad_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 3) && one == 5 && two == 3 && three == 2 && four == 5 && five == 3) {
                    Ux(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    couple_blue_rad_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 3) && one == 3 && two == 2 && three == 5 && four == 3 && five == 5) {
                    U(white, green, blue, orange, rad, scrambl);
                    Fx(green, yellow, white, orange, rad, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    couple_blue_rad_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 0) && one == 5 && two == 3 && three == 2 && four == 5 && five == 3) {
                    Ux(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    couple_blue_rad_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 0) && one == 5 && two == 3 && three == 2 && four == 3 && five == 5) {
                    Ux(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    tripod_blue_rad_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 3) && one == 3 && two == 2 && three == 5 && four == 5 && five == 3) {
                    U(white, green, blue, orange, rad, scrambl);
                    Fx(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    tripod_blue_rad_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 2) && one == 3 && two == 2 && three == 5 && four == 5 && five == 3) {
                    R(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    couple_blue_rad_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 1) && one == 5 && two == 3 && three == 2 && four == 3 && five == 5) {
                    Fx(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Fx(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    couple_blue_rad_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 2) && one == 5 && two == 3 && three == 2 && four == 3 && five == 5) {
                    Fx(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Fx(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    couple_blue_rad_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 1) && one == 3 && two == 2 && three == 5 && four == 5 && five == 3) {
                    R(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    couple_blue_rad_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 2) && one == 5 && two == 3 && three == 2 && four == 5 && five == 3) {
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    couple_blue_rad_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 1) && one == 3 && two == 2 && three == 5 && four == 3 && five == 5) {
                    R(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    tripod_blue_rad_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 2) && one == 2 && two == 5 && three == 3 && four == 3 && five == 5) {
                    Fx(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    tripod_blue_rad_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 1) && one == 2 && two == 5 && three == 3 && four == 5 && five == 3) {
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    tripod_blue_rad_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 1 && j == 2) && one == 2 && two == 5 && three == 3 && four == 3 && five == 5) {
                    R(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    couple_blue_rad_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 2 && j == 1) && one == 2 && two == 5 && three == 3 && four == 5 && five == 3) {
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    couple_blue_rad_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 0 && j == 1) && one == 2 && two == 5 && three == 3 && four == 5 && five == 3) {
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    couple_blue_rad_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 0 && j == 2) && one == 2 && two == 5 && three == 3 && four == 3 && five == 5) {
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    tripod_blue_rad_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 1) && one == 2 && two == 5 && three == 3 && four == 3 && five == 5) {
                    F(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    Fx(green, yellow, white, orange, rad, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    couple_blue_rad_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 2) && one == 2 && two == 5 && three == 3 && four == 5 && five == 3) {
                    R(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    couple_blue_rad_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                U(white, green, blue, orange, rad, scrambl);
                Updateedge(white, green, yellow, blue, orange, rad, edge);
                Updatecorners(white, green, yellow, blue, orange, rad, corners);
                p = findF2L_rad_blue(edge, corners, white, green, yellow, blue, orange, rad);
                i = p[0];
                j = p[1];
                one = p[2];
                two = p[3];
                three = p[4];
                four = p[5];
                five = p[6];
            }
        }
        if (i > 3 && j < 4) {
            for (int k = 0; k < 2; k++) {
                if (i == 5) {//угол в своём слоте, ребро сверху
                    for (int m = 0; m < 4; m++) {
                        if (j == 1 && one == 2 && two == 5 && three == 3 && four == 5 && five == 3) {
                            Ux(white, green, blue, orange, rad, scrambl);
                            Fx(green, yellow, white, orange, rad, scrambl);
                            U(white, green, blue, orange, rad, scrambl);
                            F(green, yellow, white, orange, rad, scrambl);
                            for (int l = 0; l < k; l++) {
                                D(yellow, blue, green, orange, rad, scrambl);
                            }
                            couple_blue_rad_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                            break;
                        }
                        if (j == 2 && one == 2 && two == 5 && three == 3 && four == 3 && five == 5) {
                            U(white, green, blue, orange, rad, scrambl);
                            R(rad, yellow, white, green, blue, scrambl);
                            Ux(white, green, blue, orange, rad, scrambl);
                            Rx(rad, yellow, white, green, blue, scrambl);
                            U(white, green, blue, orange, rad, scrambl);
                            U(white, green, blue, orange, rad, scrambl);
                            for (int l = 0; l < k; l++) {
                                D(yellow, blue, green, orange, rad, scrambl);
                            }
                            couple_blue_rad_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                            break;
                        }
                        if (j == 2 && one == 5 && two == 3 && three == 2 && four == 3 && five == 5) {
                            R(rad, yellow, white, green, blue, scrambl);
                            U(white, green, blue, orange, rad, scrambl);
                            Rx(rad, yellow, white, green, blue, scrambl);
                            U(white, green, blue, orange, rad, scrambl);
                            for (int l = 0; l < k; l++) {
                                D(yellow, blue, green, orange, rad, scrambl);
                            }
                            couple_blue_rad_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                            break;
                        }
                        if (j == 1 && one == 3 && two == 2 && three == 5 && four == 5 && five == 3) {
                            R(rad, yellow, white, green, blue, scrambl);
                            Ux(white, green, blue, orange, rad, scrambl);
                            Rx(rad, yellow, white, green, blue, scrambl);
                            for (int l = 0; l < k; l++) {
                                D(yellow, blue, green, orange, rad, scrambl);
                            }
                            couple_blue_rad_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                            break;
                        }
                        if (j == 2 && one == 3 && two == 2 && three == 5 && four == 3 && five == 5) {
                            Fx(green, yellow, white, orange, rad, scrambl);
                            Ux(white, green, blue, orange, rad, scrambl);
                            F(green, yellow, white, orange, rad, scrambl);
                            for (int l = 0; l < k; l++) {
                                D(yellow, blue, green, orange, rad, scrambl);
                            }
                            tripod_blue_rad_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                            break;
                        }
                        if (j == 1 && one == 5 && two == 3 && three == 2 && four == 5 && five == 3) {
                            R(rad, yellow, white, green, blue, scrambl);
                            U(white, green, blue, orange, rad, scrambl);
                            Rx(rad, yellow, white, green, blue, scrambl);
                            U(white, green, blue, orange, rad, scrambl);
                            U(white, green, blue, orange, rad, scrambl);
                            for (int l = 0; l < k; l++) {
                                D(yellow, blue, green, orange, rad, scrambl);
                            }
                            tripod_blue_rad_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                            break;
                        }
                        U(white, green, blue, orange, rad, scrambl);
                        Updateedge(white, green, yellow, blue, orange, rad, edge);
                        Updatecorners(white, green, yellow, blue, orange, rad, corners);
                        p = findF2L_rad_blue(edge, corners, white, green, yellow, blue, orange, rad);
                        j = p[1];
                        one = p[2];
                        two = p[3];
                        three = p[4];
                        four = p[5];
                        five = p[6];
                    }
                    break;
                } else {
                    Dx(yellow, blue, green, orange, rad, scrambl);
                    Updateedge(white, green, yellow, blue, orange, rad, edge);
                    Updatecorners(white, green, yellow, blue, orange, rad, corners);
                    p = findF2L_rad_blue(edge, corners, white, green, yellow, blue, orange, rad);
                    i = p[0];
                    j = p[1];
                    one = p[2];
                    two = p[3];
                    three = p[4];
                    four = p[5];
                    five = p[6];
                }
            }
        }
    }
    private static int[] findF2L_rad_green(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad){
        //Находим жёлто-сине-оранжевый угол и сине-оранжевое ребро
        int[] l = new int[7];
        int i;
        int j;
        int one = 2;
        int two = 1;
        int three = 5;
        Updatecorners(white, green, yellow, blue, orange, rad, corners);
        Updateedge(white, green, yellow, blue, orange, rad, edge);
        for (i = 0; i < 8; i++) {
            if ((corners[i][0] == one && corners[i][1] == two && corners[i][2] == three) ||
                    (corners[i][0] == two && corners[i][1] == three && corners[i][2] == one) ||
                    (corners[i][0] == three && corners[i][1] == one && corners[i][2] == two)){
                for (j = 0; j < 12; j++) {
                    if ((edge[j][0] == two && edge[j][1] == three) || (edge[j][0] == three && edge[j][1] == two)){
                        if (corners[i][0] == one && corners[i][1] == two && corners[i][2] == three && edge[j][0] == two && edge[j][1] == three){
                            int[] p = new int[7];
                            p[0] = i;
                            p[1] = j;
                            p[2] = one;
                            p[3] = two;
                            p[4] = three;
                            p[5] = two;
                            p[6] = three;
                            return p;
                        }
                        if (corners[i][0] == one && corners[i][1] == two && corners[i][2] == three && edge[j][0] == three && edge[j][1] == two){
                            int[] p = new int[7];
                            p[0] = i;
                            p[1] = j;
                            p[2] = one;
                            p[3] = two;
                            p[4] = three;
                            p[5] = three;
                            p[6] = two;
                            return p;
                        }
                        if (corners[i][0] == three && corners[i][1] == one && corners[i][2] == two && edge[j][0] == two && edge[j][1] == three){
                            int[] p = new int[7];
                            p[0] = i;
                            p[1] = j;
                            p[2] = three;
                            p[3] = one;
                            p[4] = two;
                            p[5] = two;
                            p[6] = three;
                            return p;
                        }
                        if (corners[i][0] == three && corners[i][1] == one && corners[i][2] == two && edge[j][0] == three && edge[j][1] == two){
                            int[] p = new int[7];
                            p[0] = i;
                            p[1] = j;
                            p[2] = three;
                            p[3] = one;
                            p[4] = two;
                            p[5] = three;
                            p[6] = two;
                            return p;
                        }
                        if (corners[i][0] == two && corners[i][1] == three && corners[i][2] == one && edge[j][0] == two && edge[j][1] == three){
                            int[] p = new int[7];
                            p[0] = i;
                            p[1] = j;
                            p[2] = two;
                            p[3] = three;
                            p[4] = one;
                            p[5] = two;
                            p[6] = three;
                            return p;
                        }
                        if (corners[i][0] == two && corners[i][1] == three && corners[i][2] == one && edge[j][0] == three && edge[j][1] == two){
                            int[] p = new int[7];
                            p[0] = i;
                            p[1] = j;
                            p[2] = two;
                            p[3] = three;
                            p[4] = one;
                            p[5] = three;
                            p[6] = two;
                            return p;
                        }
                    }

                }
            }
        }
        return l;
    }
    private static void F2L_rad_green(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl) {
        int[] p = findF2L_rad_green(edge, corners, white, green, yellow, blue, orange, rad);
        int i = p[0];
        int j = p[1];
        int one = p[2];
        int two = p[3];
        int three = p[4];
        int four = p[5];
        int five = p[6];
        if(i == 5 && j == 5 && one == 2 && two == 1 && three == 5 && four == 1 && five == 5){
            return;
        }
        //i - рассположение угла; j - рассположение ребра; one,two,three - цвет угла по часовой;four,five - цвет ребра сверху вниз
        //сделать скрамбл
        if (j == 5){//Если ребро находится на среднем слое, просто достаём его оттуда
            R(rad, yellow, white, green, blue, scrambl);
            U(white, green, blue, orange, rad, scrambl);
            Rx(rad, yellow, white, green, blue, scrambl);
            Updateedge(white, green, yellow, blue, orange, rad, edge);
            Updatecorners(white, green, yellow, blue, orange, rad, corners);
            p = findF2L_rad_green(edge, corners, white, green, yellow, blue, orange, rad);
            i = p[0];
            j = p[1];
            one = p[2];
            two = p[3];
            three = p[4];
            four = p[5];
            five = p[6];
        }
        if (i < 4 && j < 4) {//ребро и угол находится сверху
            for (int k = 0; k < 4; k++) {
                if ((i == 3 && j == 2) && one == 5 && two == 2 && three == 1 && four == 5 && five == 1) {//правая пара
                    Ux(white, green, blue, orange, rad, scrambl);
                    couple_green_rad_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 1) && one == 1 && two == 5 && three == 2 && four == 1 && five == 5) {//левая пара
                    U(white, green, blue, orange, rad, scrambl);
                    couple_green_rad_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 3) && one == 1 && two == 5 && three == 2 && four == 5 && five == 1) {//левая трёхходовка
                    tripod_green_rad_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if (i == 3 && j == 0 && one == 5 && two == 2 && three == 1 && four == 1 && five == 5) {//правая трёхходовка
                    tripod_green_rad_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 0) && one == 5 && two == 2 && three == 1 && four == 5 && five == 1) {
                    U(white, green, blue, orange, rad, scrambl);
                    Fx(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    couple_green_rad_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 3) && one == 1 && two == 5 && three == 2 && four == 1 && five == 5) {//левая трёхходовка
                    Ux(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    couple_green_rad_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 3) && one == 5 && two == 2 && three == 1 && four == 5 && five == 1) {
                    U(white, green, blue, orange, rad, scrambl);
                    Fx(green, yellow, white, orange, rad, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    couple_green_rad_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 0) && one == 1 && two == 5 && three == 2 && four == 1 && five == 5) {//левая трёхходовка
                    Ux(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    couple_green_rad_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 0) && one == 1 && two == 5 && three == 2 && four == 5 && five == 1) {//левая трёхходовка
                    Ux(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    tripod_green_rad_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 3) && one == 5 && two == 2 && three == 1 && four == 1 && five == 5) {
                    U(white, green, blue, orange, rad, scrambl);
                    Fx(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    tripod_green_rad_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 2) && one == 5 && two == 2 && three == 1 && four == 1 && five == 5) {//правая пара
                    R(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    couple_green_rad_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 1) && one == 1 && two == 5 && three == 2 && four == 5 && five == 1) {//левая пара
                    Fx(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Fx(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    couple_green_rad_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 2) && one == 1 && two == 5 && three == 2 && four == 5 && five == 1) {//левая пара
                    Fx(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Fx(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    couple_green_rad_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 1) && one == 5 && two == 2 && three == 1 && four == 1 && five == 5) {//левая пара
                    R(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    couple_green_rad_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 2) && one == 1 && two == 5 && three == 2 && four == 1 && five == 5) {//левая пара
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    couple_green_rad_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 1) && one == 5 && two == 2 && three == 1 && four == 5 && five == 1) {//левая пара
                    R(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    tripod_green_rad_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 2) && one == 2 && two == 1 && three == 5 && four == 5 && five == 1) {//левая пара
                    Fx(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    tripod_green_rad_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 1) && one == 2 && two == 1 && three == 5 && four == 1 && five == 5) {//левая пара
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    tripod_green_rad_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 1 && j == 2) && one == 2 && two == 1 && three == 5 && four == 5 && five == 1) {//левая пара
                    R(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    couple_green_rad_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 2 && j == 1) && one == 2 && two == 1 && three == 5 && four == 1 && five == 5) {//левая пара
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    couple_green_rad_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 0 && j == 1) && one == 2 && two == 1 && three == 5 && four == 1 && five == 5) {//левая пара
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    couple_green_rad_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 0 && j == 2) && one == 2 && two == 1 && three == 5 && four == 5 && five == 1) {//левая пара
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    tripod_green_rad_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 1) && one == 2 && two == 1 && three == 5 && four == 5 && five == 1) {//левая пара
                    F(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    Fx(green, yellow, white, orange, rad, scrambl);
                    couple_green_rad_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if ((i == 3 && j == 2) && one == 2 && two == 1 && three == 5 && four == 1 && five == 5) {//левая пара
                    R(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    couple_green_rad_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                U(white, green, blue, orange, rad, scrambl);
                Updateedge(white, green, yellow, blue, orange, rad, edge);
                Updatecorners(white, green, yellow, blue, orange, rad, corners);
                p = findF2L_rad_green(edge, corners, white, green, yellow, blue, orange, rad);
                i = p[0];
                j = p[1];
                one = p[2];
                two = p[3];
                three = p[4];
                four = p[5];
                five = p[6];
            }
        }
        if (i > 3 && j < 4) {
            //угол в своём слоте, ребро сверху
            for (int m = 0; m < 4; m++) {
                if (j == 1 && one == 2 && two == 1 && three == 5 && four == 1 && five == 5) {
                    Ux(white, green, blue, orange, rad, scrambl);
                    Fx(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    couple_green_rad_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if (j == 2 && one == 2 && two == 1 && three == 5 && four == 5 && five == 1) {
                    U(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    couple_green_rad_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if (j == 2 && one == 1 && two == 5 && three == 2 && four == 5 && five == 1) {
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    couple_green_rad_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if (j == 1 && one == 5 && two == 2 && three == 1 && four == 1 && five == 5) {
                    R(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    couple_green_rad_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if (j == 2 && one == 5 && two == 2 && three == 1 && four == 5 && five == 1) {
                    Fx(green, yellow, white, orange, rad, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    tripod_green_rad_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                if (j == 1 && one == 1 && two == 5 && three == 2 && four == 1 && five == 5) {
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    tripod_green_rad_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
                    break;
                }
                U(white, green, blue, orange, rad, scrambl);
                Updateedge(white, green, yellow, blue, orange, rad, edge);
                Updatecorners(white, green, yellow, blue, orange, rad, corners);
                p = findF2L_rad_green(edge, corners, white, green, yellow, blue, orange, rad);
                j = p[1];
                one = p[2];
                two = p[3];
                three = p[4];
                four = p[5];
                five = p[6];
            }
        }
    }
    //OLL
    private static void OLL(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        int white_edge = 0;//Количество рёбер сверху повёрнутых вверх белым
        for (int i = 0; i < 4; i++) {
            if (edge[i][0] == 0){
                white_edge++;
            }
        }
        //Скип OLL
        if (white_edge == 4 && corners[0][0] == 0 && corners[1][0] == 0 && corners[2][0] == 0 && corners[3][0] == 0){
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (white_edge == 0){//белая точка в центре; ребра смотрят в бок
                if (corners[0][1] == 0 && corners[1][2] == 0 && corners[2][2] == 0 && corners[3][1] == 0){//точка
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    Fx(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    Fx(green, yellow, white, orange, rad, scrambl);
                    Updateedge(white, green, yellow, blue, orange, rad, edge);
                    Updatecorners(white, green, yellow, blue, orange, rad, corners);
                    break;
                }
                if (corners[0][1] == 0 && corners[1][1] == 0 && corners[2][2] == 0 && corners[3][2] == 0){//точка
                    F(green, yellow, white, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    B(blue, yellow, white, rad, orange, scrambl);
                    Fx(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    L(orange, yellow, white, blue, green, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Lx(orange, yellow, white, blue, green, scrambl);
                    Bx(blue, yellow, white, rad, orange, scrambl);
                    Updateedge(white, green, yellow, blue, orange, rad, edge);
                    Updatecorners(white, green, yellow, blue, orange, rad, corners);
                    break;
                }
                if (corners[0][2] == 0 && corners[1][0] == 0 && corners[2][2] == 0 && corners[3][2] == 0){//запятая
                    L(orange, yellow, white, blue, green, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Fx(green, yellow, white, orange, rad, scrambl);
                    Lx(orange, yellow, white, blue, green, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Fx(green, yellow, white, orange, rad, scrambl);
                    Updateedge(white, green, yellow, blue, orange, rad, edge);
                    Updatecorners(white, green, yellow, blue, orange, rad, corners);
                    break;
                }
                if (corners[0][1] == 0 && corners[1][1] == 0 && corners[2][0] == 0 && corners[3][1] == 0){//запятая
                    F(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    Fx(green, yellow, white, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    Fx(green, yellow, white, orange, rad, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    Updateedge(white, green, yellow, blue, orange, rad, edge);
                    Updatecorners(white, green, yellow, blue, orange, rad, corners);
                    break;
                }
                if (corners[0][0] == 0 && corners[1][0] == 0 && corners[2][2] == 0 && corners[3][1] == 0){//микки маус
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    Updateedge(white, green, yellow, blue, orange, rad, edge);
                    Updatecorners(white, green, yellow, blue, orange, rad, corners);
                    break;
                }
                if (corners[0][0] == 0 && corners[1][2] == 0 && corners[2][0] == 0 && corners[3][1] == 0){//микки маус
                    F(green, yellow, white, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    Fx(green, yellow, white, orange, rad, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Fx(green, yellow, white, orange, rad, scrambl);
                    Updateedge(white, green, yellow, blue, orange, rad, edge);
                    Updatecorners(white, green, yellow, blue, orange, rad, corners);
                    break;
                }
                if (corners[0][0] == 0 && corners[1][1] == 0 && corners[2][2] == 0 && corners[3][0] == 0){//диогональ
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    Fx(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    Fx(green, yellow, white, orange, rad, scrambl);
                    Updateedge(white, green, yellow, blue, orange, rad, edge);
                    Updatecorners(white, green, yellow, blue, orange, rad, corners);
                    break;
                }
                if (corners[0][0] == 0 && corners[1][0] == 0 && corners[2][0] == 0 && corners[3][0] == 0){//снежинка
                    B(blue, yellow, white, rad, orange, scrambl);
                    Fx(green, yellow, white, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    L(orange, yellow, white, blue, green, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Lx(orange, yellow, white, blue, green, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Lx(orange, yellow, white, blue, green, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    L(orange, yellow, white, blue, green, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Bx(blue, yellow, white, rad, orange, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    Updateedge(white, green, yellow, blue, orange, rad, edge);
                    Updatecorners(white, green, yellow, blue, orange, rad, corners);
                    break;
                }
            }
            if (white_edge == 2){// белый угол или линия; ребра 2 в бок, 2 вверх
                if(edge[1][0] == 0 && edge[3][0] == 0){//линия
                    if (corners[0][0] == 0 && corners[1][0] == 0 && corners[2][0] == 0 && corners[3][0] == 0){//буква Н
                        R(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        L(orange, yellow, white, blue, green, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        Fx(green, yellow, white, orange, rad, scrambl);
                        Lx(orange, yellow, white, blue, green, scrambl);
                        Updateedge(white, green, yellow, blue, orange, rad, edge);
                        Updatecorners(white, green, yellow, blue, orange, rad, corners);
                        break;
                    }
                    if (corners[0][2] == 0 && corners[1][2] == 0 && corners[2][1] == 0 && corners[3][1] == 0){//палка
                        F(green, yellow, white, orange, rad, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        Fx(green, yellow, white, orange, rad, scrambl);
                        Updateedge(white, green, yellow, blue, orange, rad, edge);
                        Updatecorners(white, green, yellow, blue, orange, rad, corners);
                        break;
                    }
                    if (corners[0][2] == 0 && corners[1][1] == 0 && corners[2][2] == 0 && corners[3][1] == 0){//палка
                        F(green, yellow, white, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        Fx(green, yellow, white, orange, rad, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        Fx(green, yellow, white, orange, rad, scrambl);
                        Updateedge(white, green, yellow, blue, orange, rad, edge);
                        Updatecorners(white, green, yellow, blue, orange, rad, corners);
                        break;
                    }
                    if (corners[0][1] == 0 && corners[1][2] == 0 && corners[2][2] == 0 && corners[3][1] == 0){//палка
                        Rx(rad, yellow, white, green, blue, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        Fx(green, yellow, white, orange, rad, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        Fx(green, yellow, white, orange, rad, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        Updateedge(white, green, yellow, blue, orange, rad, edge);
                        Updatecorners(white, green, yellow, blue, orange, rad, corners);
                        break;
                    }
                    if (corners[0][2] == 0 && corners[1][1] == 0 && corners[2][1] == 0 && corners[3][2] == 0){//палка
                        Rx(rad, yellow, white, green, blue, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        Fx(green, yellow, white, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        Updateedge(white, green, yellow, blue, orange, rad, edge);
                        Updatecorners(white, green, yellow, blue, orange, rad, corners);
                        break;
                    }
                    if (corners[0][1] == 0 && corners[1][1] == 0 && corners[2][0] == 0 && corners[3][1] == 0){//буква Г
                        Rx(rad, yellow, white, green, blue, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        Fx(green, yellow, white, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        Updateedge(white, green, yellow, blue, orange, rad, edge);
                        Updatecorners(white, green, yellow, blue, orange, rad, corners);
                        break;
                    }
                    if (corners[0][2] == 0 && corners[1][2] == 0 && corners[2][0] == 0 && corners[3][2] == 0){//буква Г
                        F(green, yellow, white, orange, rad, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        Fx(green, yellow, white, orange, rad, scrambl);
                        Updateedge(white, green, yellow, blue, orange, rad, edge);
                        Updatecorners(white, green, yellow, blue, orange, rad, corners);
                        break;
                    }
                    if (corners[0][0] == 0 && corners[1][2] == 0 && corners[2][2] == 0 && corners[3][2] == 0){//буква Г
                        Rx(rad, yellow, white, green, blue, scrambl);
                        Fx(green, yellow, white, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        Lx(orange, yellow, white, blue, green, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        L(orange, yellow, white, blue, green, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        Updateedge(white, green, yellow, blue, orange, rad, edge);
                        Updatecorners(white, green, yellow, blue, orange, rad, corners);
                        break;
                    }
                    if (corners[0][1] == 0 && corners[1][1] == 0 && corners[2][1] == 0 && corners[3][0] == 0){//буква Г
                        Rx(rad, yellow, white, green, blue, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        Fx(green, yellow, white, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        Fx(green, yellow, white, orange, rad, scrambl);
                        Updateedge(white, green, yellow, blue, orange, rad, edge);
                        Updatecorners(white, green, yellow, blue, orange, rad, corners);
                        break;
                    }
                    if (corners[0][1] == 0 && corners[1][0] == 0 && corners[2][2] == 0 && corners[3][0] == 0){//буква T
                        F(green, yellow, white, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        Fx(green, yellow, white, orange, rad, scrambl);
                        Updateedge(white, green, yellow, blue, orange, rad, edge);
                        Updatecorners(white, green, yellow, blue, orange, rad, corners);
                        break;
                    }
                    if (corners[0][2] == 0 && corners[1][0] == 0 && corners[2][1] == 0 && corners[3][0] == 0){//буква T
                        R(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        Fx(green, yellow, white, orange, rad, scrambl);
                        Updateedge(white, green, yellow, blue, orange, rad, edge);
                        Updatecorners(white, green, yellow, blue, orange, rad, corners);
                        break;
                    }
                    if (corners[0][1] == 0 && corners[1][2] == 0 && corners[2][0] == 0 && corners[3][0] == 0){//Скобка
                        R(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        Fx(green, yellow, white, orange, rad, scrambl);
                        Updateedge(white, green, yellow, blue, orange, rad, edge);
                        Updatecorners(white, green, yellow, blue, orange, rad, corners);
                        break;
                    }
                    if (corners[0][2] == 0 && corners[1][1] == 0 && corners[2][0] == 0 && corners[3][0] == 0){//Скобка
                        U(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        Fx(green, yellow, white, orange, rad, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        Updateedge(white, green, yellow, blue, orange, rad, edge);
                        Updatecorners(white, green, yellow, blue, orange, rad, corners);
                        break;
                    }
                    if (corners[0][0] == 0 && corners[1][1] == 0 && corners[2][2] == 0 && corners[3][0] == 0){//Пропеллеры
                        Rx(rad, yellow, white, green, blue, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        Fx(green, yellow, white, orange, rad, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        Updateedge(white, green, yellow, blue, orange, rad, edge);
                        Updatecorners(white, green, yellow, blue, orange, rad, corners);
                        break;
                    }
                    if (corners[0][2] == 0 && corners[1][0] == 0 && corners[2][0] == 0 && corners[3][1] == 0){//Пропеллеры
                        L(orange, yellow, white, blue, green, scrambl);
                        Fx(green, yellow, white, orange, rad, scrambl);
                        Lx(orange, yellow, white, blue, green, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        L(orange, yellow, white, blue, green, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        Lx(orange, yellow, white, blue, green, scrambl);
                        Updateedge(white, green, yellow, blue, orange, rad, edge);
                        Updatecorners(white, green, yellow, blue, orange, rad, corners);
                        break;
                    }
                }
                if(edge[0][0] == 0 && edge[1][0] == 0){//угол
                    if (corners[0][2] == 0 && corners[1][2] == 0 && corners[2][1] == 0 && corners[3][1] == 0){//Стелсы
                        Fx(green, yellow, white, orange, rad, scrambl);
                        Lx(orange, yellow, white, blue, green, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        L(orange, yellow, white, blue, green, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        Lx(orange, yellow, white, blue, green, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        L(orange, yellow, white, blue, green, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        Updateedge(white, green, yellow, blue, orange, rad, edge);
                        Updatecorners(white, green, yellow, blue, orange, rad, corners);
                        break;
                    }
                    if (corners[0][1] == 0 && corners[1][2] == 0 && corners[2][2] == 0 && corners[3][1] == 0){//Стелсы
                        L(orange, yellow, white, blue, green, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        Fx(green, yellow, white, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        Lx(orange, yellow, white, blue, green, scrambl);
                        Updateedge(white, green, yellow, blue, orange, rad, edge);
                        Updatecorners(white, green, yellow, blue, orange, rad, corners);
                        break;
                    }
                    if (corners[0][1] == 0 && corners[1][2] == 0 && corners[2][1] == 0 && corners[3][2] == 0){//Стелсы
                        R(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        Fx(green, yellow, white, orange, rad, scrambl);
                        Updateedge(white, green, yellow, blue, orange, rad, edge);
                        Updatecorners(white, green, yellow, blue, orange, rad, corners);
                        break;
                    }
                    if (corners[0][1] == 0 && corners[1][0] == 0 && corners[2][1] == 0 && corners[3][1] == 0){//Квадрат
                        L(orange, yellow, white, blue, green, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        Fx(green, yellow, white, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        Fx(green, yellow, white, orange, rad, scrambl);
                        Lx(orange, yellow, white, blue, green, scrambl);
                        Updateedge(white, green, yellow, blue, orange, rad, edge);
                        Updatecorners(white, green, yellow, blue, orange, rad, corners);
                        break;
                    }
                    if (corners[0][1] == 0 && corners[1][1] == 0 && corners[2][1] == 0 && corners[3][0] == 0){//Молния
                        R(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        Fx(green, yellow, white, orange, rad, scrambl);
                        Updateedge(white, green, yellow, blue, orange, rad, edge);
                        Updatecorners(white, green, yellow, blue, orange, rad, corners);
                        break;
                    }
                    if (corners[0][2] == 0 && corners[1][2] == 0 && corners[2][2] == 0 && corners[3][0] == 0){//Молния
                        L(orange, yellow, white, blue, green, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        Lx(orange, yellow, white, blue, green, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        Updateedge(white, green, yellow, blue, orange, rad, edge);
                        Updatecorners(white, green, yellow, blue, orange, rad, corners);
                        break;
                    }
                    if (corners[0][2] == 0 && corners[1][0] == 0 && corners[2][0] == 0 && corners[3][1] == 0){//Галстук
                        Rx(rad, yellow, white, green, blue, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        Fx(green, yellow, white, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        Updateedge(white, green, yellow, blue, orange, rad, edge);
                        Updatecorners(white, green, yellow, blue, orange, rad, corners);
                        break;
                    }
                }
                if(edge[1][0] == 0 && edge[2][0] == 0){//угол
                    if (corners[0][2] == 0 && corners[1][1] == 0 && corners[2][2] == 0 && corners[3][1] == 0){//Стелсы
                        Rx(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        Fx(green, yellow, white, orange, rad, scrambl);
                        Updateedge(white, green, yellow, blue, orange, rad, edge);
                        Updatecorners(white, green, yellow, blue, orange, rad, corners);
                        break;
                    }
                    if (corners[0][2] == 0 && corners[1][1] == 0 && corners[2][1] == 0 && corners[3][1] == 0){//Молния
                        F(green, yellow, white, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        Fx(green, yellow, white, orange, rad, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        Fx(green, yellow, white, orange, rad, scrambl);
                        Updateedge(white, green, yellow, blue, orange, rad, edge);
                        Updatecorners(white, green, yellow, blue, orange, rad, corners);
                        break;
                    }
                    if (corners[0][1] == 0 && corners[1][0] == 0 && corners[2][2] == 0 && corners[3][0] == 0){//Мягкий знак
                        B(blue, yellow, white, rad, orange, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        L(orange, yellow, white, blue, green, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        Lx(orange, yellow, white, blue, green, scrambl);
                        Bx(blue, yellow, white, rad, orange, scrambl);
                        Updateedge(white, green, yellow, blue, orange, rad, edge);
                        Updatecorners(white, green, yellow, blue, orange, rad, corners);
                        break;
                    }
                    if (corners[0][2] == 0 && corners[1][0] == 0 && corners[2][1] == 0 && corners[3][0] == 0) {//Мягкий знак
                        R(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        Bx(blue, yellow, white, rad, orange, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        B(blue, yellow, white, rad, orange, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        Updateedge(white, green, yellow, blue, orange, rad, edge);
                        Updatecorners(white, green, yellow, blue, orange, rad, corners);
                        break;
                    }
                    if (corners[0][0] == 0 && corners[1][0] == 0 && corners[2][1] == 0 && corners[3][2] == 0) {//Петух
                        R(rad, yellow, white, green, blue, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        B(blue, yellow, white, rad, orange, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        Bx(blue, yellow, white, rad, orange, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        Updateedge(white, green, yellow, blue, orange, rad, edge);
                        Updatecorners(white, green, yellow, blue, orange, rad, corners);
                        break;
                    }
                    if (corners[0][0] == 0 && corners[1][0] == 0 && corners[2][2] == 0 && corners[3][1] == 0) {//Петух
                        R(rad, yellow, white, green, blue, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        Bx(blue, yellow, white, rad, orange, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        B(blue, yellow, white, rad, orange, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        Updateedge(white, green, yellow, blue, orange, rad, edge);
                        Updatecorners(white, green, yellow, blue, orange, rad, corners);
                        break;
                    }
                    if (corners[0][0] == 0 && corners[1][2] == 0 && corners[2][2] == 0 && corners[3][2] == 0){//Рюмка
                        R(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        Fx(green, yellow, white, orange, rad, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        Updateedge(white, green, yellow, blue, orange, rad, edge);
                        Updatecorners(white, green, yellow, blue, orange, rad, corners);
                        break;
                    }
                }
                if(edge[2][0] == 0 && edge[3][0] == 0){//угол
                    if (corners[0][0] == 0 && corners[1][2] == 0 && corners[2][0] == 0 && corners[3][1] == 0){//Мягкий знак
                        Bx(blue, yellow, white, rad, orange, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        B(blue, yellow, white, rad, orange, scrambl);
                        Updateedge(white, green, yellow, blue, orange, rad, edge);
                        Updatecorners(white, green, yellow, blue, orange, rad, corners);
                        break;
                    }
                    if (corners[0][0] == 0 && corners[1][1] == 0 && corners[2][0] == 0 && corners[3][2] == 0){//Мягкий знак
                        Rx(rad, yellow, white, green, blue, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        Updateedge(white, green, yellow, blue, orange, rad, edge);
                        Updatecorners(white, green, yellow, blue, orange, rad, corners);
                        break;
                    }
                    if (corners[0][0] == 0 && corners[1][0] == 0 && corners[2][1] == 0 && corners[3][2] == 0) {//Петух
                        Rx(rad, yellow, white, green, blue, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        Fx(green, yellow, white, orange, rad, scrambl);
                        Updateedge(white, green, yellow, blue, orange, rad, edge);
                        Updatecorners(white, green, yellow, blue, orange, rad, corners);
                        break;
                    }
                }
                if(edge[0][0] == 0 && edge[3][0] == 0){//угол
                    if (corners[0][1] == 0 && corners[1][1] == 0 && corners[2][2] == 0 && corners[3][2] == 0){//Стелсы
                        F(green, yellow, white, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        Fx(green, yellow, white, orange, rad, scrambl);
                        Updateedge(white, green, yellow, blue, orange, rad, edge);
                        Updatecorners(white, green, yellow, blue, orange, rad, corners);
                        break;
                    }
                    if (corners[0][1] == 0 && corners[1][2] == 0 && corners[2][2] == 0 && corners[3][1] == 0){//Стелсы
                        F(green, yellow, white, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        Fx(green, yellow, white, orange, rad, scrambl);
                        Updateedge(white, green, yellow, blue, orange, rad, edge);
                        Updatecorners(white, green, yellow, blue, orange, rad, corners);
                        break;
                    }
                    if (corners[0][1] == 0 && corners[1][0] == 0 && corners[2][0] == 0 && corners[3][2] == 0){//Буква М
                        R(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        Fx(green, yellow, white, orange, rad, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        Updateedge(white, green, yellow, blue, orange, rad, edge);
                        Updatecorners(white, green, yellow, blue, orange, rad, corners);
                        break;
                    }
                    if (corners[0][0] == 0 && corners[1][0] == 0 && corners[2][0] == 0 && corners[3][0] == 0){//Летающий змей
                        L(orange, yellow, white, blue, green, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        Fx(green, yellow, white, orange, rad, scrambl);
                        Lx(orange, yellow, white, blue, green, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        Updateedge(white, green, yellow, blue, orange, rad, edge);
                        Updatecorners(white, green, yellow, blue, orange, rad, corners);
                        break;
                    }
                    if (corners[0][0] == 0 && corners[1][2] == 0 && corners[2][2] == 0 && corners[3][2] == 0){//Квадрат
                        Rx(rad, yellow, white, green, blue, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        L(orange, yellow, white, blue, green, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        Lx(orange, yellow, white, blue, green, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        Updateedge(white, green, yellow, blue, orange, rad, edge);
                        Updatecorners(white, green, yellow, blue, orange, rad, corners);
                        break;
                    }
                    if (corners[0][0] == 0 && corners[1][2] == 0 && corners[2][2] == 0 && corners[3][2] == 0){//Рюмка
                        R(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        Fx(green, yellow, white, orange, rad, scrambl);
                        Updateedge(white, green, yellow, blue, orange, rad, edge);
                        Updatecorners(white, green, yellow, blue, orange, rad, corners);
                        break;
                    }
                    if (corners[0][2] == 0 && corners[1][2] == 0 && corners[2][0] == 0 && corners[3][2] == 0){//Молния
                        L(orange, yellow, white, blue, green, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        Lx(orange, yellow, white, blue, green, scrambl);
                        Updateedge(white, green, yellow, blue, orange, rad, edge);
                        Updatecorners(white, green, yellow, blue, orange, rad, corners);
                        break;
                    }
                    if (corners[0][2] == 0 && corners[1][0] == 0 && corners[2][0] == 0 && corners[3][1] == 0){//Буква М
                        R(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        Fx(green, yellow, white, orange, rad, scrambl);
                        Updateedge(white, green, yellow, blue, orange, rad, edge);
                        Updatecorners(white, green, yellow, blue, orange, rad, corners);
                        break;
                    }
                    if (corners[0][0] == 0 && corners[1][2] == 0 && corners[2][1] == 0 && corners[3][0] == 0){//Галстук
                        F(green, yellow, white, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        Fx(green, yellow, white, orange, rad, scrambl);
                        Updateedge(white, green, yellow, blue, orange, rad, edge);
                        Updatecorners(white, green, yellow, blue, orange, rad, corners);
                        break;
                    }
                    if (corners[0][2] == 0 && corners[1][0] == 0 && corners[2][1] == 0 && corners[3][0] == 0) {//Петух
                        R(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        Fx(green, yellow, white, orange, rad, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        F(green, yellow, white, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        Updateedge(white, green, yellow, blue, orange, rad, edge);
                        Updatecorners(white, green, yellow, blue, orange, rad, corners);
                        break;
                    }
                }
            }
            if (white_edge == 4){// белый крест; ребра смотрят наверх
                if (corners[0][2] == 0 && corners[1][1] == 0 && corners[2][0] == 0 && corners[3][0] == 0){//глаза
                    R(rad, yellow, white, green, blue, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    Dx(yellow, blue, green, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    D(yellow, blue, green, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    Updateedge(white, green, yellow, blue, orange, rad, edge);
                    Updatecorners(white, green, yellow, blue, orange, rad, corners);
                    break;
                }
                if (corners[0][1] == 0 && corners[1][2] == 0 && corners[2][0] == 0 && corners[3][0] == 0){//уши
                    Rx(rad, yellow, white, green, blue, scrambl);
                    Fx(green, yellow, white, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    F(green, yellow, white, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    Updateedge(white, green, yellow, blue, orange, rad, edge);
                    Updatecorners(white, green, yellow, blue, orange, rad, corners);
                    break;
                }
                if (corners[0][0] == 0 && corners[1][1] == 0 && corners[2][2] == 0 && corners[3][0] == 0){//восьмёрка
                    R(rad, yellow, white, green, blue, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    Dx(yellow, blue, green, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    D(yellow, blue, green, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    Updateedge(white, green, yellow, blue, orange, rad, edge);
                    Updatecorners(white, green, yellow, blue, orange, rad, corners);
                    break;
                }
                if (corners[0][1] == 0 && corners[1][2] == 0 && corners[2][2] == 0 && corners[3][1] == 0){//двойные глаза
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    Updateedge(white, green, yellow, blue, orange, rad, edge);
                    Updatecorners(white, green, yellow, blue, orange, rad, corners);
                    break;
                }
                if (corners[0][1] == 0 && corners[1][1] == 0 && corners[2][2] == 0 && corners[3][2] == 0){//верталёт
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    Updateedge(white, green, yellow, blue, orange, rad, edge);
                    Updatecorners(white, green, yellow, blue, orange, rad, corners);
                    break;
                }
                if (corners[0][2] == 0 && corners[1][2] == 0 && corners[2][0] == 0 && corners[3][2] == 0){//рыбка
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    R(rad, yellow, white, green, blue, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    Rx(rad, yellow, white, green, blue, scrambl);
                    Updateedge(white, green, yellow, blue, orange, rad, edge);
                    Updatecorners(white, green, yellow, blue, orange, rad, corners);
                    break;
                }
                if (corners[0][1] == 0 && corners[1][1] == 0 && corners[2][1] == 0 && corners[3][0] == 0){//рыбка
                    Lx(orange, yellow, white, blue, green, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    L(orange, yellow, white, blue, green, scrambl);
                    Ux(white, green, blue, orange, rad, scrambl);
                    Lx(orange, yellow, white, blue, green, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    U(white, green, blue, orange, rad, scrambl);
                    L(orange, yellow, white, blue, green, scrambl);
                    Updateedge(white, green, yellow, blue, orange, rad, edge);
                    Updatecorners(white, green, yellow, blue, orange, rad, corners);
                    break;
                }
            }
            U(white, green, blue, orange, rad, scrambl);
            Updateedge(white, green, yellow, blue, orange, rad, edge);
            Updatecorners(white, green, yellow, blue, orange, rad, corners);
        }
    }
    //PLL
    private static void PLL(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        for (int i = 0; i < 4; i++) {
            //Скип PLL
            if (edge[0][1] == 3 && edge[1][1] == 5 && edge[2][1] == 1 && edge[3][1] == 4 && corners[0][1] == 4 && corners[0][2] == 3 && corners[1][1] == 3 && corners[1][2] == 5 && corners[2][1] == 1 && corners[2][2] == 4 && corners[3][1] == 5 && corners[3][2] == 1) {
                return;
            }
            //Треугольник углов по часовой (A-perm)
            if (edge[0][1] == 3 && edge[1][1] == 5 && edge[2][1] == 1 && edge[3][1] == 4 && corners[0][1] == 3 && corners[0][2] == 5 && corners[1][1] == 5 && corners[1][2] == 1 && corners[2][1] == 1 && corners[2][2] == 4 && corners[3][1] == 4 && corners[3][2] == 3) {
                Ux(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                break;
            }
            if (edge[0][1] == 4 && edge[1][1] == 3 && edge[2][1] == 5 && edge[3][1] == 1 && corners[0][1] == 1 && corners[0][2] == 4 && corners[1][1] == 3 && corners[1][2] == 5 && corners[2][1] == 5 && corners[2][2] == 1 && corners[3][1] == 1 && corners[3][2] == 4) {
                Ux(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                break;
            }
            if (edge[0][1] == 1 && edge[1][1] == 4 && edge[2][1] == 3 && edge[3][1] == 5 && corners[0][1] == 1 && corners[0][2] == 4 && corners[1][1] == 4 && corners[1][2] == 3 && corners[2][1] == 3 && corners[2][2] == 5 && corners[3][1] == 5 && corners[3][2] == 1) {
                Ux(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                break;
            }
            if (edge[0][1] == 5 && edge[1][1] == 1 && edge[2][1] == 4 && edge[3][1] == 3 && corners[0][1] == 5 && corners[0][2] == 1 && corners[1][1] == 1 && corners[1][2] == 4 && corners[2][1] == 4 && corners[2][2] == 3 && corners[3][1] == 3 && corners[3][2] == 5) {
                Ux(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                break;
            }
            //Треугольник углов против часовой (A-perm)
            if (edge[0][1] == 3 && edge[1][1] == 5 && edge[2][1] == 1 && edge[3][1] == 4 && corners[0][1] == 5 && corners[0][2] == 1 && corners[1][1] == 4 && corners[1][2] == 3 && corners[2][1] == 1 && corners[2][2] == 4 && corners[3][1] == 3 && corners[3][2] == 5) {
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                B(blue, yellow, white, rad, orange, scrambl);
                B(blue, yellow, white, rad, orange, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                B(blue, yellow, white, rad, orange, scrambl);
                B(blue, yellow, white, rad, orange, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                break;
            }
            if (edge[0][1] == 4 && edge[1][1] == 3 && edge[2][1] == 5 && edge[3][1] == 1 && corners[0][1] == 3 && corners[0][2] == 5 && corners[1][1] == 1 && corners[1][2] == 4 && corners[2][1] == 5 && corners[2][2] == 1 && corners[3][1] == 4 && corners[3][2] == 3) {
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                B(blue, yellow, white, rad, orange, scrambl);
                B(blue, yellow, white, rad, orange, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                B(blue, yellow, white, rad, orange, scrambl);
                B(blue, yellow, white, rad, orange, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                break;
            }
            if (edge[0][1] == 1 && edge[1][1] == 4 && edge[2][1] == 3 && edge[3][1] == 5 && corners[0][1] == 4 && corners[0][2] == 3 && corners[1][1] == 5 && corners[1][2] == 1 && corners[2][1] == 3 && corners[2][2] == 5 && corners[3][1] == 1 && corners[3][2] == 4) {
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                B(blue, yellow, white, rad, orange, scrambl);
                B(blue, yellow, white, rad, orange, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                B(blue, yellow, white, rad, orange, scrambl);
                B(blue, yellow, white, rad, orange, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                break;
            }
            if (edge[0][1] == 5 && edge[1][1] == 1 && edge[2][1] == 4 && edge[3][1] == 3 && corners[0][1] == 1 && corners[0][2] == 4 && corners[1][1] == 3 && corners[1][2] == 5 && corners[2][1] == 4 && corners[2][2] == 3 && corners[3][1] == 5 && corners[3][2] == 1) {
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                B(blue, yellow, white, rad, orange, scrambl);
                B(blue, yellow, white, rad, orange, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                B(blue, yellow, white, rad, orange, scrambl);
                B(blue, yellow, white, rad, orange, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                break;
            }
            //Терминатор(E-perm)
            if (edge[0][1] == 3 && edge[1][1] == 5 && edge[2][1] == 1 && edge[3][1] == 4 && corners[0][1] == 1 && corners[0][2] == 4 && corners[1][1] == 5 && corners[1][2] == 1 && corners[2][1] == 4 && corners[2][2] == 3 && corners[3][1] == 3 && corners[3][2] == 5) {
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Dx(yellow, blue, green, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                D(yellow, blue, green, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Dx(yellow, blue, green, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                D(yellow, blue, green, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                break;
            }
            if (edge[0][1] == 4 && edge[1][1] == 3 && edge[2][1] == 5 && edge[3][1] == 1 && corners[0][1] == 1 && corners[0][2] == 4 && corners[1][1] == 5 && corners[1][2] == 1 && corners[2][1] == 4 && corners[2][2] == 3 && corners[3][1] == 3 && corners[3][2] == 5) {
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Dx(yellow, blue, green, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                D(yellow, blue, green, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Dx(yellow, blue, green, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                D(yellow, blue, green, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                break;
            }
            if (edge[0][1] == 3 && edge[1][1] == 5 && edge[2][1] == 1 && edge[3][1] == 4 && corners[0][1] == 5 && corners[0][2] == 1 && corners[1][1] == 1 && corners[1][2] == 4 && corners[2][1] == 3 && corners[2][2] == 5 && corners[3][1] == 4 && corners[3][2] == 3) {
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Dx(yellow, blue, green, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                D(yellow, blue, green, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Dx(yellow, blue, green, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                D(yellow, blue, green, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Dx(yellow, blue, green, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                D(yellow, blue, green, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Dx(yellow, blue, green, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                D(yellow, blue, green, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                break;
            }
            //Саночки (Z-perm)
            if (edge[0][1] == 4 && edge[1][1] == 1 && edge[2][1] == 5 && edge[3][1] == 3 && corners[0][1] == 4 && corners[0][2] == 3 && corners[1][1] == 3 && corners[1][2] == 5 && corners[2][1] == 1 && corners[2][2] == 4 && corners[3][1] == 5 && corners[3][2] == 1) {
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                D(yellow, blue, green, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                B(blue, yellow, white, rad, orange, scrambl);
                B(blue, yellow, white, rad, orange, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                break;
            }
            if (edge[0][1] == 1 && edge[1][1] == 5 && edge[2][1] == 3 && edge[3][1] == 4 && corners[0][1] == 1 && corners[0][2] == 4 && corners[1][1] == 4 && corners[1][2] == 3 && corners[2][1] == 5 && corners[2][2] == 1 && corners[3][1] == 3 && corners[3][2] == 5) {
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                D(yellow, blue, green, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                B(blue, yellow, white, rad, orange, scrambl);
                B(blue, yellow, white, rad, orange, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                break;
            }
            //Крест сторон (H-perm)
            if (edge[0][1] == 1 && edge[1][1] == 4 && edge[2][1] == 3 && edge[3][1] == 5 && corners[0][1] == 4 && corners[0][2] == 3 && corners[1][1] == 3 && corners[1][2] == 5 && corners[2][1] == 1 && corners[2][2] == 4 && corners[3][1] == 5 && corners[3][2] == 1) {
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                D(yellow, blue, green, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                D(yellow, blue, green, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                break;
            }
            //Треугольник сторон (U-perm) против часовой
            if (edge[0][1] == 3 && edge[1][1] == 4 && edge[2][1] == 5 && edge[3][1] == 1 && corners[0][1] == 4 && corners[0][2] == 3 && corners[1][1] == 3 && corners[1][2] == 5 && corners[2][1] == 1 && corners[2][2] == 4 && corners[3][1] == 5 && corners[3][2] == 1) {
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                break;
            }
            if (edge[0][1] == 4 && edge[1][1] == 1 && edge[2][1] == 3 && edge[3][1] == 5 && corners[0][1] == 1 && corners[0][2] == 4 && corners[1][1] == 4 && corners[1][2] == 3 && corners[2][1] == 5 && corners[2][2] == 1 && corners[3][1] == 3 && corners[3][2] == 5) {
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                break;
            }
            if (edge[0][1] == 1 && edge[1][1] == 5 && edge[2][1] == 4 && edge[3][1] == 3 && corners[0][1] == 5 && corners[0][2] == 1 && corners[1][1] == 1 && corners[1][2] == 4 && corners[2][1] == 3 && corners[2][2] == 5 && corners[3][1] == 4 && corners[3][2] == 3) {
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                break;
            }
            if (edge[0][1] == 5 && edge[1][1] == 3 && edge[2][1] == 1 && edge[3][1] == 4 && corners[0][1] == 3 && corners[0][2] == 5 && corners[1][1] == 5 && corners[1][2] == 1 && corners[2][1] == 4 && corners[2][2] == 3 && corners[3][1] == 1 && corners[3][2] == 4) {
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                break;
            }
            //Треугольник сторон (U-perm) по часовой
            if (edge[0][1] == 3 && edge[1][1] == 1 && edge[2][1] == 4 && edge[3][1] == 5 && corners[0][1] == 4 && corners[0][2] == 3 && corners[1][1] == 3 && corners[1][2] == 5 && corners[2][1] == 1 && corners[2][2] == 4 && corners[3][1] == 5 && corners[3][2] == 1) {
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                break;
            }
            if (edge[0][1] == 4 && edge[1][1] == 5 && edge[2][1] == 1 && edge[3][1] == 3 && corners[0][1] == 1 && corners[0][2] == 4 && corners[1][1] == 4 && corners[1][2] == 3 && corners[2][1] == 5 && corners[2][2] == 1 && corners[3][1] == 3 && corners[3][2] == 5) {
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                break;
            }
            if (edge[0][1] == 1 && edge[1][1] == 3 && edge[2][1] == 5 && edge[3][1] == 4 && corners[0][1] == 5 && corners[0][2] == 1 && corners[1][1] == 1 && corners[1][2] == 4 && corners[2][1] == 3 && corners[2][2] == 5 && corners[3][1] == 4 && corners[3][2] == 3) {
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                break;
            }
            if (edge[0][1] == 5 && edge[1][1] == 4 && edge[2][1] == 3 && edge[3][1] == 1 && corners[0][1] == 3 && corners[0][2] == 5 && corners[1][1] == 5 && corners[1][2] == 1 && corners[2][1] == 4 && corners[2][2] == 3 && corners[3][1] == 1 && corners[3][2] == 4) {
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                break;
            }
            //Лямбда (J-perm) ближняя
            if (edge[0][1] == 3 && edge[1][1] == 1 && edge[2][1] == 5 && edge[3][1] == 4 && corners[0][1] == 4 && corners[0][2] == 3 && corners[1][1] == 5 && corners[1][2] == 1 && corners[2][1] == 1 && corners[2][2] == 4 && corners[3][1] == 3 && corners[3][2] == 5) {
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                break;
            }
            if (edge[0][1] == 4 && edge[1][1] == 5 && edge[2][1] == 3 && edge[3][1] == 1 && corners[0][1] == 1 && corners[0][2] == 4 && corners[1][1] == 3 && corners[1][2] == 5 && corners[2][1] == 5 && corners[2][2] == 1 && corners[3][1] == 4 && corners[3][2] == 3) {
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                break;
            }
            if (edge[0][1] == 1 && edge[1][1] == 3 && edge[2][1] == 4 && edge[3][1] == 5 && corners[0][1] == 5 && corners[0][2] == 1 && corners[1][1] == 4 && corners[1][2] == 3 && corners[2][1] == 3 && corners[2][2] == 5 && corners[3][1] == 1 && corners[3][2] == 4) {
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                break;
            }
            if (edge[0][1] == 5 && edge[1][1] == 4 && edge[2][1] == 1 && edge[3][1] == 3 && corners[0][1] == 3 && corners[0][2] == 5 && corners[1][1] == 1 && corners[1][2] == 4 && corners[2][1] == 4 && corners[2][2] == 3 && corners[3][1] == 5 && corners[3][2] == 1) {
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                break;
            }
            //Лямбда (J-perm) дальняя
            if (edge[0][1] == 5 && edge[1][1] == 3 && edge[2][1] == 1 && edge[3][1] == 4 && corners[0][1] == 4 && corners[0][2] == 3 && corners[1][1] == 5 && corners[1][2] == 1 && corners[2][1] == 1 && corners[2][2] == 4 && corners[3][1] == 3 && corners[3][2] == 5) {
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Lx(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                break;
            }
            if (edge[0][1] == 3 && edge[1][1] == 4 && edge[2][1] == 5 && edge[3][1] == 1 && corners[0][1] == 1 && corners[0][2] == 4 && corners[1][1] == 3 && corners[1][2] == 5 && corners[2][1] == 5 && corners[2][2] == 1 && corners[3][1] == 4 && corners[3][2] == 3) {
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Lx(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                break;
            }
            if (edge[0][1] == 4 && edge[1][1] == 1 && edge[2][1] == 3 && edge[3][1] == 5 && corners[0][1] == 5 && corners[0][2] == 1 && corners[1][1] == 4 && corners[1][2] == 3 && corners[2][1] == 3 && corners[2][2] == 5 && corners[3][1] == 1 && corners[3][2] == 4) {
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Lx(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                break;
            }
            if (edge[0][1] == 1 && edge[1][1] == 5 && edge[2][1] == 4 && edge[3][1] == 3 && corners[0][1] == 3 && corners[0][2] == 5 && corners[1][1] == 1 && corners[1][2] == 4 && corners[2][1] == 4 && corners[2][2] == 3 && corners[3][1] == 5 && corners[3][2] == 1) {
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Lx(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                break;
            }
            //Семёрки (R-perm) правая
            if (edge[0][1] == 3 && edge[1][1] == 1 && edge[2][1] == 5 && edge[3][1] == 4 && corners[0][1] == 3 && corners[0][2] == 5 && corners[1][1] == 4 && corners[1][2] == 3 && corners[2][1] == 1 && corners[2][2] == 4 && corners[3][1] == 5 && corners[3][2] == 1) {
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                break;
            }
            if (edge[0][1] == 4 && edge[1][1] == 5 && edge[2][1] == 3 && edge[3][1] == 1 && corners[0][1] == 4 && corners[0][2] == 3 && corners[1][1] == 1 && corners[1][2] == 4 && corners[2][1] == 5 && corners[2][2] == 1 && corners[3][1] == 3 && corners[3][2] == 5) {
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                break;
            }
            if (edge[0][1] == 1 && edge[1][1] == 3 && edge[2][1] == 4 && edge[3][1] == 5 && corners[0][1] == 1 && corners[0][2] == 4 && corners[1][1] == 5 && corners[1][2] == 1 && corners[2][1] == 3 && corners[2][2] == 5 && corners[3][1] == 4 && corners[3][2] == 3) {
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                break;
            }
            if (edge[0][1] ==5 && edge[1][1] == 4 && edge[2][1] == 1 && edge[3][1] == 3 && corners[0][1] == 5 && corners[0][2] == 1 && corners[1][1] == 3 && corners[1][2] == 5 && corners[2][1] == 4 && corners[2][2] == 3 && corners[3][1] == 1 && corners[3][2] == 4) {
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                break;
            }
            //Семёрки (R-perm) левая
            if (edge[0][1] == 3 && edge[1][1] == 5 && edge[2][1] == 4 && edge[3][1] == 1 && corners[0][1] == 3 && corners[0][2] == 5 && corners[1][1] == 4 && corners[1][2] == 3 && corners[2][1] == 1 && corners[2][2] == 4 && corners[3][1] == 5 && corners[3][2] == 1) {
                L(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Lx(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                Lx(orange, yellow, white, blue, green, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                break;
            }
            if (edge[0][1] == 4 && edge[1][1] == 3 && edge[2][1] == 1 && edge[3][1] == 5 && corners[0][1] == 4 && corners[0][2] == 3 && corners[1][1] == 1 && corners[1][2] == 4 && corners[2][1] == 5 && corners[2][2] == 1 && corners[3][1] == 3 && corners[3][2] == 5) {
                L(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Lx(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                Lx(orange, yellow, white, blue, green, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                break;
            }
            if (edge[0][1] == 1 && edge[1][1] == 4 && edge[2][1] == 5 && edge[3][1] == 3 && corners[0][1] == 1 && corners[0][2] == 4 && corners[1][1] == 5 && corners[1][2] == 1 && corners[2][1] == 3 && corners[2][2] == 5 && corners[3][1] == 4 && corners[3][2] == 3) {
                L(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Lx(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                Lx(orange, yellow, white, blue, green, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                break;
            }
            if (edge[0][1] == 5 && edge[1][1] == 1 && edge[2][1] == 3 && edge[3][1] == 4 && corners[0][1] == 5 && corners[0][2] == 1 && corners[1][1] == 3 && corners[1][2] == 5 && corners[2][1] == 4 && corners[2][2] == 3 && corners[3][1] == 1 && corners[3][2] == 4) {
                L(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Lx(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                Lx(orange, yellow, white, blue, green, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                break;
            }
            //Буква Т (T-perm)
            if (edge[0][1] == 3 && edge[1][1] == 4 && edge[2][1] == 1 && edge[3][1] == 5 && corners[0][1] == 4 && corners[0][2] == 3 && corners[1][1] == 5 && corners[1][2] == 1 && corners[2][1] == 1 && corners[2][2] == 4 && corners[3][1] == 3 && corners[3][2] == 5) {
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                break;
            }
            if (edge[0][1] == 4 && edge[1][1] == 1 && edge[2][1] == 5 && edge[3][1] == 3 && corners[0][1] == 1 && corners[0][2] == 4 && corners[1][1] == 3 && corners[1][2] == 5 && corners[2][1] == 5 && corners[2][2] == 1 && corners[3][1] == 4 && corners[3][2] == 3) {
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                break;
            }
            if (edge[0][1] == 1 && edge[1][1] == 5 && edge[2][1] == 3 && edge[3][1] == 4 && corners[0][1] == 5 && corners[0][2] == 1 && corners[1][1] == 4 && corners[1][2] == 3 && corners[2][1] == 3 && corners[2][2] == 5 && corners[3][1] == 1 && corners[3][2] == 4) {
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                break;
            }
            if (edge[0][1] == 5 && edge[1][1] == 3 && edge[2][1] == 4 && edge[3][1] == 1 && corners[0][1] == 3 && corners[0][2] == 5 && corners[1][1] == 1 && corners[1][2] == 4 && corners[2][1] == 4 && corners[2][2] == 3 && corners[3][1] == 5 && corners[3][2] == 1) {
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                break;
            }
            //Копьё (Y-perm)
            if (edge[0][1] == 4 && edge[1][1] == 5 && edge[2][1] == 1 && edge[3][1] == 3 && corners[0][1] == 5 && corners[0][2] == 1 && corners[1][1] == 3 && corners[1][2] == 5 && corners[2][1] == 1 && corners[2][2] == 4 && corners[3][1] == 4 && corners[3][2] == 3) {
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                break;
            }
            if (edge[0][1] == 1 && edge[1][1] == 3 && edge[2][1] == 5 && edge[3][1] == 4 && corners[0][1] == 3 && corners[0][2] == 5 && corners[1][1] == 4 && corners[1][2] == 3 && corners[2][1] == 5 && corners[2][2] == 1 && corners[3][1] == 1 && corners[3][2] == 4) {
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                break;
            }
            if (edge[0][1] == 5 && edge[1][1] == 4 && edge[2][1] == 3 && edge[3][1] == 1 && corners[0][1] == 4 && corners[0][2] == 3 && corners[1][1] == 1 && corners[1][2] == 4 && corners[2][1] == 3 && corners[2][2] == 5 && corners[3][1] == 5 && corners[3][2] == 1) {
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                break;
            }
            if (edge[0][1] == 3 && edge[1][1] == 1 && edge[2][1] == 4 && edge[3][1] == 5 && corners[0][1] == 1 && corners[0][2] == 4 && corners[1][1] == 5 && corners[1][2] == 1 && corners[2][1] == 4 && corners[2][2] == 3 && corners[3][1] == 3 && corners[3][2] == 5) {
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                break;
            }
            //Параллельный перенос (F-perm)
            if (edge[0][1] == 1 && edge[1][1] == 5 && edge[2][1] == 3 && edge[3][1] == 4 && corners[0][1] == 4 && corners[0][2] == 3 && corners[1][1] == 5 && corners[1][2] == 1 && corners[2][1] == 1 && corners[2][2] == 4 && corners[3][1] == 3 && corners[3][2] == 5) {
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                break;
            }
            if (edge[0][1] == 5 && edge[1][1] == 3 && edge[2][1] == 4 && edge[3][1] == 1 && corners[0][1] == 1 && corners[0][2] == 4 && corners[1][1] == 3 && corners[1][2] == 5 && corners[2][1] == 5 && corners[2][2] == 1 && corners[3][1] == 4 && corners[3][2] == 3) {
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                break;
            }
            if (edge[0][1] == 3 && edge[1][1] == 4 && edge[2][1] == 1 && edge[3][1] == 5 && corners[0][1] == 5 && corners[0][2] == 1 && corners[1][1] == 4 && corners[1][2] == 3 && corners[2][1] == 3 && corners[2][2] == 5 && corners[3][1] == 1 && corners[3][2] == 4) {
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                break;
            }
            if (edge[0][1] == 4 && edge[1][1] == 1 && edge[2][1] == 5 && edge[3][1] == 3 && corners[0][1] == 3 && corners[0][2] == 5 && corners[1][1] == 1 && corners[1][2] == 4 && corners[2][1] == 4 && corners[2][2] == 3 && corners[3][1] == 5 && corners[3][2] == 1) {
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                break;
            }
            //Летающая тарелка (V-perm)
            if (edge[0][1] == 5 && edge[1][1] == 3 && edge[2][1] == 1 && edge[3][1] == 4 && corners[0][1] == 5 && corners[0][2] == 1 && corners[1][1] == 3 && corners[1][2] == 5 && corners[2][1] == 1 && corners[2][2] == 4 && corners[3][1] == 4 && corners[3][2] == 3) {
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Lx(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Lx(orange, yellow, white, blue, green, scrambl);
                break;
            }
            if (edge[0][1] == 3 && edge[1][1] == 4 && edge[2][1] == 5 && edge[3][1] == 1 && corners[0][1] == 3 && corners[0][2] == 5 && corners[1][1] == 4 && corners[1][2] == 3 && corners[2][1] == 5 && corners[2][2] == 1 && corners[3][1] == 1 && corners[3][2] == 4) {
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Lx(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Lx(orange, yellow, white, blue, green, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                break;
            }
            if (edge[0][1] == 4 && edge[1][1] == 1 && edge[2][1] == 3 && edge[3][1] == 5 && corners[0][1] == 4 && corners[0][2] == 3 && corners[1][1] == 1 && corners[1][2] == 4 && corners[2][1] == 3 && corners[2][2] == 5 && corners[3][1] == 5 && corners[3][2] == 1) {
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Lx(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Lx(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                break;
            }
            if (edge[0][1] == 1 && edge[1][1] == 5 && edge[2][1] == 4 && edge[3][1] == 3 && corners[0][1] == 1 && corners[0][2] == 4 && corners[1][1] == 5 && corners[1][2] == 1 && corners[2][1] == 4 && corners[2][2] == 3 && corners[3][1] == 3 && corners[3][2] == 5) {
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Lx(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Lx(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                break;
            }
            //Буква Х (N-perm) левая
            if (edge[0][1] == 3 && edge[1][1] == 4 && edge[2][1] == 1 && edge[3][1] == 5 && corners[0][1] == 4 && corners[0][2] == 3 && corners[1][1] == 1 && corners[1][2] == 4 && corners[2][1] == 3 && corners[2][2] == 5 && corners[3][1] == 5 && corners[3][2] == 1) {
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Lx(orange, yellow, white, blue, green, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Lx(orange, yellow, white, blue, green, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                break;
            }
            if (edge[0][1] == 4 && edge[1][1] == 1 && edge[2][1] == 5 && edge[3][1] == 3 && corners[0][1] == 1 && corners[0][2] == 4 && corners[1][1] == 5 && corners[1][2] == 1 && corners[2][1] == 4 && corners[2][2] == 3 && corners[3][1] == 3 && corners[3][2] == 5) {
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Lx(orange, yellow, white, blue, green, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Lx(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                break;
            }
            if (edge[0][1] == 1 && edge[1][1] == 5 && edge[2][1] == 3 && edge[3][1] == 4 && corners[0][1] == 5 && corners[0][2] == 1 && corners[1][1] == 3 && corners[1][2] == 5 && corners[2][1] == 1 && corners[2][2] == 4 && corners[3][1] == 4 && corners[3][2] == 3) {
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Lx(orange, yellow, white, blue, green, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Lx(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                break;
            }
            if (edge[0][1] == 5 && edge[1][1] == 3 && edge[2][1] == 4 && edge[3][1] == 1 && corners[0][1] == 3 && corners[0][2] == 5 && corners[1][1] == 4 && corners[1][2] == 3 && corners[2][1] == 5 && corners[2][2] == 1 && corners[3][1] == 1 && corners[3][2] == 4) {
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Lx(orange, yellow, white, blue, green, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Lx(orange, yellow, white, blue, green, scrambl);
                break;
            }
            //Буква Х (N-perm) правая
            if (edge[0][1] == 3 && edge[1][1] == 4 && edge[2][1] == 1 && edge[3][1] == 5 && corners[0][1] == 5 && corners[0][2] == 1 && corners[1][1] == 3 && corners[1][2] == 5 && corners[2][1] == 1 && corners[2][2] == 4 && corners[3][1] == 4 && corners[3][2] == 3) {
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                break;
            }
            if (edge[0][1] == 4 && edge[1][1] == 1 && edge[2][1] == 5 && edge[3][1] == 3 && corners[0][1] == 3 && corners[0][2] == 5 && corners[1][1] == 4 && corners[1][2] == 3 && corners[2][1] == 5 && corners[2][2] == 1 && corners[3][1] == 1 && corners[3][2] == 4) {
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                break;
            }
            if (edge[0][1] == 1 && edge[1][1] == 5 && edge[2][1] == 3 && edge[3][1] == 4 && corners[0][1] == 4 && corners[0][2] == 3 && corners[1][1] == 1 && corners[1][2] == 4 && corners[2][1] == 3 && corners[2][2] == 5 && corners[3][1] == 5 && corners[3][2] == 1) {
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                break;
            }
            if (edge[0][1] == 5 && edge[1][1] == 3 && edge[2][1] == 4 && edge[3][1] == 1 && corners[0][1] == 1 && corners[0][2] == 4 && corners[1][1] == 5 && corners[1][2] == 1 && corners[2][1] == 4 && corners[2][2] == 3 && corners[3][1] == 3 && corners[3][2] == 5) {
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                break;
            }
            //Восьмёрка (G-perm) правая, углы против часовой
            if (edge[0][1] == 5 && edge[1][1] == 4 && edge[2][1] == 1 && edge[3][1] == 3 && corners[0][1] == 5 && corners[0][2] == 1 && corners[1][1] == 4 && corners[1][2] == 3 && corners[2][1] == 1 && corners[2][2] == 4 && corners[3][1] == 3 && corners[3][2] == 5) {
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                break;
            }
            if (edge[0][1] == 3 && edge[1][1] == 1 && edge[2][1] == 5 && edge[3][1] == 4 && corners[0][1] == 3 && corners[0][2] == 5 && corners[1][1] == 1 && corners[1][2] == 4 && corners[2][1] == 5 && corners[2][2] == 1 && corners[3][1] == 4 && corners[3][2] == 3) {
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                break;
            }
            if (edge[0][1] == 4 && edge[1][1] == 5 && edge[2][1] == 3 && edge[3][1] == 1 && corners[0][1] == 4 && corners[0][2] == 3 && corners[1][1] == 5 && corners[1][2] == 1 && corners[2][1] == 3 && corners[2][2] == 5 && corners[3][1] == 1 && corners[3][2] == 4) {
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                break;
            }
            if (edge[0][1] == 1 && edge[1][1] == 3 && edge[2][1] == 4 && edge[3][1] == 5 && corners[0][1] == 1 && corners[0][2] == 4 && corners[1][1] == 3 && corners[1][2] == 5 && corners[2][1] == 4 && corners[2][2] == 3 && corners[3][1] == 5 && corners[3][2] == 1) {
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                break;
            }
            //Восьмёрка (G-perm) правая, углы по часовой
            if (edge[0][1] == 4 && edge[1][1] == 3 && edge[2][1] == 1 && edge[3][1] == 5 && corners[0][1] == 3 && corners[0][2] == 5 && corners[1][1] == 5 && corners[1][2] == 1 && corners[2][1] == 1 && corners[2][2] == 4 && corners[3][1] == 4 && corners[3][2] == 3) {
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                break;
            }
            if (edge[0][1] == 1 && edge[1][1] == 4 && edge[2][1] == 5 && edge[3][1] == 3 && corners[0][1] == 4 && corners[0][2] == 3 && corners[1][1] == 3 && corners[1][2] == 5 && corners[2][1] == 5 && corners[2][2] == 1 && corners[3][1] == 1 && corners[3][2] == 4) {
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                break;
            }
            if (edge[0][1] == 5 && edge[1][1] == 1 && edge[2][1] == 3 && edge[3][1] == 4 && corners[0][1] == 1 && corners[0][2] == 4 && corners[1][1] == 4 && corners[1][2] == 3 && corners[2][1] == 3 && corners[2][2] == 5 && corners[3][1] == 5 && corners[3][2] == 1) {
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                break;
            }
            if (edge[0][1] == 3 && edge[1][1] == 5 && edge[2][1] == 4 && edge[3][1] == 1 && corners[0][1] == 5 && corners[0][2] == 1 && corners[1][1] == 1 && corners[1][2] == 4 && corners[2][1] == 4 && corners[2][2] == 3 && corners[3][1] == 3 && corners[3][2] == 5) {
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                break;
            }
            //Восьмёрка (G-perm) левая, углы по часовой
            if (edge[0][1] == 4 && edge[1][1] == 3 && edge[2][1] == 1 && edge[3][1] == 5 && corners[0][1] == 3 && corners[0][2] == 5 && corners[1][1] == 1 && corners[1][2] == 4 && corners[2][1] == 4 && corners[2][2] == 3 && corners[3][1] == 5 && corners[3][2] == 1) {
                L(orange, yellow, white, blue, green, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                Lx(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Lx(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                Lx(orange, yellow, white, blue, green, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                break;
            }
            if (edge[0][1] == 1 && edge[1][1] == 4 && edge[2][1] == 5 && edge[3][1] == 3 && corners[0][1] == 4 && corners[0][2] == 3 && corners[1][1] == 5 && corners[1][2] == 1 && corners[2][1] == 1 && corners[2][2] == 4 && corners[3][1] == 3 && corners[3][2] == 5) {
                L(orange, yellow, white, blue, green, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                Lx(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Lx(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                Lx(orange, yellow, white, blue, green, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                break;
            }
            if (edge[0][1] == 5 && edge[1][1] == 1 && edge[2][1] == 3 && edge[3][1] == 4 && corners[0][1] == 1 && corners[0][2] == 4 && corners[1][1] == 3 && corners[1][2] == 5 && corners[2][1] == 5 && corners[2][2] == 1 && corners[3][1] == 4 && corners[3][2] == 3) {
                L(orange, yellow, white, blue, green, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                Lx(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Lx(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                Lx(orange, yellow, white, blue, green, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                break;
            }
            if (edge[0][1] == 3 && edge[1][1] == 5 && edge[2][1] == 4 && edge[3][1] == 1 && corners[0][1] == 5 && corners[0][2] == 1 && corners[1][1] == 4 && corners[1][2] == 3 && corners[2][1] == 4 && corners[2][2] == 5 && corners[3][1] == 1 && corners[3][2] == 4) {
                Ux(white, green, blue, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                Lx(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Lx(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                Lx(orange, yellow, white, blue, green, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                Fx(green, yellow, white, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                break;
            }
            //Восьмёрка (G-perm) левая, углы против часовой
            if (edge[0][1] == 5 && edge[1][1] == 4 && edge[2][1] == 1 && edge[3][1] == 3 && corners[0][1] == 1 && corners[0][2] == 4 && corners[1][1] == 4 && corners[1][2] == 3 && corners[2][1] == 3 && corners[2][2] == 5 && corners[3][1] == 5 && corners[3][2] == 1) {
                Ux(white, green, blue, orange, rad, scrambl);
                D(yellow, blue, green, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Dx(yellow, blue, green, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                break;
            }
            if (edge[0][1] == 3 && edge[1][1] == 1 && edge[2][1] == 5 && edge[3][1] == 4 && corners[0][1] == 5 && corners[0][2] == 1 && corners[1][1] == 1 && corners[1][2] == 4 && corners[2][1] == 4 && corners[2][2] == 3 && corners[3][1] == 3 && corners[3][2] == 5) {
                Ux(white, green, blue, orange, rad, scrambl);
                D(yellow, blue, green, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Dx(yellow, blue, green, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                break;
            }
            if (edge[0][1] == 4 && edge[1][1] == 5 && edge[2][1] == 3 && edge[3][1] == 1 && corners[0][1] == 3 && corners[0][2] == 5 && corners[1][1] == 5 && corners[1][2] == 1 && corners[2][1] == 1 && corners[2][2] == 4 && corners[3][1] == 4 && corners[3][2] == 3) {
                Ux(white, green, blue, orange, rad, scrambl);
                D(yellow, blue, green, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Dx(yellow, blue, green, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                break;
            }
            if (edge[0][1] == 1 && edge[1][1] == 3 && edge[2][1] == 4 && edge[3][1] == 5 && corners[0][1] == 4 && corners[0][2] == 3 && corners[1][1] == 3 && corners[1][2] == 5 && corners[2][1] == 5 && corners[2][2] == 1 && corners[3][1] == 1 && corners[3][2] == 4) {
                Ux(white, green, blue, orange, rad, scrambl);
                D(yellow, blue, green, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Dx(yellow, blue, green, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                Ux(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                break;
            }
            U(white, green, blue, orange, rad, scrambl);
            Updateedge(white, green, yellow, blue, orange, rad, edge);
            Updatecorners(white, green, yellow, blue, orange, rad, corners);
        }
    }
    //Конец сборки
    //Вращение граней(от 1 буквы английского названия; приписка x обозначает поворот против часовой стрелки):
    private static void U(int[][] one, int[][] two, int[][] three, int[][] four, int[][] five, StringBuilder scrambl){
        //верхний слой по часовой
        //углы
        int empty = one[0][2];
        one[0][2] = one [0][0];
        one[0][0] = one [2][0];
        one[2][0] = one [2][2];
        one[2][2] = empty;
        //ребра
        empty = one[0][1];
        one[0][1] = one [1][0];
        one[1][0] = one [2][1];
        one[2][1] = one [1][2];
        one[1][2] = empty;
        //боковые стороны по часовой
        //первые углы
        empty = five[0][0];
        five[0][0] = three[2][0];
        three[2][0] = four[2][2];
        four[2][2] = two[0][2];
        two[0][2] = empty;
        //вторые углы
        empty = five[2][0];
        five[2][0] = three[2][2];
        three[2][2] = four[0][2];
        four[0][2] = two[0][0];
        two[0][0] = empty;
        //ребра
        empty = five[1][0];
        five[1][0] = three[2][1];
        three[2][1] = four[1][2];
        four[1][2] = two[0][1];
        two[0][1] = empty;
        scrambl.append("U ");
    }
    private static void Ux(int[][] one, int[][] two, int[][] three, int[][] four, int[][] five, StringBuilder scrambl){
        //верхний слой против часовой
        //углы
        int empty = one[0][2];
        one[0][2] = one [2][2];
        one[2][2] = one [2][0];
        one[2][0] = one [0][0];
        one[0][0] = empty;
        //ребра
        empty = one[0][1];
        one[0][1] = one [1][2];
        one[1][2] = one [2][1];
        one[2][1] = one [1][0];
        one[1][0] = empty;
        //боковые стороны против часовой
        //первые углы
        empty = five[0][0];
        five[0][0] = two[0][2];
        two[0][2] = four[2][2];
        four[2][2] = three[2][0];
        three[2][0]= empty;
        //вторые углы
        empty = five[2][0];
        five[2][0] = two[0][0];
        two[0][0] = four[0][2];
        four[0][2] = three[2][2];
        three[2][2] = empty;
        //ребра
        empty = five[1][0];
        five[1][0] = two[0][1];
        two[0][1] = four[1][2];
        four[1][2] = three[2][1];
        three[2][1] = empty;
        scrambl.append("U' ");
    }
    private static void F(int[][] one, int[][] two, int[][] three, int[][] four, int[][] five, StringBuilder scrambl){
        //лицевой слой по часовой
        //углы
        int empty = one[0][2];
        one[0][2] = one [0][0];
        one[0][0] = one [2][0];
        one[2][0] = one [2][2];
        one[2][2] = empty;
        //ребра
        empty = one[0][1];
        one[0][1] = one [1][0];
        one[1][0] = one [2][1];
        one[2][1] = one [1][2];
        one[1][2] = empty;
        //боковые стороны по часовой
        //первые углы
        empty = five[2][0];
        five[2][0] = three[2][0];
        three[2][0] = four[2][0];
        four[2][0] = two[0][2];
        two[0][2] = empty;
        //вторые углы
        empty = five[2][2];
        five[2][2] = three[2][2];
        three[2][2] = four[2][2];
        four[2][2] = two[0][0];
        two[0][0] = empty;
        //ребра
        empty = five[2][1];
        five[2][1] = three[2][1];
        three[2][1] = four[2][1];
        four[2][1] = two[0][1];
        two[0][1] = empty;
        scrambl.append("F ");
    }
    private static void Fx(int[][] one, int[][] two, int[][] three, int[][] four, int[][] five, StringBuilder scrambl){
        //лицевой слой против часовой
        //углы
        int empty = one[0][2];
        one[0][2] = one [2][2];
        one[2][2] = one [2][0];
        one[2][0] = one [0][0];
        one[0][0] = empty;
        //ребра
        empty = one[0][1];
        one[0][1] = one [1][2];
        one[1][2] = one [2][1];
        one[2][1] = one [1][0];
        one[1][0] = empty;
        //боковые стороны против часовой
        //первые углы
        empty = five[2][0];
        five[2][0] = two[0][2];
        two[0][2] = four[2][0];
        four[2][0] = three[2][0];
        three[2][0] = empty;
        //вторые углы
        empty = five[2][2];
        five[2][2] = two[0][0];
        two[0][0] = four[2][2];
        four[2][2] = three[2][2];
        three[2][2] = empty;
        //ребра
        empty = five[2][1];
        five[2][1] = two[0][1];
        two[0][1] = four[2][1];
        four[2][1] = three[2][1];
        three[2][1] = empty;
        scrambl.append("F' ");
    }
    private static void R(int[][] one, int[][] two, int[][] three, int[][] four, int[][] five, StringBuilder scrambl){
        //правой стороны по часовой
        //углы
        int empty = one[0][2];
        one[0][2] = one [0][0];
        one[0][0] = one [2][0];
        one[2][0] = one [2][2];
        one[2][2] = empty;
        //ребра
        empty = one[0][1];
        one[0][1] = one [1][0];
        one[1][0] = one [2][1];
        one[2][1] = one [1][2];
        one[1][2] = empty;
        //боковые стороны по часовой
        //первые углы
        empty = five[2][2];
        five[2][2] = three[2][2];
        three[2][2] = four[2][2];
        four[2][2] = two[2][2];
        two[2][2] = empty;
        //вторые углы
        empty = five[0][2];
        five[0][2] = three[0][2];
        three[0][2] = four[0][2];
        four[0][2] = two[0][2];
        two[0][2] = empty;
        //ребра
        empty = five[1][2];
        five[1][2] = three[1][2];
        three[1][2] = four[1][2];
        four[1][2] = two[1][2];
        two[1][2] = empty;
        scrambl.append("R ");
    }
    private static void Rx(int[][] one, int[][] two, int[][] three, int[][] four, int[][] five, StringBuilder scrambl){
        //правой стороны против часовой
        //углы
        int empty = one[0][2];
        one[0][2] = one [2][2];
        one[2][2] = one [2][0];
        one[2][0] = one [0][0];
        one[0][0] = empty;
        //ребра
        empty = one[0][1];
        one[0][1] = one [1][2];
        one[1][2] = one [2][1];
        one[2][1] = one [1][0];
        one[1][0] = empty;
        //боковые стороны против часовой
        //первые углы
        empty = five[2][2];
        five[2][2] = two[2][2];
        two[2][2] = four[2][2];
        four[2][2] = three[2][2];
        three[2][2] = empty;
        //вторые углы
        empty = five[0][2];
        five[0][2] = two[0][2];
        two[0][2] = four[0][2];
        four[0][2] = three[0][2];
        three[0][2] = empty;
        //ребра
        empty = five[1][2];
        five[1][2] = two[1][2];
        two[1][2] = four[1][2];
        four[1][2] = three[1][2];
        three[1][2] = empty;
        scrambl.append("R' ");
    }
    private static void L(int[][] one, int[][] two, int[][] three, int[][] four, int[][] five, StringBuilder scrambl){
        //левой стороны по часовой
        //углы
        int empty = one[0][2];
        one[0][2] = one [0][0];
        one[0][0] = one [2][0];
        one[2][0] = one [2][2];
        one[2][2] = empty;
        //ребра
        empty = one[0][1];
        one[0][1] = one [1][0];
        one[1][0] = one [2][1];
        one[2][1] = one [1][2];
        one[1][2] = empty;
        //боковые стороны по часовой
        //первые углы
        empty = five[2][0];
        five[2][0] = three[2][0];
        three[2][0] = four[2][0];
        four[2][0] = two[2][0];
        two[2][0] = empty;
        //вторые углы
        empty = five[0][0];
        five[0][0] = three[0][0];
        three[0][0] = four[0][0];
        four[0][0] = two[0][0];
        two[0][0] = empty;
        //ребра
        empty = five[1][0];
        five[1][0] = three[1][0];
        three[1][0] = four[1][0];
        four[1][0] = two[1][0];
        two[1][0] = empty;
        scrambl.append("L ");
    }
    private static void Lx(int[][] one, int[][] two, int[][] three, int[][] four, int[][] five, StringBuilder scrambl){
        //левой стороны против часовой
        //углы
        int empty = one[0][2];
        one[0][2] = one [2][2];
        one[2][2] = one [2][0];
        one[2][0] = one [0][0];
        one[0][0] = empty;
        //ребра
        empty = one[0][1];
        one[0][1] = one [1][2];
        one[1][2] = one [2][1];
        one[2][1] = one [1][0];
        one[1][0] = empty;
        //боковые стороны против часовой
        //первые углы
        empty = five[2][0];
        five[2][0] = two[2][0];
        two[2][0] = four[2][0];
        four[2][0] = three[2][0];
        three[2][0] = empty;
        //вторые углы
        empty = five[0][0];
        five[0][0] = two[0][0];
        two[0][0] = four[0][0];
        four[0][0] = three[0][0];
        three[0][0] = empty;
        //ребра
        empty = five[1][0];
        five[1][0] = two[1][0];
        two[1][0] = four[1][0];
        four[1][0] = three[1][0];
        three[1][0] = empty;
        scrambl.append("L' ");
    }
    private static void B(int[][] one, int[][] two, int[][] three, int[][] four, int[][] five, StringBuilder scrambl){
        //задний слой по часовой
        //углы
        int empty = one[0][2];
        one[0][2] = one [0][0];
        one[0][0] = one [2][0];
        one[2][0] = one [2][2];
        one[2][2] = empty;
        //ребра
        empty = one[0][1];
        one[0][1] = one [1][0];
        one[1][0] = one [2][1];
        one[2][1] = one [1][2];
        one[1][2] = empty;
        //боковые стороны по часовой
        //первые углы
        empty = five[0][2];
        five[0][2] = three[0][2];
        three[0][2] = four[0][2];
        four[0][2] = two[2][0];
        two[2][0] = empty;
        //вторые углы
        empty = five[0][0];
        five[0][0] = three[0][0];
        three[0][0] = four[0][0];
        four[0][0] = two[2][2];
        two[2][2] = empty;
        //ребра
        empty = five[0][1];
        five[0][1] = three[0][1];
        three[0][1] = four[0][1];
        four[0][1] = two[2][1];
        two[2][1] = empty;
        scrambl.append("B ");
    }
    private static void Bx(int[][] one, int[][] two, int[][] three, int[][] four, int[][] five, StringBuilder scrambl) {
        //задний слой против часовой
        //углы
        int empty = one[0][2];
        one[0][2] = one[2][2];
        one[2][2] = one[2][0];
        one[2][0] = one[0][0];
        one[0][0] = empty;
        //ребра
        empty = one[0][1];
        one[0][1] = one[1][2];
        one[1][2] = one[2][1];
        one[2][1] = one[1][0];
        one[1][0] = empty;
        //боковые стороны против часовой
        //первые углы
        empty = five[0][2];
        five[0][2] = two[2][0];
        two[2][0] = four[0][2];
        four[0][2] = three[0][2];
        three[0][2] = empty;
        //вторые углы
        empty = five[0][0];
        five[0][0] = two[2][2];
        two[2][2] = four[0][0];
        four[0][0] = three[0][0];
        three[0][0] = empty;
        //ребра
        empty = five[0][1];
        five[0][1] = two[2][1];
        two[2][1] = four[0][1];
        four[0][1] = three[0][1];
        three[0][1] = empty;
        scrambl.append("B' ");
    }
    private static void D(int[][] one, int[][] two, int[][] three, int[][] four, int[][] five, StringBuilder scrambl){
        //нижний слой по часовой
        //углы
        int empty = one[0][2];
        one[0][2] = one [0][0];
        one[0][0] = one [2][0];
        one[2][0] = one [2][2];
        one[2][2] = empty;
        //ребра
        empty = one[0][1];
        one[0][1] = one [1][0];
        one[1][0] = one [2][1];
        one[2][1] = one [1][2];
        one[1][2] = empty;
        //боковые стороны по часовой
        //первые углы
        empty = five[2][2];
        five[2][2] = three[2][0];
        three[2][0] = four[0][0];
        four[0][0] = two[0][2];
        two[0][2] = empty;
        //вторые углы
        empty = five[0][2];
        five[0][2] = three[2][2];
        three[2][2] = four[2][0];
        four[2][0] = two[0][0];
        two[0][0] = empty;
        //ребра
        empty = five[1][2];
        five[1][2] = three[2][1];
        three[2][1] = four[1][0];
        four[1][0] = two[0][1];
        two[0][1] = empty;
        scrambl.append("D ");
    }
    private static void Dx(int[][] one, int[][] two, int[][] three, int[][] four, int[][] five, StringBuilder scrambl){
        //нижний слой против часовой
        //углы
        int empty = one[0][2];
        one[0][2] = one [2][2];
        one[2][2] = one [2][0];
        one[2][0] = one [0][0];
        one[0][0] = empty;
        //ребра
        empty = one[0][1];
        one[0][1] = one [1][2];
        one[1][2] = one [2][1];
        one[2][1] = one [1][0];
        one[1][0] = empty;
        //боковые стороны против часовой
        //первые углы
        empty = five[2][2];
        five[2][2] = two[0][2];
        two[0][2] = four[0][0];
        four[0][0] = three[2][0];
        three[2][0] = empty;
        //вторые углы
        empty = five[0][2];
        five[0][2] = two[0][0];
        two[0][0] = four[2][0];
        four[2][0] = three[2][2];
        three[2][2] = empty;
        //ребра
        empty = five[1][2];
        five[1][2] = two[0][1];
        two[0][1] = four[1][0];
        four[1][0] = three[2][1];
        three[2][1] = empty;
        scrambl.append("D' ");
    }
    //пары(couple) и трёхходовки(tripod) для F2L, для загона в различные слоты:
    private static void couple_green_rad_left(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        R(rad, yellow, white, green, blue, scrambl);
        Ux(white, green, blue, orange, rad, scrambl);
        Rx(rad, yellow, white, green, blue, scrambl);
        Updateedge(white, green, yellow, blue, orange, rad, edge);
        Updatecorners(white, green, yellow, blue, orange, rad, corners);
    }
    private static void couple_green_rad_right(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        Fx(green, yellow, white, orange, rad, scrambl);
        U(white, green, blue, orange, rad, scrambl);
        F(green, yellow, white, orange, rad, scrambl);
        Updateedge(white, green, yellow, blue, orange, rad, edge);
        Updatecorners(white, green, yellow, blue, orange, rad, corners);
    }
    private static void couple_green_orange_left(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        F(green, yellow, white, orange, rad, scrambl);
        Ux(white, green, blue, orange, rad, scrambl);
        Fx(green, yellow, white, orange, rad, scrambl);
        Updateedge(white, green, yellow, blue, orange, rad, edge);
        Updatecorners(white, green, yellow, blue, orange, rad, corners);
    }
    private static void couple_green_orange_right(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        Lx(orange, yellow, white, blue, green, scrambl);
        U(white, green, blue, orange, rad, scrambl);
        L(orange, yellow, white, blue, green, scrambl);
        Updateedge(white, green, yellow, blue, orange, rad, edge);
        Updatecorners(white, green, yellow, blue, orange, rad, corners);
    }
    private static void couple_orange_blue_left(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        L(orange, yellow, white, blue, green, scrambl);
        Ux(white, green, blue, orange, rad, scrambl);
        Lx(orange, yellow, white, blue, green, scrambl);
        Updateedge(white, green, yellow, blue, orange, rad, edge);
        Updatecorners(white, green, yellow, blue, orange, rad, corners);
    }
    private static void couple_orange_blue_right(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        Bx(blue, yellow, white, rad, orange, scrambl);
        U(white, green, blue, orange, rad, scrambl);
        B(blue, yellow, white, rad, orange, scrambl);
        Updateedge(white, green, yellow, blue, orange, rad, edge);
        Updatecorners(white, green, yellow, blue, orange, rad, corners);
    }
    private static void couple_blue_rad_left(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        B(blue, yellow, white, rad, orange, scrambl);
        Ux(white, green, blue, orange, rad, scrambl);
        Bx(blue, yellow, white, rad, orange, scrambl);
        Updateedge(white, green, yellow, blue, orange, rad, edge);
        Updatecorners(white, green, yellow, blue, orange, rad, corners);
    }
    private static void couple_blue_rad_right(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        Rx(rad, yellow, white, green, blue, scrambl);
        U(white, green, blue, orange, rad, scrambl);
        R(rad, yellow, white, green, blue, scrambl);
        Updateedge(white, green, yellow, blue, orange, rad, edge);
        Updatecorners(white, green, yellow, blue, orange, rad, corners);
    }
    private static void tripod_green_rad_left(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        Fx(green, yellow, white, orange, rad, scrambl);
        Ux(white, green, blue, orange, rad, scrambl);
        F(green, yellow, white, orange, rad, scrambl);
        Updateedge(white, green, yellow, blue, orange, rad, edge);
        Updatecorners(white, green, yellow, blue, orange, rad, corners);
    }
    private static void tripod_green_rad_right(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        R(rad, yellow, white, green, blue, scrambl);
        U(white, green, blue, orange, rad, scrambl);
        Rx(rad, yellow, white, green, blue, scrambl);
        Updateedge(white, green, yellow, blue, orange, rad, edge);
        Updatecorners(white, green, yellow, blue, orange, rad, corners);
    }
    private static void tripod_green_orange_left(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        Lx(orange, yellow, white, blue, green, scrambl);
        Ux(white, green, blue, orange, rad, scrambl);
        L(orange, yellow, white, blue, green, scrambl);
        Updateedge(white, green, yellow, blue, orange, rad, edge);
        Updatecorners(white, green, yellow, blue, orange, rad, corners);
    }
    private static void tripod_green_orange_right(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        F(green, yellow, white, orange, rad, scrambl);
        U(white, green, blue, orange, rad, scrambl);
        Fx(green, yellow, white, orange, rad, scrambl);
        Updateedge(white, green, yellow, blue, orange, rad, edge);
        Updatecorners(white, green, yellow, blue, orange, rad, corners);
    }
    private static void tripod_orange_blue_left(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        Bx(blue, yellow, white, rad, orange, scrambl);
        Ux(white, green, blue, orange, rad, scrambl);
        B(blue, yellow, white, rad, orange, scrambl);
        Updateedge(white, green, yellow, blue, orange, rad, edge);
        Updatecorners(white, green, yellow, blue, orange, rad, corners);
    }
    private static void tripod_orange_blue_right(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        L(orange, yellow, white, blue, green, scrambl);
        U(white, green, blue, orange, rad, scrambl);
        Lx(orange, yellow, white, blue, green, scrambl);
        Updateedge(white, green, yellow, blue, orange, rad, edge);
        Updatecorners(white, green, yellow, blue, orange, rad, corners);
    }
    private static void tripod_blue_rad_left(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        Rx(rad, yellow, white, green, blue, scrambl);
        Ux(white, green, blue, orange, rad, scrambl);
        R(rad, yellow, white, green, blue, scrambl);
        Updateedge(white, green, yellow, blue, orange, rad, edge);
        Updatecorners(white, green, yellow, blue, orange, rad, corners);
    }
    private static void tripod_blue_rad_right(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        B(blue, yellow, white, rad, orange, scrambl);
        U(white, green, blue, orange, rad, scrambl);
        Bx(blue, yellow, white, rad, orange, scrambl);
        Updateedge(white, green, yellow, blue, orange, rad, edge);
        Updatecorners(white, green, yellow, blue, orange, rad, corners);
    }
    private static String Scrambl(StringBuilder scrambl) {
        StringBuilder newScrambl = new StringBuilder();
        char lastLetter = ' ';
        int counter = 0;
        int hatch = 0;
        int dlaseba = 0;
        for (int n = 0; n < 2; n++) {
            for (int i = 0; i < scrambl.length(); i++) {
                if (scrambl.charAt(i) != ' ') {
                    if (lastLetter == scrambl.charAt(i)) {
                        if (((int) scrambl.charAt(i + 1) == 39 && scrambl.charAt(i - 2) == lastLetter) || (scrambl.charAt(i + 1) == ' ' && (int) scrambl.charAt(i - 2) == 39)) {
                            if ((int) scrambl.charAt(i + 1) == 39 && scrambl.charAt(i - 2) == lastLetter) {
                                counter--;
                                newScrambl.deleteCharAt(counter);
                                counter--;
                                newScrambl.deleteCharAt(counter);
                                counter--;
                                newScrambl.deleteCharAt(counter);
                                i++;
                                continue;
                            } else {
                                newScrambl.deleteCharAt(counter - 1);
                                counter--;
                                newScrambl.deleteCharAt(counter - 1);
                                counter--;
                                newScrambl.deleteCharAt(counter - 1);
                                counter--;
                                newScrambl.deleteCharAt(counter - 1);
                                counter--;
                                continue;
                            }
                        } else {
                            newScrambl.append(scrambl.charAt(i));
                            counter++;
                            continue;
                        }
                    }
                    if ((int) scrambl.charAt(i) != 39) {
                        dlaseba++;
                        lastLetter = scrambl.charAt(i);
                        newScrambl.append(scrambl.charAt(i));
                    }
                    if ((int) scrambl.charAt(i) == 39) {
                        newScrambl.append(scrambl.charAt(i));
                    }
                } else {
                    newScrambl.append(scrambl.charAt(i));
                }
                counter++;
            }
        }
        System.out.println(dlaseba);
        lastLetter = ' ';
        counter = 0;
        for (int i = 0; i < newScrambl.length(); i++) {
            if (newScrambl.charAt(i) != ' ') {
                if (newScrambl.charAt(i) != lastLetter){
                    lastLetter = newScrambl.charAt(i);
                    counter = 1;
                }else {
                    counter++;
                }
                if (counter == 4){
                    newScrambl.deleteCharAt(i);
                    i--;
                    newScrambl.deleteCharAt(i);
                    i--;
                    newScrambl.deleteCharAt(i);
                    i--;
                    newScrambl.deleteCharAt(i);
                    i--;
                    newScrambl.deleteCharAt(i);
                    i--;
                    newScrambl.deleteCharAt(i);
                    i--;
                    newScrambl.deleteCharAt(i);
                    i--;
                    newScrambl.deleteCharAt(i);
                    counter = 0;
                }
            }
        }
        counter = 0;
        lastLetter = ' ';
        for (int i = 0; i < newScrambl.length(); i++) {
            if (newScrambl.charAt(i) != ' ') {
                if (newScrambl.charAt(i) != lastLetter) {
                    lastLetter = newScrambl.charAt(i);
                    hatch = 0;
                    counter = 1;
                } else {
                    counter++;
                }
                if (counter == 3) {
                    newScrambl.deleteCharAt(i);
                    i--;
                    newScrambl.deleteCharAt(i);
                    i--;
                    newScrambl.deleteCharAt(i);
                    i--;
                    newScrambl.insert(i,"'");
                    i++;
                    newScrambl.deleteCharAt(i);
                    counter = 0;
                }
            }
        }
        counter = 0;
        lastLetter = ' ';
        for (int i = 0; i < newScrambl.length(); i++) {
            if ((int)newScrambl.charAt(i) != 39){
                if (newScrambl.charAt(i) != ' ') {
                    if (newScrambl.charAt(i) != lastLetter) {
                        lastLetter = newScrambl.charAt(i);
                        hatch = 0;
                        counter = 1;
                    }else {
                        counter++;
                    }
                    if (counter == 2) {
                        if (hatch == 0){
                            newScrambl.deleteCharAt(i);
                            i--;
                            newScrambl.insert(i, "2");
                            i++;
                            newScrambl.deleteCharAt(i);
                            counter = 0;
                        }
                        if (hatch == 1){
                            newScrambl.deleteCharAt(i + 1);
                            newScrambl.deleteCharAt(i);
                            newScrambl.deleteCharAt(i - 1);
                            newScrambl.insert(i - 2, "2");
                            newScrambl.deleteCharAt(i - 1);
                            counter = 0;
                        }
                    }
                }
            }else {
                hatch++;
            }
        }
        return newScrambl.toString();
    }
    private static void sout(int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
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