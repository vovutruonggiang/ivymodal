//package com.ivymodal.mapper;
//import com.ivymodal.entity.ProductVariant;
//import org.modelmapper.ModelMapper;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class BaseConversion<T,E> {
//
//    private final ModelMapper modelMapper;
//    private final Class<T> dtoClass;
//    private final Class<E> entityClass;
//
//    protected BaseConversion(Class<T> dtoClass, Class<E> entityClass) {
//        this.modelMapper = new ModelMapper(); // Khởi tạo trực tiếp ModelMapper
//        this.dtoClass = dtoClass;
//        this.entityClass = entityClass;
//    }
//
//    public T toDTO(E entity) {
//        return modelMapper.map(entity, dtoClass);
//    }
//
//    public E toEntity(T dto) {
//        return modelMapper.map(dto, entityClass);
//    }
//
//    public List<T> toDTOList(List<E> entities) {
//        return entities.stream()
//                .map(this::toDTO)
//                .collect(Collectors.toList());
//    }
//
//    public List<E> toEntityList(List<T> dtos) {
//        return dtos.stream()
//                .map(this::toEntity)
//                .collect(Collectors.toList());
//    }
//
//}
