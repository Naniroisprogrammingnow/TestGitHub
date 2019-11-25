import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class activationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        String [] keys = scanner.nextLine().split("&");
        List<String> validKeys = new ArrayList<>();
        for (int i = 0; i < keys.length; i++) {
            String curr = keys[i];
            Pattern pattern = Pattern.compile("^[A-Za-z\\d]+");
            Matcher matcher = pattern.matcher(curr);
            List<String> res = new ArrayList<>();
            String finaRes = "";
            while (matcher.find()){
                if(matcher.group().length()==16){
                    for (int j = 0; j < curr.length(); j+=4) {
                        res.add(curr.substring(j, j+4));
                    }
                }else if (matcher.group().length() == 25){
                    for (int j = 0; j < curr.length(); j+=5) {
                        res.add(curr.substring(j, j+5));
                    }

                }
                finaRes = String.join("-", res);
                finaRes = replaceNums(finaRes);
                if(!finaRes.equals("")){
                    validKeys.add(finaRes.toUpperCase());
                }
            }
        }
        System.out.println(String.join(", ", validKeys));
    }

    private static String replaceNums(String finaRes) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < finaRes.length(); i++) {
            char ch = finaRes.charAt(i);
            if(Character.isDigit(finaRes.charAt(i))){
                int digit = 9 - Integer.parseInt(finaRes.substring(i, i+1));
                res.append(String.valueOf(digit));
            }else{
                res.append(ch);
            }
        }
        return res.toString();
    }
}
