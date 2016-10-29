package oktmo;

import java.util.Comparator;

/**
 * Created by designAi on 20.10.2016.
 */
public class SortedByName implements Comparator<Place> {
    @Override
    public int compare(Place o1, Place o2) {
        String name1 = o1.getName();
        String name2 = o2.getName();

        return name1.compareTo(name2);
    }
}
