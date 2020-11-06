
package matrixreducer;

public class GaussJordan {
    private Matrix matrix;
     
    public GaussJordan(Matrix matrix) {
        this.matrix = matrix;
    }
    
    public void reduce() {
        System.out.println("REDUSOIDAAN MATRIISI ELLIN HUIKEALLA SPAGETTIKOODILLA: ");
        System.out.println(matrix);
        int i = 0;
        int k = 1;
        boolean loppuunAsti = true;
        while (i < matrix.getRows()) {
            Fraction leading = matrix.getValueFrom(i, i);
            if (!leading.isZero()) {
                matrix.multiplyRow(i, leading.inverse());
                System.out.println("Jaetaan rivi " + (i+1) + " luvulla " + leading);
                System.out.println(matrix);
                for (int j = 0; j < matrix.getRows(); j++) {
                    if (j != i) {
                        System.out.println("Vähennetään rivi " + (i + 1) + " rivistä " + (j + 1));
                        matrix.addRows(j, i, matrix.getValueFrom(j, i).negative());
                        System.out.println(matrix);
                    }
                }
                i++;
            } else {
                if (i < matrix.getRows() - 1) {
                    System.out.println("Vaihdetaan rivien " + (i+1) + " ja " + (i+k+1) + " paikkaa");
                matrix.changeRows(i, i + k);
                System.out.println(matrix);
                k++;
                } else {
                    i++;
                    loppuunAsti = false;
                }
            }
        }
        if (loppuunAsti) {
            System.out.println("Waaaau!");
            System.out.println("");
            System.out.println("");
        } else {
            System.out.println("Ei taida yhtälöryhmä ratketa.");
            System.out.println("");
            System.out.println("");
        }
    }

}
