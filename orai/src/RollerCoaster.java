import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class RollerCoaster
        implements Comparable<RollerCoaster> {
    private String name;
    private String world;
    private int height;
    private int time;

    public RollerCoaster(String name, String world,
                         int height, int time) {
        this.name = name;
        this.world = world;
        this.height = height;
        this.time = time;
    }

    public RollerCoaster(String line) {
        String[] tokens = line.split(";");
        this.name = tokens[0];
        this.world = tokens[1];
        this.height = parseInt(tokens[2]);
        this.time = parseInt(tokens[3]);
    }

    @Override
    public String toString() {
        return String.format("%s (%s): %d",
                this.name, this.world, this.time);
    }

    @Override
    public int compareTo(RollerCoaster o) {
        if (this.time != o.time) {
            return Integer.compare(this.time, o.time);
        }
        /*
        int res = Integer.compare(this.time, o.time);
        if(res != 0){
            return res;
        }
         */

        if (this.height != o.height) {
            return -Integer.compare(
                    this.height, o.height);
        }

        return this.name.compareTo(o.name);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RollerCoaster[] coasters
                = new RollerCoaster[20];
        int counter = 0;

        while (true) {
            String line = sc.nextLine();
            if (Objects.equals(line, "END")) {
                break;
            }

            /*
            String[] tokens = line.split(";");
            coasters[counter] = new RollerCoaster(
                    tokens[0],
                    tokens[1],
                    parseInt(tokens[2]),
                    parseInt(tokens[3])
            );

             */
            coasters[counter] = new RollerCoaster(line);
            counter++;
        }
        Arrays.sort(coasters, 0, counter);
        for (int i = 0; i < counter; i++) {
            System.out.println(coasters[i]);
        }
    }
}
