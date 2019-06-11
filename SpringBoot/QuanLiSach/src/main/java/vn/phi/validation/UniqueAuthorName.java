package vn.phi.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueAuthorNameValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UniqueAuthorName {
    public String message() default "Tác giả đã tồn tại trong cơ sở dữ liệu";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default{};

}
