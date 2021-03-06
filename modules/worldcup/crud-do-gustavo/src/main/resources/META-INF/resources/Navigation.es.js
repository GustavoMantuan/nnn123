import Component from 'metal-component/src/Component';
import Footer from './Footer.es';
import Header from './EditFoo.es';
import Soy from 'metal-soy/src/Soy';
import templates from './Navigation.soy';

/**
 * Navigation Component
 */
class Navigation extends Component {}

// Register component
Soy.register(Navigation, templates);

export default Navigation;