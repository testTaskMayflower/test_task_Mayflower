package com.vorkylele.config;

import org.aeonbits.owner.Config;

/**
 * <h3>Interface ProjectConfig - Getting data from default.properties</h3>
 *
 * @author A.Vikhlyantsev
 */


@Config.Sources({"classpath:default.properties"})
public interface ProjectConfig extends Config {

    @Key("base.uri")
    @DefaultValue("http://3.73.86.8:3333")
    String getBaseUriProperties();
}
