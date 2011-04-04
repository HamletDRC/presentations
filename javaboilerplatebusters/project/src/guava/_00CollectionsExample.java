package guava;

import com.google.common.collect.*;

import java.util.Collection;

/**
 * @author Hamlet D'Arcy
 */
public class _00CollectionsExample {

    public static void main(String[] args) {
        // multimap
        Multimap<String, String> multiMap = HashMultimap.create();
        multiMap.put("Canoo", "Hamlet");
        multiMap.put("Canoo", "Dierk");
        multiMap.put("Canoo", "Andres");
        multiMap.put("EngineYard", "Charles");
        multiMap.put("EngineYard", "Thomas");
        multiMap.put("EngineYard", "Nick");

        assert multiMap.containsKey("Canoo");
        assert multiMap.containsKey("EngineYard");
        assert multiMap.containsValue("Hamlet");
        assert multiMap.containsValue("Charles");

        Collection<String> canooies =
                multiMap.get("Canoo");
        Collection<String> c =
                Lists.newArrayList("Dierk", "Andres", "Hamlet");
        assert canooies.containsAll(c);


        // BiMap is a bidirectional map (1 to 1 relationship)
        BiMap<String, String> biMap = HashBiMap.create();
        biMap.put("Switzerland", "die Schweiz");
        biMap.put("Poland", "Polska");
        biMap.put("Austria", "Österreich");

        assert "Polska" == biMap.get("Poland");
        assert "Switzerland" == biMap.inverse().get("die Schweiz");


        // tables replace Map<T1, Map<T2, T3>> or some other convolution
        Table<Integer, Integer, String> table = HashBasedTable.create();
        table.put(1, 1, "Hamlet");
        table.put(1, 2, "Dierk");
        table.put(2, 1, "Andres");
        table.put(2, 2, "Matthius");

        assert table.contains(1, 1);
        assert table.containsRow(1);
        assert table.containsColumn(2);

        assert !table.contains(3, 1);
        assert !table.containsRow(3);
        assert !table.containsColumn(3);

        assert "Hamlet" == table.get(1, 1);
        assert table.containsValue("Hamlet");

    }
}
