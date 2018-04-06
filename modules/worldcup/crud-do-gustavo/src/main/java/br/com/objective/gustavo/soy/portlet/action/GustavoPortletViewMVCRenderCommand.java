package br.com.objective.gustavo.soy.portlet.action;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ReleaseInfo;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import objective.model.Foo;
import objective.model.impl.FooImpl;
import objective.service.FooLocalService;
import objective.service.FooLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import org.osgi.service.component.annotations.Component;
import com.liferay.portal.kernel.util.ParamUtil;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author gustavo
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=GustavoPortlet", "mvc.command.name=View",
		"mvc.command.name=/"
	},
	service = MVCRenderCommand.class
)
public class GustavoPortletViewMVCRenderCommand
	implements MVCRenderCommand {

	@Reference
	private volatile FooLocalService _fooLocalService;

	public FooLocalService getFooLocalService() { return _fooLocalService; }

	public static final String MVC_ACTION_NAME = "CREATE_FOO";


	private static final Log log=LogFactoryUtil.getLog(GustavoPortletViewMVCRenderCommand.class);

	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse) {

		Template template = (Template)renderRequest.getAttribute(
			WebKeys.TEMPLATE);

		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		template.put("layouts", themeDisplay.getLayouts());



		template.put("portletNamespace", renderResponse.getNamespace());

		template.put("EditFooUrl", getAddFooUrl(renderResponse));

		template.put("releaseInfo", ReleaseInfo.getReleaseInfo());

		List<Foo> groups = getFooLocalService().getFoos(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		template.put("ListFoos",
				groups
						.stream()
						.map(g -> toData(g, renderResponse))
						.collect(Collectors.toList()));


		return "View";
	}

	private String getAddFooUrl(RenderResponse renderResponse) {
		PortletURL addFooURL = renderResponse.createRenderURL();
		addFooURL.setParameter("mvcRenderCommandName", "EditFoo");
		return addFooURL.toString();
	}

	private Map<String, Object> toData(Foo foo, RenderResponse renderResponse) {
		Map<String, Object> dataGroup = new HashMap<>();

		dataGroup.put("fooId", String.valueOf(foo.getFooId()));
		dataGroup.put("field1", foo.getField1());
		dataGroup.put("field2", foo.getField2());
		dataGroup.put("field3", foo.getField3());
		dataGroup.put("field4", foo.getField4());
		dataGroup.put("editUrl", getEditGroupURL(foo, renderResponse));
		dataGroup.put("deleteUrl", getDeleteGroupURL(foo, renderResponse));
		return dataGroup;
	}

	private String getEditGroupURL(Foo foo, RenderResponse renderResponse) {
		PortletURL editGroupURL = renderResponse.createRenderURL();
		editGroupURL.setParameter("mvcRenderCommandName", "EditFoo");
		editGroupURL.setParameter("fooId", String.valueOf(foo.getFooId()));
		return editGroupURL.toString();
	}

	private String getDeleteGroupURL(Foo foo, RenderResponse renderResponse) {
		PortletURL deleteGroupURL = renderResponse.createActionURL();
		deleteGroupURL.setParameter(ActionRequest.ACTION_NAME, "DELETE");
		deleteGroupURL.setParameter("fooId", String.valueOf(foo.getFooId()));

		return deleteGroupURL.toString();
	}





}