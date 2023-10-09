package a_util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Position {
    public static void main(String[] args) throws FileNotFoundException {
        // pass the path to the file as a parameter
       // File file = new File("C:\\Users\\I339640\\Desktop\\position_data.txt");
        File file = new File("C:\\Users\\I339640\\Desktop\\position_data2.txt");
        Scanner sc = new Scanner(file);
        List<String[]> rowsCols = new ArrayList<>();
        while (sc.hasNextLine()){
            String[] col = sc.nextLine().split(";");
            rowsCols.add(col);
        }
        Collections.sort(rowsCols,(a,b)->Long.compare(Long.valueOf(a[2]),Long.valueOf(b[2])));
        List<Long> duplicate = new ArrayList<>();
        Set<Long> dCheck = new HashSet<>();
        for(String[] col:rowsCols){
            if(dCheck.contains(Long.valueOf(col[2]))){
                duplicate.add(Long.valueOf(col[2]));
            }else{
                dCheck.add(Long.valueOf(col[2]));
            }
        }
        System.out.println(duplicate+ " "+dCheck.size());
    }
}
