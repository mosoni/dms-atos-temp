<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%>
<%@ include file="/init.jsp" %>
<%@page import="java.util.Set"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>


	<%
 		String actionDescription = ParamUtil.getString(request, "actionDescription");
	JSONArray array = new JSONArray(actionDescription); 
	String oldValue = "";
	String newValue = "";
	String fieldName = "";
	for(int i=0; i < array.length(); i++)   
	{  
	JSONObject object = array.getJSONObject(i);  
	oldValue = object.getString("oldValue");
	newValue = object.getString("newValue");
	fieldName = object.getString("fieldsName");
	}  
	
	%>
</head>
<body>
<h1 align="center">Action Description Details</h1>
<table id="t01" style="border:1px solid black;margin-left:auto;margin-right:auto;">
  <tr>
  	<th>Field Name</th>
    <th>Old Value</th>
    <th>New Value</th> 
  </tr>
  <tr>
  	<td><%=fieldName %></td>
    <td><%=oldValue %></td>
    <td><%=newValue %></td>
  </tr>
</table>

</body>
</html>