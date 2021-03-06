package org.apereo.cas.config;

import org.apereo.cas.configuration.CasConfigurationProperties;
import org.apereo.cas.configuration.CasConfigurationPropertiesEnvironmentManager;
import org.apereo.cas.support.events.listener.CasConfigurationEventListener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This is {@link CasCoreEventsConfigEnvironmentConfiguration}.
 *
 * @author Misagh Moayyed
 * @since 5.1.0
 */
@Configuration("casCoreEventsConfigEnvironmentConfiguration")
@EnableConfigurationProperties(CasConfigurationProperties.class)
@Slf4j
public class CasCoreEventsConfigEnvironmentConfiguration {

    @Autowired
    @Qualifier("configurationPropertiesEnvironmentManager")
    private ObjectProvider<CasConfigurationPropertiesEnvironmentManager> manager;

    @ConditionalOnMissingBean(name = "casConfigurationEventListener")
    @Bean
    public CasConfigurationEventListener casConfigurationEventListener() {
        return new CasConfigurationEventListener(manager.getIfAvailable());
    }

}
