package com.ds.common;

import java.util.HashMap;
import java.util.Map;

public class TestCaseTesting {

	public static void main(String[] args) {
		Map<String, String> testStatusMap = new HashMap<String, String>();
		/*testStatusMap.put("TC-User_6114,6115.xls", "FAILURE");
		testStatusMap.put("TC-mxAdminAssetCapacity_3486,3547.xls", "SUCCESS");
		testStatusMap.put("TC-mxAdminAssetCapacity_3831.xls", "FAILURE");
		testStatusMap.put("TC-mxAdminAssetCapacity_3565.xls", "SUCCESS");
		testStatusMap.put("TC-mxAdminAssetCapacity_4159.xls", "SUCCESS");
		testStatusMap.put("TC-mxAdminAssetCapacity_3829.xls", "FAILURE");
		testStatusMap.put("TC-mxAdminAssetCapacity_3828.xls", "FAILURE");*/
		String testCase = "TC-mxAdminAssetCapacity_3486,3547.xls";
		testCase = testCase.substring(testCase.indexOf("_")+1,testCase.lastIndexOf(".xls"));
		String[] testCaseIds = testCase.split(",");
		for(String testCaseId :testCaseIds){
			System.out.println(testCaseId);
		}
		
	}
}
