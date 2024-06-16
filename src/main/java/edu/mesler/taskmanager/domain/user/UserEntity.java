package edu.mesler.taskmanager.domain.user;

import edu.mesler.taskmanager.domain.TaskEntity;
import edu.mesler.taskmanager.domain.common.BaseDomainEntity;
import org.springframework.security.core.userdetails.UserDetails;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Type;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Getter
@Setter
@Entity
@Table(name = "user_info")
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class UserEntity extends BaseDomainEntity implements UserDetails {
    String username;
    String password;
    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    Set<UserRole> authorities;
    @OneToMany(mappedBy = "user")
    List<TaskEntity> tasks;
    boolean accountNonExpired;
    boolean credentialsNonExpired;
    boolean enabled;
    boolean accountNonLocked;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity user = (UserEntity) o;
        return id != null && id.equals(user.getId());
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
