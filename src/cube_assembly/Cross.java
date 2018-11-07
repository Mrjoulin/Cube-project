package cube_assembly;

import Cube_project.Main;

public class Cross {
    private static Main main = new Main();

    public static void Cross(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl) {
        //Сборка жёлтого креста
        for (int i = 0; i < 5; i++) {
            main.Updateedge(white, green, yellow, blue, orange, rad, edge);
            while (true){
                if (edge[6][1] == 2 & edge[7][0] == 2 & edge[8][0] == 2 & edge[9][0] == 2) {//если все рёбра уже на местах
                    //Рассположение рёбер в правильном порядке
                    for (int j = 0; j < 4; j++) {
                        int l = 0;
                        if (edge[7][1] == 4) l++;
                        if (edge[6][0] == 1) l++;
                        if (edge[8][1] == 5) l++;
                        if (edge[9][1] == 3) l++;
                        if (l == 4) {
                            break;
                        } else {
                            if (edge[7][1] == 4 && edge[6][0] == 1) {//совпали оранжевый и зелёный
                                Rx(rad, yellow, white, green, blue, scrambl);
                                Dx(yellow, blue, green, orange, rad, scrambl);
                                R(rad, yellow, white, green, blue, scrambl);
                                D(yellow, blue, green, orange, rad, scrambl);
                                Rx(rad, yellow, white, green, blue, scrambl);
                                break;
                            }
                            if (edge[7][1] == 4 && edge[8][1] == 5) {//совпали оранжевый и красный
                                F(green, yellow, white, orange, rad, scrambl);
                                D(yellow, blue, green, orange, rad, scrambl);
                                D(yellow, blue, green, orange, rad, scrambl);
                                Fx(green, yellow, white, orange, rad, scrambl);
                                D(yellow, blue, green, orange, rad, scrambl);
                                D(yellow, blue, green, orange, rad, scrambl);
                                F(green, yellow, white, orange, rad, scrambl);
                                break;
                            }
                            if (edge[7][1] == 4 && edge[9][1] == 3) {//совпали оранжевый и синий
                                Rx(rad, yellow, white, green, blue, scrambl);
                                D(yellow, blue, green, orange, rad, scrambl);
                                R(rad, yellow, white, green, blue, scrambl);
                                Dx(yellow, blue, green, orange, rad, scrambl);
                                Rx(rad, yellow, white, green, blue, scrambl);
                                break;
                            }
                            if (edge[6][0] == 1 && edge[8][1] == 5) {//совпали зелёный и крассный
                                L(orange, yellow, white, blue, green, scrambl);
                                D(yellow, blue, green, orange, rad, scrambl);
                                Lx(orange, yellow, white, blue, green, scrambl);
                                Dx(yellow, blue, green, orange, rad, scrambl);
                                L(orange, yellow, white, blue, green, scrambl);
                                break;
                            }
                            if (edge[6][0] == 1 && edge[9][1] == 3) {//совпали зелёный и синий
                                R(rad, yellow, white, green, blue, scrambl);
                                D(yellow, blue, green, orange, rad, scrambl);
                                D(yellow, blue, green, orange, rad, scrambl);
                                Rx(rad, yellow, white, green, blue, scrambl);
                                D(yellow, blue, green, orange, rad, scrambl);
                                D(yellow, blue, green, orange, rad, scrambl);
                                R(rad, yellow, white, green, blue, scrambl);
                                break;
                            }
                            if (edge[8][1] == 5 && edge[9][1] == 3) {//совпали красный и синий
                                F(green, yellow, white, orange, rad, scrambl);
                                D(yellow, blue, green, orange, rad, scrambl);
                                Fx(green, yellow, white, orange, rad, scrambl);
                                Dx(yellow, blue, green, orange, rad, scrambl);
                                F(green, yellow, white, orange, rad, scrambl);
                                break;
                            }
                        }
                        D(yellow, blue, green, orange, rad, scrambl);
                        main.Updateedge(white, green, yellow, blue, orange, rad, edge);
                    }
                    main.Updateedge(white, green, yellow, blue, orange, rad, edge);
                    if (edge[6][1] == 2 & edge[7][0] == 2 & edge[8][0] == 2 & edge[9][0] == 2 & edge[6][0] == 1 &
                            edge[7][1] == 4 & edge[8][1] == 5 & edge[9][1] == 3) return;
                }else {
                    break;
                }
            }
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
                continue;
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
                continue;
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
                continue;
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
                continue;
            }
            //Жёлтое ребро с боку на верхнем слое
            if (edge[0][1] == 2) {
                for (int j = 0; j < 2; j++) {
                    main.Updateedge(white, green, yellow, blue, orange, rad, edge);
                    if (edge[8][0] != 2 || edge[7][0] != 2) {
                        if (edge[8][0] != 2) {//жёлто-красное
                            Bx(blue, yellow, white, rad, orange, scrambl);
                            R(rad, yellow, white, green, blue, scrambl);
                            B(blue, yellow, white, rad, orange, scrambl);
                        } else {
                            //жёлто-оранжевый
                            B(blue, yellow, white, rad, orange, scrambl);
                            Lx(orange, yellow, white, blue, green, scrambl);
                            Bx(blue, yellow, white, rad, orange, scrambl);
                        }
                        break;
                    } else {
                        D(yellow, blue, green, orange, rad, scrambl);
                    }
                }
                continue;
            }
            if (edge[1][1] == 2) {
                for (int j = 0; j < 2; j++) {
                    main.Updateedge(white, green, yellow, blue, orange, rad, edge);
                    if (edge[9][0] != 2 || edge[6][1] != 2) {
                        if (edge[9][0] != 2) {//жёлто-синее
                            R(rad, yellow, white, green, blue, scrambl);
                            Bx(blue, yellow, white, rad, orange, scrambl);
                            Rx(rad, yellow, white, green, blue, scrambl);
                        } else {
                            //жёлто-зелёное
                            Rx(rad, yellow, white, green, blue, scrambl);
                            F(green, yellow, white, orange, rad, scrambl);
                            R(rad, yellow, white, green, blue, scrambl);
                        }
                        break;
                    } else {
                        D(yellow, blue, green, orange, rad, scrambl);
                    }
                }
                continue;
            }
            if (edge[2][1] == 2) {
                for (int j = 0; j < 2; j++) {
                    main.Updateedge(white, green, yellow, blue, orange, rad, edge);
                    if (edge[8][0] != 2 || edge[7][0] != 2) {
                        if (edge[8][0] != 2) {//жёлто-красное
                            F(green, yellow, white, orange, rad, scrambl);
                            Rx(rad, yellow, white, green, blue, scrambl);
                            Fx(green, yellow, white, orange, rad, scrambl);
                        } else {
                            //жёлто-оранжевый
                            Fx(green, yellow, white, orange, rad, scrambl);
                            L(orange, yellow, white, blue, green, scrambl);
                            F(green, yellow, white, orange, rad, scrambl);
                        }
                        break;
                    } else {
                        D(yellow, blue, green, orange, rad, scrambl);
                    }
                }
                continue;
            }
            if (edge[3][1] == 2) {
                for (int j = 0; j < 2; j++) {
                    main.Updateedge(white, green, yellow, blue, orange, rad, edge);
                    if (edge[9][0] != 2 || edge[6][1] != 2) {
                        if (edge[9][0] != 2) {//жёлто-синее
                            Lx(orange, yellow, white, blue, green, scrambl);
                            B(blue, yellow, white, rad, orange, scrambl);
                            L(orange, yellow, white, blue, green, scrambl);
                        } else {
                            //жёлто-зелёный
                            L(orange, yellow, white, blue, green, scrambl);
                            Fx(green, yellow, white, orange, rad, scrambl);
                            Lx(orange, yellow, white, blue, green, scrambl);
                        }
                        break;
                    } else {
                        D(yellow, blue, green, orange, rad, scrambl);
                    }
                }
                continue;
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
                continue;
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
                continue;
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
                continue;
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
                continue;
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
                continue;
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
                continue;
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
                continue;
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
                continue;
            }
            //Жёлтый находится на нижнем слое с боку
            if (edge[9][1] == 2) {//Жёлто-синее
                B(blue, yellow, white, rad, orange, scrambl);
                Dx(yellow, blue, green, orange, rad, scrambl);
                R(rad, yellow, white, green, blue, scrambl);
                continue;
            }
            if (edge[8][1] == 2) {//Жёлто-красное
                R(rad, yellow, white, green, blue, scrambl);
                Dx(yellow, blue, green, orange, rad, scrambl);
                F(green, yellow, white, orange, rad, scrambl);
                continue;
            }
            if (edge[6][0] == 2) {//Жёлто-зелёное
                F(green, yellow, white, orange, rad, scrambl);
                Dx(yellow, blue, green, orange, rad, scrambl);
                L(orange, yellow, white, blue, green, scrambl);
                continue;
            }
            if (edge[7][1] == 2) {//Жёлто-оранжевое
                L(orange, yellow, white, blue, green, scrambl);
                Dx(yellow, blue, green, orange, rad, scrambl);
                B(blue, yellow, white, rad, orange, scrambl);
            }
        }
        //Заполнение массива рёбер
        main.Updateedge(white, green, yellow, blue, orange, rad, edge);
        //Заполнение массива углов
        main.Updatecorners(white, green, yellow, blue, orange, rad, corners);
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
}
