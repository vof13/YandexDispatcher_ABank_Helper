package com.yahelper.yandexdispatcher_abank_helper.repository;

import com.yahelper.yandexdispatcher_abank_helper.entity.EntityTransactions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsRepository extends CrudRepository<EntityTransactions, String> {
}
