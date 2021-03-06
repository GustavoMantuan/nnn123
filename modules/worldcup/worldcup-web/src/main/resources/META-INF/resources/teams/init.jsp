<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>


<%@ page import="com.objective.worldcup.model.Team" %>
<%@ page import="com.objective.worldcup.model.Group" %>
<%@ page import="com.objective.worldcup.service.TeamLocalService" %>
<%@ page import="com.objective.worldcup.service.GroupLocalService" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.taglib.search.ResultRow" %>

<%@ page import="javax.portlet.PortletURL" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
    PortletURL portletURL = renderResponse.createRenderURL();

    String currentURL = portletURL.toString();

    //get service bean
    TeamLocalService teamLocalService = (TeamLocalService)request.getAttribute("teamLocalService");
    GroupLocalService groupLocalService = (GroupLocalService)request.getAttribute("groupLocalService");

%>