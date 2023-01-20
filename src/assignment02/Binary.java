package assignment02;
import java.util.Scanner;

public class Binary {
    public static void main(String[] args)
    {
        int n;

        Scanner input = new Scanner(System.in);
        System.out.print("Input the number you want to convert to binary: ");
        n = input.nextInt();



        int first;
        int second;
        int third;
        int fourth = 0;
        int fifth = 0;
        int sixth = 0;
        int seventh = 0;
        int eighth = 0;

        first = n%2;
        second = ((n-first)/2)%2;
        third = ((n-second)/2)%2;
        fourth = third%2;
        fifth = fourth%2;
        sixth = fifth%2;
        seventh = sixth%2;
        eighth = seventh%2;



        System.out.printf("%d%d%d%d%d%d%d%d", eighth,seventh,sixth,fifth,fourth,third,second,first);
    }
}
