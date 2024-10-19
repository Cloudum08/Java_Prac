/*Given two positive integers n and k, the binary string Sn is formed as follows:

S1 = "0"
Si = Si - 1 + "1" + reverse(invert(Si - 1)) for i > 1
Where + denotes the concatenation operation, reverse(x) returns the reversed string x, and invert(x) inverts all the bits in x (0 changes to 1 and 1 changes to 0).

For example, the first four strings in the above sequence are:

S1 = "0"
S2 = "011"
S3 = "0111001"
S4 = "011100110110001"
Return the kth bit in Sn. It is guaranteed that k is valid for the given n.*/



class binaryString {
    private String[] v;

    private String solve(int ind) {
        if (ind == 0) {
            return "0";
        }

        String tmp = solve(ind - 1);
        v[ind] = tmp + "1" + rev(invert(tmp));
        return v[ind];
    }

    private String invert(String s) {
        StringBuilder tmp = new StringBuilder(s);
        for (int i = 0; i < tmp.length(); i++) {
            if (tmp.charAt(i) == '1') {
                tmp.setCharAt(i, '0');
            } else {
                tmp.setCharAt(i, '1');
            }
        }
        return tmp.toString();
    }

    private String rev(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public char findKthBit(int n, int k) {
        v = new String[n];
        v[0] = "0";
        solve(n - 1);
        return v[n - 1].charAt(k - 1);
    }
}
