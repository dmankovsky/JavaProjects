package com.danielmankovsky;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //printMegaBytesAndKiloBytes(8765);
        //bark(false,56);
        //System.out.println(isPalindrome(-222));
        //sumFirstAndLastDigit(23489);
        //numberToWords(100);
        //reverse(100);
        //getDigitCount(23674);
        //getDigitCount(0);
        //printSquareStar(2);
        //reverseWords ("hello  world!");
        //int [] myIntArray = {1,2,3,4,5,6,7};
        //dailyNew(myIntArray,2,5);

        //eureka (224, 240);
        //toMilesPerHour(25.42);
        //printConversion(25.42);
        //countNumbersEntered();
        //minMaxChallenge();
        //inputThenPrintSumAndAverage();


    }

    public static void eureka (int low, int high){
        System.out.println(String.valueOf(low).length());
        System.out.println(String.valueOf(high).length());
        int count =  String.valueOf(high).length();

        while (count > 0){
            System.out.println(high%10);
            count--;
        }
    }

    public static void printMegaBytesAndKiloBytes(int kiloBytes) {
        if (kiloBytes < 0) {
            System.out.println("Invalid Value");
        } else {
            int var = 1024;
            int YY = kiloBytes / var;
            int ZZ = kiloBytes % var;
            System.out.println(kiloBytes + " KB = " + YY + " MB and " + ZZ + " KB");
        }
    }

    public static boolean bark(boolean barking, int hourOfDay) {
        if (hourOfDay < 0 || hourOfDay > 23) {
            return false;
        } else if ((barking && hourOfDay < 8) || (barking && hourOfDay > 22)) {
            return true;
        }
        return false;
    }

    public static boolean isLeapYear(int year) {
        if (year < 1 || year > 9999) {
            return false;
        } else if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            return true;
        }
        return false;
    }

    public static boolean isPalindrome(int number) {
        number = Math.abs(number);
        int var = number;
        int reverse = 0;
        int lastdigit = 0;
        if (number > 0) {
            while (number > 0) {
                reverse = reverse * 10;
                lastdigit = Math.abs(number) % 10;
                reverse += lastdigit;
                number = number / 10;
                System.out.println(reverse);
            }
            System.out.println(reverse);
            System.out.println(var);
        }
        if (reverse == var) {
            return true;
        } else {
            return false;
        }
    }

    public static int sumFirstAndLastDigit (int number){
        if (number  == 0){
            return 0;
        } else if (number < 0){
            return -1;
        } else {
          int sum = 0;
          if (number < 10){
              sum = number * 2;
              System.out.println(sum);
          } else {
              sum = number%10;
              while (number /10 > 0){
                  number = number /10;
              }
              sum += number;
              System.out.println(sum);
          }
            return sum;
        }
    }

    public static void numberToWords (int number){
        int reverseNumber = reverse(number);
        int digitsNumber = getDigitCount(number);
        int digitsReverse = getDigitCount(reverseNumber);
        if (number < 0) {
            System.out.println("Invalid Value");
        }
        String words = null;
        while (reverseNumber > 0){
            int lastDigit = reverseNumber %10;
            switch (lastDigit){
                case 0:
                    System.out.println("Zero\r");
                    break;
                case 1:
                    System.out.println("One\r");
                    break;
                case 2:
                    System.out.println("Two\r");
                    break;
                case 3:
                    System.out.println("Three\r");
                    break;
                case 4:
                    System.out.println("Four\r");
                    break;
                case 5:
                    System.out.println("Five\r");
                    break;
                case 6:
                    System.out.println("Six\r");
                    break;
                case 7:
                    System.out.println("Seven\r");
                    break;
                case 8:
                    System.out.println("Eight\r");
                    break;
                case 9:
                    System.out.println("Nine\r");
                    break;
            }
            words += lastDigit;
            reverseNumber = reverseNumber / 10;
        }
        for (int difference = digitsNumber - digitsReverse;difference > 0;difference --){
            System.out.println("Zero");
        }
    }


    public static int reverse (int number) {
        int var = number;
        number = Math.abs(number);
        int reverse = 0;
        int lastdigit = 0;
        if (number > 0) {
            while (number > 0) {
                reverse = reverse * 10;
                lastdigit = number % 10;
                reverse += lastdigit;
                number = number / 10;
            }
        }
        //System.out.println(reverse);
        if (var >= 0) {
            return reverse;
        } else{
            return (-reverse);
        }
    }

    public static int getDigitCount (int number){
        if (number < 0){
            return -1;
        }
        if (number == 0){
            return 1;
        } else {
            int counter = 0;
            while (number > 0) {
                number /= 10;
                counter++;
            }
            System.out.println(counter);
            return counter;
        }
    }

    public static void printSquareStar (int number){
        if (number < 5){
            System.out.println("Invalid value");
        } else {
            for (int curRow = 0; curRow < number; curRow++) {
                for (int curCol = 0; curCol < number; curCol++) {
                    if (curCol == number - 1) {
                        System.out.println("*");
                    } else if (curCol == 0 || curRow == 0 || curCol == curRow || curRow == number - 1 || curCol == number - 1 - curRow) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
        }
    }

    public static String reverseWords(final String original) {
        char[] inputArray = original.toCharArray();
        char[] result = new char[inputArray.length];

        for(int i =0;i<inputArray.length;i++){
            if (inputArray[i]==' '){
                result[i] = ' ';
            }
        }

        int j = result.length -1;
        for (int i =0; i< inputArray.length; i++){
            if (!" ".equals(inputArray[i])){
                if (" ".equals(result[j])){
                    j--;
                }
                result[j] = inputArray[i];
                j--;
            }
        }
        String result2 = String.copyValueOf(result);
/*        System.out.println(String.valueOf(result2));*/


        return result2;
    }

    public static int dailyNew(int[] inputIntArray, int firstElement, int secondElement){
        if (firstElement > secondElement){
            System.out.println("Second number must be greater than the first.");
            return -1;
        }
        int sum = 0;
        for (int i = firstElement-1; i<secondElement; i++){
            sum += inputIntArray[i];
            //sum += inputIntArray[i];
        }
        System.out.println(sum);
        return sum;
    }

    public static long toMilesPerHour(double kilometersPerHour){
        if (kilometersPerHour < 0) {
            System.out.println("-1");
            return -1;
        } else {
            System.out.println(Math.round(kilometersPerHour / 1.609));
            return (long) Math.round(kilometersPerHour / 1.609);
        }
    }

    public static void printConversion(double kilometersPerHour){
        if (kilometersPerHour < 0){
            System.out.println("Invalid Value");
        } else {
            System.out.println(kilometersPerHour + " km/h = " + (int)Math.round(kilometersPerHour / 1.609) + " mi/h");
        }
    }

    public static void countNumbersEntered(){
        int count = 1;
        int sum = 0;
        Scanner s = new Scanner(System.in);

        while (count <=10) {
            System.out.println("Enter number #" + count + ":");
            boolean isAnInt = s.hasNextInt();
            if (isAnInt) {
                sum += s.nextInt();
                count++;
            } else {
                System.out.println("Invalid Input. Pick a Positiv Integer");
            }
            s.nextLine();
        }
        s.close();
        System.out.println("The sum of your numbers is " + sum);
    }

    public static void minMaxChallenge(){
        int min = 0;
        int max = 0;
        boolean first = true;

        Scanner s = new Scanner(System.in);

        while (true){
            System.out.println("Enter positive integer:");
            boolean isAnInt = s.hasNextInt();
            if (isAnInt){
                int numberEntered = s.nextInt();
                if (first) {
                    first = false;
                    min = numberEntered;
                    max = numberEntered;
                }
                if (numberEntered <= min){
                    min = numberEntered;
                } else if (numberEntered >= max){
                    max = numberEntered;
                }
            } else {
                break;
            }
            s.nextLine();
        }
        s.close();
        System.out.println("Min is " + min + ", max is " + max);
    }

    public static void inputThenPrintSumAndAverage(){
        int sum = 0;
        //long avg = 0;
        int count = 0;

        boolean first = true;

        Scanner s = new Scanner(System.in);
        while (true){
            //System.out.println("Enter positive integer: ");
            boolean isInt = s.hasNextInt();
            if (isInt){
                int numberEntered = s.nextInt();
                if (first){
                    first = false;
                    count ++;
                    sum = numberEntered;
                    //avg = (long)(numberEntered / count);
                } else {
                    sum += numberEntered;
                    count++;
                    //avg = (long) (sum / count);
                }
            } else {
                break;
            }
            s.nextLine();
        }
        s.close();
        System.out.println("SUM = " + sum + " AVG = " + Math.round(sum/count));
    }


    public class SimpleCalculator {
        private double firstNumber;
        private double secondNumber;

        public double getFirstNumber() {
            return this.firstNumber;
        }

        public double getSecondNumber() {
            return this.secondNumber;
        }

        public void setFirstNumber(double firstNumber) {
            this.firstNumber = firstNumber;
        }

        public void setSecondNumber(double secondNumber) {
            this.secondNumber = secondNumber;
        }

        public double getAdditionResult(){
            return (this.firstNumber + this.secondNumber);
        }

        public double getSubtractionResult(){
            return (this.firstNumber - this.secondNumber);
        }

        public double getMultiplicationResult(){
            return (this.firstNumber * this.secondNumber);
        }

        public double getDivisionResult(){
            if (this.secondNumber == 0){
                return 0;
            } else {
                return (this.firstNumber / this.secondNumber);
            }
        }
    }

    public class Person{
        private String firstName;
        private String lastName;
        private int age;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            if (age > 100 || age < 0) {
                this.age = 0;
            } else {
                this.age = age;
            }
        }

        public boolean isTeen (){
            return this.age > 12 && this.age < 20;
        }

        public String getFullName(){
            if (this.firstName.isEmpty() && this.lastName.isEmpty()){
                return "";
            } else if (this.firstName.isEmpty()){
                return this.lastName;
            } else if (this.lastName.isEmpty()){
                return this.firstName;
            } else {
                return this.firstName + " " + this.lastName;
            }
        }

    }

    public class Wall{
        private double width;
        private double height;

        public Wall(double width, double height) {
            if (width < 0){
                this.width = 0;
            } else {
                this.width = width;
            }
            if (height < 0) {
                this.height = 0;
            } else {
                this.height = height;
            }
        }

        public Wall(){ }


        public double getWidth() {
            return width;
        }

        public void setWidth(double width) {
            if (width < 0) {
                this.width = 0;
            } else {
                this.width = width;
            }
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            if (height < 0) {
                this.height = 0;
            } else {
                this.height = height;
            }
        }

        public double getArea(){
            return this.height * this.width;
        }
    }

    public class Point{
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(){};

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public double distance (Point another){
            return Math.sqrt((another.getX()-this.x)*(another.getX()-this.x)+(another.getY()-this.y)*(another.getY()-this.y));
        }

        public double distance (int x, int y){
            Point point = new Point(x,y);
            return distance(point);
        }

        public double distance (){
            return Math.sqrt((this.x)*(this.x)+(this.y)*(this.y));
        }
    }

    public class Floor{
        private double width;
        private double length;

        public Floor(double width, double length) {
            if (width < 0){
                this.width = 0;
            } else {
                this.width = width;
            }
            if (length < 0){
                this.length = 0;
            } else {
                this.length = length;
            }
        }

        public double getArea(){
            return this.width * this.length;
        }
    }

    public class ComplexNumber{
        private double real;
        private double imaginary;

        public ComplexNumber(double real, double imaginary) {
            this.real = real;
            this.imaginary = imaginary;
        }

        public double getReal() {
            return real;
        }

        public double getImaginary() {
            return imaginary;
        }

        public void add (double real, double imaginary){
            this.real += real;
            this.imaginary += imaginary;
        }

        public void add (ComplexNumber complexNumber){
//            this.real += complexNumber.getReal();
//            this.imaginary += complexNumber.getImaginary();
               add(complexNumber.getReal(), complexNumber.getImaginary());
        }

        public void subtract (double real, double imaginary){
            this.real -= real;
            this.imaginary -= imaginary;
        }

        public void subtract (ComplexNumber complexNumber){
//            this.real -= complexNumber.getReal();
//            this.imaginary -= complexNumber.getImaginary();
            subtract(complexNumber.getReal(),complexNumber.getImaginary());
        }
    }

}