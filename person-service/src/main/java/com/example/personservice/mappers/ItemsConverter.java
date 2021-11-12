package com.example.personservice.mappers;

import com.example.personservice.enums.Items;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class ItemsConverter implements AttributeConverter<Items, String> {
    @Override
    public String convertToDatabaseColumn(Items items) {
        if (items == null) {
            return null;
        }
        return items.getCode();
    }

    @Override
    public Items convertToEntityAttribute(String s) {
        if (s == null) {
            return null;
        }

        return Stream.of(Items.values())
                .filter(c -> c.getCode().equals(s))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

    }
}
