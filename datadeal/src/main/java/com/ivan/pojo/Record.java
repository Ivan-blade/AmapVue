package com.ivan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

/**
 * @author apple
 * @date 2021/5/7 下午7:34
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Record {

    // id,longitude，latitude，height,date,time
    private String id;

    private String longitude;

    private String latitude;

    private String height;

    private String curDate;

    private String curTime;


}
