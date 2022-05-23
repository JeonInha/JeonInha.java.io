import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 사용자가 입력한 정수의 약수 나열하고 총 갯수 출력하기
        System.out.println("***정수 약수 나열, 갯수 출력***");
        System.out.print("정수 입력: ");
        int x = sc.nextInt();
        int a = 0;
        for (int i = 1; i <= x; i++) {
            if (x % i == 0) {
                a++;
                System.out.printf("약수 %d번째: %d\n", a, i);
            }
        }
        System.out.println("총 약수 갯수: " + a);
        System.out.println("\n\n\n");

        // 사용자가 입력한 5개의 정수 중 가장 큰 수 출력하기
        System.out.println("***입력한 정수 중 가장 큰 수 출력***");
        x = 0;
        int new1 = 0;
        for (int i = 0; i < 5; i++) {
            System.out.print("정수 입력: ");
            new1 = sc.nextInt();
            if (x < new1) {
                x = new1;
            }
        }
        System.out.print("가장 큰 수: " + x);
        System.out.println("\n\n\n");

        // 사용자가 입력한 영단어(latin 문자열)에서 모음이 몇개인지 출력
        System.out.println("***입력한 라틴어에서 모음이 몇개인가?***");
        System.out.print("정수 입력: ");
        sc.nextLine();
        String latin = sc.nextLine();
        x = latin.length();
        int num = 0;
        char y;
        for (int i = 0; i < x; i++) {
            y = latin.charAt(i);
            if (y == 97 || y == 101 || y == 105 || y == 111 || y == 117)
                num++;
        }
        System.out.println("모음 갯수: " + num);

    }
}
