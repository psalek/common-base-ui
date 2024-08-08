package edu.miu.common.ui.builders;

import edu.miu.common.ui.config.CommonUIConfiguration;
import edu.miu.common.ui.utils.CommonUtils;
import org.springframework.stereotype.Component;

@Component
public class StandardLayoutBuilder extends CommonLayoutBuilder<StandardLayoutBuilder> {

    public StandardLayoutBuilder(CommonUtils commonUtils, CommonUIConfiguration navbarConfiguration) {
        super(commonUtils, navbarConfiguration);
    }

    @Override
    public StandardLayoutBuilder initiateDefaults() {
        super.initiateDefaults();

        commonUtils.initiateDefaults(attributes);

        return this;
    }

}