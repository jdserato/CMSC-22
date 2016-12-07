package MP4.Threads;

/**
 * Created by Serato on December 07, 2016.
 */

public class Rule30 extends Thread {
    private static Rule30 rule;
    static int[][] table;
    private static int gen;
    int[] scope;
    int i;
    int start;
    int end;

    Rule30(int i, int start, int end) {
        this.i = i;
        this.start = start;
        this.end = end;
        scope = new int[end - start + 1];
        //Rule30.getInstance(0);
    }

    private Rule30(int gen) {
        Rule30.gen = gen;
    }

    // using Singleton Design Pattern
    public static Rule30 getInstance(int gen) {
        if (rule == null) {
            rule = new Rule30(gen);
            initialization();
        }
        return rule;
    }

    private static void initialization() { //Initializing 2-D array
        table = new int[gen][(gen * 2) + 1] ;
        for(int i = 0; i < gen; i++) {
            for (int j = 0; j < (gen * 2) + 1; j++) {
                table[i][j] = 0;
            }
        }
        table[0][gen] = 1;
    }

    public void run() { //Declaring
        for (int j = start; j <= end; j++) {
            if (table[i - 1][j - 1] == 1) {
                if (table[i - 1][j] == 0 && table[i - 1][j + 1] == 0) {
                    table[i][j] = 1;
                    scope[j - start] = 1;
                } else {
                    table[i][j] = 0;
                    scope[j - start] = 0;
                }
            } else {
                if (table[i - 1][j] == 0 && table[i - 1][j + 1] == 0) {
                    table[i][j] = 0;
                    scope[j - start] = 0;
                } else {
                    table[i][j] = 1;
                    scope[j - start] = 1;
                }
            }
        }
    }

    static void printing() { //Printing
        for(int i = 0; i < gen; i++) {
            for (int j = 1; j < (gen * 2); j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
