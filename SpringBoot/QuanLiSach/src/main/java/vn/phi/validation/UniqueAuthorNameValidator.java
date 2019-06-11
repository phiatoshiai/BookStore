package vn.phi.validation;

import org.springframework.beans.factory.annotation.Autowired;
import vn.phi.repository.AuthorRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueAuthorNameValidator implements ConstraintValidator<UniqueAuthorName, String> {
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void initialize(UniqueAuthorName constraintAnnotation) {

    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        if(authorRepository == null){
            return true;
        }
        return authorRepository.countAllByName(name)<1;
    }
}
