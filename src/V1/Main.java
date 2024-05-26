package V1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Ai_V1 ver1 = new Ai_V1();
        int a = 2;
        int b = 1;
        int price = 0;
        IsValid inputNum = new IsValid();
        Scanner sc = new Scanner(System.in);
        String input;
        int userInputNumber;

        do {
            ver1.v1Message();
            ver1.startAiV1();
            input = sc.nextLine();
            if (inputNum.isValid(input)) {
                userInputNumber = Integer.parseInt(input);
                System.out.printf("[안내] 입력된 광고비는 %d원 입니다.", userInputNumber);
                System.out.printf("[안내] AI의 예측(클릭 수)은 %d 입니다.", ver1.aiPrediction(a, b, userInputNumber));
            } else {
                System.out.println("[안내] 정확한 가격을 입력하여 주세요.");
            }
        } while (!inputNum.isValid(input));









    }
}