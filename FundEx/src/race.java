import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        Pattern pattern = Pattern.compile("([#$%&*])([A-Za-z]+)\\1=([\\d]+)!!(.+)");
        String input = scanner.nextLine();
        boolean found = false;
        while (!found){
            Matcher matcher = pattern.matcher(input);
            if(matcher.find()){
                String name = matcher.group(2);
                int len = Integer.parseInt(matcher.group(3));
                String code = matcher.group(4);
                if(code.length()==len){
                    code = decode(code, len);
                    System.out.printf("Coordinates found! %s -> %s%n", name, code);
                    found = true;
                }
            }
            if(!found){
                System.out.println("Nothing found!");
                input= scanner.nextLine();
            }
        }
    }

    private static String decode(String code, int len) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < code.length(); i++) {
            char ch = code.charAt(i);
            ch = (char) (ch+len);
            res.append(ch);
        }
        return res.toString();
    }
}
