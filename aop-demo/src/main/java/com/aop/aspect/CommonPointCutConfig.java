package com.aop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointCutConfig {

    @Pointcut("execution(* com.aop.service..*(..))")
    public void servicePackageConfig() {}

    @Pointcut("execution(* com.aop.repository..*(..))")
    public void repositoryPackageConfig() {}

    /*@Pointcut("execution(* com.aop..*(..))")
    public void serviceAndRepositoryPackageConfig() {}*/

    @Pointcut("com.aop.aspect.CommonPointCutConfig.servicePackageConfig() || " +
            "com.aop.aspect.CommonPointCutConfig.repositoryPackageConfig()")
    public void serviceAndRepositoryPackageConfig() {}

    // It intercepts any bean whose name contains the word Service.
    @Pointcut("bean(*Service*)")
    public void servicePackageConfigUsingBean() {}

}
