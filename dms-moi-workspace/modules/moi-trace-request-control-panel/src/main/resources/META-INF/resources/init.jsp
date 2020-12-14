<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

 <%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

 <%@ taglib prefix="aui" uri="http://liferay.com/tld/aui" %>
 <%@ taglib prefix="clay" uri="http://liferay.com/tld/clay" %>
 <%@ taglib prefix="liferay-item-selector" uri="http://liferay.com/tld/item-selector" %>
 <%@ taglib prefix="liferay-frontend" uri="http://liferay.com/tld/frontend" %>
 <%@ taglib prefix="liferay-portlet" uri="http://liferay.com/tld/portlet" %>
 <%@ taglib prefix="liferay-theme" uri="http://liferay.com/tld/theme" %>
 <%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui" %>
 <%@ taglib prefix="liferay-util" uri="http://liferay.com/tld/util" %> 

 <%@ page import="java.util.Date"%>
 <%@ page import="java.util.List"%>
 <%@ page import="java.text.SimpleDateFormat"%>
 <%@ page import="javax.portlet.WindowState"%>
 <%@page import="javax.portlet.PortletURL"%>

 <%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
 <%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
 <%@ page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
 <%@ page import="com.liferay.portal.kernel.language.LanguageUtil"%>
 <%@ page import="com.liferay.portal.kernel.util.HtmlUtil"%>
 <%@ page import="com.liferay.portal.kernel.util.ListUtil"%>

 <%@ page import="com.moi.dms.trace.request.model.MOITraceRequest"%>
 
<liferay-theme:defineObjects />

<portlet:defineObjects />