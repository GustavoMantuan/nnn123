package time.form.field;

import com.liferay.dynamic.data.mapping.form.field.type.BaseDDMFormFieldType;
import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldType;

import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldTypeSettings;
import org.osgi.service.component.annotations.Component;

/**
 * @author guedes
 */
@Component(
	immediate = true,
	property = {
		"ddm.form.field.type.display.order:Integer=9",
		"ddm.form.field.type.icon=time",
		"ddm.form.field.type.js.class.name=Liferay.DDM.Field.Time",
		"ddm.form.field.type.js.module=time-form-field",
		"ddm.form.field.type.label=time-label",
		"ddm.form.field.type.name=Time"
	},
	service = DDMFormFieldType.class
)
public class TimeDDMFormFieldType extends BaseDDMFormFieldType {

	@Override
	public Class<? extends DDMFormFieldTypeSettings>
	getDDMFormFieldTypeSettings() {

		return TimeDDMFormFieldTypeSettings.class;
	}

	@Override
	public String getName() {
		return "Time";
	}

}