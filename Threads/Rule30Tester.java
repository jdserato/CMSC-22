package MP4.Threads;

/**
 * Created by Serato on December 07, 2016.
 */
public class Rule30Tester {

    private static final int GENERATION = 20;
    private static final int THREAD_COUNT = 4;
    private static final int MIN = 1;
    private static final int GEN_COLUMNS = GENERATION * 2;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int[][] table = new int[GENERATION][GENERATION * 2];
        Rule30.getInstance(GENERATION);
        System.arraycopy(Rule30.table[0], 0, table[0], 0, Rule30.table[0].length - 1);
        Rule30[] worker = new Rule30[THREAD_COUNT];
        int columnsPerThread = GEN_COLUMNS / THREAD_COUNT;
        for (int o = 1; o < GENERATION; o++) {
            // starting point for first thread
            int start = MIN;
            // end point for range of ints
            int end = start + columnsPerThread - 1;

            for (int i = 0; i < THREAD_COUNT; i++) {
                if (i == THREAD_COUNT - 1) {
                    end = GEN_COLUMNS - 1;
                }
                worker[i] = new Rule30(o, start, end);

                start = end + 1;
                end = start + columnsPerThread - 1;
            }

            for (int i = 0; i < THREAD_COUNT; i++) {
                worker[i].start();
            }

            // we want to wait for the workers to die before displaying the final results!
            for (int i = 0; i < THREAD_COUNT; i++) {
                while (worker[i].isAlive()) {
                    try {
                        worker[i].join();
                    } catch (InterruptedException e) {
                        System.err.println("thread interrupted: " + e.getMessage());
                    }
                }
            }
            // copy the progress made to the local array
            for (int i = 0; i < THREAD_COUNT; i++) {
                System.arraycopy(worker[i].scope, 0, table[worker[i].i], worker[i].start, worker[i].end + 1 - worker[i].start);
            }

        }

        for (int i = 0; i < GENERATION; i++) {
            for (int j = 1; j < GEN_COLUMNS; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("time consumed in ms: " + (System.currentTimeMillis() - startTime));
    }
}
