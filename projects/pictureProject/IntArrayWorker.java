package pixLab.classes;

public class IntArrayWorker {
    /**
     * two dimensional matrix
     */
    private int[][] matrix = null;

    /**
     * set the matrix to the passed one
     *
     * @param theMatrix the one to use
     */
    public void setMatrix(int[][] theMatrix) {
        matrix = theMatrix;
    }

    /**
     * Method to return the total
     *
     * @return the total of the values in the array
     */
    public int getTotal() {
        int total = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                total = total + matrix[row][col];
            }
        }
        return total;
    }

    /**
     * Method to return the total using a nested for-each loop
     *
     * @return the total of the values in the array
     */
    public int getTotalNested() {
        int total = 0;
        for (int[] rowArray : matrix) {
            for (int item : rowArray) {
                total = total + item;
            }
        }
        return total;
    }

    /**
     * Method to fill with an increasing count
     */
    public void fillCount() {
        int numCols = matrix[0].length;
        int count = 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < numCols; col++) {
                matrix[row][col] = count;
                count++;
            }
        }
    }

    /*
     * print the values in the array in rows and columns
     */
    public void print() {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    /*
     * fill the array with a pattern
     */
    public void fillPattern1() {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (row < col) matrix[row][col] = 1;
                else if (row == col) matrix[row][col] = 2;
                else matrix[row][col] = 3;
            }
        }
    }

    // Returns the count of a certain value (num) in the given matrix (matrix)
    public int getCount(int num) {
        int count = 0;
        for (int[] r : matrix)
            for (int c : r)
                if (c == num)
                    count++;
        return count;
    }

    // Returns the value (ret) of the largest integer in a given matrix (martrix)
    public int getLargest() {
        int ret = -1;
        for (int[] r : matrix)
            for (int c : r)
                if (c > ret)
                    ret = c;
        return ret;
    }

    // Returns the sum (sum) of the numbers in a given col (col)
    public int getColTotal(int col) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++)
            sum += matrix[i][col];
        return sum;
    }
}