package pl.jug.warszawa.togglz.web;

import org.junit.Rule;
import org.junit.Test;
import org.togglz.junit.TogglzRule;
import pl.jug.warszawa.togglz.HelloBean;
import pl.jug.warszawa.togglz.features.FeatureToggle;

import static org.junit.Assert.assertEquals;

public class HelloBeanTest {

    @Rule
    public TogglzRule togglzRule = TogglzRule.allDisabled(FeatureToggle.class);

    private HelloBean helloBean = new HelloBean();

    @Test
    public void wjugFullNameFeatureDisabled() {
        assertEquals("WJUG", helloBean.getName());
    }

    @Test
    public void wjugFullNameFeatureEnabled() {
        togglzRule.enable(FeatureToggle.WJUG_FULL_NAME);

        assertEquals("Warsaw Java User Group", helloBean.getName());
    }

}
