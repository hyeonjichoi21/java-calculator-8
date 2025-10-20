package calculator.splitter;

public final class DelimiterSplitter {
    private DelimiterSplitter(){}

    // ex) 1,2 / 1,2,3 / 1,2:3
    // ex) str.split("@|#|%");
    // 기본구분자 쪼갬
    public static String[] splitByBasic(String input){
        return input.split(",|:");
    }


    // ex) //;\n1;2;3
    // 커스텀구분자 쪼갬
    public static String[] splitByCustom(String input){
        // 커스텀 구분자 추출
        char delimiter = input.charAt(2);
        if(delimiter == ',' ||  delimiter == ':') throw new IllegalArgumentException("기본구분자(쉼표 또는 콜론)외에 다른 문자를 사용해 주세요.");

        if(!(input.charAt(3) == '\\' && input.charAt(4) == 'n')) throw new IllegalArgumentException("잘못된 형식의 입력값입니다.");

        // 본문(피연산자 + 연산자) 추출 (trim() → 공백 허용)
        String body = input.substring(5).trim();


        return body.split(String.valueOf(delimiter));
    }



}
