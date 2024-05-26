package V2;

import java.util.*;

public class Ai_V2 {
    public final static String inputAMessage = "[안내] A값을 입력해 주세요";
    public final static String inputBMessage = "[안내] B값을 입력해 주세요";
    public final static String aiName = " [인공지능 프로그램 V2]";


    public static void startMessage(String aiName) {
        System.out.println(aiName);
        System.out.println("=".repeat(25));

    }

    public static ArrayList<Integer> priceInput() {
        ArrayList<Integer> priceList = new ArrayList<>();
        String input1 = "";
        String exit;
        int inputPrice = 0;
        int boolean1 = -1;

        do {
            System.out.print("[System]예측에 영향을 주는 원인(광고비)의 값을 알려주세요 (단위 원) :");
            input1 = Input.input();
            if (Validation.isValid(input1)) {
                inputPrice = Integer.parseInt(input1);
                priceList.add(inputPrice);

                    do{
                        System.out.println("[안내] 광고비를 추가하시겠습니까? \nY/N");
                        String exitInput = Input.input().toUpperCase();

                    switch (exitInput) {
                        case "Y":
                            System.out.print("[System]추가할 광고비를 입력하여 주세요 (단위 원) :");
                            String inputRepeat = Input.input();
                            if (Validation.isValid(inputRepeat)) {
                                inputPrice = Integer.parseInt(inputRepeat);
                                priceList.add(inputPrice);
                                boolean1 = -2;
                                break;
                            }else {
                                System.out.println("[경고]정확한 광고비를 입력하여 주세요.");
                                    boolean1 = -2;
                            }
                            break;
                        case "N":
                            boolean1 = -1;
                            break;
                        default:
                            System.out.println("Y/N 중 입력해주세요.");
                            boolean1 = -2;
                            break;
                    }
                    }while (!(boolean1 == -1));

                        //수정하기 전 코드에서는 switch문을 do while로 묶어서 계속실행되도록 했었는데
                        //안에서 새로운 인풋을 받아 인풋변수에 할당해서 priceList에 넣어주면
                        //뎁스안에서 해야하기때문에 비효울적이라고 선생님이 말씀해주셨고 그렇다면 제일 처음 입력받는 곳으로 돌아가는게 효율적이다!
                        //switch문이 실행되려면 유효성검증을 끝내고 내려와야하기 때문에 다시 반복할 필요가 없고 맨위로 다시 가면 되는 부분이었다!
                        // 이렇게하니까 y/n을 외에 입력값이 들어가면 처음으로 돌아가서 다시 do while문을 써서 스위치문 안에서 할당해줌으로 해결하였다.
            } else {
                System.out.println("[안내] 정확한 가격을 입력하여 주세요.");
                boolean1 = -2;
            }
        }
        while (!(boolean1 == -1));
        return priceList;
    }


    public static int input(String str) {
        String input1 = "";
        String input2 = "";
        int inputNuma = 0;
        do {
            System.out.println(str);
            input1 = Input.input();

            if (Validation.isValid(input1)) {
                inputNuma = Integer.parseInt(input1);
            } else {
                System.out.println("[안내] 정확한 가격을 입력하여 주세요.");
            }
        }
        while (!Validation.isValid(input1));
        return inputNuma;
//        아래메서드 실행하면 트루 펄스값을 반환 숫자가 맞다면 false를 아니라면 true를 반환

    }

    //추가가능하도록 입력받은 어레이리스트에서 인덱스와 벨류(가격)값을 가져온 후 해시맵으로 만들면서 해당하는 키에 벨류값을 예측값 (a * price ) + b 으로 넣어준다
    public static HashMap<Integer, Integer> aiPredictionMap(int inputA, int inputB, ArrayList<Integer> priceArrayList) {
        HashMap<Integer, Integer> priceMap1 = new HashMap<>();
        Iterator<Integer> iterator = priceArrayList.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            priceMap1.put(index, (inputA * value) + inputB);
            index++;
        }
        return priceMap1;
    }

    public static void aiPredictionMessage(HashMap<Integer, Integer> aiPredictionMap) {
        System.out.println("\n[안내] AI의 '웹 페이지 방문자' 예측 결과는 다음과 같습니다.");
        for (int i = 0; i < aiPredictionMap.size(); i++) {
            System.out.printf(i + 1 + "번째 예측 " + "%d회 방문\n", aiPredictionMap.get(i));
        }
    }


    public static void printPriceList(ArrayList<Integer> priceList) {
        Iterator<Integer> iterator = priceList.iterator();
        System.out.println("[안내] 입력된 광고비 목록:");
        int index = 0;
        while (iterator.hasNext()) {
            System.out.printf("%d번 %d원 ", index++ +1, iterator.next());
        }
    }

}