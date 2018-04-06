import Component from 'metal-component/src/Component';
import Soy from 'metal-soy/src/Soy';

import templates from './EditFoo.soy';

/**
 * Header Component
 */
class EditFoo extends Component {}

// Register component
Soy.register(EditFoo, templates);

export default EditFoo;