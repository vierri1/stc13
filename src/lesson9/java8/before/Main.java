package lesson9.java8.before;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your salary");
        Integer salary = scanner.nextInt();
        System.out.println("Enter your country");
        scanner.nextLine();
        String country = scanner.nextLine();
        NonFuncTaxCalc taxCalc = null;
        switch (country) {
            case "Russia": {
                taxCalc = new NonFuncTaxCalc() {
                    @Override
                    public double calculateTax(int sum) {
                        return sum * 0.13;
                    }
                };
                break;
            }
            case "USA": {
                taxCalc = new NonFuncTaxCalc() {
                    @Override
                    public double calculateTax(int sum) {
                        return sum * 0.25;
                    }
                };
                break;
            }
        }
        System.out.println(taxCalc.calculateTax(salary));
    }
}
