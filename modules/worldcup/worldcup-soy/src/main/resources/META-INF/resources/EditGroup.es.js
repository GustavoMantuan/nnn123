import Component from 'metal-component/src/Component';
import Soy from 'metal-soy/src/Soy';
import templates from './EditGroup.soy';

class EditGroup extends Component {}

// Register component
Soy.register(EditGroup, templates);

export default EditGroup;