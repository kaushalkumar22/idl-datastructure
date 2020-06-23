package com.aa.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {

	public static void main(String[] args) {
		
		Map<String, Integer> fieldVsIndex = new HashMap<String, Integer>();
		fieldVsIndex.put("code",0);
		fieldVsIndex.put("externalName",1);
		fieldVsIndex.put("name",2);
		fieldVsIndex.put("reference.name",3);
		fieldVsIndex.put("children.name",4);
		fieldVsIndex.put("internalId",5);
		fieldVsIndex.put("rowId",6);
		fieldVsIndex.put("mdfSystemRecordStatus",7);

		 List<List<String>> li = Arrays.asList(Arrays.asList("pending_record1","workflow pending record","Whatever1","name field in reference1","null","1005","1006","P"),
				 Arrays.asList("pending_record1","workflow pending record","Whatever1","name field in reference1","null","1005","1007","N"),
				 Arrays.asList("pending_record10","workflow pending record","Whatever10","null","null","1014","1024","P"),
				 Arrays.asList("pending_record10","workflow pending record","Whatever10","null","null","1014","1025","N"),
				 Arrays.asList("pending_record11","workflow pending record","Whatever11","null","null","1015","1026","P"),
				 Arrays.asList("pending_record11","workflow pending record","Whatever11","null","null","1015","1027","N"),
				 Arrays.asList("pending_record12","workflow pending record","Whatever12","null","null","1016","1028","P"),
				 Arrays.asList("pending_record12","workflow pending record","Whatever12","null","null","1016","1029","N"),
				 Arrays.asList("pending_record13","workflow pending record","Whatever13","null","null","1017","1030","P"),
				 Arrays.asList("pending_record13","workflow pending record","Whatever13","null","null","1017","1031","N]"));
                for (List<String> list : li) {
                	System.out.println(list.get(fieldVsIndex.get("rowId")));
		       }
	}
}
