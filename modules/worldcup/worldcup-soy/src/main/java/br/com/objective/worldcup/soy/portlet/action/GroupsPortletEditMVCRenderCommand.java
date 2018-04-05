package br.com.objective.worldcup.soy.portlet.action;

import com.objective.worldcup.model.Group;
import com.objective.worldcup.service.GroupLocalService;
import br.com.objective.worldcup.soy.constants.PortletPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.*;

/**
 * @author guedes
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name="  + PortletPortletKeys.GroupsPortlet,
		"mvc.command.name=EditGroup"
	},
	service = MVCRenderCommand.class
)
public class GroupsPortletEditMVCRenderCommand
	implements MVCRenderCommand {

	private static final Log _log = LogFactoryUtil.getLog(GroupsPortletEditMVCRenderCommand.class);

	@Reference
	private volatile GroupLocalService _groupLocalService;

	public GroupLocalService getGroupLocalService() { return _groupLocalService; }

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		try {
			Template template = (Template) renderRequest.getAttribute(
					WebKeys.TEMPLATE);

			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(
					WebKeys.THEME_DISPLAY);

			template.put("portletNamespace", renderResponse.getNamespace());

			PortletURL viewGroupURL = renderResponse.createRenderURL();
			viewGroupURL.setParameter("mvcRenderCommandName", "ListGroup");
			template.put("viewGroupURL", viewGroupURL.toString());

			PortletURL viewCreateGroupURL = renderResponse.createActionURL();
			viewCreateGroupURL.setParameter(ActionRequest.ACTION_NAME, GroupsPortletCreateMVCActionCommand.MVC_ACTION_NAME);
			template.put("createGroupActionURL", viewCreateGroupURL.toString());

			Long grpId = ParamUtil.getLong(renderRequest, "grpId");

			if (grpId > 0) {
				Group group = getGroupLocalService().getGroup(grpId);
				template.put("name", group.getName());
			} else {
				template.put("name", "");
			}

		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
			SessionErrors.add(renderRequest, e.getLocalizedMessage());
		}

		return "EditGroup";
	}

}