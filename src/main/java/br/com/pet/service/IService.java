package br.com.pet.service;

public interface IService<T> {
	
	public Object save(T t); 
	
	public Object update(Long id, T t); 
	
	public void delete(Long id); 
	
	public Object listAll(Integer page, Integer size);
	
}
