package a_revision;

public class SumAmount {
    public static void main(String[] args) {
        String str = "*1 Rental $70,000Shopping  $299. Expenses $800 . House$2,00,000.";
        str = str.replaceAll(",","");
        int sum = 0;
        char[] ch = str.toCharArray();
        int startIndex =-1;
        int endEndex = -1;
        boolean isNumberStarted =false;
        for(int i = 0 ;i< ch.length;i++){
            char c = ch[i];
            if(c=='$'){
                startIndex=i;
                isNumberStarted = true;
            }
            if(isNumberStarted && c=='$' ){
                continue;
            }
            if(isNumberStarted && Character.isDigit(c) ){
                endEndex = i;
            }else if(isNumberStarted ){
                isNumberStarted = false;
                String st = str.substring(startIndex+1,endEndex+1);
                endEndex = -1;
                startIndex= -1;
                sum +=Integer.valueOf(st);
            }

        }
        System.out.println("$"+sum);
    }
}
