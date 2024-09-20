package org.hypnos;


import java.util.Arrays;

/**
 * 2332. 坐上公交的最晚时间
 */
public class LatestTimeCatchTheBus {

    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);

        int j = 0;
        int c = 0;
        for (int t : buses) {
            for (c = capacity; j < passengers.length && c > 0 && passengers[j] <= t; --c) ++j;
        }

        j--;
        int ans = c > 0 ? buses[buses.length - 1] : passengers[j];
        while (j >= 0 && ans == passengers[j]) {
            j--;
            ans--;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] buses = {100};
        int[] passengers = {2,3,5,6, 80, 100};
        int capacity = 1000;
        LatestTimeCatchTheBus latestTimeCatchTheBus = new LatestTimeCatchTheBus();
        System.out.println(latestTimeCatchTheBus.latestTimeCatchTheBus(buses, passengers, capacity));
    }
}
