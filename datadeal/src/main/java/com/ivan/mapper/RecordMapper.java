package com.ivan.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ivan.pojo.Record;
import com.ivan.pojo.RecordInput;

import java.util.List;

/**
 * @author apple
 * @date 2021/5/7 下午9:13
 * @description
 */

public interface RecordMapper extends BaseMapper<Record> {

    List<Record> selectByIdAndTime(Record record);

    List<Record> selectLimit(String id);

    List<Record> selectByDateAndTime(RecordInput recordInput);

    List<String> selectId();
}
