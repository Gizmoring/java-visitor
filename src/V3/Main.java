package V3;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ArrayList<Double> priceArrayList = new ArrayList<>();
//        광고비를 얼마나 입력받을지 모르기 때문에 순서가 있는 어레이리스트로 만들어주고 반환하는 Arraylist를 할당해주기 위한 리스트객체를 만들어 뒀다
        HashMap<Integer, Double> priceMap = new HashMap<>();
//        앞에 만들어진 Arraylist를 받아서 인덱스를 키값으로 벨류값을 입력받은 예측가격으로 맵에 담아주기 위한 해시맵객체를 하나 만들어 뒀다

        ArrayList<Double> visitorArrayList = new ArrayList<>();

        HashMap<Integer, Double> visitorMap = new HashMap<>();

        int boolean1 = -1;
        double result;


        double inputA;
        double inputB;
        Ai_V3.startMessage(Ai_V3.aiName);
        System.out.println("==".repeat(30));
        inputA = Ai_V3.input(Ai_V3.inputAMessage);
        inputB = Ai_V3.input(Ai_V3.inputBMessage);
        System.out.println("==".repeat(30));

        do {
            priceArrayList = Ai_V3.priceInput();
            Ai_V3.printPriceList(priceArrayList);
            priceMap = Ai_V3.priceInputMap(inputA, inputB, priceArrayList);
            Ai_V3.printPriceInputMap(priceMap);
//            전부 완성하고 돌려보다가 떠오른 생각은
//            여기까지 진행했을 때에 priceArrayList.size() 만큼 아래 visitorArrayList를 만들게 하면되잖아 조건식으로!!
//            V4에서 해보는걸로
            visitorArrayList = Ai_V3.visitorInput();
            Ai_V3.printVisitorList(visitorArrayList);
            visitorMap = Ai_V3.visitorInputMap(visitorArrayList);

            // 두 맵의 사이즈의 크기를 비교해서 priceArrayList visitorArrayList size를 비교해서
//        1. priceArrayList.size() > visitorArrayList.size()  (priceArrayList.size() - visitorArrayList.size()) 차이만큼 visitorArrayList에 추가해줘야한다.
//        2. priceArrayList.size() < visitorArrayList.size()  (visitorArrayList.size() - priceArrayList.size()) 차이만큼 priceArrayList에 추가해줘야한다.
//        3. priceArrayList.size() = visitorArrayList.size() 아래로 실행해야함


            if (priceArrayList.size() > visitorArrayList.size()) {
                int needNum = priceArrayList.size() - visitorArrayList.size();
                System.out.println("광고비와 실제 방문자 수를 맞춰서 입력해주세요.");
                boolean1 = -2;
            } else if (priceArrayList.size() < visitorArrayList.size()) {
                int needNum = visitorArrayList.size() - priceArrayList.size();
                System.out.println("광고비와 실제 방문자 수를 맞춰서 입력해주세요.");
                boolean1 = -2;
            } else {
                boolean1 = -1;
            }

        } while (!(boolean1 == -1));

        System.out.println("==".repeat(30));
        Ai_V3.dataPrint(priceMap, visitorMap);
        result = Ai_V3.errorMeasure(priceMap, visitorMap);
        System.out.println("==".repeat(30));
        Ai_V3.totalDataPrint(result);


    }
}