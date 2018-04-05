package br.com.objective.worldcup.portlet;

import br.com.objective.worldcup.constants.WorldCupPortletKeys;

import com.objective.worldcup.model.Team;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import com.objective.worldcup.service.GroupLocalService;
import com.objective.worldcup.service.TeamLocalService;
import javax.portlet.*;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;

/**
 * @author guedes
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=World Cup",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Teams",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/teams/view.jsp",
		"javax.portlet.name=" + WorldCupPortletKeys.Teams,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class TeamsPortlet extends MVCPortlet {

	@Reference
	private TeamLocalService _teamLocalService;

	@Reference
	private GroupLocalService _groupLocalService;

	public TeamLocalService getTeamLocalService() { return _teamLocalService; }

	public GroupLocalService getGroupLocalService() { return _groupLocalService; }

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		//set service bean
		renderRequest.setAttribute("teamLocalService", getTeamLocalService());
		renderRequest.setAttribute("groupLocalService", getGroupLocalService());

		super.render(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {

		try {
			String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

			if (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE)) {
				updateTeam(actionRequest);
			}
			else if (cmd.equals(Constants.DELETE)) {
				deleteTeam(actionRequest);
			}

			if (Validator.isNotNull(cmd)) {
				if (SessionErrors.isEmpty(actionRequest)) {
					SessionMessages.add(actionRequest, "requestProcessed");
				}

				String redirect = ParamUtil.getString(
						actionRequest, "redirect");

				actionResponse.sendRedirect(redirect);
			}
		}
		catch (Exception e) {
			throw new PortletException(e);
		}

	}

	protected void deleteTeam(ActionRequest actionRequest) throws Exception {
		long teamId = ParamUtil.getLong(actionRequest, "teamId");

		getTeamLocalService().deleteTeam(teamId);
	}

	protected void updateTeam(ActionRequest actionRequest) throws Exception {

		long teamId = ParamUtil.getLong(actionRequest, "teamId");

		String nameValue = ParamUtil.getString(actionRequest, "name");
		long grpId = ParamUtil.getLong(actionRequest, "grpId");

		if (teamId <= 0) {
			Team team = getTeamLocalService().createTeam(0);

			team.setName(nameValue);
			team.setGrpId(grpId);
			team.isNew();

			getTeamLocalService().addTeamWithoutId(team);
		}
		else {
			Team team = getTeamLocalService().getTeam(teamId);
			team.setName(nameValue);
			team.setGrpId(grpId);

			getTeamLocalService().updateTeam(team);
		}
	}
}