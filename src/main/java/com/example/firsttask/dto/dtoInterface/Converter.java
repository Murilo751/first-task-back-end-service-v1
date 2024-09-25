package com.example.firsttask.dto.dtoInterface;

public interface Converter {
    public GenericDTO convertFromEntity(GenericEntity entity);
    public GenericEntity convertFromDTO(GenericDTO DTO);
}
