package az.semmed.mapper;

public interface EntityMapper<T, E> {
    T toEntity(E e);

    E toDto(T t);
}
