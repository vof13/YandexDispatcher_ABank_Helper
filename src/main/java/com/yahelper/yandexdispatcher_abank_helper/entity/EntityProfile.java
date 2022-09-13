package com.yahelper.yandexdispatcher_abank_helper.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table (name = "profiles")
public class EntityProfile {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    private String callsign;

    private String lastName;

    private String firstName;

    private String middleName;

    private String balance;
}
