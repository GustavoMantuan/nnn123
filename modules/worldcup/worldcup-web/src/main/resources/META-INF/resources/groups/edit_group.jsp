<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/groups/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

long grpId = ParamUtil.getLong(request, "grpId");

Group group = null;

if (grpId > 0) {
	group = groupLocalService.getGroup(grpId);
}
%>

<aui:form action="<%= renderResponse.createActionURL() %>" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= group == null ? Constants.ADD : Constants.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
	<aui:input name="grpId" type="hidden" value="<%= grpId %>" />

	<liferay-ui:header
		backURL="<%= redirect %>"
		title='<%= (group != null) ? group.getName() : "new-group" %>'
	/>

	<aui:model-context bean="<%= group %>" model="<%= Group.class %>" />

	<aui:fieldset>
		<aui:input name="name" />

		<liferay-ui:custom-attributes-available className="<%= Group.class.getName() %>">
			<liferay-ui:custom-attribute-list
				className="<%= Group.class.getName() %>"
				classPK="<%= (group != null) ? group.getGrpId() : 0 %>"
				editable="<%= true %>"
				label="<%= true %>"
			/>
		</liferay-ui:custom-attributes-available>

	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button href="<%= redirect %>" type="cancel" />
	</aui:button-row>
</aui:form>