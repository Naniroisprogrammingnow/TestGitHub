import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class songIncription {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        Pattern pattern = Pattern.compile("^([A-Z][a-z' ]+):([A-Z ]+)");
        String input = scanner.nextLine();
        while(!input.equals("end")){
            Matcher matcher = pattern.matcher(input);
            if(matcher.find()){
                String name = matcher.group(1);
                String song = matcher.group(2);
                name = encrypt(name, name.length());
                song = encrypt(song, name.length());
                String res = name+"@"+song;
                System.out.printf("Successful encryption: %s%n", res);
            }else{
                System.out.println("Invalid input!");
            }
            input = scanner.nextLine();
        }
    }

    private static String encrypt(String decrypted, int key) {
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < decrypted.length(); i++) {
            char ch = decrypted.charAt(i);
            if(ch!=' ' && ch!= '\'' ){
                if(ch>='a' && ch+key>'z'){
                    ch = (char)('a' + (ch+key-123));
                }else if(ch>='A' && ch<'a' && ch+key>'Z'){
                    ch = (char)('A'+(ch+key-91));
                }else{
                    ch = (char)(ch+key);
                }
            }
            encrypted.append(ch);
        }
        return encrypted.toString();
    }
}
