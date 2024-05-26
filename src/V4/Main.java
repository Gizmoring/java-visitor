package V4;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ArrayList<Double> priceArrayList = new ArrayList<>();
        HashMap<Integer, Double> priceMap = new HashMap<>();
        ArrayList<Double> visitorArrayList = new ArrayList<>();
        HashMap<Integer, Double> visitorMap = new HashMap<>();

        int boolean1 = -1;
        double result;
        double inputA;
        double inputB;

        Ai_V4.startMessage(Ai_V4.aiName);
        System.out.println("==".repeat(30));
        inputA = Ai_V4.input(Ai_V4.inputAMessage);
        inputB = Ai_V4.input(Ai_V4.inputBMessage);
        System.out.println("==".repeat(30));

        priceArrayList = Ai_V4.priceInput();
        Ai_V4.printPriceList(priceArrayList);
        priceMap = Ai_V4.priceInputMap(inputA, inputB, priceArrayList);


        while(boolean1 == -1) {
            Ai_V4.printPriceInputMap(priceMap);
            visitorArrayList = Ai_V4.visitorInput();
            Ai_V4.printVisitorList(visitorArrayList);
            visitorMap = Ai_V4.visitorInputMap(visitorArrayList);
            if (priceMap.size() == visitorMap.size()) {
                boolean1 = -2;
            } else {
                System.out.println("예측 방문자 개수와 맞는 실제 방문자 수를 입력해주세요.");
                boolean1 = -1;
            }
        }

        System.out.println("==".repeat(30));
        Ai_V4.dataPrint(priceMap, visitorMap);
        result = Ai_V4.errorMeasure(priceMap, visitorMap);
        System.out.println("==".repeat(30));
        Ai_V4.totalDataPrint(result);

    }
}