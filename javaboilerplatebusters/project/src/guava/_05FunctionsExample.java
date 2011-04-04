package guava;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import static com.google.common.collect.Lists.*;

import java.util.Collection;
import java.util.List;


class _05FunctionsExample {
    public static void main(String[] args) {
        Person alice = new Person("Alice");
        Person bob = new Person("Bob");
        Person carol = new Person("Carol");
        List<Person> people = newArrayList(alice, bob, carol);


        Function<Person, String> getName = new Function<Person, String>() {
            public String apply(Person p) {
                return p.getName();
            }
        };

        assert "Alice" == getName.apply(alice);
        Collection<String> names = Collections2.transform(people, getName);
        assert names.containsAll(newArrayList("Alice", "Bob", "Carol"));


        Predicate<Person> predicate = new Predicate<Person>() {
            public boolean apply(Person input) {
                return input.getName().contains("o");
            }
        };

        Iterable<Person> filteredList = Iterables.filter(people, predicate);
        assert Iterables.contains(filteredList, bob);
        assert Iterables.contains(filteredList, carol);
        assert !Iterables.contains(filteredList, alice);

    }
}



/*
assertTrue(isCustomerWithOddId.apply(bob));
assertFalse(isCustomerWithOddId.apply(lisa));



ImmutableSet<Customer> customers = ImmutableSet.of(bob, lisa, stephen);

Predicate<Customer> itsBob = Predicates.equalTo(bob);
Predicate<Customer> itsLisa = Predicates.equalTo(lisa);
Predicate<Customer> bobOrLisa = Predicates.or(itsBob, itsLisa);

// Predicates are great to pass in to higher-order functions like filter/search
Iterable<Customer> filtered = Iterables.filter(customers, bobOrLisa);
assertEquals(2, ImmutableSet.copyOf(filtered).size());


// collections
ImmutableSet<Customer> customers1 = ImmutableSet.of(bob, lisa, stephen);
ImmutableSet<Customer> customers2 = ImmutableSet.of(stephen, ken);
assertEquals(4, Sets.union(customers1, customers2).size());
assertEquals(ImmutableSet.of(stephen), Sets.intersection(customers1, customers2));


*/
