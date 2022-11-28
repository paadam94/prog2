package kutatóintézet;

import patogenetika.Kórokozó;

import java.util.Comparator;

public class BetegsegComparator implements Comparator<Kórokozó> {

    @Override
    public int compare(Kórokozó o1, Kórokozó o2) {
        if(o1.getType() != o2.getType()) return Character.compare(o1.getType(), o2.getType());
        return o1.getName().compareTo(o2.getName());
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
