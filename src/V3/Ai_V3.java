package V3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Ai_V3 {
    public final static String inputAMessage = "[안내] A값을 입력해 주세요";
    public final static String inputBMessage = "[안내] B값을 입력해 주세요";
    public final static String aiName = " [인공지능 프로그램 V3]";


    public static void startMessage(String aiName) {
        System.out.println(aiName);
    }

    public static ArrayList<Double> priceInput() {
        ArrayList<Double> priceList = new ArrayList<>();
        String input1 = "";
        String exit;
        double inputPrice = 0;
        int boolean1 = -1;

        do {
            System.out.print("[System]예측에 영향을 주는 원인(광고비)의 값을 알려주세요 (단위 원) :");
            input1 = Input.input();
            if (Validation.isValid(input1)) {
                inputPrice = Double.parseDouble(input1);
                priceList.add(inputPrice);

                do {
                    System.out.println("[안내] 광고비를 추가하시겠습니까? \nY/N");
                    String exitInput = Input.input().toUpperCase();

                    switch (exitInput) {
                        case "Y":
                            System.out.print("[System]추가할 광고비를 입력하여 주세요 (단위 원) :");
                            String inputRepeat = Input.input();
                            if (Validation.isValid(inputRepeat)) {
                                inputPrice = Double.parseDouble(inputRepeat);
                                priceList.add(inputPrice);
                                boolean1 = -2;
                                break;
                            } else {
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
                } while (!(boolean1 == -1));

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


    public static ArrayList<Double> visitorInput() {
        ArrayList<Double> visitorList = new ArrayList<>();
        String input1 = "";
        String exit;
        double inputVisitor = 0;
        int boolean1 = -1;

        do {
            System.out.print("[System]실제 웹 페이지 방문자 수를 입력하여주세요. :");
            input1 = Input.input();
            if (Validation.isValid(input1)) {
                inputVisitor = Double.parseDouble(input1);
                visitorList.add(inputVisitor);

                do {
                    System.out.println("[안내]웹 페이지 방문자 수를 추가하시겠습니까? \nY/N");
                    String exitInput = Input.input().toUpperCase();

                    switch (exitInput) {
                        case "Y":
                            System.out.print("[System]추가할 인원수를 입력하여 주세요. :");
                            String inputRepeat = Input.input();
                            if (Validation.isValid(inputRepeat)) {
                                inputVisitor = Double.parseDouble(inputRepeat);
                                visitorList.add(inputVisitor);
                                boolean1 = -2;
                                break;
                            } else {
                                System.out.println("[경고]정확한 인원수를 입력하여 주세요.");
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
                } while (!(boolean1 == -1));

                //수정하기 전 코드에서는 switch문을 do while로 묶어서 계속실행되도록 했었는데
                //안에서 새로운 인풋을 받아 인풋변수에 할당해서 priceList에 넣어주면
                //뎁스안에서 해야하기때문에 비효울적이라고 선생님이 말씀해주셨고 그렇다면 제일 처음 입력받는 곳으로 돌아가는게 효율적이다!
                //switch문이 실행되려면 유효성검증을 끝내고 내려와야하기 때문에 다시 반복할 필요가 없고 맨위로 다시 가면 되는 부분이었다!
                // 이렇게하니까 y/n을 외에 입력값이 들어가면 처음으로 돌아가서 다시 do while문을 써서 스위치문 안에서 할당해줌으로 해결하였다.
            } else {
                System.out.println("[안내] 정확한 인원수를 입력하여 주세요.");
                boolean1 = -2;
            }
        }
        while (!(boolean1 == -1));
        return visitorList;
    }

    public static Double input(String str) {
        String input1 = "";
        String input2 = "";
        double inputNuma = 0;
        do {
            System.out.println(str);
            input1 = Input.input();

            if (Validation.isValid(input1)) {
                inputNuma = Double.parseDouble(input1);
            } else {
                System.out.println("[안내]숫자로 입력하여 주세요.");
            }
        }
        while (!Validation.isValid(input1));
        return inputNuma;
//        아래메서드 실행하면 트루 펄스값을 반환 숫자가 맞다면 false를 아니라면 true를 반환

    }

    //추가가능하도록 입력받은 어레이리스트에서 인덱스와 벨류(가격)값을 가져온 후 해시맵으로 만들면서 해당하는 키에 벨류값을 예측값 (a * price ) + b 으로 넣어준다
    public static HashMap<Integer, Double> priceInputMap(double inputA, double inputB, ArrayList<Double> priceArrayList) {
        HashMap<Integer, Double> priceMap1 = new HashMap<>();
        Iterator<Double> iterator = priceArrayList.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            Double value = iterator.next();
            priceMap1.put(index, (inputA * value) + inputB);
            index++;
        }
        return priceMap1;
    }

    public static HashMap<Integer, Double> visitorInputMap(ArrayList<Double> visitorInput) {
        HashMap<Integer, Double> visitorInputMap = new HashMap<>();
        Iterator<Double> iterator = visitorInput.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            Double value = iterator.next();
            visitorInputMap.put(index, value);
            index++;
        }
        return visitorInputMap;
    }


    public static void printPriceInputMap(HashMap<Integer, Double> priceMap) {
        System.out.println("\n[안내] AI의 '웹 페이지 방문자' 예측 결과는 다음과 같습니다.");
        for (int i = 0; i < priceMap.size(); i++) {
            System.out.printf(i + 1 + "번째 예측 " + "%.1f회 방문\n", priceMap.get(i));
        }
    }


    public static void printPriceList(ArrayList<Double> priceList) {
        Iterator<Double> iterator = priceList.iterator();
        System.out.println("[안내] 입력된 광고비 목록:");
        int index = 0;
        while (iterator.hasNext()) {
            System.out.printf("%d번 %.1f원 ", index++ + 1, iterator.next());
        }
    }

    public static void printVisitorList(ArrayList<Double> priceList) {
        Iterator<Double> iterator = priceList.iterator();
        System.out.println("[안내] 입력된 실제 방문자 수 목록:");
        int index = 0;
        while (iterator.hasNext()) {
            System.out.printf("%d번째 실제 방문자 수 %.1f명 \n", index++ + 1, iterator.next());
        }
    }

    public static void dataPrint(HashMap<Integer, Double> priceInputMap, HashMap<Integer, Double> visitorInputMap) {

        System.out.println("[안내] 인공지능 프로그램에 할당된 데이터");
        for(int i =0; i < priceInputMap.size(); i++){
            System.out.printf("%d번 째 데이터) [실제값] 웹 페이지 방문자 수 : %.1f [인공지능 예측값] 웹 페이지 방문자 수 : %.1f\n\n",i+1,priceInputMap.get(i),visitorInputMap.get(i)) ;
        }

    }

    public static void totalDataPrint(double result){
        System.out.printf("[안내]인공지능 프로그램의 성능(오차의 제곱 합) : %.1f" , result);
    }
    public static Double errorMeasure(HashMap<Integer, Double> priceInputMap, HashMap<Integer, Double> visitorInputMap){
        double result = 0;
        for(int i = 0; i < priceInputMap.size(); i++){
            double errorNum = (priceInputMap.get(i)-visitorInputMap.get(i));
            double resultErrorNum = (errorNum * errorNum);
            System.out.printf("[%d 번째 데이터] 실제 값과 예측값의 오차 : -%.1f \n[안내] 오차의 제곱 : %.1f\n\n",i+1, errorNum, resultErrorNum );
            result += resultErrorNum;
        }
        return result;
    }

}