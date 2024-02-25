package com.example.odTest;
import org.junit.jupiter.api.Test;

/**
 * 乌鸫科技笔试题--三个瓶子可以换一瓶酒，七个瓶盖可以换一瓶酒，可以喝多少瓶酒
 */
class solution {

    @Test
    public void test() {
        System.out.println(result(10));
    }

    int result = 0;

    public int result(int n) {
        drink(n, 0, 0);
        return result;
    }

    public void drink(int n, int a, int b) {
        if (n <= 0 && a < 3 && b < 7) {
            return;
        }
        result = result + n;
        int x = (a + n) / 3;
        int y = (b + n) / 7;
        drink(x + y, a + n - x * 3, b + n - y * 7);
    }
}
