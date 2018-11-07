package Cube_project;

import cube_assembly.*;
import cube_disassembly.*;
import print.Sout;

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
        System.out.println("Введите 0 - если хотите сами ввести разборку, или 1 - если хотите автоматическую разборку");
        int nextInt = sc.nextInt();
        if (nextInt == 0){
            Filling_in.Filling_in(white, green, yellow, blue, orange, rad, sc);
        }else {
            GenerateScrambl.GenerateScrambl(white, green, yellow, blue, orange, rad, scrambl);
            scrambl = new StringBuilder();
        }
        //Сборка куба
        //Жёлтый крест:
        Cross.Cross(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
        //F2L
        F2L.F2L(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
        //OLL
        OLL.OLL(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
        //PLL
        PLL.PLL(edge, corners, white, green, yellow, blue, orange, rad, scrambl);
        //Конец сборки
        Sout.sout(white, green, yellow, blue, orange, rad, scrambl);
    }
    //Обновление массива рёбер и углов
    public void Updateedge(int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, int[][] edge){
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
    public void Updatecorners(int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, int[][] corners){
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
    //Вращение граней(от 1 буквы английского названия; приписка x обозначает поворот против часовой стрелки):
    public void U(int[][] one, int[][] two, int[][] three, int[][] four, int[][] five, StringBuilder scrambl){
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
    public void Ux(int[][] one, int[][] two, int[][] three, int[][] four, int[][] five, StringBuilder scrambl){
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
    public void F(int[][] one, int[][] two, int[][] three, int[][] four, int[][] five, StringBuilder scrambl){
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
    public void Fx(int[][] one, int[][] two, int[][] three, int[][] four, int[][] five, StringBuilder scrambl){
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
    public void R(int[][] one, int[][] two, int[][] three, int[][] four, int[][] five, StringBuilder scrambl){
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
    public void Rx(int[][] one, int[][] two, int[][] three, int[][] four, int[][] five, StringBuilder scrambl){
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
    public void L(int[][] one, int[][] two, int[][] three, int[][] four, int[][] five, StringBuilder scrambl){
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
    public void Lx(int[][] one, int[][] two, int[][] three, int[][] four, int[][] five, StringBuilder scrambl){
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
    public void B(int[][] one, int[][] two, int[][] three, int[][] four, int[][] five, StringBuilder scrambl){
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
    public void Bx(int[][] one, int[][] two, int[][] three, int[][] four, int[][] five, StringBuilder scrambl) {
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
    public void D(int[][] one, int[][] two, int[][] three, int[][] four, int[][] five, StringBuilder scrambl){
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
    public void Dx(int[][] one, int[][] two, int[][] three, int[][] four, int[][] five, StringBuilder scrambl){
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
    public void couple_green_rad_left(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        R(rad, yellow, white, green, blue, scrambl);
        Ux(white, green, blue, orange, rad, scrambl);
        Rx(rad, yellow, white, green, blue, scrambl);
        Updateedge(white, green, yellow, blue, orange, rad, edge);
        Updatecorners(white, green, yellow, blue, orange, rad, corners);
    }
    public void couple_green_rad_right(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        Fx(green, yellow, white, orange, rad, scrambl);
        U(white, green, blue, orange, rad, scrambl);
        F(green, yellow, white, orange, rad, scrambl);
        Updateedge(white, green, yellow, blue, orange, rad, edge);
        Updatecorners(white, green, yellow, blue, orange, rad, corners);
    }
    public void couple_green_orange_left(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        F(green, yellow, white, orange, rad, scrambl);
        Ux(white, green, blue, orange, rad, scrambl);
        Fx(green, yellow, white, orange, rad, scrambl);
        Updateedge(white, green, yellow, blue, orange, rad, edge);
        Updatecorners(white, green, yellow, blue, orange, rad, corners);
    }
    public void couple_green_orange_right(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        Lx(orange, yellow, white, blue, green, scrambl);
        U(white, green, blue, orange, rad, scrambl);
        L(orange, yellow, white, blue, green, scrambl);
        Updateedge(white, green, yellow, blue, orange, rad, edge);
        Updatecorners(white, green, yellow, blue, orange, rad, corners);
    }
    public void couple_orange_blue_left(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        L(orange, yellow, white, blue, green, scrambl);
        Ux(white, green, blue, orange, rad, scrambl);
        Lx(orange, yellow, white, blue, green, scrambl);
        Updateedge(white, green, yellow, blue, orange, rad, edge);
        Updatecorners(white, green, yellow, blue, orange, rad, corners);
    }
    public void couple_orange_blue_right(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        Bx(blue, yellow, white, rad, orange, scrambl);
        U(white, green, blue, orange, rad, scrambl);
        B(blue, yellow, white, rad, orange, scrambl);
        Updateedge(white, green, yellow, blue, orange, rad, edge);
        Updatecorners(white, green, yellow, blue, orange, rad, corners);
    }
    public void couple_blue_rad_left(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        B(blue, yellow, white, rad, orange, scrambl);
        Ux(white, green, blue, orange, rad, scrambl);
        Bx(blue, yellow, white, rad, orange, scrambl);
        Updateedge(white, green, yellow, blue, orange, rad, edge);
        Updatecorners(white, green, yellow, blue, orange, rad, corners);
    }
    public void couple_blue_rad_right(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        Rx(rad, yellow, white, green, blue, scrambl);
        U(white, green, blue, orange, rad, scrambl);
        R(rad, yellow, white, green, blue, scrambl);
        Updateedge(white, green, yellow, blue, orange, rad, edge);
        Updatecorners(white, green, yellow, blue, orange, rad, corners);
    }
    public void tripod_green_rad_left(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        Fx(green, yellow, white, orange, rad, scrambl);
        Ux(white, green, blue, orange, rad, scrambl);
        F(green, yellow, white, orange, rad, scrambl);
        Updateedge(white, green, yellow, blue, orange, rad, edge);
        Updatecorners(white, green, yellow, blue, orange, rad, corners);
    }
    public void tripod_green_rad_right(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        R(rad, yellow, white, green, blue, scrambl);
        U(white, green, blue, orange, rad, scrambl);
        Rx(rad, yellow, white, green, blue, scrambl);
        Updateedge(white, green, yellow, blue, orange, rad, edge);
        Updatecorners(white, green, yellow, blue, orange, rad, corners);
    }
    public void tripod_green_orange_left(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        Lx(orange, yellow, white, blue, green, scrambl);
        Ux(white, green, blue, orange, rad, scrambl);
        L(orange, yellow, white, blue, green, scrambl);
        Updateedge(white, green, yellow, blue, orange, rad, edge);
        Updatecorners(white, green, yellow, blue, orange, rad, corners);
    }
    public void tripod_green_orange_right(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        F(green, yellow, white, orange, rad, scrambl);
        U(white, green, blue, orange, rad, scrambl);
        Fx(green, yellow, white, orange, rad, scrambl);
        Updateedge(white, green, yellow, blue, orange, rad, edge);
        Updatecorners(white, green, yellow, blue, orange, rad, corners);
    }
    public void tripod_orange_blue_left(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        Bx(blue, yellow, white, rad, orange, scrambl);
        Ux(white, green, blue, orange, rad, scrambl);
        B(blue, yellow, white, rad, orange, scrambl);
        Updateedge(white, green, yellow, blue, orange, rad, edge);
        Updatecorners(white, green, yellow, blue, orange, rad, corners);
    }
    public void tripod_orange_blue_right(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        L(orange, yellow, white, blue, green, scrambl);
        U(white, green, blue, orange, rad, scrambl);
        Lx(orange, yellow, white, blue, green, scrambl);
        Updateedge(white, green, yellow, blue, orange, rad, edge);
        Updatecorners(white, green, yellow, blue, orange, rad, corners);
    }
    public void tripod_blue_rad_left(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        Rx(rad, yellow, white, green, blue, scrambl);
        Ux(white, green, blue, orange, rad, scrambl);
        R(rad, yellow, white, green, blue, scrambl);
        Updateedge(white, green, yellow, blue, orange, rad, edge);
        Updatecorners(white, green, yellow, blue, orange, rad, corners);
    }
    public void tripod_blue_rad_right(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
        B(blue, yellow, white, rad, orange, scrambl);
        U(white, green, blue, orange, rad, scrambl);
        Bx(blue, yellow, white, rad, orange, scrambl);
        Updateedge(white, green, yellow, blue, orange, rad, edge);
        Updatecorners(white, green, yellow, blue, orange, rad, corners);
    }
}