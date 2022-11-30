import java.util.Scanner;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

class Main {

    public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	LinkedList<LegoSet> list = new LinkedList<>();
	long n = sc.nextInt();
	sc.nextLine();
	sc.useDelimiter(";|\n");
	for(int i = 0; i < n; ++i) {
	    long number = Integer.valueOf(sc.next());
	    String name = sc.next();
	    String theme = sc.next();
	    long pieces = Integer.valueOf(sc.next());
	    LegoSet set = new LegoSet(number, name, theme, pieces);
	    list.add(set);
	    sc.nextLine();
	}
	// sort 1
	Collections.sort(list, new PiecesDecThemeIncNameIncNumberIncLegoSetComparator42069());
	for(LegoSet set: list) {
	    System.out.println(set);
	}
	System.out.println();

	// sort 2
	Collections.sort(list, new Comparator2());
	for(LegoSet set: list) {
	    System.out.println(set);
	}
    }
}

class LegoSet {

    final long number;
    final String name;
    final String theme;
    final long pieces;

    public LegoSet(long number, String name,
		   String theme, long pieces) {
	this.number = number;
	this.name = name;
	this.theme = theme;
	this.pieces = pieces;
    }
    
    @Override
    public String toString() {
	return String.format("%s (%d): %d - %s",
			     this.name,
			     this.number,
			     this.pieces,
			     this.theme);
    }

}

/*
  1. pieces d; theme u; name u; number u
*/
class PiecesDecThemeIncNameIncNumberIncLegoSetComparator42069 implements Comparator<LegoSet> {
    @Override
    public int compare(LegoSet set1, LegoSet set2) {
	if (set1.pieces != set2.pieces)
	    return -Long.compare(set1.pieces, set2.pieces);
	else if (!Objects.equals(set1.theme, set2.theme))
	    return set1.theme.compareTo(set2.theme);
	else if (!Objects.equals(set1.name, set2.name))
	    return set1.name.compareTo(set2.name);
	else
	    return Long.compare(set1.number, set2.number);
    }
}

/*
  2. theme u; name u; number u;
*/
class Comparator2 implements Comparator<LegoSet> {
    @Override
    public int compare(LegoSet set1, LegoSet set2) {
	if (!Objects.equals(set1.theme, set2.theme))
	    return set1.theme.compareTo(set2.theme);
	else if (!Objects.equals(set1.name, set2.name))
	    return set1.name.compareTo(set2.name);
	else
	    return Long.compare(set1.number, set2.number);
    }
}
