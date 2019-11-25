import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class emojis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        String text = scanner.nextLine();
        Pattern pattern = Pattern.compile("([\\s|^])(?<emoji>:[a-z]{4,}:)(?=[\\s,.!?])");
        Matcher matcher = pattern.matcher(text);
        List <String> emojis = new ArrayList<>();
        while (matcher.find()){
            emojis.add(matcher.group("emoji"));
        }
        int [] ints = Arrays.stream(scanner.nextLine().split(":")).mapToInt(e ->Integer.parseInt(e)).toArray();
        StringBuilder emojiSpecial = new StringBuilder();

        for (int i = 0; i < ints.length; i++) {
            char ch = (char)ints[i];
            emojiSpecial.append(ch);
        }
        String special = ":"+emojiSpecial.toString()+":";
        int totalPower = 0;
        for (String s : emojis) {
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i)==':'){
                    continue;
                }
                totalPower+=s.charAt(i);
            }
        }
        for (String emoji : emojis) {
            if(emoji.equals(special)){
                totalPower*=2;
            }
        }
        if(emojis.size()!=0){
            System.out.print("Emojis found: ");
            System.out.println(String.join(", ", emojis));
        }
        System.out.println("Total Emoji Power: " + totalPower);
    }

}
