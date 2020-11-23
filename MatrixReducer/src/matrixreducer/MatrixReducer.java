
package matrixreducer;

public class MatrixReducer {


    public static void main(String[] args) {
        
        Matrix mA = new Matrix("1 1 -1 9\n0 8 6 -6\n-2 4 -6 40");        
        Matrix mB = new Matrix("0 4 3 8\n2 0 -1 2\n3 2 0 5");
        Matrix mC = new Matrix("2 -2 1 0\n-1 -2 0 1");
        Matrix mD = new Matrix("1 3 5 -2\n3 -2 -7 5\n2 1 0 1");
        Matrix mD2 = new Matrix("1 3 5 -2 11\n3 -2 -7 5 0\n2 1 0 1 3");
        Matrix mE = new Matrix("1 -1 3 7\n2 3 1 -1\n5 4 61 8\n3 2 4 73");
        Matrix mE2 = new Matrix("1 -1 3\n2 3 1\n5 4 61\n3 2 4");
        
        /*GaussJordan teht3a = new GaussJordan(mA);
        teht3a.reduce();
        
        GaussJordan teht3b = new GaussJordan(mB);
        teht3b.reduce();*/
        
        //GaussJordan stack1 = new GaussJordan(mC);
        //stack1.reduce();
        
        //GaussJordan teht1 = new GaussJordan(mD);
        //teht1.reduce();
        
        //GaussJordan teht12 = new GaussJordan(mD2);
        //teht12.reduce();
        
        GaussJordan teht2 = new GaussJordan(mE2);
        teht2.reduce();
        
    }
}
