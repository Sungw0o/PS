import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {

            HashMap<String, Integer> playlist = new HashMap<>();
            HashMap<String, ArrayList<int[]>> songsByGenre = new HashMap<>();

            for (int i = 0; i < genres.length; i++) {
                playlist.put(genres[i], playlist.getOrDefault(genres[i], 0) + plays[i]);

                songsByGenre.putIfAbsent(genres[i], new ArrayList<>());
                songsByGenre.get(genres[i]).add(new int[]{plays[i], i});
            }

            List<String> genreList = new ArrayList<>(playlist.keySet());
            genreList.sort((a, b) -> playlist.get(b) - playlist.get(a));

            ArrayList<Integer> answerList = new ArrayList<>();

            for (String genre : genreList) {
                ArrayList<int[]> songs = songsByGenre.get(genre);

                songs.sort((a, b) -> {
                    if (b[0] == a[0]) {
                        return a[1] - b[1];
                    } else {
                        return b[0] - a[0];
                    }
                });


                answerList.add(songs.get(0)[1]);
                if (songs.size() > 1) {
                    answerList.add(songs.get(1)[1]);
                }
            }

            int[] answer = new int[answerList.size()];
            for (int i = 0; i < answerList.size(); i++) {
                answer[i] = answerList.get(i);
            }

            return answer;
        }
}