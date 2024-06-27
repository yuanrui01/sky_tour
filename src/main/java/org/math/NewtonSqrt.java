package org.math;

/**
 * 牛顿求根
 */
public class NewtonSqrt {

    public static double sqrt(double c) {
        if (c < 0)
            return Double.NaN;
        double err = 1e-15;
        double t = c;
        while (Math.abs(t - c/t) > t * err)
            t = (c / t + t) / 2.0;
        return t;
    }
}
