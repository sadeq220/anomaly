package model;



import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;
import java.util.Arrays;

@Documented
@Constraint(validatedBy = DBCheckValidator.class)
@Target( { ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface OccupiedInDB {

    //error message
   String message() default "Username Already Occupied";
    //represents group of constraints
     Class<?>[] groups() default {};
    //represents additional information about annotation
    Class<? extends Payload>[] payload() default {};
    String property() default "";
    Class<?> entity();
}
