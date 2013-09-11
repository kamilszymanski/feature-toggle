package pl.jug.warszawa.togglz.features;

import org.togglz.core.Feature;
import org.togglz.core.manager.TogglzConfig;
import org.togglz.core.repository.StateRepository;
import org.togglz.core.repository.cache.CachingStateRepository;
import org.togglz.core.repository.file.FileBasedStateRepository;
import org.togglz.core.user.FeatureUser;
import org.togglz.core.user.SimpleFeatureUser;
import org.togglz.core.user.UserProvider;

import java.io.File;

public class TogglzConfiguration implements TogglzConfig {

    @Override
    public Class<? extends Feature> getFeatureClass() {
        return FeatureToggle.class;
    }

    @Override
    public StateRepository getStateRepository() {
        FileBasedStateRepository fileRepository = new FileBasedStateRepository(
                new File("/tmp/features.properties"));
        return new CachingStateRepository(fileRepository);
    }

    @Override
    public UserProvider getUserProvider() {
        return new UserProvider() {
            @Override
            public FeatureUser getCurrentUser() {
                boolean featureAdmin = true;
                return new SimpleFeatureUser("Duke", featureAdmin);
            }
        };
    }

}
