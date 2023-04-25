import java.util.Scanner;
import java.util.Random;
public class Main {
    static Random rand = new Random();

    public static boolean check_orient(boolean flag_user, boolean flag_extra, int orient) {//בדיקת כיוון בדיקה מספר 1
        if (!(orient == 0 || orient == 1)) {
            if (flag_extra) {
                System.out.println("Illegal orientation, try again!");
            }
            return true;
        }
        return false;
    }

    public static boolean check_bord_limits(boolean flag_user, boolean flag_extra, int x, int y, int n, int m) {//בדיקת חריגת נקודה מהלוח בדיקה מספר 2
        if (flag_user)
            return true;
        else {
            if (!((1 <= x && x <= n + 1) && (1 <= y && y <= m + 1))) {//הלכנו על דרך השלילה
                if (flag_extra) {
                    System.out.println("Illegal tile, try again!");
                }
                return true;
            }
            return false;
        }

    }

    public static boolean check_bord_limits_ship(boolean flag_user, boolean flag_extra, int x, int y, int size, int n, int m, int orient) {//   בדיקת חריגה מספר  3
        if (flag_user)
            return true;
        else if (orient == 0) {
            if (((y + size - 1) > m + 1)) {
                if (flag_extra) {
                    System.out.println("Battleship exceeds the boundaries of the board, trey again!");
                    return true;
                }
                return true;
            }
            return false;
        } else if (orient == 1) {
            if ((x + size - 1) > n + 1) {
                if (flag_extra) {
                    System.out.println("Battleship exceeds the boundaries of the board, try again!");
                    return true;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public static boolean check_overlaps(boolean flag_user, boolean flag_extra, String[][] matrix, int x, int y, int size, int orient) {// בדיקה מספר 4 חריגה מהלוח
        if (flag_user)
            return true;
        else if (orient == 0) {
            for (int j = y; j < y + size; j++) {
                if (!((matrix[x][j]).equals("–"))) {
                    if (flag_extra) {
                        System.out.println("Battleship overlaps another battleship, try again!");
                    }
                    return true;
                }
                return false;
            }
        } else if (orient == 1) {
            for (int i = y; i < x + size; i++) {
                if (!((matrix[i][y]).equals("–"))) {
                    if (flag_extra) {
                        System.out.println("Battleship overlaps another battleship, try again!");
                    }
                    return true;
                }
                return false;
            }
        }
        return true;
    }

    public boolean check_adjacent(boolean flag, String[][] matrix, int x, int y, int n, int m, int size, int orient) {//בדיקה מספר 5  סמיכות לגבולות ולאזורים אסורים** לא שלם- המשך של נדב -במידה ואתה משתמשש בטמפלט שלי- לשים לב שזה מערך של סטרינגים ולא צ'ארים ולכן צריך להשתמש בפונקציה equals()
        if (flag)
            return true;
        else if (orient == 0) {//בדיקה במידה והצוללת אופקית
            for (int j = y; j < size + y; j++) {  ///// בדיקה של כל הנקודות הסמוכות לנקודת ההדפסה של הצוללת ** לא כולל צלעות ופינות
                if (1 < x && x <= n && 1 < y && y <= m) {
                    if (matrix[x][j + 1] == '–' && matrix[x][j - 1] == '–' && matrix[x - 1][j] == '–' && matrix[x + 1][j] == '–' && matrix[x + 1][j + 1] == '–' && matrix[x - 1][j + 1] == '–' && matrix[x + 1][j - 1] == '–' && matrix[x - 1][j - 1] == '–')
                        return false;
                    return true;
                } else if (x == 1) {//צלע עליונה -אופקי
                    if (matrix[x][j + 1] == '–' && matrix[x][j - 1] == '–' && matrix[x - 1][j] == '–' && matrix[x - 1][j - 1] == '–' && matrix[x - 1][j + 1] == '–')
                        return false;
                    return true;
                } else if (x == n + 1) {//צלע תחתונה-אופקי
                    if (matrix[x][j + 1] == '–' && matrix[x][j - 1] == '–' && matrix[x + 1][j] == '–' && matrix[x + 1][j - 1] == '–' && matrix[x + 1][j + 1] == '–')
                        return false;
                    return true;
                }
            }
        } else if (orient == 1) {
            for (int i = x; i < size + x; i++) {// בדיקה במידה והצוללת אנכית
                if (1 < x && x <= n && 1 < y && y <= m) {
                    if (matrix[i + 1][y] == '–' && matrix[i - 1][y] == '–' && matrix[i][y + 1] == '–' && matrix[i][y - 1] == '–' && matrix[i + 1][y + 1] == '–' && matrix[i + 1][y - 1] == '–' && matrix[i - 1][y + 1] == '–' && matrix[i - 1][y - 1] == '–')
                        return false;
                    return true;
                } else if (y == 1) {// בדיקה של צלע שמאלית-אנכי
                    if (matrix[i + 1][y] == '–' && matrix[i - 1][y] == '–' && matrix[i][y + 1] == '–' && matrix[i + 1][y + 1] == '–' && matrix[i - 1][y + 1] == '–')
                        return false;
                    return true;
                } else if (y == m + 1) {// בדיקה של צלע ימנית-אנכי
                    if (matrix[i + 1][y] == '–' && matrix[i - 1][y] == '–' && matrix[i][y - 1] == '–' && matrix[i - 1][y - 1] == '–' && matrix[i + 1][y - 1] == '–')
                        return false;
                    return true;
                }
                // צריך לבדוק את עניין הפינות
            }
        }
    }

    public static void print_user_board(String[][] matrix) {
        int num_rows = matrix.length;
        int num_cols = matrix[0].length;
        for (int i = 0; i < num_rows; i++) {
            for (int j = 0; j < num_cols; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }

    public static void print_computer_board(String[][] matrix) {
        int num_rows = matrix.length;
        int num_cols = matrix[0].length;
        for (int i = 0; i < num_rows; i++) {
            for (int j = 0; j < num_cols; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }

    public static void split_X(String str, int[] array, int counter) {
        String[] S1 = str.split("X");
        int n = Integer.parseInt(S1[0]);
        int m = Integer.parseInt(S1[1]);
        array[counter++] = n;
        array[counter] = m;
    }

    public static void change_board(int[] hist, String[][] matrix, int orient, int x, int y, int size) {
        if (orient == 0) {
            for (int j = 0; j < size; j++) {
                matrix[x][y + j] = "#";
                hist[size] -= 1;
            }
        }
        if (orient == 1) {
            for (int j = 0; j < size; j++) {
                matrix[x + j][y] = "#";
                hist[size] -= 1;
            }
        }
    }

    public static String[][] matrix(int n, int m) {
        String[][] matrix = new String[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++)
                matrix[i][j] = "–";
        }
        matrix[0][0] = " ";
        for (int j = 0; j + 1 < m + 1; j++) {
            matrix[0][j + 1] = j + "";
        }
        for (int i = 0; i + 1 < n + 1; i++) {
            matrix[i + 1][0] = i + "";
        }
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
        return matrix;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //קליטת הקלט ויצירת מטריצה
        String str = scanner.nextLine();
        String[] S1 = str.split("X");
        int n = Integer.parseInt(S1[0]);
        int m = Integer.parseInt(S1[1]);
        String[][] matrix_user = matrix(n, m);
        String[][] matrix_computer = matrix(n, m);
        //*****קליטת הצוללות צריך לעטוף בפונקציה
        String zoollelot = scanner.nextLine();//קליטת צוללות

        String[] shlav1 = zoollelot.split(" ");
        int len = shlav1.length;
        int[] arr1 = new int[len * 2];//מערך עזר בינתיים...
        int counter = 0;
        for (int i = 0; i < len; i++) {
            split_X(shlav1[i], arr1, counter);
            counter += 2;
        }
        int hist_len = arr1[(len * 2) - 1] + 1;//אורך ההיסטוגרמה
        int[] hist_z = new int[hist_len];//יצירת ההיסטוגרמה
        for (int j = 0; j + 1 < len * 2; j++)//גודל מערך העזר
            hist_z[arr1[j + 1]] = arr1[j++];
        int sum = 0;
        for (int k = 0; k < hist_len; k++) {//הדפסת ההיסטוגרמה+ספירת כמות הצוללות
            sum += hist_z[k];
            System.out.print(hist_z[k] + ",");
        }
        System.out.println();
        System.out.println(sum);//הדפסת כמות הצוללות
        //זהו לגבי קליטת הצוללות
        /////////////////////////////////////////////////////////////////////*******

        int[] hist_user_copy = new int[hist_z.length];
        for (int i = 0; i < hist_z.length; i++)
            hist_user_copy[i] = hist_z[i];
        /////            פונקציית בדיקות+הצבות ליוזר
        for (int size = 0; size < hist_user_copy.length; size++) {
            while (hist_user_copy[size] != 0) {
                System.out.println("Enter location and orientation ,for battelship of size " + size);
                boolean flag_user = true;
                boolean flag_extra = true;
                int x = 0, y = 0, orient = 0;
                while (flag_user) {
                    String str_2 = scanner.nextLine();//קבלת עוד מחוזרת שפינקו אותנו בה במקום קלט רגיל ונורמלי
                    String[] S2 = str.split(",");///// יש לשקול להפוך לפונקציה נפרדת שמפרידה לפי פסיק
                    x = Integer.parseInt(S2[0]);
                    y = Integer.parseInt(S2[1]);
                    orient = Integer.parseInt(S2[2]);
                    flag_user = check_orient(flag_user, flag_extra, orient);
                    flag_user = check_bord_limits(flag_user, flag_extra, x, y, n, m);
                    flag_user = check_bord_limits_ship(flag_user, flag_extra, x, y, n, m, size, orient);
                    flag_user = check_overlaps(flag_user, flag_extra, matrix_user, x, y, size, orient);
                    flag_user = check_adjacent(flag_user, flag_extra, matrix_user, x, y, size, orient);
                }
                change_board(hist_user_copy, matrix_user, orient, x, y, size);
                print_user_board(matrix_user);
            }
        }/////// קליטת קלט למחשב+בדיקות+הדפסה למחשב
        int[] hist_computer_copy = new int[hist_z.length];//היסטוגרמה למחשב-העתק
        for (int i = 0; i < hist_z.length; i++)
            hist_computer_copy[i] = hist_z[i];
        for (int size = 0; size < hist_computer_copy.length; size++) {
            int xc = 0, yc = 0, orient_c = 0;
            boolean flag_computer = true;
            boolean flag_extra = false;
            while (hist_computer_copy[size] != 0) {
                while (flag_computer) {
                    xc = rand.nextInt(n);
                    yc = rand.nextInt(m);
                    orient_c = rand.nextInt(2);
                    flag_computer = check_orient(flag_computer, flag_extra, orient_c);
                    flag_computer = check_bord_limits(flag_computer, flag_extra, xc, yc, n, m);
                    flag_computer = check_bord_limits_ship(flag_computer, flag_extra, xc, yc, n, m, size, orient_c);
                    flag_computer = check_overlaps(flag_computer, flag_extra, matrix_computer, xc, yc, size, orient_c);
                    flag_computer = check_adjacent(flag_computer, flag_extra, matrix_computer, xc, yc, size, orient_c);
                }
            }
            change_board(hist_computer_copy, matrix_computer, orient_c, xc, yc, size);
        }


/////////////////////////////////////////////////////////////////////////////attacks!
        System.out.println("Your current guessing board: ");
        print_computer_board(matrix_computer);
        System.out.println("Enter a tile to attack");
        boolean good_point=true;
        boolean flag_extra=false;
        int x=0,y=0;
        while(good_point){// !!!בדיקת קלט של התקפה
            String str_3 = scanner.nextLine();
            String[] S3 = str.split(",");
            x = Integer.parseInt(S3[0]);
            y = Integer.parseInt(S3[1]);
            check_bord_limits(good_point, flag_extra, x, y, n, m);
            String cordinations=matrix_computer[x][y];
            if(!good_point) {
                if (!cordinations.equals("–") && !cordinations.equals("#")) {
                    System.out.println("Tile already attacked, try again!");
                    good_point = true;
                } else good_point = false;
            }
        }
        /////// ההתקפות עצמן

    }
}

    public static int sum_Digits(int n){
        int counter = 0;
        if(n==0)
            return 1;
        while(n!=0){
            n /= 10;
            counter++;
        }
        return counter;
    }

    public static String[][] matrix(int n, int m) {
        String[][] matrix = new String[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++)
                matrix[i][j] = "–";
        }
        int num_Spaces = sum_Digits(n);
        matrix[0][0] = "";
        for (int k = 0; k < num_Spaces; k++)
            matrix[0][0]+=" ";
        for (int j = 0; j + 1 < m + 1; j++) {
            matrix[0][j + 1] = j + "";
        }
        for (int i = 0; i + 1 < n + 1; i++) {
            int sum_Spaces =num_Spaces-sum_Digits(i);
            matrix[i+1][0]= "";
            for (int l = 0; l < sum_Spaces; l++)
                matrix[i+1][0]+= " ";
            matrix[i + 1][0]+= i + "";
        }
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
        return matrix;
    }
