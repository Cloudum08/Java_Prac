/*You are given two strings sentence1 and sentence2, each representing a sentence composed of words. A sentence is a list of words that are separated by a single space with no leading or trailing spaces. Each word consists of only uppercase and lowercase English characters.

Two sentences s1 and s2 are considered similar if it is possible to insert an arbitrary sentence (possibly empty) inside one of these sentences such that the two sentences become equal. Note that the inserted sentence must be separated from existing words by spaces.*/




public class SentenceSimilarity {
    public boolean areSentencesSimilar(String t1, String t2) {
        if (t1.equals(t2)) return true;

        String[] a1 = t1.split(" ");
        String[] a2 = t2.split(" ");
        int i1 = 0, i2 = 0, s1 = a1.length - 1, s2 = a2.length - 1;

        while (i1 <= s1 && i2 <= s2 && a1[i1].equals(a2[i2])) {
            i1++;
            i2++;
        }

        while (s1 >= i1 && s2 >= i2 && a1[s1].equals(a2[s2])) {
            s1--;
            s2--;
        }

        return s1 < i1 || s2 < i2;
    }
}