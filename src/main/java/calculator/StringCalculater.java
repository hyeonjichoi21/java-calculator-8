package calculator;

public class StringCalculater {

    public static int add(String input){

        // 빈값 "" 이면 return 0;
        if (input == null || input.isEmpty()) return 0;

        // 첫문자가 숫자로 시작하는지?
        char firstWord = input.charAt(0);
        if(Character.isDigit(firstWord)) return addBasicDelimiter(input);
        // 첫문자가 문자(//)로 시작하는지?
        else if(input.startsWith("//")) return addCustomDelimiter(input);
        else throw new IllegalArgumentException("잘못된 입력값입니다.");
    }

    private static int addBasicDelimiter(String input){
        return 0;
    }

    private static int addCustomDelimiter(String input){
        return 0;
    }

}
