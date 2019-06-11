package vn.phi.validation;

import java.lang.annotation.*;
import javax.validation.*;

@Constraint(validatedBy = UniqueBookNameValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface UniqueBookName {
    public String message() default "Sách đã tồn tại trong cơ sở dữ liệu";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default{};
}
