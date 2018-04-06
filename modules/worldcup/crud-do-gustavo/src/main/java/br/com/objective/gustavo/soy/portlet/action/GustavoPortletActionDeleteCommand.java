package br.com.objective.gustavo.soy.portlet.action;

import br.com.objective.gustavo.soy.constants.GustavoPortletPortletKeys;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import objective.model.Foo;
import objective.service.FooLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;


@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + GustavoPortletPortletKeys.GustavoPortlet,
                "mvc.command.name=" + GustavoPortletViewMVCRenderCommand.MVC_ACTION_NAME,
        },
        service = MVCActionCommand.class
)
public class GustavoPortletActionDeleteCommand extends BaseMVCActionCommand {


    @Reference
    private volatile FooLocalService _fooLocalService;

    public FooLocalService getFooLocalService() { return _fooLocalService; }

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        addFoo(actionRequest, actionResponse);
    }

    public void addFoo(ActionRequest actionRequest,
                       ActionResponse actionResponse) throws IOException, PortletException {

        long grpId = ParamUtil.getLong(actionRequest, "fooId");

        try {
            String field1 = ParamUtil.getString(actionRequest, "field1");
            boolean field2 = ParamUtil.getBoolean(actionRequest, "field2");
            int field3 = ParamUtil.getInteger(actionRequest, "field3");
            Date field4 = ParamUtil.getDate(actionRequest, "field4",DateFormat.getDateInstance());

            String field5 = ParamUtil.getString(actionRequest, "field5");
            long fooId = CounterLocalServiceUtil.increment();

            Foo foo = getFooLocalService().createFoo(fooId);

            foo.setField1(field1);
            foo.setField2(field2);
            foo.setField3(field3);
            foo.setField4(field4);
            foo.setField5(field5);

            foo = getFooLocalService().addFoo(foo);

            if (foo != null){
                _log.info("Foo have been added successfylly");
            } else {
                _log.error("There is an Error in adding Foo");
            }

        }  catch (Exception e) {
            e.printStackTrace();
        }

}

    private static Log _log = LogFactoryUtil.getLog(GustavoPortletActionDeleteCommand.class);
}




