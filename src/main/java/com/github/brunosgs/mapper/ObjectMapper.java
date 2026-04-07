package com.github.brunosgs.mapper;

import com.github.brunosgs.data.dto.v1.PersonDTOV1;
import com.github.brunosgs.model.Person;
import com.github.brunosgs.serializer.GenderSerializer;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.github.dozermapper.core.loader.api.BeanMappingBuilder;

import java.util.ArrayList;
import java.util.List;

import static com.github.dozermapper.core.loader.api.FieldsMappingOptions.customConverter;
import static com.github.dozermapper.core.loader.api.TypeMappingOptions.oneWay;

public class ObjectMapper {
    private static final Mapper mapper = DozerBeanMapperBuilder.create().withMappingBuilder(new BeanMappingBuilder() {
        @Override
        protected void configure() {
            mapping(Person.class, PersonDTOV1.class, oneWay())
                    .fields("gender", "gender", customConverter(GenderSerializer.class));
        }
    }).build();

    public static <O, D> D parseObject(O origin, Class<D> destination) {
        return mapper.map(origin, destination);
    }

    public static <O, D> List<D> parseListObjects(List<O> origin, Class<D> destination) {
        List<D> destinationObjects = new ArrayList<>();

        for (Object o : origin) {
            destinationObjects.add(mapper.map(o, destination));
        }

        return destinationObjects;
    }
}
