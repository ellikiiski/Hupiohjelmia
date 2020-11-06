
package matrixreducer;

public class MatrixReducer {


    public static void main(String[] args) {
        
        Matrix mA = new Matrix("1 1 -1 9\n0 8 6 -6\n-2 4 -6 40");        
        Matrix mB = new Matrix("0 4 3 8\n2 0 -1 2\n3 2 0 5");      
        
        GaussJordan teht3a = new GaussJordan(mA);
        teht3a.reduce();
        
        GaussJordan teht3b = new GaussJordan(mB);
        teht3b.reduce();
        
    }
}
