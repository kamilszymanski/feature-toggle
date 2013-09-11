package pl.jug.warszawa.togglz.features;

import org.togglz.core.Feature;
import org.togglz.core.annotation.EnabledByDefault;
import org.togglz.core.annotation.InfoLink;
import org.togglz.core.annotation.Label;
import org.togglz.core.annotation.Owner;
import org.togglz.core.context.FeatureContext;

public enum FeatureToggle implements Feature {

    WJUG_FULL_NAME,

    @EnabledByDefault
    @Label("Show WJUG logo")
    @Owner("Duke")
    @InfoLink("http://warszawa.jug.pl")
    WJUG_LOGO;

    public boolean isActive() {
        return FeatureContext.getFeatureManager().isActive(this);
    }

}
