package io.com.order.api.ordermanagement.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import io.com.order.api.ordermanagement.model.DBSequence;


@Component
/**
 * The SequenceGenerator class provides methods for generating unique sequence numbers.
 * @author abhis
 */
public class SequenceGenerator {
    /**
     * The MongoDB operations for accessing and modifying data.
     */
    @Autowired
    private MongoOperations mongoOperations;

    /**
     * Generates a sequence number for the given sequence name.
     * @param seqName The name of the sequence.
     * @return The generated sequence number.
     */
    public Long generateSequence(String seqName) {
        Query query = new Query(Criteria.where("id").is(seqName));
        Update update = new Update().inc("seqNo", 1);
        DBSequence counter = mongoOperations.findAndModify(query, update, options().returnNew(true).upsert(true),
                DBSequence.class);
        return !Objects.isNull(counter) ? counter.getSeqNo() : 1;
    }
}

