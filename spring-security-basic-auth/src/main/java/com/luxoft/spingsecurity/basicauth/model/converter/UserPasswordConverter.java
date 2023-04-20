package com.luxoft.spingsecurity.basicauth.model.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Converter
public class UserPasswordConverter implements AttributeConverter<String, String> {
  private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

  @Override
  public String convertToDatabaseColumn(String attribute) {
    return encoder.encode(attribute);
  }

  @Override
  public String convertToEntityAttribute(String dbData) {
    return dbData;
  }
}
