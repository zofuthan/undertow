package io.undertow.websockets.jsr;

import javax.websocket.Endpoint;
import javax.websocket.server.ServerEndpointConfig;

import io.undertow.servlet.api.InstanceFactory;

/**
 * @author Stuart Douglas
 */
public class ConfiguredServerEndpoint {

    private final ServerEndpointConfig endpointConfiguration;
    private final InstanceFactory<Endpoint> endpointFactory;
    private final PathTemplate pathTemplate;

    public ConfiguredServerEndpoint(final ServerEndpointConfig endpointConfiguration, final InstanceFactory<Endpoint> endpointFactory, final PathTemplate pathTemplate) {
        this.endpointConfiguration = endpointConfiguration;
        this.endpointFactory = endpointFactory;
        this.pathTemplate = pathTemplate;
    }

    public ServerEndpointConfig getEndpointConfiguration() {
        return endpointConfiguration;
    }

    public InstanceFactory<Endpoint> getEndpointFactory() {
        return endpointFactory;
    }

    public PathTemplate getPathTemplate() {
        return pathTemplate;
    }
}