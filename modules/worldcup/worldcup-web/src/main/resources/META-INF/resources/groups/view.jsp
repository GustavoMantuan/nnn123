<%@ include file="/groups/init.jsp" %>

<aui:button-row>
	<portlet:renderURL var="editTeamURL">
		<portlet:param name="mvcPath" value="/groups/edit_group.jsp" />
		<portlet:param name="redirect" value="<%= currentURL %>" />
	</portlet:renderURL>

	<aui:button href="<%= editTeamURL %>" value="add-group" />
</aui:button-row>

<liferay-ui:search-container
	total="<%= groupLocalService.getGroupsCount() %>"
>
	<liferay-ui:search-container-results
		results="<%= groupLocalService.getGroups(searchContainer.getStart(), searchContainer.getEnd()) %>"
	/>

	<liferay-ui:search-container-row
		className="com.objective.worldcup.model.Group"
		escapedModel="true"
		modelVar="team"
	>

		<liferay-ui:search-container-column-text
			property="name"
			valign="top"
		/>

		<liferay-ui:search-container-column-jsp
			cssClass="entry-action"
			path="/groups/group_action.jsp"
			valign="top"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>