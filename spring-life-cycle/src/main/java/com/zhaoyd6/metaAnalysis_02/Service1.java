package com.zhaoyd6.metaAnalysis_02;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Lazy
@Primary
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Service1 {
}
