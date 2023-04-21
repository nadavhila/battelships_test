import java.util.Scanner;
public class Main {
    public static boolean check_orient(boolean flag,int orient) {//בדיקת כיוון בדיקה מספר 1
            if (!(orient == 0 || orient == 1)) {
                System.out.println("Illegal orientation, try again!");
                return true;
            }
            return false;
    }
    public static boolean check_bord_limits(boolean flag,int x,int y,int n,int m){//בדיקת חריגת נקודה מהלוח בדיקה מספר 2
        if(flag true)
            return true;
        else if{
            if(!((1<=x && x<=n+1)&&(1<=y && y<=m+1))) {//הלכנו על דרך השלילה
                System.out.println("Illegal tile, try again!");
                return true;
            }
            return false;
        }

    }
    public static boolean check_bord_limits_ship(boolean flag,int x,int y,int size,int orient){//   בדיקת חריגה מספר  3
        if(flag true)
            return true;
        else if(orient==0) {
            if (((y + size - 1) > m + 1))
                System.out.println("Battelship exceeds the boundaries of the board, trey again!");
            return true;
            return false;
        } else if(orient==1){
            if ((x+size-1)>n+1))
                System.out.println("Battelship exceeds the boundaries of the board, trey again!");
                return true;
            return false;
            }
    }
    public boolean check_overlaps(int[][]matrix,int x,int y,int size,int orient){// בדיקה מספר 4 חריגה מהלוח
        if(flag true)
          return true;
        else if(orient==0){
            for(int j=y;j<y+size;j++){
                if(matrix[x][j]!='–') {
                    System.out.println("Battelship overlaps another battelship, try again!");
                    return true;
                }
                return false;
            }
        }
        else if(orient==1){
            for(int i=y;i<x+size;i++){
                if(matrix[i][y]!='–') {
                    System.out.println("Battelship overlaps another battelship, try again!");
                    return true;
                }
                return false;
            }
        }
    }
    public boolean check_adjacent(boolean flag,int[][] matrix,int x,int y,int size,int orient){//בדיקה מספר 5 ת סמיכות לגבולות ולאזורים אסורים
        if(flag true)
          return true;
        else if(orient==0){
            for(int i=y;i<size+y;i++){
                if(matrix[x][y-1]== '-')&(matrix[x-1][y-1]=='-')&(matrix[x-1][y]=='-')&()
            }
        }
    }
}



     public static void split_X(String str, int[] array, int counter) {
        String[] S1 = str.split("X");
        int n = Integer.parseInt(S1[0]);
        int m = Integer.parseInt(S1[1]);
        array[counter++] = n;
        array[counter] = m;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //קליטת הקלט ויצירת מטריצה
        String str = scanner.nextLine();
        String[] S1 = str.split("X");
        int n = Integer.parseInt(S1[0]);
        int m = Integer.parseInt(S1[1]);
        String[][] matrix = new String[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++)
                matrix[i][j] = '–';
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
        int hist_len = arr1[(len * 2) - 1]+1;//אורך ההיסטוגרמה
        int [] hist_z = new int[hist_len];//יצירת ההיסטוגרמה
        for (int j = 0; j+1 < len*2; j++)//גודל מערך העזר
            hist_z[arr1[j + 1]] = arr1[j++];
        int sum=0;
        for (int k = 0; k < hist_len; k++) {//הדפסת ההיסטוגרמה+ספירת כמות הצוללות
            sum += hist_z[k];
            System.out.print(hist_z[k] + ",");
        }
        System.out.println();
        System.out.println(sum);//הדפסת כמות הצוללות
        //זהו לגבי קליטת הצוללות
    /////////////////////////////////////////////////////////////////////*******

        int hist_user_copy[]=new int[hist_z.length];
        for(int i=0;i<hist_z.length;i++)
            hist_user_copy[i]=hist_z[i];
        ///////              פונקציית בדיקות+הצבות ליוזר
        for(int size = 0; size <hist_user_copy.length< size++){
            while(hist[size]!=0){
                System.out.println("Enter location and orientation ,for battelship of size "+ size);
                boolean flag_check=true;
                while(flag){
                   String str_2= scanner.nextLine();//קבלת עוד מחוזרת שפינקו אותנו בה במקום קלט רגיל ונורמלי
                   String[] S2 = str.split(",");///// יש לשקול להפוך לפונקציה נפרדת שמפרידה לפי פסיק
                    int x = Integer.parseInt(S2[0]);
                    int y= Integer.parseInt(S2[1]);
                   int orient=Integer.parseInt(S2[2]);
                   flag_check=check_orient(flag_check,orient);
                   flag_check=check_bord_limits(flag_check,x,y,n,m);
                   flag_check=check_bord_limits_ship(flag_check,x,y,n,m,size,orient);
                   flag_check=check_overlaps(flag_check,x,y,size,orient);





            }
        }



    }
}

מעניין לראות אם זה יישמר



