package io.com.payment.api.paymentmanagement.service;

import io.com.payment.api.paymentmanagement.model.DBSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;


@Component
public class SequenceGenerator {
    @Autowired
    private MongoOperations mongoOperations;

    public Long generateSequence(String seqName) {
        Query query = new Query(Criteria.where("id").is(seqName));
        Update update = new Update().inc("seqNo", 1);
        DBSequence counter = mongoOperations.findAndModify(query, update, options().returnNew(true).upsert(true),
                DBSequence.class);
        return !Objects.isNull(counter) ? counter.getSeqNo() : 1;
    }
}
