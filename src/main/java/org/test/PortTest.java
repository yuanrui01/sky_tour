package org.test;

import java.util.regex.Pattern;

public class PortTest {

    public static final String PORT = "(\\d|[1-9]\\d{1,3}|[1-5]\\d{4}|6[0-4]\\d{3}|65[0-4]\\d{2}|655[0-2]\\d|6553[0-5])";

    public static final Pattern PORT_PATTERN = Pattern.compile(PORT);

    public static boolean isValidPort(String port) {
        return PORT_PATTERN.matcher(port).matches();
    }



    public static void main(String[] args) {
        System.out.println(isValidPort("60001"));
    }
}
