package V2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> priceArrayList = new ArrayList<>();
//        광고비를 얼마나 입력받을지 모르기 때문에 순서가 있는 어레이리스트로 만들어주고 반환하는 Arraylist를 할당해주기 위한 리스트객체를 만들어 뒀다
        HashMap<Integer,Integer> priceMap = new HashMap<>();
//        앞에 만들어진 Arraylist를 받아서 인덱스를 키값으로 벨류값을 입력받은 예측가격으로 맵에 담아주기 위한 해시맵객체를 하나 만들어 뒀다
        int inputA;
//        예측결과를 만들기 위한 변수를 담을 A변수 선언해뒀다.
        int inputB;
//        예측결과를 만들기 위한 변수를 담을 B변수 선언해뒀다.

        Ai_V2.startMessage(Ai_V2.aiName);
        inputA = Ai_V2.input(Ai_V2.inputAMessage);
        inputB = Ai_V2.input(Ai_V2.inputBMessage);
        priceArrayList = Ai_V2.priceInput();
//        이 메서드를 실행하면 입력받은 문자열을 검증해서 숫자로 변환하고 arraylist로 생성했다.
//        얼마나 입력받을지 모르기때문에 컬렉션을 활용했고 그것을 priceArrayList에 할당해줬다.
        Ai_V2.printPriceList(priceArrayList);
//        printPriceList()를 호출하면 arrayList를 받아서 순환하면서 모든 인덱스에 있는 벨류들을 출력해준다!
        priceMap = Ai_V2.aiPredictionMap(inputA,inputB,priceArrayList);
//        aiPredictionMap()는 예측값을 출력하기위한 intputA,intputB,priceArrayList를 매개변수로 받아서
//        iterator로 순회를 돌면서 0번부터 키값에 각각 예측값을 벨류로 넣어줬다 그리고 벨류값은 추가가 될 수도 있기때문에 해시맵으로 생성해줬다.
        Ai_V2.aiPredictionMessage(priceMap);
//        aiPredictionMessage()는 priceMap을 입력받으면 해당하는 반복문을 돌면서 키값에 벨류들을 메시지로 출력해준다!
    }
}