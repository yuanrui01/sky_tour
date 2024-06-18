package org.hypnos;


/**
 * 2288. 价格减免
 */
public class DiscountPrices {

    public String discountPrices(String sentence, int discount) {
        discount = 100 - discount;
        String[] words = sentence.split(" ");
        int len = words.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.charAt(0) != '$' || word.length() == 1) {
                sb.append(word);
            } else if (isLegal(word)) {
                String discountNum = transfer(word, discount);
                sb.append(discountNum);
            } else {
                sb.append(word);
            }
            if (i != len - 1) sb.append(" ");
        }
        return sb.toString();
    }

    private boolean isLegal(String word) {
        char[] charArray = word.toCharArray();
        if (charArray[1] < '1' || charArray[1] > '9')
            return false;
        for (int i = 2; i < charArray.length; ++i)
            if (charArray[i] < '0' || charArray[i] > '9')
                return false;
        return true;
    }

    private String transfer(String word, int discount) {
        double l = Double.parseDouble(word.substring(1));
        return String.format("$%.2f", l*discount/100);
    }


    public static void main(String[] args) {
        DiscountPrices discountPrices = new DiscountPrices();

        int discount = 100;
        String sentence = "1 2 $3 4 $5 $6 7 8$ $9 $10$";

        System.out.println(discountPrices.discountPrices(sentence, discount));
    }
}
