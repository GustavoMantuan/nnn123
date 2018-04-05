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

<%@ include file="/teams/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

long teamId = ParamUtil.getLong(request, "teamId");

Team team = null;

if (teamId > 0) {
	team = teamLocalService.getTeam(teamId);
}
%>

<aui:form action="<%= renderResponse.createActionURL() %>" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= team == null ? Constants.ADD : Constants.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
	<aui:input name="teamId" type="hidden" value="<%= teamId %>" />

	<liferay-ui:header
		backURL="<%= redirect %>"
		title='<%= (team != null) ? team.getName() : "new-team" %>'
	/>

	<aui:model-context bean="<%= team %>" model="<%= Team.class %>" />

	<aui:fieldset>

		<aui:input name="name" />

        <aui:select name="grpId" label="display-style">

            <%
            for (Group group : groupLocalService.getGroups(0, groupLocalService.getGroupsCount())) {
            %>
                <aui:option label="<%= group.getName() %>" selected="false" value="<%= group.getGrpId() %>" />
            <%
            }
			%>

        </aui:select>

		<liferay-ui:custom-attributes-available className="<%= Team.class.getName() %>">
			<liferay-ui:custom-attribute-list
				className="<%= Team.class.getName() %>"
				classPK="<%= (team != null) ? team.getTeamId() : 0 %>"
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