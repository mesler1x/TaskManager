package edu.mesler.taskmanager.domain;

import edu.mesler.taskmanager.domain.common.BaseDomainEntity;

import edu.mesler.taskmanager.domain.user.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "task")
public class TaskEntity extends BaseDomainEntity {

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    UserEntity user;
}
