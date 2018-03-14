package com.usping.kdsn.mapper;

import com.usping.kdsn.bean.Transaction;

public interface TransactionMapper {

    /**
     * delete instance by offered transaction id
     * @param transactionId
     * @return
     */
    int deleteByPrimaryKey(Integer transactionId);

    /**
     * insert with full record
     * @param record
     * @return
     */
    int insert(Transaction record);

    /**
     * insert selective
     * @param record
     * @return
     */
    int insertSelective(Transaction record);

    /**
     * select by transaction id
     * @param transactionId
     * @return
     */
    Transaction selectByPrimaryKey(Integer transactionId);

    /**
     *update by primary key selective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Transaction record);
}