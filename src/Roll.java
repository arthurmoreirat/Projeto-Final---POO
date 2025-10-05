import java.util.Random;

public final class Roll {
    private static final Random r = new Random();

    // Método genérico: rola um dado de N lados
    private static int roll(int lados) {
        return r.nextInt(lados) + 1;
    }

    // Método genérico: rola com vantagem (>0), desvantagem (<0)
    private static int roll(int lados, int vantagem) {
        int d1 = roll(lados);
        int d2 = roll(lados);

        System.out.printf("Rolagens: %d, %d\n", d1, d2);

        if (vantagem > 0) {
            System.out.printf("Resultado: %d\n", Math.max(d1, d2));
            return Math.max(d1, d2);
        } else {
            System.out.printf("Resultado: %d\n", Math.min(d1, d2));
            return Math.min(d1, d2);
        } 
    }

    // Dados específicos
    public static int d6() { 
        return roll(6); 
    }

    public static int d6(int vantagem) { 
        return roll(6, vantagem); 
    }

    public static int d8() { 
        return roll(8); 
    }

    public static int d8(int vantagem) { 
        return roll(8, vantagem); 
    }

    public static int d10() { 
        return roll(10); 
    }

    public static int d10(int vantagem) { 
        return roll(10, vantagem); 
    }

    public static int d20() { 
        return roll(20); 
    }

    public static int d20(int vantagem) { 
        return roll(20, vantagem); 
    }
}
