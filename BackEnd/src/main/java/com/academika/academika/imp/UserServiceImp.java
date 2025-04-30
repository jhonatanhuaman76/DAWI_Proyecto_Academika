package com.academika.academika.imp;

import com.academika.academika.dto.user.UserRequestDTO;
import com.academika.academika.dto.user.UserResponseDTO;
import com.academika.academika.mapper.UserMapper;
import com.academika.academika.repository.UserRepository;
import com.academika.academika.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    //--------------------------------------

    @Override
    public List<UserResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    //--------------------------------------

    @Override
    public UserResponseDTO registrar(UserRequestDTO requestDTO) {
        return mapper.toDTO(repository.save(mapper.toEntity(requestDTO)));
    }

    //--------------------------------------

    //Métodos adicionales.
    //Obtener por id
    @Override
    public UserResponseDTO obtenerPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(()-> new RuntimeException("Usuario NO encontrado"));
    }

    //--------------------------------------

    //Eliminar
    @Override
    public void eliminar(Long id) {
    if(!repository.existsById(id)){
        throw new RuntimeException("No existe el Usuario con ID:  "+id);
    }
    repository.deleteById(id);

    }

    //--------------------------------------
    //Actualizar
    @Override
    public UserResponseDTO actualizar(Long id, UserRequestDTO requestDTO) {
        return repository.findById(id).map(usuarioExistente ->{
            /// Aquí solo estan los atributos que solo tiene permitida
            ///  una actualización.
            usuarioExistente.setNombre(requestDTO.getNombre());
            usuarioExistente.setFechaNac(requestDTO.getFechaNac());
            usuarioExistente.setEmail(requestDTO.getEmail());
            //Hacemos la actualización
          return mapper.toDTO(repository.save(usuarioExistente));
        }).orElseThrow(()-> new RuntimeException("No es encontró el Usuario con Id: "+id));
    }

    //--------------------------------------


} ///FIN DEL  [ UserServiceImp ]
