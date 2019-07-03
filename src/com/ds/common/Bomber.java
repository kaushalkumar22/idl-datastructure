package com.ds.common;

public class Bomber {

	public static void main(String[] args) {

		String str = "bbdaaaaddcccdeedla";
		String newString =doBomber( str);
		System.out.println(newString);
	}
	private static String doBomber(String str){
		int len = str.length();
		boolean isRequire = false;
		int arr[] = new int[len];
		arr[0]=1;
		for(int i=1;i<len;i++){
			if(str.charAt(i)==str.charAt(i-1)){
				arr[i]=arr[i-1]+1;
			}else{
				arr[i]=1;
			}
		}
		for(int i=arr.length-1;i>=0;i--){
			if(arr[i]>=3){
				isRequire=true;
				String s2=str.substring(i-arr[i-1], i+1);
				str=str.replace(s2, "");
				i=i-arr[i-1];
			}
		}
		return isRequire? doBomber(str):str;
	}

}
