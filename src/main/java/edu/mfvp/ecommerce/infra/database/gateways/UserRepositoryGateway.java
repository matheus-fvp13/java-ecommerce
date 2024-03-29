package edu.mfvp.ecommerce.infra.database.gateways;

import edu.mfvp.ecommerce.application.gateways.UserGateway;
import edu.mfvp.ecommerce.domain.entities.User;
import edu.mfvp.ecommerce.domain.exception.DataBaseException;
import edu.mfvp.ecommerce.domain.exception.ResourceNotFoundException;
import edu.mfvp.ecommerce.infra.database.entities.UserEntity;
import edu.mfvp.ecommerce.infra.database.repositories.UserRepository;
import org.hibernate.sql.Update;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserRepositoryGateway implements UserGateway {

    private final UserRepository userRepository;

    public UserRepositoryGateway(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll().stream().map(UserEntity::toUser).collect(Collectors.toList());
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id)).toUser();
    }

    @Override
    public User create(User user) {
        return userRepository.save(UserEntity.fromUser(user)).toUser();
    }

    @Override
    public void delete(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(e.getCause().getMessage());
        }
    }

    @Override
    public User update(User user) {
        if (userRepository.existsById(user.getId())) {
            UserEntity userEntity = userRepository.getReferenceById(user.getId());
            updateUserEntity(userEntity, user);
            return userEntity.toUser();
        } else {
            throw new ResourceNotFoundException(user.getId());
        }
    }

    private void updateUserEntity(UserEntity entity, User user) {
        entity.setFirstName(user.getFirstName());
        entity.setLastName(user.getLastName());
        entity.setEmail(user.getEmail());
        if (user.getPhone() != null) {
            entity.setPhone(user.getPhone());
        }
    }
}
