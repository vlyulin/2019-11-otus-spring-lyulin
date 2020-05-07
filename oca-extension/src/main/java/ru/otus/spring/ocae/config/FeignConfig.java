package ru.otus.spring.ocae.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.codec.Decoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.mediatype.hal.Jackson2HalModule;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

// import org.springframework.hateoas.mediatype.hal.Jackson2HalModule;

// import org.springframework.hateoas.mediatype.hal.Jackson2HalModule;

@Configuration
public class FeignConfig {

    @Bean
    public Decoder feignDecoder() {

        // SimpleModule module = new SimpleModule();
        // module.addDeserializer(StandardReceipt.class, new StandardReceiptDeserializer());
        ObjectMapper mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .registerModule(new Jackson2HalModule());

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(MediaType.parseMediaTypes("application/hal+json"));
        converter.setObjectMapper(mapper);

        // https://stackoverflow.com/questions/35853908/how-to-set-custom-jackson-objectmapper-with-spring-cloud-netflix-feign
        ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(converter);

        return new ResponseEntityDecoder(new SpringDecoder(objectFactory));
    }

//    @Bean
//    public Decoder feignDecoder() {
//
//        SimpleModule module = new SimpleModule();
//        module.addDeserializer(StandardReceipt.class, new StandardReceiptDeserializer());
//
//        ObjectMapper mapper = new ObjectMapper()
//                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
//                .registerModule( module); // new Jackson2HalModule());
//
//        return new ResponseEntityDecoder(new JacksonDecoder(mapper)); // new JacksonDecoder(mapper));
//    }

//    @Bean
//    public Decoder feignDecoder() {
//        ObjectMapper mapper = new ObjectMapper()
//                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true)
//                .registerModule(new Jackson2HalModule());
//
//        return new ResponseEntityDecoder(new JacksonDecoder(mapper));
//    }

//    @Bean
//    public MappingJackson2HttpMessageConverter halConverter(
//            @Autowired CurieProvider curieProvider,
//            @Autowired LinkRelationProvider linkRelationProvider
//    ) {
//        // CurieProvider curieProvider = CurieProvider();
//        // LinkRelationProvider relProvider = new DelegatingRelProvider(relProviderRegistry);
//        ObjectMapper halObjectMapper = new ObjectMapper();
//        halObjectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
//        halObjectMapper.registerModule(new Jackson2HalModule());
//        halObjectMapper.setHandlerInstantiator(new
//                Jackson2HalModule.HalHandlerInstantiator(linkRelationProvider, curieProvider, null));
//        MappingJackson2HttpMessageConverter halConverter = new
//                MappingJackson2HttpMessageConverter();
//        halConverter.setSupportedMediaTypes(Arrays.asList(MediaTypes.HAL_JSON));
//        halConverter.setObjectMapper(halObjectMapper);
//        return halConverter;
//    }
}
