package com.usping.kdsn.mapper;

import com.usping.kdsn.bean.Transaction;
import org.springframework.dao.DataAccessException;

public interface TransactionMapper {

    /**
     * delete instance by offered transaction id
     *
     * @param transactionId
     * @return
     */
    int deleteByPrimaryKey(Integer transactionId) throws DataAccessException;

    /**
     * insert with full record
     *
     * @param record
     * @return
     */
    int insert(Transaction record) throws DataAccessException;

    /**
     * insert selective
     *
     * @param record
     * @return
     */
    int insertSelective(Transaction record) throws DataAccessException;

    /**
     * select by transaction id
     *
     * @param transactionId
     * @return
     */
    Transaction selectByPrimaryKey(Integer transactionId) throws DataAccessException;

    /**
     * update by primary key selective
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Transaction record) throws DataAccessException;
}