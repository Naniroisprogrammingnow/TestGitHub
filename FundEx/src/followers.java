import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;

public class followers {
    public static void main(String [] args){
        Scanner scanner = new Scanner (System.in);

        Map<String, Integer> followerLikes = new LinkedHashMap<>();
        Map<String, Integer> followerComment = new LinkedHashMap<>();
        String command = scanner.nextLine();
        while (!command.equals("Log out")){
            String [] tokens = command.split(": ");
            String username = tokens[1];
            switch (tokens[0]){
                case "New follower":
                    followerLikes.putIfAbsent(username, 0);
                    followerComment.putIfAbsent(username, 0);
                    break;
                case "Like":
                    int count = Integer.parseInt(tokens[2]);
                    followerLikes.putIfAbsent(username, 0);
                    followerLikes.put(username, followerLikes.get(username)+count);
                    followerComment.putIfAbsent(username, 0);
                    break;
                case "Comment":
                   followerComment.putIfAbsent(username, 0);
                   followerComment.put(username, followerComment.get(username)+1);
                   followerLikes.putIfAbsent(username, 0);
                    break;
                case "Blocked":
                    if(followerLikes.containsKey(username) || followerComment.containsKey(username)){
                        followerLikes.remove(username);
                        followerComment.remove(username);
                    }else{
                        System.out.printf("%s doesn't exist.%n", username);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        int countFollow = Math.max(followerLikes.size(), followerComment.size());
        System.out.printf("%d followers%n", countFollow);
        followerLikes.entrySet().stream().sorted((a,b)-> {
            int res = b.getValue().compareTo(a.getValue());
            if(res == 0){
                res = a.getKey().compareTo(b.getKey());
            }
            return res;
        }).forEach(e->{
            System.out.printf("%s: %d%n", e.getKey(), (e.getValue()+followerComment.get(e.getKey())));
        });

    }
}
