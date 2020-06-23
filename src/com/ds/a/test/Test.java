package com.ds.a.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ds.a.test.HanaHierarchyQueryBuilder.Direction;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Test {

	//private final String  REGEX="\\w+[\\\\?%*]+(?= |$)";
	public static void main(String[] args) {
		//HanaHierarchyQueryBuilder hq =	new HanaHierarchyQueryBuilder("rsurren_ditdb","GENERIC_OBJECT_T_HVIEW","NODE",1,true,Direction.PREDECESSOR,null);
		//System.out.println(hq.build(false).getHanaStartsWithQuery());
		//System.out.println(hq.build(false).getHanaHierarchySubquery());
	    System.out.println(beHViewWithFieldCreateStatement);
	
	}

	private static String  beHViewWithFieldCreateStatement = "CREATE COLUMN VIEW change_on_setup.%s TYPE hierarchy WITH PARAMETERS (\n" +
			"'hierarchyDefinition'='{\n" +
			"\"MULTIPARENT\":true,\n" +
			"\"ORPHANS\":true,\n" +
			"\"PARAMETERS\":["
			+ "{\"name\":\"$$EFFECTIVE_DATE$$\",\"type\":\"CHAR(10)\"},\n"
			+ "{\"name\":\"$$EFFECTIVE_STATUS$$\",\"type\":\"CHAR(1)\"},\n"
			+ "{\"name\":\"$$EFFECTIVE_STATUS_I$$\",\"type\":\"CHAR(1)\"},\n"
			+ "{\"name\":\"$$RECORD_STATUS$$\",\"type\":\"NVARCHAR(128)\"},\n"
			+ "{\"name\":\"$$RECORD_STATUS_P$$\",\"type\":\"NVARCHAR(128)\"},\n"
			+ "{\"name\":\"$$OBJECT_TYPE$$\",\"type\":\"NVARCHAR(512)\"},\n"
			+"{\"name\":\"$$BA_TYPE$$\",\"type\":\"NUMBER(512)\"},\n"
		    +"{\"name\":\"$$DIRECTION$$\",\"type\":\"NVARCHAR(30)\"}\n"
			+ "],\n" +
			"\"RUNTIMEOBJECTTYPE\":\"iter\",\n" +
			"\"SOURCEQUERY\":\"(SELECT T1.INTERNAL_ID as pred, T0.INTERNAL_ID as succ FROM (SELECT ROW_ID, INTERNAL_ID, %s from change_on_setup.%s WHERE OBJECT_TYPE = ''$$OBJECT_TYPE$$'' \n"
			+ "AND ((''$$EFFECTIVE_DATE$$'') BETWEEN to_varchar(EFFECTIVE_START_DATE,''yyyy-mm-dd'') AND to_varchar(EFFECTIVE_END_DATE,''yyyy-mm-dd'')) \n"
			+ "AND (EFFECTIVE_STATUS = ''$$EFFECTIVE_STATUS$$'' OR EFFECTIVE_STATUS = ''$$EFFECTIVE_STATUS_I$$'') \n"
			+ "AND (RECORD_STATUS = ''$$RECORD_STATUS$$'' OR RECORD_STATUS = ''$$RECORD_STATUS_P$$''))T0 LEFT OUTER JOIN (SELECT ROW_ID, INTERNAL_ID, %s from change_on_setup.%s \n"
			+ "WHERE OBJECT_TYPE = ''$$OBJECT_TYPE$$'' AND ((''$$EFFECTIVE_DATE$$'') BETWEEN to_varchar(EFFECTIVE_START_DATE,''yyyy-mm-dd'') \n"
			+ "AND to_varchar(EFFECTIVE_END_DATE,''yyyy-mm-dd'')) AND (EFFECTIVE_STATUS = ''$$EFFECTIVE_STATUS$$'' OR EFFECTIVE_STATUS = ''$$EFFECTIVE_STATUS_I$$'') \n"
			+ "AND (RECORD_STATUS = ''$$RECORD_STATUS$$'' OR RECORD_STATUS = ''$$RECORD_STATUS_P$$''))T1 ON T1.INTERNAL_ID = T0.%s) \n"
			+"UNION ALL (SELECT  CAST(BA_NUMBER as INTEGER) succ ,-999999 pred FROM BIZX_DITDB.TMP_BA_COND WHERE BA_TYPE=''$$BA_TYPE$$'' and ''$$DIRECTION$$''=''SUCCESSOR'') \n"
		    +"UNION ALL (SELECT -999999 succ,NULL pred FROM DUMMY where  ''$$DIRECTION$$'' =''SUCCESSOR'') \n"
		    +"UNION ALL (SELECT -999999 pred, CAST(BA_NUMBER as INTEGER) succ FROM BIZX_DITDB.TMP_BA_COND WHERE BA_TYPE=''$$BA_TYPE$$'' and  ''$$DIRECTION$$'' =''PREDECESSOR'') \n"
		    +"UNION ALL (SELECT NULL pred,-999999 succ FROM DUMMY where  ''$$DIRECTION$$'' =''PREDECESSOR'')\", \n"
			+"\"SOURCETYPE\":\"RECURSIVE\"}'\n" +
			")\n" +
			";";


}
 class HanaHierarchyQueryBuilder implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		/**
		 * 
		 * @author Suren
		 * 
		 * Helper class to build HANA hierarchy queries. 
		 * 
		 * If level >=(MAX_LEVEL = 99999) then query will be
		 * select result_node, query_node, ordinal,distance as level from rsurren_ditdb.GENERIC_OBJECT_T_HVIEW('expression'='descendantsOrSelf(600)',
		 * 'placeholder'=('EFFECTIVE_DATE','2017-06-27'),'placeholder'=('RECORD_STATUS','N'),'placeholder'=('EFFECTIVE_STATUS_I','A'),
		 * 'placeholder'=('EFFECTIVE_STATUS','A'),'placeholder'=('OBJECT_TYPE','Position1'),'placeholder'=('RECORD_STATUS_P','N'),
		 * 'placeholder'=('RELATIOSHIP_NAME','reportingPosition'))
		 * 
		 * else query will look like 
		 * select result_node, query_node, ordinal,distance as level from rsurren_ditdb.GENERIC_OBJECT_T_HVIEW('expression'='subtree( nodes( 600 ),0,2)',
		 * 'placeholder'=('EFFECTIVE_DATE','2017-06-27'),'placeholder'=('RECORD_STATUS','N'),'placeholder'=('EFFECTIVE_STATUS_I','A'),
		 * 'placeholder'=('EFFECTIVE_STATUS','A'),'placeholder'=('OBJECT_TYPE','Position1'),'placeholder'=('RECORD_STATUS_P','N'),
		 * 'placeholder'=('RELATIOSHIP_NAME','reportingPosition'))
		 * 
		 * As a workaround for this limitation use @HierarchyQueryBuilder. 
		 * @HierarchyQueryBuilder will not support multiple starting nodes.
		 * 
		 */

		/**
		 * Enum class for defining the direction of the hierarchy query. 
		 */
		public enum Direction {
			/**
			 * Direction: finding Predecessors
			 */
			PREDECESSOR,
			/**
			 * Direction: finding Successors
			 */
			SUCCESSOR
		};

		/**
		 * This is the max level in a hierarchy query.
		 */
		public static final int MAX_LEVEL = 99999;

		/**
		 * Company Schema
		 */
		private String companySchema;
		/**
		 * Table name
		 */
		private String hviewName;
		/**
		 * Value for the starting node of the hierarchy query view
		 */
		private Object startingNodeValue;
		/**
		 * Number of levels of records that the hierarchy query should include
		 */
		private int level = MAX_LEVEL;
		/**
		 * Include the starting node in the result set or not
		 */
		private boolean includeStartingNode;
		/**
		 * Which direction - SUCCESSOR or PREDECESSOR - the hierarchy query should traverse
		 */
		private Direction direction = Direction.SUCCESSOR;
		/**
		 * Placeholders for the HANA hierarchy expression parameters.
		 */
		private Map<String,String> placeholders;
		
		private HanaHierarchySubquery hierarchySubquery;
		
		/**
		 * Constructor.
		 * 
		 * @param companySchema  Company Schema
		 * @param hviewName  HANA Hierarchy view
		 * @param startingNodeValue  Value of the starting node
		 * @param level  Levels to traverse in the hierarchy view
		 * @param includeStartingNode  To include the starting node in the result set or not
		 * @param direction  The direction of the query traversal - Successor or Predecessor
		 */
		public HanaHierarchyQueryBuilder(String companySchema, String hviewName, Object startingNodeValue,
				int level, boolean includeStartingNode, Direction direction) {
			this.companySchema = companySchema;
			this.hviewName = hviewName;   
			this.startingNodeValue = startingNodeValue;
			this.level = level;
			this.includeStartingNode = includeStartingNode;
			this.direction = direction;
			this.hierarchySubquery = new HanaHierarchySubquery();
		}

		/**
		 * Constructor.
		 *
		 * @param companySchema  Company Schema
		 * @param hviewName  HANA Hierarchy view
		 * @param parentColumnName  Column that stores the Parent ID
		 * @param childColumnName  Column that stores the Child ID
		 * @param startingNodeValue  Value of the starting node
		 * @param level  Levels to traverse in the hierarchy view
		 * @param includeStartingNode  To include the starting node in the result set or not
		 * @param direction  The direction of the query traversal - Successor or Predecessor
		 * @param placeholders The placeholder defined in the particular hierarchy view, there could be multiple placeholders
		 */
		public HanaHierarchyQueryBuilder(String companySchema, String hviewName, Object startingNodeValue,
				int level, boolean includeStartingNode, Direction direction,
				Map<String,String> placeholders) {
			this.companySchema = companySchema;
			this.hviewName = hviewName;    
			this.startingNodeValue = startingNodeValue;
			this.level = level;
			this.includeStartingNode = includeStartingNode;
			this.direction = direction;
			this.placeholders = placeholders;
			this.hierarchySubquery = new HanaHierarchySubquery();
		}
		
		/**
		 * Returns the hierarchy in the form of a subquery/view and WITH STARTS As  query that is useful for inclusion
		 * to the FROM clause of another query.
		 * 
		 * @return a view that represents the hierarchy query
		 */
		public HanaHierarchySubquery build(boolean isStartsWithRequire) {  

			hierarchySubquery.setHanaHierarchySubquery(buildHierarchySubquery(isStartsWithRequire ));
			// WITH STARTS AS subquery is require only if isStartsWithRequire is true otherwise no need to create this query.
			if(isStartsWithRequire){
				hierarchySubquery.setHanaStartsWithQuery(buildStartsWithSubQuery());
			}
			return hierarchySubquery;
		}
		/**
		 * Returns the hierarchy in form of a subquery/view
		 * @param isStartsWithRequire
		 * @return
		 */
		private String buildHierarchySubquery(boolean isStartsWithRequire ) {  
			StringBuilder sb = new StringBuilder();
			sb.append("(select result_node,");
			if(includeStartingNode){
				sb.append("distance + 1 as level from ");	
			}else{
				sb.append("distance as level from ");
			}		
			sb.append(buildSubtreeExpression(isStartsWithRequire ));
			sb.append(" order by level ,result_node ");
			sb.append(" ) ");	
			return sb.toString();
		}
		/**
		 * Returns the WITH STARTS AS subquery that is useful for inclusion to the
		 * /*HANAVIEW_EXPRESSION of another query. WITH STARTS AS (SELECT row_id
		 * FROM RSURREN_devhana.GENERIC_OBJECT_T WHERE row_id in(?,?,?))
		 * 
		 * @return a view that represents the hierarchy query
		 */
		private String buildStartsWithSubQuery() {
			StringBuilder sb = new StringBuilder();
			sb.append("WITH STARTS AS ( SELECT ");
			sb.append("ROW_ID");
			sb.append(" FROM ");
			sb.append(formatCompanySchema(companySchema));
			sb.append("NAME");
			sb.append(" WHERE ");
			sb.append("ROW_ID");
			sb.append(" IN ");
			sb.append("( ? )");
			sb.append(" )");

			return sb.toString();
		}
		
		private String buildSubtreeExpressionForMinLevel(boolean isStartsWithRequire ) {
			StringBuilder sb = new StringBuilder();
			sb.append("(SELECT query_node, min(level) as level FROM ");
			sb.append( buildSubtreeExpression( isStartsWithRequire ));
			sb.append(" group by query_node) ");
			return sb.toString();
		}

		/**
		 * Returns the table/view alias of the hierarchy query.
		 *
		 * @return the alias of the hierarchy query/view
		 */
		public String getAlias() {
			return "hv";
		}
		/**
		 * Method to append processed startingNodeValue to given string builder instance
		 * Hana and oracle has different behavior for leaf node ,if there is empty leaf node value ,
		 * oracle treat as leaf node but Hana treat as the Root node.
		 * Hana is expecting null value for leaf node, now we are checking leaf node is empty then 
		 * passing as null and working as expected.
		 * Ref: XAF-27247
		 * @param sb - StringBuilder object instance
		 */
		private void processStartingNodeValue(StringBuilder sb) {
			if (startingNodeValue != null  && startingNodeValue instanceof Collection) {
				Collection collection = (Collection<?>)startingNodeValue;
				if(!collection.isEmpty()){
					boolean isFirstValueProcessed = false;
					for (Object ob : (Collection<?>) startingNodeValue) {
						if (isFirstValueProcessed) {
							sb.append(",");
						} else {
							isFirstValueProcessed = true;
						}
						getValueOf(sb, ob); 
					}
				}else{
					getValueOf(sb, null);
				}
			} else {
				getValueOf(sb, startingNodeValue);
			}

		}
		/**
		 * Method to append given node value to given string builder instance, based on instanceOf comparsion
		 * @param sb - StringBuilder object instance
		 * @param nodeValue - Object type node
		 */
		private void getValueOf(StringBuilder sb, Object nodeValue) {
			if (nodeValue instanceof String) {
				//If node value is String then append node value with singlequotes, to string builder instance.
				sb.append("\"").append(nodeValue).append("\"");
			} else {
				//append node value as-is, to string builder instance.
				sb.append(nodeValue);
			}
		}
	
		
		/**
		 * Builds the HANA hierarchy view's "subtree" expression.
		 *
		 * @return HANA expression string
		 */
		private String buildSubtreeExpression(boolean isStartsWithRequire ) {
			
			StringBuilder sb = new StringBuilder();
			
			sb.append(formatCompanySchema(companySchema));
			sb.append(hviewName);
			sb.append("/*HANAVIEW_EXPRESSION");
			
			if(level>=MAX_LEVEL){	

				sb.append(isStartsWithRequire ? "('expression'='" : "(\"expression\"=>");
				sb.append(includeStartingNode ? "descendantsOrSelf( " : "descendants( ");
				sb.append(isStartsWithRequire ? ":STARTS" : "-999999");
				sb.append(" )'");

			}else{
				
				sb.append(isStartsWithRequire ? "('expression'='subtree( nodes( " : "(\"expression\"=>'subtree( nodes(");
				sb.append(isStartsWithRequire ? ":STARTS" : "-999999");
				sb.append(" ),");

				if (Direction.SUCCESSOR == direction) { 	
					sb.append(isStartsWithRequire ? (includeStartingNode ? "0," : "1,") : (includeStartingNode ? "1," : "2,"));
					sb.append(isStartsWithRequire ? level:(level+1));

				}else{
					sb.append(isStartsWithRequire ? (-1*(level-1)) : (-1*(level)));
					sb.append(includeStartingNode ? ",0" : ",-1");//need to check with kunjan
				}
				
				sb.append(" )'");
			}
			sb.append(getPlaceholdersExpression());
			sb.append(")*/"); 

			return sb.toString();
		}
		/**
		 * Returns Placeholder expression.
		 *
		 * @return  Placeholder expression
		 */
		private String getPlaceholdersExpression() {
			StringBuilder sb = new StringBuilder();
			if (null != placeholders && !placeholders.isEmpty()) {
				for (Map.Entry<String,String> entry : placeholders.entrySet()) {
					sb.append(",placeholder.\"")
					.append(entry.getKey())
					.append("\"=>'")
					.append(entry.getValue())
					.append("'");
				}
			}
			return sb.toString();
		}

		/**
		 * Returns the appropriate companySchema that is properly formatted.
		 *
		 * @param companySchema
		 * @return  formatted companySchema
		 */
		private String formatCompanySchema(String companySchema) {
			if (null == companySchema) {
				return ";DEFAULT_SCHEMA;."; 
			}
			if (companySchema.indexOf(".") < 0) {
				return (companySchema+".");
			}
			return companySchema;
		}
	/*	public static String createRestrictionsForIn( int sizeOfParams) {

			return "(" + StringUtils.repeat("?,", sizeOfParams - 1) + "?)";
		}*/
		

		/**
		 * Gets the list of bind values from Lists of objects.
		 *
		 * @param gos the gos
		 * @return the start with value
		 */
		public List<Object> getBindValues() { 

			List<Object> bindValuesList = new ArrayList<>();

			if(startingNodeValue instanceof List<?>){
				for (Object obj : (Collection<?>) startingNodeValue) {
					bindValuesList.add(obj);
				}
				return bindValuesList;
			}
			return null;
		}
		/**
		 * As  isStartsWithRequire flag status either can add :STARTS  or just use the startingNodeValue
		 * in subquery/view
		 * @param sb
		 * @param isStartsWithRequire
		 */
		private void setProcessStartingNodeValueOrStarts(StringBuilder sb,boolean isStartsWithRequire ){
			if(isStartsWithRequire ){
				sb.append(":STARTS");
			}else{
				processStartingNodeValue(sb);
			}
		}
		/**
		 * this inner class  holds the WITH STARTS AS subquery that is useful for inclusion to the
		 * HANAVIEW_EXPRESSION of another query. WITH STARTS AS (SELECT row_id
		 * FROM RSURREN_devhana.GENERIC_OBJECT_T WHERE row_id in(?,?,?))
		 * 
		 * And also holds the hierarchy query in the form of a subquery/view that is useful for inclusion
		 * to the FROM clause of another query.
		 * 
		 * @author I339640
		 *
		 */
		class HanaHierarchySubquery{

			private String hanaStartsWithQuery;
			private String hanaHierarchySubquery;

			public String getHanaStartsWithQuery() {
				return hanaStartsWithQuery;
			}
			private void setHanaStartsWithQuery(String hanaStartsWithQuery) {
				this.hanaStartsWithQuery = hanaStartsWithQuery;
			}
			public String getHanaHierarchySubquery() {
				return hanaHierarchySubquery;
			}
			private void setHanaHierarchySubquery(String hanaHierarchySubquery) {
				this.hanaHierarchySubquery = hanaHierarchySubquery;
			}
	        
		}
	}

