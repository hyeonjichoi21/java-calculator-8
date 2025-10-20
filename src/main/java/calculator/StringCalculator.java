package calculator;

public class StringCalculator {

    public static int add(String input){

        // 빈값 "" 이면 return 0;
        if (input == null || input.isEmpty()) return 0;

        char firstWord = input.charAt(0);

        // 첫문자가 숫자로 시작하는지?
        if(Character.isDigit(firstWord)) return addBasicDelimiter(input);
        // 첫문자가 문자(//)로 시작하는지?
        else if(input.startsWith("//")) return addCustomDelimiter(input);
        else throw new IllegalArgumentException("잘못된 형식의 입력값입니다.");
    }

    // ex) 1,2 / 1,2,3 / 1,2:3
    // ex) str.split("@|#|%");
    // 기본구분자 덧셈
    private static int addBasicDelimiter(String input){
        String[] integers = input.split(",|:");

        int sum = 0;
        for(int i=0; i< integers.length; i++){
            int number = Integer.parseInt(integers[i]);
            
            if(number > 0) sum += number;
            else throw new IllegalArgumentException("피연산자는 양수만 가능합니다.");
        }

        return sum;
    }

    // ex) //;\n1;2;3
    // 커스텀구분자 덧셈
    private static int addCustomDelimiter(String input){
        return 0;
    }

}
