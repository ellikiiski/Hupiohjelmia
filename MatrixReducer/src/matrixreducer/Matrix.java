
package matrixreducer;

public class Matrix {
    
    private Fraction[][] matrix;
    
    public Matrix(String matrixString) {
        this.matrix = matrixBuilder(matrixString);
    }
    
    public Fraction getValueFrom(int row, int column) {
        return matrix[row][column];
    }
    
    public int getRows() {
        return matrix.length;
    }
    
    public int getColumns() {
        return matrix[0].length;
    }
    
    public void multiplyRow(int row, Fraction multiplier) {
        for (int i = 0; i < matrix[row].length; i++) {
            matrix[row][i] = matrix[row][i].multiply(multiplier);
        }
    }
    
    public void addRows(int rowToAddTo, int rowToBeAdded, Fraction coefficient) {
        for (int i = 0; i < matrix[rowToAddTo].length; i++) {
            Fraction plus = matrix[rowToBeAdded][i].multiply(coefficient);
            matrix[rowToAddTo][i] = matrix[rowToAddTo][i].add(plus);
        }
    }
    
    public void changeRows(int row1, int row2) {
        Fraction[][] newMatrix = new Fraction[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == row1) {
                    //System.out.println("laitetaan rivin " + row1 + " arvoja uuteen matriisiin riville " + row2);
                    //System.out.println("pois " + matrix[row2][j] + " ja tilalle " + matrix[row1][j]);
                    newMatrix[row2][j] = new Fraction(matrix[row1][j].numerator, matrix[row1][j].nominator);
                } else if (i == row2) {
                    //System.out.println("laitetaan rivin " + row2 + " arvoja uuteen matriisiin riville " + row1);
                    //System.out.println("pois " + matrix[row1][j] + " ja tilalle " + matrix[row2][j]);
                    newMatrix[row1][j] = new Fraction(matrix[row2][j].numerator, matrix[row2][j].nominator);
                } else {
                    newMatrix[i][j] = matrix[i][j];
                }
            }
        }
        
        matrix = newMatrix;
    }
    
    private Fraction[][] matrixBuilder(String s) {
        String[] rows = s.split("\n");
        Fraction[][] ret = new Fraction[rows.length][rows[0].split(" ").length];
        for (int i = 0; i < rows.length; i++) {
            String[] values = rows[i].split(" ");
            for (int j = 0; j < values.length; j++) {
                ret[i][j] = new Fraction(Integer.valueOf(values[j]), 1);
            }
        }
        return ret;
    }

    @Override
    public String toString() {
        StringBuilder printOut = new StringBuilder("\n");
        for (int i = 0; i < matrix.length; i++) {
            printOut.append("| ");
            for (int j = 0; j < matrix[i].length; j++) {
                printOut.append(matrix[i][j] + " ");
            }
            printOut.append("|");
            printOut.append("\n");
        }
        return printOut.toString();
    }    
    
}
