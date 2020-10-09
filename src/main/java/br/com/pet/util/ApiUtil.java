package br.com.pet.util;

import java.util.Objects;

import org.springframework.data.domain.PageRequest;

public class ApiUtil {

	public static PageRequest PageRequest(Integer page, Integer size) {
		return PageRequest.of(Objects.isNull(page) ? 0 : page , Objects.isNull(size) ? 20 : size);	
	}
}
