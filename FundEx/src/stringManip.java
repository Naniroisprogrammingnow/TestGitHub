import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class stringManip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        String str = "";
        String input = scanner.nextLine();
        while (!input.equals("End")){
            String [] tokens = input.split(" ");
            switch (tokens[0]){
                case "Add":
                    str = str+tokens[1];
                    break;
                case "Upgrade":
                    int ch = tokens[1].charAt(0) +1;
                    char newCh = (char) ch;
                    str = str.replace(tokens[1].charAt(0), newCh);
                    break;
                case "Print":
                    System.out.println(str);
                    break;
                case "Index":
                    char chInd = tokens[1].charAt(0);
                    List<Integer> indexes = new ArrayList<>();
                    for (int i = 0; i < str.length(); i++) {
                        if(chInd==str.charAt(i)){
                            indexes.add(i);
                        }
                    }
                    if (indexes.size()==0){
                        System.out.println("None");
                    }else{
                        for (Integer index : indexes) {
                            System.out.print(index + " ");
                        }
                        System.out.println();
                    }
                    break;
                case "Remove":
                    str = str.replace(tokens[1], "");
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
