/**
 * Created by dmanzelmann on 4/9/2015.
 */
public class LCSLength {
    int m, n;
    int[][] b, c;

    public LCSLength(char[] x, char[] y) {
        m = x.length;
        n = y.length;

        //b = new int[m-1][n-1];
        c = new int[m][n];

        for (int i = 0; i < m; i++)
            c[i][0] = 0;
        for (int i = 0; i < n; i++)
            c[0][i] = 0;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (x[i-1] == y[j-1]) {
                    c[i][j] = c[i-1][j-1] + 1;
                    //b[i][j] = "diagnol left";
                }
                else if (c[i-1][j] >= c[i][j-1]) {
                    c[i][j] = c[i - 1][j];
                   // b[i][j] = "up";
                }
                else {
                    c[i][j] = c[i][j-1];
                    //b[i][j] = "left arrow";
                }
            }
        }
    }

    public void printLCS() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(c[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[] x = new char[]{'A', 'B', 'C', 'B', 'D', 'A', 'B'};
        char[] y = new char[]{'B', 'D', 'C', 'A', 'B', 'A'};

        LCSLength test = new LCSLength(x, y);
        test.printLCS();
    }
}
