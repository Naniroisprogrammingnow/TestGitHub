import java.util.Scanner;
public class crossword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        int[] indCommon = findCommon(a,b);
        if(indCommon[0]!=-1 && indCommon[1]!=-1){
            int aInd = indCommon[0];
            int bInd = indCommon[1];
            for (int i = 0; i < a.length(); i++) {
                for (int j = 0; j < b.length(); j++) {
                    if (j == bInd){
                        System.out.print(a.charAt(i));
                        if(i==aInd){
                            System.out.print(b.substring(bInd+1));
                            break;
                        }
                    }else{
                        if (i==aInd){
                            System.out.print(b.charAt(j));
                        }else {
                            System.out.print(" ");
                        }
                    }

                }
                System.out.println();
            }
        }else {
            System.out.println("Нема такова");
        }
    }

    private static int[] findCommon(String a, String b) {
        int[] res = new int[] {-1,-1};
        for (int i = 0; i < a.length(); i++) {
            String curr = "";
            curr += a.charAt(i);
             if(b.contains(curr)){
                    res[0]=i;
                    res[1]=b.indexOf(curr);
                    return res;
                }

        }
        return res;
    }
}
