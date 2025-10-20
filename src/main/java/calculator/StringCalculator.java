package calculator;

import calculator.calculation.CalculationEngine;
import calculator.splitter.DelimiterSplitter;

public class StringCalculator {

    public static int add(String input){

        // 빈값 "" 이면 return 0;
        if (input == null || input.isEmpty()) return 0;

        char firstWord = input.charAt(0);

        // 첫문자가 숫자로 시작하는지?
        if(Character.isDigit(firstWord)) return CalculationEngine.addNumbers(DelimiterSplitter.splitByBasic(input));
        // 첫문자가 문자(//)로 시작하는지?
        else if(input.startsWith("//")) return CalculationEngine.addNumbers(DelimiterSplitter.splitByCustom(input));
        else throw new IllegalArgumentException("잘못된 형식의 입력값입니다." + input);
    }

}
