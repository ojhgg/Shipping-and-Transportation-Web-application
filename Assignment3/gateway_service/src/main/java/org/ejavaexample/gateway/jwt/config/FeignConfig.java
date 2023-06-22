package org.ejavaexample.gateway.jwt.config;

import java.util.stream.Collectors;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import com.fasterxml.jackson.databind.ObjectMapper;

import feign.codec.Decoder;

@Configuration
@EnableFeignClients
public class FeignConfig {

//	@Bean
//	public Decoder feignDecoder() {
//
//	        ObjectFactory<HttpMessageConverters> messageConverters = () -> {
//	            HttpMessageConverters converters = new HttpMessageConverters();
//	            return converters;
//	        };
//	        return new SpringDecoder(messageConverters);
//	    }
//	
//	@Bean
//	public ObjectMapper customObjectMapper() {
//		return new ObjectMapper();
//	}

	  
    @Bean
    @ConditionalOnMissingBean
    public HttpMessageConverters messageConverters(ObjectProvider<HttpMessageConverter<?>> converters) {
          
   
        return new HttpMessageConverters(converters.orderedStream().collect(Collectors.toList()));
    }
	/*@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}*/
}
