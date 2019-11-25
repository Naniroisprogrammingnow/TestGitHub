import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class concert2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> bandMembers = new LinkedHashMap<>();
        Map<String, Integer> bandTime = new LinkedHashMap<>();
        String command = scanner.nextLine();
        while (!command.equals("start of concert")) {
            String[] tokens = command.split(";\\s*");
            String name = tokens[1];
            switch (tokens[0]) {
                case "Play":
                    int time = Integer.parseInt(tokens[2]);
                    bandTime.putIfAbsent(name, 0);
                    bandTime.put(name, bandTime.get(name) + time);
                    bandMembers.putIfAbsent(name, new ArrayList<>());
                    break;
                case "Add":
                    String[] members = tokens[2].split(",\\s*");
                    bandMembers.putIfAbsent(name, new ArrayList<>());
                    for (int i = 0; i < members.length; i++) {
                        if (!bandMembers.get(name).contains(members[i])) {
                            bandMembers.get(name).add(members[i]);
                        }
                    }
                    bandTime.putIfAbsent(name, 0);

                    break;
            }

            command = scanner.nextLine();
        }
        long totalTime = 0;
        for (Map.Entry<String, Integer> entry : bandTime.entrySet()) {
            totalTime += entry.getValue();
        }
        System.out.printf("Total time: %d%n", totalTime);
        List<String> bestBand = new ArrayList<>();
        int bestTime = 0;
        bandTime.entrySet().stream().sorted((a, b) -> {
            int res = b.getValue().compareTo(a.getValue());
            if (res == 0) {
                res = a.getKey().compareTo(b.getKey());
            }
            return res;
        }).forEach(e -> {
            if (e.getValue() > bestTime) {
                bestBand.add(e.getKey());
            }
            System.out.printf("%s -> %d%n", e.getKey(), e.getValue());
        });
        System.out.println(bestBand.get(0));
        for (String s : bandMembers.get(bestBand.get(0))) {
            System.out.printf("=> %s%n", s);
        }
    }
}
