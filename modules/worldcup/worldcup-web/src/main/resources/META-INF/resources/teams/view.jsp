<%@ include file="/teams/init.jsp" %>

<aui:button-row>
	<portlet:renderURL var="editTeamURL">
		<portlet:param name="mvcPath" value="/teams/edit_team.jsp" />
		<portlet:param name="redirect" value="<%= currentURL %>" />
	</portlet:renderURL>

	<aui:button href="<%= editTeamURL %>" value="add-team" />
</aui:button-row>

<liferay-ui:search-container
	total="<%= teamLocalService.getTeamsCount() %>"
>
	<liferay-ui:search-container-results
		results="<%= teamLocalService.getTeams(searchContainer.getStart(), searchContainer.getEnd()) %>"
	/>

	<liferay-ui:search-container-row
		className="br.com.objective.worldcup.model.Team"
		escapedModel="true"
		modelVar="team"
	>

		<liferay-ui:search-container-column-text
			property="name"
			valign="top"
		/>

		<liferay-ui:search-container-column-text
		    valign="top"
		    title="Grupo">

		    <% Group group = groupLocalService.getGroup(team.getGrpId()); %>
		    <%= group != null ? group.getName() : "" %>

		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-jsp
			cssClass="entry-action"
			path="/teams/team_action.jsp"
			valign="top"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>