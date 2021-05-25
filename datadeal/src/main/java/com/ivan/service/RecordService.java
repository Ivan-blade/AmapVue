package com.ivan.service;

import com.ivan.pojo.Record;
import com.ivan.pojo.RecordInput;

import java.util.List;

/**
 * @author apple
 * @date 2021/5/8 下午12:03
 * @description
 */

public interface RecordService {

    List<Record> selectByIdAndTime(Record record);

    List<Record> selectById(String id);

    List<Record> selectByLimit(String id);

    List<Record> selectByDateAndTime(RecordInput recordInput);

    List<String> selectId();

}
