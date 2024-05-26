package V2;

public class Validation {

    //    전 수정버전에서는 빈문자열이 들어왔을 때 검증을 못하는 오류를 발견했기 때문에 빈문자열을 검증해주는 구문을 추가해줬다.
    public static boolean isValid(String input) {
        String table = "0123456789";
        boolean isValid = false;

        if (input.isEmpty()) {
            return false;
        }
        for (char c : input.toCharArray()) {
            if (table.indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }
}

