package pl.mcx.vacationplanner.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mcx.vacationplanner.Exceptions.UserNotFoundException;
import pl.mcx.vacationplanner.dto.user.UserCreationRequest;
import pl.mcx.vacationplanner.dto.user.UserDto;
import pl.mcx.vacationplanner.dto.user.UserShortDto;
import pl.mcx.vacationplanner.dto.user.UserUpadateRequest;
import pl.mcx.vacationplanner.entity.User;
import pl.mcx.vacationplanner.repository.main.UserRepository;

import static java.util.Optional.ofNullable;

@Service
@Slf4j
public class UserServiceImpl implements  UserService {

       private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Long create(UserCreationRequest userCreationRequest){
        return userRepository.save(userCreationRequest.toUser()).getId();
    }

    @Override
    public Long update(UserUpadateRequest userUpadateRequest){
        User user = userRepository.getOne(userUpadateRequest.getId());
        fillUserUpdatableFields(userUpadateRequest, user);
        return userRepository.save(user).getId();
    }

    @Override
    public UserDto getUserByUserName(String username){
        return userRepository.findFirstByUserName(username).toDto();
    }

    @Override
    public UserDto UserGetUserById(Long userId) throws UserNotFoundException {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("No found user with member with id:" + userId))
                .toDto();
    }

    @Override
    public Page<UserDto> getShortUsersByManagerId(Long managerId, Pageable pageable){
        return userRepository.findAllByManagerId(managerId ,pageable)
                .map(User::toDto);
    }

    @Override
    public Page<UserShortDto> getShortUsers(Pageable pageable){
        return userRepository.findAll(pageable).map(User::toShortDto);
    }

    @Override
    public Page<UserDto> getUsers(Pageable pageable){
        return userRepository.findAll(pageable).map(User::toDto);
    }

    private void fillUserUpdatableFields(UserUpadateRequest userUpadateRequest, User user) {
        ofNullable(userUpadateRequest.getEmail()).ifPresent(user::setEmail);
        ofNullable(userUpadateRequest.getManagerId()).ifPresent(user::setManagerId);
        ofNullable(userUpadateRequest.getUserName()).ifPresent(user::setUserName);
        ofNullable(userUpadateRequest.getUserRole()).ifPresent(user::setUserRole);
    }

}
