import Component from 'metal-component/src/Component';
import Soy from 'metal-soy/src/Soy';
import templates from './ListGroup.soy';

import Alert from 'meta-alert/src/Alert';
import Select from 'meta-select/src/Select';

/**
 * View Component
 */
class ListGroup extends Component {}

// Register component
Soy.register(ListGroup, templates);

export default ListGroup;