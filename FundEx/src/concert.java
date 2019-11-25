import java.util.*;

public class concert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        Map<String, List<String>> bandMembers = new LinkedHashMap<>();
        Map<String, Integer> bandTime = new LinkedHashMap<>();
        String command = scanner.nextLine();
        while(!command.equals("start of concert")){
            String [] tokens = command.split(";\\s+");
            String name = tokens[1];
            switch (tokens[0]){
                case "Play":
                    int time = Integer.parseInt(tokens[2]);
                    bandTime.putIfAbsent(name, 0);
                    bandTime.put(name, bandTime.get(name)+time);
                    bandMembers.putIfAbsent(name, new ArrayList<>());
                    break;
                case "Add":
                    String [] members = tokens[2].split(",\\s+");
                    bandMembers.putIfAbsent(name, new ArrayList<>());
                    for (int i = 0; i < members.length; i++) {
                        if(!bandMembers.get(name).contains(members[i])){
                            bandMembers.get(name).add(members[i]);
                        }
                    }
                    bandTime.putIfAbsent(name, 0);

                    break;
            }

            command = scanner.nextLine();
        }
        int totalTime = 0;
        for (Map.Entry<String, Integer> entry: bandTime.entrySet()){
            totalTime+= entry.getValue();
        }
        System.out.printf("Total time: %d%n", totalTime);

        bandTime.entrySet().stream().sorted((a,b)->{
            int res = b.getValue().compareTo(a.getValue());
            if(res == 0){
                res = a.getKey().compareTo(b.getKey());
            }
            return res;
        }).forEach(e->{
            System.out.printf("%s -> %d%n", e.getKey(), e.getValue());
        });
        String finalInput = scanner.nextLine();
        System.out.println(finalInput);
        for (String s : bandMembers.get(finalInput)) {
            System.out.printf("=> %s%n", s);
        }

    }
}
