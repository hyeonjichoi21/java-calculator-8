package calculator.calculation;

public class CalculationEngine {
    public static int addNumbers(String[] integers){
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
