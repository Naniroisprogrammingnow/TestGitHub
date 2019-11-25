import java.util.Scanner;

public class string {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        String input = scanner.nextLine();
        String command = scanner.nextLine();
        while (!command.equals("Done")){
            String[] token = command. split(" ");
            switch (token[0]){
                case "Change":
                    input = input.replace(token[1].charAt(0), token[2].charAt(0));
                    System.out.println(input);
                    break;
                case "Includes":
                    if(input.contains(token[1])){
                        System.out.println("True");
                    }else{
                        System.out.println("False");
                    }
                    break;
                case "End":

                    if(input.endsWith(token[1])){
                        System.out.println("True");
                    }else{
                        System.out.println("False");
                    }
                    break;
                case "Uppercase":
                    input = input.toUpperCase();
                    System.out.println(input);
                    break;
                case "FindIndex":
                    int ind = input.indexOf(token[1]);
                    System.out.println(ind);
                    break;
                case "Cut":
                    int start = Integer.parseInt(token[1]);
                    int count = Integer.parseInt(token[2]);
                    input = input.substring(start, start+count);
                    System.out.println(input);
                    break;
            }
            command= scanner.nextLine();
        }
    }
}
