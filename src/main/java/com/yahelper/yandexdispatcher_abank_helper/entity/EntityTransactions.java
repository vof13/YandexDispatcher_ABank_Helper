package com.yahelper.yandexdispatcher_abank_helper.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table (name = "transactions")
@Getter
@Setter
public class EntityTransactions {
    @Id
    private String driverProfileId;

    private String categoryName;

    private String amount;
}
