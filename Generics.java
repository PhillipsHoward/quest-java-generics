import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Generics {
    interface Predicate<T> {
        boolean filter(T obj);
    }

    interface Mapper<T, U> {
        U map(T obj);
    }

    /**
     * Java entry point
     */
    public static void main(String... args) {
        new Generics();
    }

    /**
     * Class Constructor
     */
    private Generics() {
        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> strs = Arrays.asList("tout", "titi", "ototo", "jean", "tous", "taratata");

        ints = filter(ints, new Predicate<Integer>() {
            @Override
            public boolean filter(Integer i) {
                if (i%2 == 0) {
                    return true;
                }
                return false;
            }
        });
        // DONE - Multiplier par 2 chaque élément de la liste.
        ints = map(ints, new Mapper<Integer, Integer>() {
            @Override
            public Integer map(Integer i) {
                return i*2;
            }
        });
        for (Integer i : ints) System.out.println(i);

        // DONE - Ne retourner que les Strings contenant au moins 2 lettres t.
        strs = filter(strs, new Predicate<String>() {
            @Override
            public boolean filter(String str) {

                int lengthStr = str.length();
                String newStr = str.replace("t", "");

                if (lengthStr-newStr.length() > 1) {
                    return true;
                }
                return false;
            }
        });

        // DONE - Passer en majuscule toutes les Strings
        strs = map(strs, new Mapper<String, String>() {
            @Override
            public String map(String i) {
                return i.toUpperCase();
            }
        });
        for (Integer i : ints) System.out.println(i);
        for (String s : strs) System.out.println(s);
    }

    /**
     * Returns a list consisting of the elements of a collection that match the given predicate.
     *
     * @param c   Collection<T>: The input collection
     * @param p   The predicate
     * @param <T> Type of the element in the collection
     * @return A list that match the given filter.
     */
    private <T> List<T> filter(Collection<T> c, Predicate<T> p) {
        List<T> result = new ArrayList<>();

        for (T t : c) {
            if (p.filter(t)) {
                result.add(t);
            }
        }
        return result;
    }

    /**
     * Returns a list consisting of the results of applying the given function to the elements of the collection.
     *
     * @param c   Collection<T>: The input collection
     * @param m   The predicate
     * @param <T> Type of the element in the collection
     * @param <U> Type of the element in the returned list
     * @return A list that match the given mapper.
     */
    private <T, U> List<U> map(Collection<T> c, Mapper<T, U> m) {
        List<U> result = new ArrayList<>();

        for (T i : c) {
            result.add(m.map(i));
        }
        return result;
    }
}
