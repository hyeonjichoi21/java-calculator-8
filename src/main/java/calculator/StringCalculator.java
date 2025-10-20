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
        else throw new IllegalArgumentException("잘못된 형식의 입력값입니다." + input);
    }

    // ex) 1,2 / 1,2,3 / 1,2:3
    // ex) str.split("@|#|%");
    // 기본구분자 덧셈
    private static int addBasicDelimiter(String input){
        String[] integers = input.split(",|:");

        int sum = 0;
        for (String integer : integers) {
            // trim()사용해 공백을 허용해준다.
            String cleanIntegers = integer.trim();

            // 피연산자가 비어있을 경우, 예외 처리를 한다.
            if(cleanIntegers.isEmpty()) throw new IllegalArgumentException("빈 피연산자는 허용되지 않습니다.");

            int number;

            try { number = Integer.parseInt(cleanIntegers); }
            // 피연산자 위치에 숫자(양수)외에 문자가 올 경우, 예외 처리를 한다.
            catch (NumberFormatException e) { throw new IllegalArgumentException("피연산자는 숫자(양수)만 입력 가능합니다." + cleanIntegers, e); }

            // 피연산자 양수 X → 예외처리
            if (number > 0) sum += number;
            else throw new IllegalArgumentException("피연산자는 양수만 가능합니다." + number);
        }

        return sum;
    }

    // ex) //;\n1;2;3
    // 커스텀구분자 덧셈
    private static int addCustomDelimiter(String input){

        // 커스텀 구분자 추출
        Character delimiter = input.charAt(2);
        if(delimiter == ',' ||  delimiter == ':') throw new IllegalArgumentException("기본구분자(쉼표 또는 콜론)외에 다른 문자를 사용해 주세요.");

        if(!(input.charAt(3) == '\\' && input.charAt(4) == 'n')) throw new IllegalArgumentException("잘못된 형식의 입력값입니다.");

        // 본문(피연산자 + 연산자) 추출 (trim() → 공백 허용)
        String body = input.substring(5).trim();


        // 커스텀 구분자로 숫자 쪼갬
        String[] integers = body.split(String.valueOf(delimiter));

        int sum = 0;
        for (String integer : integers) {
            // trim()사용해 공백을 허용해준다.
            String cleanIntegers = integer.trim();

            // 피연산자가 비어있을 경우, 예외 처리를 한다.
            if(cleanIntegers.isEmpty()) throw new IllegalArgumentException("빈 피연산자는 허용되지 않습니다.");

            int number;

            try { number = Integer.parseInt(cleanIntegers); }
            // 피연산자 위치에 숫자(양수)외에 문자가 올 경우, 예외 처리를 한다.
            catch (NumberFormatException e) { throw new IllegalArgumentException("피연산자는 숫자(양수)만 입력 가능합니다." + cleanIntegers, e); }

            // 피연산자 양수 X → 예외처리
            if (number > 0) sum += number;
            else throw new IllegalArgumentException("피연산자는 양수만 가능합니다." + number);
        }

        return sum;
    }

}
