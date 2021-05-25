package com.ivan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author apple
 * @date 2021/5/25 下午3:07
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RecordInput {

    private String id;

    private String longitude;

    private String latitude;

    private String height;

    private String curDate;

    private String curTime;

    private String endTime;
}
