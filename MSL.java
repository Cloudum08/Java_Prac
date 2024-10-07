/*You are given a string s consisting only of uppercase English letters.

You can apply some operations to this string where, in one operation, you can remove any occurrence of one of the substrings "AB" or "CD" from s.

Return the minimum possible length of the resulting string that you can obtain.

Note that the string concatenates after removing the substring and could produce new "AB" or "CD" substrings.*/





class MSL {
    public int minLength(String s) {
        char[] stack = new char[s.length()+1];
        int top=0;
        for(char ch:s.toCharArray()){
            if(top==0){
                stack[top++]=ch;
                continue;
            }
            if((ch=='B' && stack[top-1]=='A')|| ch=='D' && stack[top-1]=='C'){
                top--;
            }
            else{
                stack[top++]=ch;
            }
        }
        return top;
    }
}