import java.util.ArrayList;
import java.util.List;

/**
 * Created by rashid on 5/4/16.
 */
public class Ski {
    private List<Integer> routeMap;

    public Ski(List<Integer> routeMap) {
        this.routeMap = new ArrayList<>(routeMap);
    }

    public List<Integer> getPath() {
        Integer startElevation = routeMap.get(0);
        routeMap.remove(0);

        List<Integer> path = new ArrayList<>();
        path.add(startElevation);

        for (Integer currentElevation : routeMap) {
            if(currentElevation < startElevation) {
                path.add(currentElevation);
                startElevation = currentElevation;
            } else {
                break;
            }
        }

        return path;
    }
}
