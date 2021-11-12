package com.example.personservice.mappers;

import com.example.personservice.enums.Profile;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class ProfileConverter implements AttributeConverter<Profile, String> {

    @Override
    public String convertToDatabaseColumn(Profile category) {
        if (category == null) {
            return null;
        }
        return category.getCode();
    }

    @Override
    public Profile convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(Profile.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}