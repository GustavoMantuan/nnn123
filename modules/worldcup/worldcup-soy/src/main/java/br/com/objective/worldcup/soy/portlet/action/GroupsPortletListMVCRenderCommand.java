package br.com.objective.worldcup.soy.portlet.action;

import br.com.objective.worldcup.model.Group;
import br.com.objective.worldcup.service.GroupLocalService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author guedes
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=GroupsPortlet",
		"mvc.command.name=ListGroup",
		"mvc.command.name=/"
	},
	service = MVCRenderCommand.class
)
public class GroupsPortletListMVCRenderCommand
	implements MVCRenderCommand {

	@Reference
	private volatile GroupLocalService _groupLocalService;

	public GroupLocalService getGroupLocalService() {
		return _groupLocalService;
	}

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) {

		Template template = (Template)renderRequest.getAttribute(
			WebKeys.TEMPLATE);

		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		template.put("pathThemeImages", themeDisplay.getPathThemeImages());

		List<Group> groups = getGroupLocalService().getGroups(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		template.put("addGroupURL", getAddGroupURL(renderResponse));

		template.put("groups",
				groups
					.stream()
					.map(g -> toData(g, renderResponse))
					.collect(Collectors.toList()));

//		template.put("portletNamespace", renderResponse.getNamespace());

		return "ListGroup";
	}

	private Map<String, Object> toData(Group group, RenderResponse renderResponse) {
		Map<String, Object> dataGroup = new HashMap<>();

		dataGroup.put("grpId", String.valueOf(group.getGrpId()));
		dataGroup.put("name", group.getName());
		dataGroup.put("editGroupURL", getEditGroupURL(group, renderResponse));
		dataGroup.put("deleteGroupURL", getDeleteGroupURL(group, renderResponse));

		return dataGroup;
	}

	private String getAddGroupURL(RenderResponse renderResponse) {
		PortletURL addGroupURL = renderResponse.createRenderURL();
		addGroupURL.setParameter("mvcRenderCommandName", "EditGroup");

		return addGroupURL.toString();
	}

	private String getEditGroupURL(Group group, RenderResponse renderResponse) {
		PortletURL editGroupURL = renderResponse.createRenderURL();
		editGroupURL.setParameter("mvcRenderCommandName", "EditGroup");
		editGroupURL.setParameter("grpId", String.valueOf(group.getGrpId()));

		return editGroupURL.toString();
	}

	private String getDeleteGroupURL(Group group, RenderResponse renderResponse) {
		PortletURL deleteGroupURL = renderResponse.createActionURL();
		deleteGroupURL.setParameter(ActionRequest.ACTION_NAME, GroupsPortletDeleteMVCActionCommand.MVC_ACTION_NAME);
		deleteGroupURL.setParameter("grpId", String.valueOf(group.getGrpId()));

		return deleteGroupURL.toString();
	}

}