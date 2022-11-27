import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

public class Coupon implements Comparable<Coupon> {
    String name;
    String store;
    int discount;

    public Coupon(String name, String store, int discount) {
        this.name = name;
        this.store = store;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "name='" + name + '\'' +
                ", store='" + store + '\'' +
                ", discount=" + discount +
                '}';
    }

    @Override
    public int compareTo(Coupon o) {
        if (this.discount != o.discount) {
            return -Integer.compare(this.discount, o.discount);
        }

        if (!Objects.equals(this.store, o.store)) {
            return this.store.compareTo(o.store);
        }

        return this.name.compareTo(o.name);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Coupon[] coupons = new Coupon[n];
        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine()
                    .split(";");
            coupons[i] = new Coupon(
                    tokens[0],
                    tokens[1],
                    Integer.parseInt(tokens[2])
            );
        }

        Arrays.sort(coupons);
        for (Coupon coupon : coupons) {
            System.out.println(coupon);
        }
        System.out.println();

        Arrays.sort(coupons, new CouponComparator());

        Arrays.sort(coupons, (o1, o2) -> 0);

        Arrays.sort(coupons, (o1, o2) -> {
            return 0;
        });
    }



    static class CouponComparator implements Comparator<Coupon> {
        @Override
        public int compare(Coupon o1, Coupon o2) {
            if (!Objects.equals(o1.store, o2.store)) {
                return o1.store.compareTo(o2.store);
            }

            if (o1.discount != o2.discount) {
                return -Integer.compare(o1.discount, o2.discount);
            }

            return o1.name.compareTo(o2.name);
        }
    }
}

