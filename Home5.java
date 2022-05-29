package Homework5;

import java.util.Scanner;

public class Home5 {
    private static boolean k=true;
    private static int TotalSum = 0;
    public static void main(String[] args) {

        System.out.println("Пожалуйста, введите ваше имя и несколько первых простых чисел");
        Scanner scanner = new Scanner(System.in);
        String NameNumber = scanner.nextLine();
        String[] words = NameNumber.split(" ");
        //System.out.println(NameNumber);
        //System.out.println(words.length);
        if (words.length == 2) {
            Check(words[1]);
            //для boolean не обязательное расписывать условте, это флаг
            if (k){
                Summator(words[1]);
                String name = words[0];
                //%s отвечает за вывод значения переменной STRING words[0] (т.е. нашего имени)
                System.out.printf("Здравствуй,%s! Сумма цифр в числе %s",name,Converter(TotalSum));
            }
            // System.out.println(words[1]);
            //System.out.println(words[1].length());
        }
        else
        {
            System.out.println("Вы ввели неверные данные,формат ввода: Имя + \"пробел\" + цифры");
        }
    }
    public static void Check(String numbers) {
        try {
            int y = Integer.valueOf(numbers);
        } catch (Exception e) {
            System.out.println("Вы ввели неверные данные,формат ввода: Имя + \"пробел\" + цифры");
            k = false;
        }
        if (!(numbers.length()>1 && numbers.length()<6)) {
            k = false;
            //System.out.println("Введите кол-во чисел от 2 до 5");
        }
    }
    // метод int на вход принимает строку
    // создать цикл, запоминать значения и резать строку, переводим в инт и суммировать
    // перевести в рекурсию
    public static void Summator(String numbers) {
        if (numbers.length()>0 && TotalSum<10) {
            String numbers1=numbers.substring(numbers.length()-1);
            TotalSum = TotalSum + Integer.valueOf(numbers1);
            Summator(numbers.substring(0,numbers.length()-1));
        }
        if(TotalSum>10){
            TotalSum=11;
        }
    }
    public static String Converter(int value){
        String digital[] = {"ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь",
                "девять", "десять", "больше десяти"};
        return digital[value];
    }
}
