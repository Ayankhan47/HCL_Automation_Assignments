import java.util.Scanner;

public class Q3_MatrixOperations {

    static Scanner sc = new Scanner(System.in);

    static int[][] read(String name) {
        System.out.print("Enter rows and columns of matrix " + name + ": ");
        int r = sc.nextInt(), c = sc.nextInt();
        int[][] m = new int[r][c];
        System.out.println("Enter elements of matrix " + name + ":");
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                m[i][j] = sc.nextInt();
        return m;
    }

    static void print(int[][] m) {
        for (int[] row : m) {
            for (int x : row) System.out.print(x + "\t");
            System.out.println();
        }
    }

    static boolean sameSize(int[][] a, int[][] b) {
        return a.length == b.length && a[0].length == b[0].length;
    }

    static int[][] add(int[][] a, int[][] b) {
        int[][] r = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++)
                r[i][j] = a[i][j] + b[i][j];
        return r;
    }

    static int[][] subtract(int[][] a, int[][] b) {
        int[][] r = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++)
                r[i][j] = a[i][j] - b[i][j];
        return r;
    }

    static int[][] multiply(int[][] a, int[][] b) {
        int[][] r = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < b[0].length; j++)
                for (int k = 0; k < b.length; k++)
                    r[i][j] += a[i][k] * b[k][j];
        return r;
    }

    static int[][] transpose(int[][] a) {
        int[][] t = new int[a[0].length][a.length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++)
                t[j][i] = a[i][j];
        return t;
    }

    static boolean isSquare(int[][] a) { return a.length == a[0].length; }

    static boolean isDiagonal(int[][] a) {
        if (!isSquare(a)) return false;
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a.length; j++)
                if (i != j && a[i][j] != 0) return false;
        return true;
    }

    static boolean isIdentity(int[][] a) {
        if (!isDiagonal(a)) return false;
        for (int i = 0; i < a.length; i++)
            if (a[i][i] != 1) return false;
        return true;
    }

    public static void main(String[] args) {
        int ch;
        do {
            System.out.println("\n===== MATRIX MENU =====");
            System.out.println("1. Addition          2. Subtraction");
            System.out.println("3. Multiplication    4. Transpose");
            System.out.println("5. Check Square      6. Check Diagonal");
            System.out.println("7. Check Identity    0. Exit");
            System.out.print("Enter choice: ");
            ch = sc.nextInt();

            if (ch >= 1 && ch <= 3) {
                int[][] a = read("A"), b = read("B");
                if (ch == 3) {
                    if (a[0].length != b.length) System.out.println("Not possible: columns of A must equal rows of B.");
                    else { System.out.println("Result:"); print(multiply(a, b)); }
                } else if (!sameSize(a, b)) {
                    System.out.println("Not possible: matrices must have the same order.");
                } else {
                    System.out.println("Result:");
                    print(ch == 1 ? add(a, b) : subtract(a, b));
                }
            } else if (ch >= 4 && ch <= 7) {
                int[][] a = read("A");
                switch (ch) {
                    case 4: System.out.println("Transpose:"); print(transpose(a)); break;
                    case 5: System.out.println(isSquare(a) ? "It is a square matrix." : "Not a square matrix."); break;
                    case 6: System.out.println(isDiagonal(a) ? "It is a diagonal matrix." : "Not a diagonal matrix."); break;
                    case 7: System.out.println(isIdentity(a) ? "It is an identity matrix." : "Not an identity matrix."); break;
                }
            } else if (ch != 0) {
                System.out.println("Invalid choice!");
            }
        } while (ch != 0);
        System.out.println("Goodbye!");
        sc.close();
    }
}
