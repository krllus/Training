package com.github.krllus.training.dagger

import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class GlobalScope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ModuleScope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ModuleScreenScope