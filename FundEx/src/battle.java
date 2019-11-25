import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
public class battle{
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        Map<String, Integer> health = new LinkedHashMap<>();
        Map<String, Integer> energy = new LinkedHashMap<>();
        String command = scanner.nextLine();
        while(!command.equals("Results")){
            String[] tokens = command.split(":");
            switch (tokens[0]){
                case "Add":
                    int healthCurr = Integer.parseInt(tokens[2]);
                    int energyCurr = Integer.parseInt(tokens[3]);
                    health.putIfAbsent(tokens[1], 0);
                    health.put(tokens[1], health.get(tokens[1])+healthCurr);
                    energy.putIfAbsent(tokens[1], energyCurr);
                    break;
                case "Attack":
                    String attacker = tokens[1];
                    String defender = tokens[2];
                    int damage = Integer.parseInt(tokens[3]);
                    if(health.containsKey(attacker) && health.containsKey(defender) &&
                            energy.containsKey(attacker) && energy.containsKey(defender)){
                        health.put(defender, health.get(defender)-damage);
                        if(health.get(defender)<=0){
                            health.remove(defender);
                            energy.remove(defender);
                            System.out.println(defender + " was disqualified!");
                        }
                        energy.put(attacker, energy.get(attacker)-1);
                        if(energy.get(attacker)<=0){
                            energy.remove(attacker);
                            health.remove(attacker);
                            System.out.println(attacker + " was disqualified!");
                        }
                    }
                    break;
                case "Delete":
                    if(tokens[1].equals("All")){
                        health.clear();
                        energy.clear();
                    }else{
                        energy.remove(tokens[1]);
                        health.remove(tokens[1]);
                    }

                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println("People count: " + health.size());
        health.entrySet().stream().sorted((a,b)-> {
            int res = b.getValue().compareTo(a.getValue());
            if(res==0){
                res = a.getKey().compareTo(b.getKey());
            }
            return res;
        }).forEach(e->{
            System.out.printf("%s - %d - %d%n", e.getKey(), e.getValue(), energy.get(e.getKey()));
        });
    }
}
