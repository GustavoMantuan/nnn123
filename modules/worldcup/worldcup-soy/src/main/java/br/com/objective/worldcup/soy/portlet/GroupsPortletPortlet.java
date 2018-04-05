package br.com.objective.worldcup.soy.portlet;

import br.com.objective.worldcup.soy.constants.PortletPortletKeys;

import com.liferay.portal.portlet.bridge.soy.SoyPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import java.io.IOException;

/**
 * @author guedes
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=World Cup",
		"com.liferay.portlet.instanceable=false",
//		"com.liferay.portlet.single-page-application=false",
		"javax.portlet.display-name=Groups SOY",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=ListGroup",
		"javax.portlet.name=" + PortletPortletKeys.GroupsPortlet,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",

		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.application-type=full-page-application",
		"com.liferay.portlet.application-type=widget",
		"com.liferay.portlet.layout-cacheable=true",
		"com.liferay.portlet.preferences-owned-by-group=true",
		"com.liferay.portlet.private-request-attributes=false",
		"com.liferay.portlet.private-session-attributes=false",
		"com.liferay.portlet.render-weight=50",
		"javax.portlet.expiration-cache=0",
		"javax.portlet.init-param.copy-request-parameters=true"
	},
	service = Portlet.class
)
public class GroupsPortletPortlet extends SoyPortlet {

}