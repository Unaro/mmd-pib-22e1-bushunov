public class Calc {
    public static void main(String[] args) {
        try {
            for (String arg : args) {
                System.out.println(arg);
            }
            if (args.length > 3) throw new ArrayIndexOutOfBoundsException("Невалидное количество элементов!");
            if (args[1].length() > 1) throw new IllegalArgumentException("Неверный оператор!");

            System.out.print(calc(Double.parseDouble(args[0]), Double.parseDouble(args[2]), args[1].charAt(0)));
        }
        catch (ArithmeticException e) {
            System.err.print("NaN");
        } 
        catch(NumberFormatException e) {
            System.err.println("Неверный формат аргументов!");
        }
        catch(IllegalArgumentException | ArrayIndexOutOfBoundsException | AssertionError e) {
            System.err.println(e.getMessage());
        }
    }

    static double calc(double x, double y, char operation) {
        switch (operation) {
            case '+' -> {
                return x + y;
            }
            case '-' -> {
                return x - y;
            }
            case '*' -> {
                return x * y;
            }
            case '/' -> { 
                if (y == 0.0)
                    throw new ArithmeticException("Деление на ноль!");
                return x / y;
            }
            
            default -> throw new AssertionError("Непредвиденный оператор!");
        }
    }
}

