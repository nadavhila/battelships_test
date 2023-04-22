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






התקפות משתמש:

system.out.println("Your current guessing board:");

מדפיס את המטריצה של המחשב המעודכנת

system.out.print("Enter a tile to attack");

בגלל שצריך לסרוק מחדש בגלל תנאים נראלי כדאי לשים הכל בפונקציה,או לעשות סריקה עם דגל ואז אם הדגל תקין אחרי שעברנו את שני התנאים להיכנס לאיזור של התקיפה עצמה.

 "x,y" לסרוק מהמשתמש

  שני התנאים הבאים גורמים לסריקה מחדש אז צריך להשתמש שוב בדגל:

1.לקרוא לפונקציה שבודקת אם הנקודה נמצאת בגבולות הלוח כדי לבדוק תקינות

2.לעשות תנאי, אם המטריצה בנקודה הנתונה שווה לכל דבר ששונה ממקף,זה יכול להיות איקס או וי,אז להדפיס
  if (matrix_computer[x][y] != "-"){
    system.out.println("Tile already attacked, try again!");
    משהו עם פלאג
  }

"יציאה מהתנאים"

"ביצוע ההתקפה"
שלוש אפשרויות:

1.   אם המטריצה באותו מקום היתה שווה למקף,להדפיס פספוס ולשנות את המטריצה של המחשב לאיקס

 if (matrix_computer[x][y] == "-"){
    system.out.println("That is a miss!");
    matrix_computer[x][y] == "X";
 }

2. אם המטריצה באותו מקום היתה שווה לסולמית, להדפיס פגיעה ולשים וי
    if (matrix_computer[x][y] == "#"){
    system.out.println("That is a hit!");
    matrix_computer[x][y] == " V";
 }

 3. בנוסף אם התקיפה גרמה לצוללת לשקוע להדפיס עוד משהו, וגם לשנות בהיסטוגרמה של המחשב באותו גודל של הצוללת פחות אחת ולהראות את אר שהוא מספר הצוללות הנותרות
     הנקודה הבעייתית ביותר כי קשה לבדוק את הצדדים או מעל ומתחת וגם אם כן צריך לבדוק אם כל מה שאחרי הוא גם וי ואז לספור את הויים לראות את הגודל שלהם, ללכת להיסטוגרמה ולהוריד מהאינדקס ששווה לגודל אחד.

    


4. לדעתי, אחרי כל תקיפה צריך לבדוק אם אר של היריב שווה לאפס, אם כן המשחק נגמר והוא ניצח אם לא עוברים להתקפה הבאה
   בדיקת האר תהיה חיבור כל האיברים בהיסטוגרמה
    r_c = 0;  זה חישוב הכמות בהיסטוגרמה של המחשב
   for (i=0, i< hist_computer.length(), i++) {
        r_c = r_c + hist_computer[i],
   }
   עדיף לבדוק את אר אחרי כל ההצבות ואז לעשות לו משתנה.
   if (r_C == 0 ){
        system.out.println("You won the game!");
        חזרה מהפונקציה המקורית כדי לסיים את המשחק לגמרי
 }
" סיום התקפה של המשתמש"

 התקפות מחשב:

 לעשות שתי הגרלות, אחת לאיקס ואחת לוואי כמו בקבלת המיקום

 "לעשות את שני התנאים למחשב אבל בלי הדפסות שגיאה"
  
1. לפי הפונקציה שבודקת תקינות בגבולות הלוח

2. כמו אצל המשתמש

    if (matrix_user[x][y] != "-"){
        משהו עם פלאג
  }

"יציאה מהתנאים"

"ביצוע ההתקפה"

system.out.println("The computer attacked " + (משתנה וואי ,משתנה איקס));

שוב אותן פעולות תקיפה כמו שהגדרנו למשתמש, לשים לב לשינויים הקטנים בהדפסות
ובשמות המשתנים המתקבלים

 r_u = 0;  זה חישוב הכמות בהיסטוגרמה של המשתמש
   for (i=0, i< hist_User.length(), i++) {
        r_c = r_c + hist_User[i],
   }
   עדיף לבדוק את אר אחרי כל ההצבות ואז לעשות לו משתנה.
   if (r_u == 0 ){
        system.out.println("You lost ):");
        חזרה מהפונקציה המקורית כדי לסיים את המשחק לגמרי
 }

System.out.println("Your current game board:");
הדפסת המטריצה של המשתמש המעודכנת

 "סיום ההתקפה של המחשב"








