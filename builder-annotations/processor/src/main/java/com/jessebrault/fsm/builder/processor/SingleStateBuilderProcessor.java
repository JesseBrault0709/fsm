package com.jessebrault.fsm.builder.processor;

import com.google.auto.service.AutoService;
import com.jessebrault.fsm.builder.annotations.SingleStateBuilder;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import java.util.Set;

@AutoService(Processor.class)
@SupportedSourceVersion(SourceVersion.RELEASE_18)
@SupportedAnnotationTypes("com.jessebrault.fsm.builder.annotations.SingleStateBuilder")
public final class SingleStateBuilderProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (final var annotation : annotations) {
            for (final var element : annotation.getEnclosedElements()) {

            }
        }
        for (final var element : roundEnv.getElementsAnnotatedWith(SingleStateBuilder.class)) {

            if (element instanceof TypeElement te) {

            }
        }
        return false;
    }

}
