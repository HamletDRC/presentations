@Grab(group='com.google.guava', module='guava', version='r08')
@Grab(group='com.google.guava', module='guava', version='r08', classifier='sources')
import com.google.common.collect.Table
import com.google.common.collect.HashBasedTable
import com.google.common.collect.Multimap
import com.google.common.collect.HashMultimap
import com.google.common.collect.HashBiMap
import com.google.common.collect.BiMap

// http://blog.solidcraft.eu/2010/10/googole-guava-v07-examples.html


// MultiMap replaces Map<T1, Set<T2>>
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

Set<String> canooies = multiMap.get("Canoo");
assert canooies.containsAll(["Dierk", "Andres", "Hamlet"])


// BiMap is a bidirectional map (1 to 1 relationship)
BiMap<String, String> biMap = HashBiMap.create();
biMap.put("Switzerland", "die Schweiz")
biMap.put("Poland", "Polska")
biMap.put("Austria", "Österreich")

assert "Polska" == biMap.get("Poland")
assert "Switzerland" == biMap.inverse().get("die Schweiz")


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

println 'Success'