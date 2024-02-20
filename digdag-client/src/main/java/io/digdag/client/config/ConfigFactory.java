package io.digdag.client.config;

import java.io.IOException;
import javax.inject.Inject;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConfigFactory
{
    final ObjectMapper objectMapper;

    @Inject
    public ConfigFactory(ObjectMapper typeConverter)
    {
        this.objectMapper = typeConverter;
    }

    public Config create()
    {
        return new Config(objectMapper);
    }

    public Config create(Object other)
    {
        // System.out.println("ConfigFactory.java の createの中 =============");
        // System.out.println(other);// 展開されている
        return create().set("_", other).getNested("_");
    }

    public Config fromJsonString(String json)
    {
        System.out.println("ConfigFactory.java の fromJsonStringの中 =============");
        try {
            return new Config(objectMapper, objectMapper.readTree(json));
        }
        catch (IOException ex) {
            throw new ConfigException(ex);
        }
    }
}
