package com.ivan.controller;

import com.ivan.pojo.Record;
import com.ivan.pojo.RecordInput;
import com.ivan.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author apple
 * @date 2021/5/8 下午12:02
 * @description
 */

@RestController
@RequestMapping("/record")
public class RecordController {

    @Autowired
    RecordService recordService;

    @RequestMapping("/selectById/{id}")
    public List<Record> selectById(@PathVariable String id) {
        List<Record> records = recordService.selectById(id);
        // List<Record> records = recordService.selectByLimit(id);
        Collections.shuffle(records);
        return records.subList(0,1000);
    }

    @RequestMapping("/selectByIdAndTime")
    public List<Record> selectByIdAndTime(Record record) {
        List<Record> records = recordService.selectByIdAndTime(record);
        Collections.shuffle(records);
//        if(records == null) return null;
//        return records.get(0);
        List<Record> res = new ArrayList<>();
        if(records.size() <= 5) return records;
        for(int i = 0; i < 5;i++) {
            res.add(records.get(i));
        }
        return res;
    }

    @RequestMapping("/selectByDateAndTime")
    public List<Record> selectByDateAndTime(RecordInput recordInput) {
        List<Record> records = recordService.selectByDateAndTime(recordInput);
        return records;
    }

    @RequestMapping("/selectId")
    public List<String> selectId() {
        return recordService.selectId();
    }

    @RequestMapping("/selectRandom")
    public List<Record> selectRandom(String id) {
        List<Record> records = recordService.selectByLimit(id);
        
        Collections.shuffle(records);

        List<Record> res = new ArrayList<>();
        if(records.size() <= 5) return records;
        for(int i = 0; i < 5;i++) {
            res.add(records.get(i));
        }
        return res;
    }
}
