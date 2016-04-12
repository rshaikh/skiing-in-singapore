import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by rashid on 5/4/16.
 */
public class SkiTest {

    @Test
    public void itShouldGivePathWhenThereIsOnlyOneBlockAvailable() throws Exception {
        List<Integer> routeMap = asList(4);
        Ski ski = new Ski(routeMap);

        List<Integer> path = ski.getPath();

        assertThat(path.size(), is(1));
        assertThat(path, is(asList(4)));
    }


    @Test
    public void itShouldSkyInDownhillDirectionOnly() throws Exception {
        List<Integer> routeMap = asList(4, 3);
        Ski ski = new Ski(routeMap);
        List<Integer> path = ski.getPath();

        assertThat(path.size(), is(2));
        assertThat(path, is(asList(4, 3)));
    }

    @Test
    public void itShouldNotSkyInUphillDirection() throws Exception {
        List<Integer> routeMap = asList(4, 5);
        Ski ski = new Ski(routeMap);
        List<Integer> path = ski.getPath();

        assertThat(path.size(), is(1));
        assertThat(path, is(asList(4)));
    }

    @Test
    public void itShouldStopSkiingWhenHigherElevationIsFound() throws Exception {
        List<Integer> routeMap = asList(4, 3, 5, 1);
        Ski ski = new Ski(routeMap);
        List<Integer> path = ski.getPath();

        assertThat(path.size(), is(2));
        assertThat(path, is(asList(4, 3)));
    }

    @Test
    public void itShouldSkyForTheLongestPathDistance() throws Exception {
        List<Integer> routeMap = asList(4, 3, 5, 4, 1);
        Ski ski = new Ski(routeMap);
        List<Integer> path = ski.getPath();

        assertThat(path.size(), is(3));
        assertThat(path, is(asList(5, 4, 1)));
    }
}
