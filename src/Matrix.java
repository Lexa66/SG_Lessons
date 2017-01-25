import java.util.Random;

public class Matrix {
    public static void main(String[] args) {
        m(5);
    }

    static void m(int N) {
        Random random = new Random();
        int[][] m = new int[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                m[r][c] = random.nextInt(1000);
                System.out.print((m[r][c] + " "));
            }
            System.out.print("\n");
        }

        int max = m[0][0];
        int i, i_max = 0, j_max = 0;
        for (i = 0; i < N; i++) {
            if (max < m[i][i]) {
                max = m[i][i];
                i_max = i;
                j_max = i;
            }
            if (max < m[i][N - 1 - i]) {
                max = m[i][N - 1 - i];
                i_max = i;
                j_max = N - 1 - i;
            }
        }
        System.out.println();
        System.out.println("max element = " + max);
        System.out.println();

        int middle = m[N / 2][N / 2];
        m[N / 2][N / 2] = m[i_max][j_max];
        m[i_max][j_max] = middle;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                System.out.print((m[r][c] + " "));
            }
            System.out.print("\n");
        }
    }
}

