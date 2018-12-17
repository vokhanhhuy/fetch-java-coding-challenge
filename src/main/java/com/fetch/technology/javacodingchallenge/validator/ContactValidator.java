package com.fetch.technology.javacodingchallenge.validator;

import com.fetch.technology.javacodingchallenge.entity.Contact;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Date;
import java.util.regex.Pattern;

@Component("beforeCreateContactValidator")
public class ContactValidator implements Validator {
    private static final Pattern EMAIl_PATTERN = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$");

    @Override
    public boolean supports(Class<?> aClass) {
        return Contact.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Contact contactEntity = (Contact) o;
        if (contactEntity.getEmailAddress() == null
            || !EMAIl_PATTERN.matcher(contactEntity.getEmailAddress()).matches()) {
            errors.rejectValue("emailAddress", "email not well-formed");
        }

        if (contactEntity.getBirthDate() != null && contactEntity.getBirthDate().after(new Date())) {
            errors.rejectValue("birthDate", "birth date is future date");
        }

    }
}
