package pl.jug.warszawa.togglz;

import javax.faces.bean.ManagedBean;

import static pl.jug.warszawa.togglz.features.FeatureToggle.WJUG_FULL_NAME;

@ManagedBean
public class HelloBean {

    public String getName() {
        return WJUG_FULL_NAME.isActive() ? "Warsaw Java User Group" : "WJUG";
    }

}
