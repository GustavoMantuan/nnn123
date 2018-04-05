package br.com.objective.worldcup.soy.portlet.action;

import com.objective.worldcup.model.Group;
import com.objective.worldcup.service.GroupLocalService;
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
                "mvc.command.name=" + GroupsPortletCreateMVCActionCommand.MVC_ACTION_NAME,
        },
        service = MVCActionCommand.class
)
public class GroupsPortletCreateMVCActionCommand extends BaseMVCActionCommand {

    public static final String MVC_ACTION_NAME = "CreateGroup";

    @Reference
    private volatile GroupLocalService _groupLocalService;

    public GroupLocalService getGroupLocalService() { return _groupLocalService; }

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        updateGroup(actionRequest);
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
