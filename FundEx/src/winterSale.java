import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class winterSale {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        String[] allInput = scanner.nextLine().split(", ");
        Map<String, Double> prices = new LinkedHashMap<>();
        Map<String, String> DLCs = new LinkedHashMap<>(); //list -> more than one dcl
        for (int i = 0; i < allInput.length; i++) {
            String [] currInput = new String[2];
            if(allInput[i].contains("-")){
                currInput = allInput[i].split("-");
                String name = currInput[0];
                double price = Double.parseDouble(currInput[1]);
                if(isValidName(name)){
                    prices.putIfAbsent(name, price);
                }
            }else{
                currInput = allInput[i].split(":");
                if(prices.containsKey(currInput[0])){
                    DLCs.putIfAbsent(currInput[0], currInput[1]);
                    prices.put(currInput[0], prices.get(currInput[0])*1.2);
                }
            }
        }
        for(Map.Entry<String, Double> price: prices.entrySet()){
            if(DLCs.containsKey(price.getKey())){
                prices.put(price.getKey(), price.getValue()/2);
            }else{
                prices.put(price.getKey(), price.getValue()*0.8);
            }
        }
        prices.entrySet().stream().sorted((a,b) -> a.getValue().compareTo(b.getValue())).forEach(e->{
            if(DLCs.containsKey(e.getKey())){
                System.out.printf("%s - %s - %.2f%n", e.getKey(), DLCs.get(e.getKey()), e.getValue());
            }
        });
        prices.entrySet().stream().sorted((a,b) -> b.getValue().compareTo(a.getValue())).forEach(e->{
            if(!DLCs.containsKey(e.getKey())){
                System.out.printf("%s - %.2f%n", e.getKey(), e.getValue());
            }
        });

    }
    public static boolean isValidName(String name){
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            if(!Character.isLetterOrDigit(ch) && ch!=' '){
                return false;
            }
        }
        return true;
    }
}
