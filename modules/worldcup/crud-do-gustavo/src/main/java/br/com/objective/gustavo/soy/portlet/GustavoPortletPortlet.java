package br.com.objective.gustavo.soy.portlet;

import br.com.objective.gustavo.soy.constants.GustavoPortletPortletKeys;

import com.liferay.portal.portlet.bridge.soy.SoyPortlet;

import java.io.IOException;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author gustavo
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=CRUD",
		"com.liferay.portlet.instanceable=false",
		"com.liferay.portlet.single-page-application=true",
		"javax.portlet.display-name=Crud FOO - Gustavo",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=View",
		"javax.portlet.name=" + GustavoPortletPortletKeys.GustavoPortlet,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class GustavoPortletPortlet extends SoyPortlet {



}