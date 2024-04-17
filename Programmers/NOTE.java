import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class NOTE {
    public static void main(String[] args) {
        ArrayList<Integer> answer = new ArrayList<>();
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        HashMap<String, Integer> num = new HashMap<>();
        HashMap<String, HashMap<Integer, Integer>> music = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            if (!num.containsKey(genres[i])) {
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                music.put(genres[i], map);
                num.put(genres[i], plays[i]);
            } else {
                num.put(genres[i], num.get(genres[i]) + plays[i]);
                music.get(genres[i]).put(i, plays[i]);
            }
        }

        ArrayList<String> keySet = new ArrayList(num.keySet());
        Collections.sort(keySet, new Comparator<>() {
            public int compare(String o1, String o2) {
                return num.get(o2) - num.get(o1);
            }
        });

        for (String key : keySet) {
            HashMap<Integer, Integer> map = music.get(key);
            ArrayList<Integer> al = new ArrayList(map.keySet());
            Collections.sort(al, (s1, s2) -> map.get(s2) - map.get(s1));

            answer.add(al.get(0));
            if (al.size() > 1) {
                answer.add(al.get(1));
            }
        }

        System.out.println(answer);
    }
}