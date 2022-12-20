package a_revision;

import java.util.Stack;

public class Test {

    public static boolean isValid(String s){
        Stack<Character> st = new Stack<>();
        //((a+b)+c)
        for(char c : s.toCharArray()){

            if(c!=')'){
                st.push(c);
            }else if((!st.isEmpty())&&st.peek()=='('&&c==')'){
                return true;
            }else{
               while((!st.isEmpty())&&st.peek()!='('){
                   st.pop();
               }
               if((!st.isEmpty())){
                    st.pop();
                }
            }
        }

        return false;
    }
    public static void main(String[] args) {
      //  System.out.println(isValid("(a+b)+(c)"));
        //I/o - "  Kaushal  works   for  SAP   "
        // O/p - "   SAP  for   works  Kaushal  "
        String res ="";
        String s ="Kaushal  works   for  SAP   ";
        char[] ch = s.toCharArray();

        int len = s.length();
        int low =0;
        int high =len-1;
        reverse(ch, low, high);
        int count = 0;
        for(int i=0;i<len;i++){
            if(ch[i] ==' '){
                if(count!=0){
                    reverse(ch, i-count, i-1);
                    count= 0;
                }
            }else{
                count ++;
            }
        }
        if(count!=0){
            reverse(ch, len-count,len-1);
        }
        System.out.println(new String(ch));
       System.out.println(new String(ch).equals("   SAP  for   works  Kaushal"));
    }
    static void reverse(char[] ch, int low, int high){
        while(low<high){
           char c= ch[low];
           ch[low]=ch[high];
           ch[high]=c;
           low++;
           high--;
        }
    }
}
