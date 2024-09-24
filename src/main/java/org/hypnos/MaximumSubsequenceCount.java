package org.hypnos;


/**
 * 2207. 字符串中最多数目的子序列
 */
public class MaximumSubsequenceCount {

    public long maximumSubsequenceCount(String text, String pattern) {
        long ans = 0L;
        char c1 = pattern.charAt(0);
        char c2 = pattern.charAt(1);
        int c1Count = 0;
        int c2Count = 0;
        char[] crr = text.toCharArray();
        for (char c : crr) {
            if (c2 == c) {
                ans += c1Count;
                c2Count++;
            }
            if (c1 == c) {
                c1Count++;
            }
        }
        ans += Math.max(c1Count, c2Count);
        return ans;
    }

    public static void main(String[] args) {
        MaximumSubsequenceCount maximumSubsequenceCount = new MaximumSubsequenceCount();
        String text = "vnedkpkkyxelxqptfwuzcjhqmwagvrglkeivowvbjdoyydnjrqrqejoyptzoklaxcjxbrrfmpdxckfjzahparhpanwqfjrpbslsyiwbldnpjqishlsuagevjmiyktgofvnyncizswldwnngnkifmaxbmospdeslxirofgqouaapfgltgqxdhurxljcepdpndqqgfwkfiqrwuwxfamciyweehktaegynfumwnhrgrhcluenpnoieqdivznrjljcotysnlylyswvdlkgsvrotavnkifwmnvgagjykxgwaimavqsxuitknmbxppgzfwtjdvegapcplreokicxcsbdrsyfpustpxxssnouifkypwqrywprjlyddrggkcglbgcrbihgpxxosmejchmzkydhquevpschkpyulqxgduqkqgwnsowxrmgqbmltrltzqmmpjilpfxocflpkwithsjlljxdygfvstvwqsyxlkknmgpppupgjvfgmxnwmvrfuwcrsadomyddazlonjyjdeswwznkaeaasyvurpgyvjsiltiykwquesfjmuswjlrphsdthmuqkrhynmqnfqdlwnwesdmiiqvcpingbcgcsvqmsmskesrajqwmgtdoktreqssutpudfykriqhblntfabspbeddpdkownehqszbmddizdgtqmobirwbopmoqzwydnpqnvkwadajbecmajilzkfwjnpfyamudpppuxhlcngkign";
        String pattern = "rr";
        System.out.println(maximumSubsequenceCount.maximumSubsequenceCount(text, pattern));
    }
}
