;(function() {
	AUI().applyConfig(
		{
			groups: {
				'time-group': {
					base: MODULE_PATH + '/',
					combine: Liferay.AUI.getCombine(),
					modules: {
						'time-form-field': {
							condition: {
								trigger: 'liferay-ddm-form-renderer'
							},
							path: 'time_field.js',
							requires: [
								'liferay-ddm-form-renderer-field'
							]
						},
						'time-form-field-template': {
							condition: {
								trigger: 'liferay-ddm-form-renderer'
							},
							path: 'time.soy.js',
							requires: [
								'soyutils'
							]
						}
					},
					root: MODULE_PATH + '/'
				}
			}
		}
	);
})();