package br.com.objective.worldcup.soy.portlet.action;

import br.com.objective.worldcup.model.Group;
import br.com.objective.worldcup.service.GroupLocalService;
import br.com.objective.worldcup.soy.constants.PortletPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + PortletPortletKeys.GroupsPortlet,
                "mvc.command.name=" + GroupsPortletDeleteMVCActionCommand.MVC_ACTION_NAME,
        },
        service = MVCActionCommand.class
)
public class GroupsPortletDeleteMVCActionCommand extends BaseMVCActionCommand {

    public static final String MVC_ACTION_NAME = "DeleteGroup";

    @Reference
    private volatile GroupLocalService _groupLocalService;

    public GroupLocalService getGroupLocalService() { return _groupLocalService; }

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        deleteGroup(actionRequest);
    }

    protected void deleteGroup(ActionRequest actionRequest) throws Exception {
        long grpId = ParamUtil.getLong(actionRequest, "grpId");

        getGroupLocalService().deleteGroup(grpId);
    }

}
