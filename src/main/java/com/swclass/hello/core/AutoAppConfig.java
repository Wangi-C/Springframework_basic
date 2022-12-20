package com.swclass.hello.core;

import com.swclass.hello.core.member.MemberRepository;
import com.swclass.hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "com.swclass.hello.core.member",
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
//scan 범위를 지정하지 않으면 default로 현재 class의 Package(com.swclass.hello.core)하위의 class를 스캔
//메인 실행 class - HeeloSpringApplication의 @SpringBootApplication이 기본적으로
//ComponentScan 을 해준다.(최상단에서)
/**
 * 컴포넌트 스캔 기본 대상
 * Component, Controller, Service, Repository, Configuration
 * **/
public class AutoAppConfig {
}
