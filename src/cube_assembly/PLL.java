package cube_assembly;

public class PLL {
    private static Cube_project.Main main = new Cube_project.Main();

    public static void PLL(int[][] edge, int[][] corners, int[][] white, int[][] green, int[][] yellow, int[][] blue, int[][] orange, int[][] rad, StringBuilder scrambl){
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
            if (edge[0][1] == 3 && edge[1][1] == 5 && edge[2][1] == 4 && edge[3][1] == 1 && corners[0][1] == 5 && corners[0][2] == 1 && corners[1][1] == 4 && corners[1][2] == 3 && corners[2][1] == 3 && corners[2][2] == 5 && corners[3][1] == 1 && corners[3][2] == 4) {
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
            main.Updateedge(white, green, yellow, blue, orange, rad, edge);
            main.Updatecorners(white, green, yellow, blue, orange, rad, corners);
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
}
