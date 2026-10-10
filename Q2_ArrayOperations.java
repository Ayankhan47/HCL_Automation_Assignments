import java.util.Scanner;

public class Q2_ArrayOperations {

    static int[] arr = new int[100];  
    static int n = 0;                  

    static void display() {
        if (n == 0) { System.out.println("Array is empty."); return; }
        System.out.print("Array: ");
        for (int i = 0; i < n; i++) System.out.print(arr[i] + " ");
        System.out.println();
    }

    static void insert(int pos, int val) {          // pos is 1-based
        if (n == arr.length) { System.out.println("Array is full!"); return; }
        if (pos < 1 || pos > n + 1) { System.out.println("Invalid position!"); return; }
        for (int i = n; i >= pos; i--) arr[i] = arr[i - 1];
        arr[pos - 1] = val;
        n++;
        System.out.println("Inserted.");
    }

    static void delete(int pos) {                   // pos is 1-based
        if (n == 0) { System.out.println("Array is empty!"); return; }
        if (pos < 1 || pos > n) { System.out.println("Invalid position!"); return; }
        for (int i = pos - 1; i < n - 1; i++) arr[i] = arr[i + 1];
        n--;
        System.out.println("Deleted.");
    }

    static int linearSearch(int key) {
        for (int i = 0; i < n; i++) if (arr[i] == key) return i;
        return -1;
    }

    static int binarySearch(int key) {              // array must be sorted
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) return mid;
            else if (arr[mid] < key) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    static boolean isSorted() {
        for (int i = 0; i < n - 1; i++) if (arr[i] > arr[i + 1]) return false;
        return true;
    }

    static int max() {
        int m = arr[0];
        for (int i = 1; i < n; i++) if (arr[i] > m) m = arr[i];
        return m;
    }

    static void countEvenOdd() {
        int even = 0, odd = 0;
        for (int i = 0; i < n; i++) { if (arr[i] % 2 == 0) even++; else odd++; }
        System.out.println("Even = " + even + ", Odd = " + odd);
    }

    static void insertionSort() {
        for (int i = 1; i < n; i++) {
            int key = arr[i], j = i - 1;
            while (j >= 0 && arr[j] > key) { arr[j + 1] = arr[j]; j--; }
            arr[j + 1] = key;
        }
        System.out.println("Array sorted.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch;
        do {
            System.out.println("\n===== ARRAY MENU =====");
            System.out.println("1. Insertion        2. Deletion");
            System.out.println("3. Linear Search    4. Binary Search");
            System.out.println("5. Maximum value    6. Count Even/Odd");
            System.out.println("7. Insertion Sort   8. Display");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter position (1-" + (n + 1) + ") and value: ");
                    int p = sc.nextInt(), v = sc.nextInt();
                    insert(p, v);
                    break;
                case 2:
                    System.out.print("Enter position to delete: ");
                    delete(sc.nextInt());
                    break;
                case 3:
                    System.out.print("Enter element to search: ");
                    int idx = linearSearch(sc.nextInt());
                    System.out.println(idx == -1 ? "Not found." : "Found at position " + (idx + 1));
                    break;
                case 4:
                    if (!isSorted()) { System.out.println("Array must be sorted first (use option 7)."); break; }
                    System.out.print("Enter element to search: ");
                    int bi = binarySearch(sc.nextInt());
                    System.out.println(bi == -1 ? "Not found." : "Found at position " + (bi + 1));
                    break;
                case 5:
                    if (n == 0) System.out.println("Array is empty!");
                    else System.out.println("Maximum = " + max());
                    break;
                case 6: countEvenOdd(); break;
                case 7: insertionSort(); display(); break;
                case 8: display(); break;
                case 0: System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid choice!");
            }
        } while (ch != 0);
        sc.close();
    }
}
