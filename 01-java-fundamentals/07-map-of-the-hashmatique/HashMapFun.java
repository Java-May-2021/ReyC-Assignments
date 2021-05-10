import java.util.HashMap;
import java.util.Set;

public class HashMapFun {
    public void saveTracks() {
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("Sugar Crush", "I am on a sugar crush");
        trackList.put("Wake Up", "With every waking breath until you decide to wake up");
        trackList.put("Used To Being Someone you Loved", "I'm getting kinda used to being someone you loved.");
        trackList.put("Somebody That I Used To Know", "Now you're just somebody that I used to know");

        Set<String> trackKeys = trackList.keySet();

        String oneSong = trackList.get("Sugar Crush");
        System.out.println(oneSong);
        
        for(String key : trackKeys) {
            System.out.println(key + " : " + trackList.get(key));
        }
    }
}