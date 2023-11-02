package org.example;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;
import com.fasterxml.jackson.databind.jsontype.impl.TypeIdResolverBase;
import com.fasterxml.jackson.databind.type.TypeFactory;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String json = "{\"id\":\"1\", \"name\":\"asd\", \"partnerType\":\"220\", \"communityClass\":\"1\"}";
        ObjectMapper mapper = new ObjectMapper();
        Partner partner = mapper.readValue(json, Partner.class);
        System.out.println(partner);
    }

    @NoArgsConstructor
    public class PartnerTypeIdResolver extends TypeIdResolverBase {
        private JavaType superType;

        @Override
        public void init(JavaType baseType) {
            superType = baseType;
        }

        @Override
        public String idFromValue(Object value) {
            return null;
        }

        @Override
        public String idFromValueAndType(Object value, Class<?> suggestedType) {
            return null;
        }

        @Override
        public JsonTypeInfo.Id getMechanism() {
            return null;
        }

        @Override
        public JavaType typeFromId(DatabindContext context, String id) throws IOException {
            char c = id.charAt(0);
            Class<?> subType = null;
            switch (c) {
                case '1':
                    subType = Person.class;
                    break;
                case '2':
                    subType = Community.class;
                    break;
                case '3':
                    subType = Organization.class;
                    break;
                default:
                    throw new RuntimeException("Invalid Partner type");
            }
            return context.constructSpecializedType(superType, subType);
        }
    }

    @Data
    @JsonTypeInfo(use = JsonTypeInfo.Id.CUSTOM, include = JsonTypeInfo.As.PROPERTY, property = "partnerType")
    @JsonTypeIdResolver(PartnerTypeIdResolver.class)
    class Partner {
        private Long id;
        private String name;
        private Integer partnerType;
    }

    @Data
    class Person extends Partner {
        private Integer personClass;
    }

    @Data
    class Community extends Partner {
        private Integer communityClass;
    }

    @Data
    class Organization extends Partner {
        private Integer organisationClass;
    }

}