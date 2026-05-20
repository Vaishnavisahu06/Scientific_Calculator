import java.util.Scanner;
class Calculator {
    double add(double... n) {
        double r = 0;
        for (double a : n) {
            r += a;
        }
        return r;
    }

    double sub(double... n) {
        if (n.length == 0) {
            return 0;
        }
        double r = n[0];
        for (int i = 1; i < n.length; i++) {
            r -= n[i];
        }
        return r;
    }

    double mul(double... n) {
        double r = 1;
        for (double a : n) {
            r *= a;
        }
        return r;
    }

    double div(double... n) {
        if (n.length == 0) {
            return 0;
        }
        double r = n[0];
        for (int i = 1; i < n.length; i++) {
            if (n[i] == 0) {
                System.out.println("Error: Cannot divide by zero");
                return 0;
            }
            r /= n[i];
        }
        return r;
    }

    double sqRoot(double a) {
        return Math.sqrt(a);
    }

    double powd(double a, double b) {
        return Math.pow(a, b);
    }

    double sine(double angle) {
        return Math.sin(angle);
    }

    double cosine(double angle) {
        return Math.cos(angle);
    }
}

public class scientific_calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();
        System.out.println("Choose an operator (+, -, *, /, power, sqrt, sin, cos):");
        String o = sc.nextLine().trim().toLowerCase();

        double r = 0;
        boolean showResult = true;
        switch (o) {
            case "+":
                r = calc.add(rNum(sc, 2));
                break;
            case "-":
                r = calc.sub(rNum(sc, 2));
                break;
            case "*":
                r = calc.mul(rNum(sc, 2));
                break;
            case "/":
                r = calc.div(rNum(sc, 2));
                break;
            case "power": {
                double[] numbers = rNum(sc, 2);
                r = calc.powd(numbers[0], numbers[1]);
                break;
            }
            case "sqrt":
                r = calc.sqRoot(rNum(sc, 1)[0]);
                break;
            case "sin":
                r = calc.sine(Math.toRadians(rNum(sc, 1)[0]));
                break;
            case "cos":
                r = calc.cosine(Math.toRadians(rNum(sc, 1)[0]));
                break;
            default:
                showResult = false;
                System.out.println("Unknown operator: " + o);
                break;
        }
        if (showResult) {
            System.out.println("Result: " + r);
        }
    }

    private static double[] rNum(Scanner sc, int minCount) {
        while (true) {
            System.out.println("Enter numbers separated by spaces:");
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                System.out.println("Please enter at least " + minCount + " numbers.");
                continue;
            }
            String[] tokens = line.split("\\s+");
            if (tokens.length < minCount) {
                System.out.println("Please enter at least " + minCount + " numbers.");
                continue;
            }
            try {
                double[] numbers = new double[tokens.length];
                for (int i = 0; i < tokens.length; i++) {
                    numbers[i] = Double.parseDouble(tokens[i]);
                }
                return numbers;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Try again.");
            }
        }
    }
}
