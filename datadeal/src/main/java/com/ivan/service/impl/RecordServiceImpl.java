package com.ivan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ivan.mapper.RecordMapper;
import com.ivan.pojo.Record;
import com.ivan.pojo.RecordInput;
import com.ivan.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author apple
 * @date 2021/5/8 下午12:03
 * @description
 */
@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordMapper recordMapper;

    @Override
    public List<Record> selectByIdAndTime(Record record) {
        return recordMapper.selectByIdAndTime(record);
    }

    @Override
    public List<Record> selectById(String id) {

        // 条件构造器
        QueryWrapper<Record> wrapper = new QueryWrapper<>();

        Map<String,Object> map = new HashMap<>();
        map.put("id",id);

        wrapper.allEq(map);

        List<Record> records = recordMapper.selectList(wrapper);
        return records;
    }

    @Override
    public List<Record> selectByLimit(String id) {
        return recordMapper.selectLimit(id);
    }

    @Override
    public List<Record> selectByDateAndTime(RecordInput recordInput) {
        return recordMapper.selectByDateAndTime(recordInput);
    }

    @Override
    public List<String> selectId() {
        return recordMapper.selectId();
    }



}
