package br.com.objective.gustavo.soy.portlet.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ReleaseInfo;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.ActionRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author gustavo
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=GustavoPortlet", "mvc.command.name=EditFoo",
		"mvc.command.name=/"
	},
	service = MVCRenderCommand.class
)
public class GustavoPortletEditFooMVCRenderCommand
	implements MVCRenderCommand {

	private static final Log log=LogFactoryUtil.getLog(GustavoPortletEditFooMVCRenderCommand.class);

	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse) {

		Template template = (Template)renderRequest.getAttribute(
			WebKeys.TEMPLATE);

		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		template.put("layouts", themeDisplay.getLayouts());

		template.put("portletNamespace", renderResponse.getNamespace());

		PortletURL viewCreateGroupURL = renderResponse.createActionURL();
		viewCreateGroupURL.setParameter(ActionRequest.ACTION_NAME, GustavoPortletViewMVCRenderCommand.MVC_ACTION_NAME);
		template.put("createFooActionURL", viewCreateGroupURL.toString());

		template.put("releaseInfo", ReleaseInfo.getReleaseInfo());

		return "EditFoo";
	}


}