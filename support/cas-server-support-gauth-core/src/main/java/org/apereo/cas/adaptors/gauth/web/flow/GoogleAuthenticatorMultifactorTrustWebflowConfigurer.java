package org.apereo.cas.adaptors.gauth.web.flow;

import org.apereo.cas.configuration.CasConfigurationProperties;
import org.apereo.cas.web.flow.configurer.AbstractMultifactorTrustedDeviceWebflowConfigurer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;

/**
 * This is {@link GoogleAuthenticatorMultifactorTrustWebflowConfigurer}.
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@Slf4j
public class GoogleAuthenticatorMultifactorTrustWebflowConfigurer extends AbstractMultifactorTrustedDeviceWebflowConfigurer {

    private final FlowDefinitionRegistry flowDefinitionRegistry;

    public GoogleAuthenticatorMultifactorTrustWebflowConfigurer(final FlowBuilderServices flowBuilderServices,
                                                                final FlowDefinitionRegistry loginFlowDefinitionRegistry,
                                                                final boolean enableDeviceRegistration,
                                                                final FlowDefinitionRegistry flowDefinitionRegistry,
                                                                final ApplicationContext applicationContext,
                                                                final CasConfigurationProperties casProperties) {
        super(flowBuilderServices, loginFlowDefinitionRegistry, enableDeviceRegistration, applicationContext, casProperties);
        this.flowDefinitionRegistry = flowDefinitionRegistry;
    }

    @Override
    protected void doInitialize() {
        registerMultifactorTrustedAuthentication(this.flowDefinitionRegistry);
    }
}
