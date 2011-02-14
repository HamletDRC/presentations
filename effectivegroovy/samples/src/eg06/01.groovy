package eg06;

public class CollectionClassifier {
    public static String classify(Set s) { return "Set"; }
    public static String classify(List l) { return "List"; }
    public static String classify(Collection c) { return "Collection"; }

    public static void main(String[] args) {
        List<Collection> collections = Arrays.asList(
                new HashSet(),
                new ArrayList(),
                new HashMap().values()
        );

        for (Collection c : collections) {
            System.out.println(classify(c));
        }
    }
}