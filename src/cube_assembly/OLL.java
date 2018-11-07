package cube_assembly;

import Cube_project.Main;

public class OLL {
    private static Main main = new Main();

    public static void OLL(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
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
                        break;
                    }
                    if (corners[0][1] == 0 && corners[1][0] == 0 && corners[2][2] == 0 && corners[3][0] == 0){//буква T
                        F(green, yellow, white, orange, rad, scrambl);
                        R(rad, yellow, white, green, blue, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        Rx(rad, yellow, white, green, blue, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        Fx(green, yellow, white, orange, rad, scrambl);
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
                        break;
                    }
                    if (corners[0][1] == 0 && corners[1][0] == 0 && corners[2][1] == 0 && corners[3][1] == 0){//Молния
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
                        break;
                    }
                    if (corners[0][1] == 0 && corners[1][0] == 0 && corners[2][2] == 0 && corners[3][0] == 0){//Мягкий знак
                        B(blue, yellow, white, rad, orange, scrambl);
                        U(white, green, blue, orange, rad, scrambl);
                        L(orange, yellow, white, blue, green, scrambl);
                        Ux(white, green, blue, orange, rad, scrambl);
                        Lx(orange, yellow, white, blue, green, scrambl);
                        Bx(blue, yellow, white, rad, orange, scrambl);
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
                        break;
                    }
                    if (corners[0][1] == 0 && corners[1][1] == 0 && corners[2][1] == 0 && corners[3][0] == 0){//Рюмка
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
                    break;
                }
            }
            U(white, green, blue, orange, rad, scrambl);
            main.Updateedge(white, green, yellow, blue, orange, rad, edge);
            main.Updatecorners(white, green, yellow, blue, orange, rad, corners);
        }
        main.Updateedge(white, green, yellow, blue, orange, rad, edge);
        main.Updatecorners(white, green, yellow, blue, orange, rad, corners);
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
}
