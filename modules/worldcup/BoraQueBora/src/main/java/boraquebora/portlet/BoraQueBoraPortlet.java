package boraquebora.portlet;

import boraquebora.constants.BoraQueBoraPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author gustavo
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=BoraQueBora Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=HelloWorld",
		"javax.portlet.name=" + BoraQueBoraPortletKeys.BoraQueBora,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class BoraQueBoraPortlet extends MVCPortlet {
}