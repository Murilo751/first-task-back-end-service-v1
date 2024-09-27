package com.example.firsttask.dtoEntity;

import com.example.firsttask.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String password;

//    public User toDomain() {
//        return new User(name, email, password);
//    }
//
//    public static UserDTO fromDomain(User user) {
//        return new UserDTO(user.getName(), user.getEmail(), user.getPassword());
//    }


}
