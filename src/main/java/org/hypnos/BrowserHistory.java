package org.hypnos;

/**
 * 1472. 设计浏览器历史记录
 */
public class BrowserHistory {

    private String[] histories;
    private int cur;
    private int last;

    public BrowserHistory(String homepage) {
        histories = new String[5001];
        cur = 0;
        last = 0;
        histories[cur] = homepage;
    }

    public void visit(String url) {
        histories[++cur] = url;
        last = cur;
    }

    public String back(int steps) {
        int pos = Math.max(cur - steps, 0);
        String page = histories[pos];
        cur = pos;
        return page;
    }

    public String forward(int steps) {
        int pos = Math.min(last, cur + steps);
        String page = histories[pos];
        cur = pos;
        return page;
    }

    public static void main(String[] args) {

    }
}
