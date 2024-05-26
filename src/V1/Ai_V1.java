package V1;

public class Ai_V1 {




    public void v1Message(){
        System.out.println("[안공지능 프로그램 V1]");
        System.out.println("=".repeat(25));
    }

    public void startAiV1(){
        System.out.println("[System]예측에 영향을 주는 원인(광고비)의 값을 알려주세요 (단위 원) : ");
    }

    public int aiPrediction(int a , int b , int price){
        return (a * price ) + b;
    }
}
