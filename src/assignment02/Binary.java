package assignment02;
import java.util.Scanner;

public class Binary {
    public static void main(String[] args)
    {
        int n;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        n = input.nextInt();

        int first = 0;
        int second = 2;
        int third = 4;
        int fourth = 8;
        int fifth = 16;
        int sixth = 32;
        int seventh = 64;
        int eighth = 128;

        eighth = n/eighth;
        seventh = (n-(eighth*128))/64;
        sixth = (n-((eighth*128)+(seventh*64)))/32;
        fifth = (n-((eighth*128)+(seventh*64)+(sixth*32)))/16;
        fourth = (n-((eighth*128)+(seventh*64)+(sixth*32)+(fifth*16)))/8;
        third = (n-((eighth*128)+(seventh*64)+(sixth*32)+(fifth*16)+(fourth*8)))/4;
        second = (n-((eighth*128)+(seventh*64)+(sixth*32)+(fifth*16)+(fourth*8)+(third*4)))/2;
        first = (n-((eighth*128)+(seventh*64)+(sixth*32)+(fifth*16)+(fourth*8)+(third*4)+(second*2)))/1;

        System.out.printf("%d%d%d%d%d%d%d%d", eighth, seventh, sixth, fifth, fourth, third, second, first);
    }
}