import geb.Browser
import geb.binding.BindingUpdater
import pages.user.HomePage

import static cucumber.api.groovy.Hooks.After
import static cucumber.api.groovy.Hooks.Before

Before () {
    bindingUpdater = new BindingUpdater (binding, new Browser ())
    bindingUpdater.initialize ()

    to HomePage
}

After () {
    bindingUpdater.remove ()
}