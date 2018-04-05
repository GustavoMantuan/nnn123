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
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Groups Listener",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/groups_listener/view.jsp",
		"javax.portlet.name=" + WorldCupPortletKeys.GroupsListener,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class GroupsListenerPortlet extends MVCPortlet {

	@Reference
	private volatile GroupLocalService _groupLocalService;

	public GroupLocalService getGroupLocalService() { return _groupLocalService; }

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		//set service bean
		renderRequest.setAttribute("groupLocalService", getGroupLocalService());

		super.render(renderRequest, renderResponse);
	}

}