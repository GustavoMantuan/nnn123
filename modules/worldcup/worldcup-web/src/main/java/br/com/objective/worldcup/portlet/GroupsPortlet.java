package br.com.objective.worldcup.portlet;

import br.com.objective.worldcup.constants.WorldCupPortletKeys;
import com.objective.worldcup.model.Group;
import com.objective.worldcup.service.GroupLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.*;
import java.io.IOException;

/**
 * @author guedes
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=World Cup",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Groups",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/groups/view.jsp",
		"javax.portlet.name=" + WorldCupPortletKeys.Groups,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class GroupsPortlet extends MVCPortlet {

	@Reference
	private volatile GroupLocalService _groupLocalService;

	public GroupLocalService getGroupLocalService() { return _groupLocalService; }

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		//set service bean
		renderRequest.setAttribute("groupLocalService", getGroupLocalService());

		super.render(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {

		try {
			String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

			if (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE)) {
				updateGroup(actionRequest);
			}
			else if (cmd.equals(Constants.DELETE)) {
				deleteGroup(actionRequest);
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

	protected void deleteGroup(ActionRequest actionRequest) throws Exception {
		long grpId = ParamUtil.getLong(actionRequest, "grpId");

		getGroupLocalService().deleteGroup(grpId);
	}

	protected void updateGroup(ActionRequest actionRequest) throws Exception {

		long grpId = ParamUtil.getLong(actionRequest, "grpId");

		String nameValue = ParamUtil.getString(actionRequest, "name");

		if (grpId <= 0) {
			Group group = getGroupLocalService().createGroup(0);

			group.setName(nameValue);
			group.isNew();

			getGroupLocalService().addGroupWithoutId(group);
		}
		else {
			Group group = getGroupLocalService().getGroup(grpId);
			group.setName(nameValue);

			getGroupLocalService().updateGroup(group);
		}
	}

}