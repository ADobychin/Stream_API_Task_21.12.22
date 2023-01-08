package Task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Program {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("Начало диапазона лет");
        byte numYear = sc.nextByte();
        System.out.println("Конец диапозона лет");
        byte endYear = sc.nextByte();

        List<Byte> leapYears = returnLeapYear(numYear, endYear);
        System.out.println(leapYears);

        System.out.println("Кол-во требуемых зарплат");
        double salaryNumber = sc.nextDouble();
        List<Double> mySalary = salaries(salaryNumber);


    }

    static List<Byte> returnLeapYear(byte numYear, byte endYear) {
        List<Byte> yearRanges = new ArrayList<>();
        for (byte i = numYear; i <= endYear; i++) {
            yearRanges.add(i);
        }

        List<Byte> leapYearRanges = yearRanges
                .stream().filter(n -> (n % 400 == 0 || (n % 100 != 0 && n % 4 == 0)))
                .toList();
        return leapYearRanges;
    }

    static List<Double> salaries(double salaryNumber) {
        Random randomNum = new Random();
        List<Double> mySalaries = DoubleStream.generate(() -> randomNum.nextGaussian(11190, 29267))
                .filter(n -> n >= 0)
                .limit((long) salaryNumber)
                .boxed()
                .toList();

        return mySalaries;
    }
}
