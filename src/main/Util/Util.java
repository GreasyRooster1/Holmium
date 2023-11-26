package main.Util;

import static java.lang.Integer.parseInt;
import static processing.core.PApplet.println;

public class Util {
    public static int hsv(float hue1, float saturation1, float value1) {
        float hue = hue1/255;
        float saturation = saturation1/255;
        float value = value1/255;

        float r, g, b;

        int h = (int)(hue * 6);
        float f = hue * 6 - h;
        float p = value * (1 - saturation);
        float q = value * (1 - f * saturation);
        float t = value * (1 - (1 - f) * saturation);

        if (h == 0) {
            r = value;
            g = t;
            b = p;
        } else if (h == 1) {
            r = q;
            g = value;
            b = p;
        } else if (h == 2) {
            r = p;
            g = value;
            b = t;
        } else if (h == 3) {
            r = p;
            g = q;
            b = value;
        } else if (h == 4) {
            r = t;
            g = p;
            b = value;
        } else if (h <= 6) {
            r = value;
            g = p;
            b = q;
        } else {
            throw new RuntimeException("Something went wrong when converting from HSV to RGB. Input was " + hue + ", " + saturation + ", " + value);
        }

        String rs = Integer.toHexString((int)(r * 255));
        String gs = Integer.toHexString((int)(g * 255));
        String bs = Integer.toHexString((int)(b * 255));
        return (int) Long.parseLong((rs+gs+bs), 16);
    }
}
