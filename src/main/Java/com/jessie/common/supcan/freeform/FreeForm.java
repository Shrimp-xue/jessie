package com.jessie.common.supcan.freeform;

import com.jessie.common.supcan.common.Common;
import com.jessie.common.supcan.common.properties.Properties;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 硕正FreeForm
 *
 */
@XStreamAlias("FreeForm")
public class FreeForm extends Common {

    public FreeForm() {
        super();
    }

    public FreeForm(Properties properties) {
        this();
        this.properties = properties;
    }

}
