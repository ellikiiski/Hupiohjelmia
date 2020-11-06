
package matrixreducer;

public class Fraction{
    int numerator;
    int nominator;
    
    public Fraction(int numenator, int nominatior) {
        this.numerator = numenator;
        this.nominator = nominatior;
    }
    
    public boolean isZero() {
        return numerator == 0;
    }
    
    public Fraction inverse() {
        return new Fraction(nominator, numerator);
    }
    
    public Fraction negative() {
        return new Fraction(numerator * (-1), nominator);
    }
    
    public Fraction multiply(Fraction frac) {
        sievenna();
        Fraction newFraction = new Fraction(numerator * frac.numerator, nominator * frac.nominator);
        newFraction.sievenna();
        return newFraction;
    }
    
    public Fraction add(Fraction frac) {
        sievenna();
        int lav1 = frac.nominator;
        int lav2 = this.nominator;
        lavenna(lav1);
        frac.lavenna(lav2);
        Fraction newFraction = new Fraction(numerator + frac.numerator, nominator);
        newFraction.sievenna();
        return newFraction;
    }
    
    public void lavenna(int number) {
        numerator *= number;
        nominator *= number;
    }
    
    public void sievenna() {
        if (this.isZero()) {
            nominator = 1;
        } else {
            for (int i = Math.max(Math.abs(numerator), Math.abs(nominator)); i > 0; i--) {
                if (numerator % i == 0 && nominator % i == 0) {
                    numerator /= i;
                    nominator /= i;
                }
            }
            if (nominator < 0) {
                numerator *= -1;
                nominator *= -1;
            }
        }
        
    }

    @Override
    public String toString() {
        sievenna();
        int numLength = Integer.toString(numerator).length();
        int nomLength = Integer.toString(nominator).length();
        if (nominator == 1 || numerator == 0) {
            if (numLength == 1) {
                return "  " + numerator + "  ";
            }
            if (numLength == 2) {
                return " " + numerator + "  ";
            }
            if (numLength == 3) {
                return " " + numerator + " ";
            }
            if (numLength == 4) {
                return numerator + " ";
            }
            if (numLength == 5) {
                return numerator + "";
            }
            return " big ";
        }
        if (numLength == 1) {
            if (nomLength == 1) {
                return " " + numerator + "/" + nominator + " ";
            }
            if (nomLength == 2) {
                return " " + numerator + "/" + nominator;            
            }
        }
        if (numLength == 2) {
            if (nomLength == 1) {
                return numerator + "/" + nominator + " ";
            }
            if (nomLength == 2) {
                return numerator + "/" + nominator;            
            }
        }
        return "slick";
    }
    
}
