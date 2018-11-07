package cube_assembly;

import Cube_project.Main;

public class F2L {
    private static Main main = new Main();

    public static void F2L(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        F2L_orange_blue(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
        F2L_orange_green(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
        F2L_rad_blue(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
        F2L_rad_green(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
    }

    private static int[] findF2L_orange_blue(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad){
        //Находим жёлто-сине-оранжевый угол и сине-оранжевое ребро
        int[] l = new int[7];
        int i;
        int j;
        int one = 2;
        int two = 3;
        int three = 4;
        main.Updatecorners(white, green, yellow, blue, orange, rad, corners);
        main.Updateedge(white, green, yellow, blue, orange, rad, edge);
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
                main.Updateedge(white, green, yellow, blue, orange, rad, edge);
            }
            if (j == 5){
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                main.Updateedge(white, green, yellow, blue, orange, rad, edge);
            }
            if (j == 10){
                L(orange, yellow, white, blue, green, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Lx(orange, yellow, white, blue, green, scrambl);
                main.Updateedge(white, green, yellow, blue, orange, rad, edge);
            }
            if (j == 11){
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                main.Updateedge(white, green, yellow, blue, orange, rad, edge);
            }
            main.Updatecorners(white, green, yellow, blue, orange, rad, corners);
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
                main.Updateedge(white, green, yellow, blue, orange, rad, edge);
                main.Updatecorners(white, green, yellow, blue, orange, rad, corners);
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
                        main.Updateedge(white, green, yellow, blue, orange, rad, edge);
                        main.Updatecorners(white, green, yellow, blue, orange, rad, corners);
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
                    main.Updateedge(white, green, yellow, blue, orange, rad, edge);
                    main.Updatecorners(white, green, yellow, blue, orange, rad, corners);
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
        main.Updatecorners(white, green, yellow, blue, orange, rad, corners);
        main.Updateedge(white, green, yellow, blue, orange, rad, edge);
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
                main.Updateedge(white, green, yellow, blue, orange, rad, edge);

            }
            if (j == 5){
                R(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                Rx(rad, yellow, white, green, blue, scrambl);
                main.Updateedge(white, green, yellow, blue, orange, rad, edge);
            }
            if (j == 11){
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                main.Updateedge(white, green, yellow, blue, orange, rad, edge);
            }
            main.Updatecorners(white, green, yellow, blue, orange, rad, corners);
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
                main.Updateedge(white, green, yellow, blue, orange, rad, edge);
                main.Updatecorners(white, green, yellow, blue, orange, rad, corners);
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
                        main.Updateedge(white, green, yellow, blue, orange, rad, edge);
                        main.Updatecorners(white, green, yellow, blue, orange, rad, corners);
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
                    main.Updateedge(white, green, yellow, blue, orange, rad, edge);
                    main.Updatecorners(white, green, yellow, blue, orange, rad, corners);
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
        main.Updatecorners(white, green, yellow, blue, orange, rad, corners);
        main.Updateedge(white, green, yellow, blue, orange, rad, edge);
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
                main.Updateedge(white, green, yellow, blue, orange, rad, edge);
            }
            if (j == 11){
                Rx(rad, yellow, white, green, blue, scrambl);
                U(white, green, blue, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                main.Updateedge(white, green, yellow, blue, orange, rad, edge);
            }
            main.Updatecorners(white, green, yellow, blue, orange, rad, corners);
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
                main.Updateedge(white, green, yellow, blue, orange, rad, edge);
                main.Updatecorners(white, green, yellow, blue, orange, rad, corners);
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
                        main.Updateedge(white, green, yellow, blue, orange, rad, edge);
                        main.Updatecorners(white, green, yellow, blue, orange, rad, corners);
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
                    main.Updateedge(white, green, yellow, blue, orange, rad, edge);
                    main.Updatecorners(white, green, yellow, blue, orange, rad, corners);
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
        main.Updatecorners(white, green, yellow, blue, orange, rad, corners);
        main.Updateedge(white, green, yellow, blue, orange, rad, edge);
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
            main.Updateedge(white, green, yellow, blue, orange, rad, edge);
            main.Updatecorners(white, green, yellow, blue, orange, rad, corners);
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
                    R(rad, yellow, white, green, blue, scrambl);//где-то ошибка
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
                main.Updateedge(white, green, yellow, blue, orange, rad, edge);
                main.Updatecorners(white, green, yellow, blue, orange, rad, corners);
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
                main.Updateedge(white, green, yellow, blue, orange, rad, edge);
                main.Updatecorners(white, green, yellow, blue, orange, rad, corners);
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

    private static void U(int[][] one, int[][] two, int[][] three, int[][] four, int[][] five, StringBuilder scrambl){
        main.U(one, two,three, four, five, scrambl);
    }
    private static void Ux(int[][] one, int[][] two, int[][] three, int[][] four, int[][] five, StringBuilder scrambl){
        main.Ux(one, two,three, four, five, scrambl);
    }
    private static void R(int[][] one, int[][] two, int[][] three, int[][] four, int[][] five, StringBuilder scrambl){
        main.R(one, two,three, four, five, scrambl);
    }
    private static void Rx(int[][] one, int[][] two, int[][] three, int[][] four, int[][] five, StringBuilder scrambl){
        main.Rx(one, two,three, four, five, scrambl);
    }
    private static void L(int[][] one, int[][] two, int[][] three, int[][] four, int[][] five, StringBuilder scrambl){
        main.L(one, two,three, four, five, scrambl);
    }
    private static void Lx(int[][] one, int[][] two, int[][] three, int[][] four, int[][] five, StringBuilder scrambl){
        main.Lx(one, two,three, four, five, scrambl);
    }
    private static void F(int[][] one, int[][] two, int[][] three, int[][] four, int[][] five, StringBuilder scrambl){
        main.F(one, two,three, four, five, scrambl);
    }
    private static void Fx(int[][] one, int[][] two, int[][] three, int[][] four, int[][] five, StringBuilder scrambl){
        main.Fx(one, two,three, four, five, scrambl);
    }
    private static void B(int[][] one, int[][] two, int[][] three, int[][] four, int[][] five, StringBuilder scrambl){
        main.B(one, two,three, four, five, scrambl);
    }
    private static void Bx(int[][] one, int[][] two, int[][] three, int[][] four, int[][] five, StringBuilder scrambl){
        main.Bx(one, two,three, four, five, scrambl);
    }
    private static void D(int[][] one, int[][] two, int[][] three, int[][] four, int[][] five, StringBuilder scrambl){
        main.D(one, two,three, four, five, scrambl);
    }
    private static void Dx(int[][] one, int[][] two, int[][] three, int[][] four, int[][] five, StringBuilder scrambl){
        main.Dx(one, two,three, four, five, scrambl);
    }

    private static void couple_green_rad_left(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
       main.couple_green_rad_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
    }
    private static void couple_green_rad_right(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        main.couple_green_rad_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
    }
    private static void couple_green_orange_left(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        main.couple_green_orange_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
    }
    private static void couple_green_orange_right(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        main.couple_green_orange_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
    }
    private static void couple_orange_blue_left(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        main.couple_orange_blue_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
    }
    private static void couple_orange_blue_right(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        main.couple_orange_blue_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
    }
    private static void couple_blue_rad_left(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        main.couple_blue_rad_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
    }
    private static void couple_blue_rad_right(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        main.couple_blue_rad_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
    }
    private static void tripod_green_rad_left(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        main.tripod_green_rad_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
    }
    private static void tripod_green_rad_right(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        main.tripod_green_rad_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
    }
    private static void tripod_green_orange_left(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        main.tripod_green_orange_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
    }
    private static void tripod_green_orange_right(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        main.tripod_green_orange_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
    }
    private static void tripod_orange_blue_left(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        main.tripod_orange_blue_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
    }
    private static void tripod_orange_blue_right(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        main.tripod_orange_blue_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
    }
    private static void tripod_blue_rad_left(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        main.tripod_blue_rad_left(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
    }
    private static void tripod_blue_rad_right(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        main.tripod_blue_rad_right(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
    }

}
