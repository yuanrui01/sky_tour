package org.hypnos;

public class MinSpeedOnTime {

    private int[] dist;

    public int minSpeedOnTime(int[] dist, double hour) {
        this.dist = dist;
        int left = 1;
        int right = 10000000;

        while (left <= right) {
            int mid = left + (right -  left) / 2;
            if (!isReachable(mid, hour))
                left = mid + 1;
            else
                right = mid - 1;
        }

        return isReachable(left, hour) ? left : -1;
    }

    private boolean isReachable(int speed, double hour) {
        double t_hour = 0.0;
        for (int i = 0; i < dist.length - 1; ++i) {
            t_hour += (dist[i] / speed);
            if (dist[i] % speed != 0)
                t_hour++;
        }
        double last_hour = (1.0 * dist[dist.length - 1]) /  speed;
        t_hour += last_hour;
        return t_hour <= hour;
    }

    public static void main(String[] args) {
        MinSpeedOnTime minSpeedOnTime = new MinSpeedOnTime();
        int[] dist = {1, 3, 2};
        double hour = 1.9;

        System.out.println(minSpeedOnTime.minSpeedOnTime(dist, hour));
    }
}
