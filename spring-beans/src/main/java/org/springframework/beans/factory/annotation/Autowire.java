/*
 * Copyright 2002-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.beans.factory.annotation;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;

/**
 * Enumeration determining autowiring status: that is, whether a bean should
 * have its dependencies automatically injected by the Spring container using
 * setter injection. This is a core concept in Spring DI.
 * 枚举确定自动装配状态：即，一个 bean 是否应该使用 setter 注入由 Spring 容器自动注入其依赖项。 这是 Spring DI 中的一个核心概念。
 *
 * <p>Available for use in annotation-based configurations, such as for the
 * AspectJ AnnotationBeanConfigurer aspect.
 * 可用于基于注解的配置，例如 AspectJ AnnotationBeanConfigurer 方面。
 *
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @since 2.0
 * @see org.springframework.beans.factory.annotation.Configurable
 * @see org.springframework.beans.factory.config.AutowireCapableBeanFactory
 */
public enum Autowire {

	/**
	 * Constant that indicates no autowiring at all.
	 * 表示根本没有自动装配的常量。
	 */
	NO(AutowireCapableBeanFactory.AUTOWIRE_NO),

	/**
	 * Constant that indicates autowiring bean properties by name.
	 * 按名称指示自动装配 bean 属性的常量。
	 */
	BY_NAME(AutowireCapableBeanFactory.AUTOWIRE_BY_NAME),

	/**
	 * Constant that indicates autowiring bean properties by type.
	 * 按类型指示自动装配 bean 属性的常量。
	 */
	BY_TYPE(AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE);


	private final int value;


	Autowire(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	/**
	 * Return whether this represents an actual autowiring value.
	 * 返回这是否代表实际的自动装配值。
	 * @return whether actual autowiring was specified 是否指定了实际的自动装配（BY_NAME 或 BY_TYPE）
	 * (either BY_NAME or BY_TYPE)
	 */
	public boolean isAutowire() {
		return (this == BY_NAME || this == BY_TYPE);
	}

}
