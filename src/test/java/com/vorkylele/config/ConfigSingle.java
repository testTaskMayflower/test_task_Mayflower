package com.vorkylele.config;

import org.aeonbits.owner.ConfigFactory;

/**
 * <h3>Class ConfigSingle - initializing the config</h3>
 *
 * @author A.Vikhlyantsev
 */

public class ConfigSingle {

    public static ProjectConfig config = ConfigFactory.create(ProjectConfig.class);

}
