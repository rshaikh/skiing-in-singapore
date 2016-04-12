import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by rashid on 5/4/16.
 */
public class Ski {
    private List<Integer> routeMap;

    public Ski(List<Integer> routeMap) {
        this.routeMap = new ArrayList<>(routeMap);
    }

    public List<Integer> getPath() {
        return IntStream
                .range(0, routeMap.size())
                .mapToObj(this::findPathStartingFrom)
                .sorted(this::withPathLengthAndSteep)
                .findFirst().get();
    }

    private List<Integer> findPathStartingFrom(int startIndex) {
        Integer startElevation = routeMap.get(startIndex);

        List<Integer> path = new ArrayList<>();
        path.add(startElevation);

        for (int index = startIndex + 1; index < routeMap.size(); index++) {
            Integer currentElevation = routeMap.get(index);
            if (currentElevation < startElevation) {
                path.add(currentElevation);
                startElevation = currentElevation;
            } else {
                break;
            }
        }

        return path;
    }

    private int withPathLengthAndSteep(List<Integer> pathOne, List<Integer> pathTwo) {
        if (pathOne.size() == pathTwo.size()) {
            if (steepOf(pathOne) > steepOf(pathTwo)) {
                return -1;
            } else {
                return 1;
            }
        }
        return pathOne.size() > pathTwo.size() ? -1 : 1;
    }

    private int steepOf(List<Integer> path) {
        return getFirstElement(path) - getLastElement(path);
    }

    private Integer getLastElement(List<Integer> path) {
        return path.get(path.size() - 1);
    }

    private Integer getFirstElement(List<Integer> path) {
        return path.get(0);
    }
}
