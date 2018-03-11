package exam_preparations.examIII.test.java.app.waste_disposal.fakeClassesForTests;

import b_recyclingStation.app.annotations.Disposable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Disposable
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface FakeDisposable {}
