package calculator;
import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static void main(String[] args) {
        // 입력 안내
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        // TODO: 프로그램 구현
        int answer = StringCalculator.add(input);

        // 결과 출력
        System.out.println("결과 : "+ answer);

    }
}
