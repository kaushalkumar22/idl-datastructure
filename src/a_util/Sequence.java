package a_util;

import java.util.*;

public class Sequence {
    public static void main(String[] args) {
        Map<String, Set<Long>> objectsVsICsMap = new HashMap<>();
        objectsVsICsMap.putIfAbsent("abc",new HashSet<>());
        objectsVsICsMap.get("abc").add(1000l);
        objectsVsICsMap.get("abc").add(2000l);
        objectsVsICsMap.get("abc").add(3000l);
        objectsVsICsMap.putIfAbsent("xyz",new HashSet<>());
        objectsVsICsMap.get("xyz").add(1001l);
        objectsVsICsMap.get("xyz").add(2002l);
        objectsVsICsMap.get("xyz").add(3003l);

        Map<String, Map<Long,Long>> objectVsICVsSequenceMap = new HashMap<>();
        Set<String> objTypes = objectsVsICsMap.keySet();
        Collection<Set<Long>> values = objectsVsICsMap.values();

        System.out.println(getBindValues(objTypes) );
        System.out.println(getBindValues(objectsVsICsMap.get("xyz")) );

        //System.out.println(buildSelectQueryForBatch( objs.size(), ics.size()));
    }

    /**
     * Returns the SELECT  that is useful while doing batching and
     * SELECT ENTITY_NAME,INTERNAL_ID,SEQUENCE_NUMBER FROM ;DEFAULT_SCHEMA;.MDF_SEQUENCE WHERE ENTITY_NAME IN (?,?) AND INTERNAL_ID IN (?,?,?,?,?,?);
     * @param countEntityType
     * @param countIcs
     * @return
     */
    private static String buildSelectQueryForBatch(int countEntityType, int countIcs) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ENTITY_NAME,INTERNAL_ID,SEQUENCE_NUMBER FROM ;DEFAULT_SCHEMA;.MDF_SEQUENCE ");
        sb.append("WHERE ");
        sb.append("ENTITY_NAME ");
        sb.append("IN ");
        sb.append(createRestrictionsForIn(countEntityType));
        sb.append(" AND INTERNAL_ID ");
        sb.append("IN ");
        sb.append(createRestrictionsForIn(countIcs));
        sb.append(";");
        return sb.toString();
    }

    /**
     * Gets the list of bind values from collect of objects.
     * @param values: either `objects or ICs
     * @return
     */
    public static List<Object> getBindValues(Set<?> values) {
        List<Object> bindValuesList = new ArrayList<>();
        for (var obj : values) {
            bindValuesList.add(obj);
        }
        return bindValuesList;
    }

    /**
     * It returns the number of placeholder require for bind values
     * Ex: sizeOfParams k =6  then (?,?,?,?,?,?)
     * @param sizeOfParams
     * @return
     */
    public static String createRestrictionsForIn( int sizeOfParams) {
        return "(" + repeat("?,", sizeOfParams-1) + "?)";
    }

    /**
     * Its a generalize util method to add the required number of placeholder
     * @param str
     * @param repeat
     * @return
     */
    public static String repeat(final String str, final int repeat) {
        if (str == null) {
            return null;
        }
        if (repeat <= 0) {
            return "";
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < repeat; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}



