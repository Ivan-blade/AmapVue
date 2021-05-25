package com.ivan.pojo;

import com.ivan.mapper.RecordMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
class DatadealApplicationTests {


    @Autowired
    private RecordMapper recordMapper;


//    @Test
    public void init() {
        // 根据Data文件夹路径遍历文件夹内所有文件:/Volumes/infomation/gitResource/wuhao/Geolife Trajectories 1.3/Data
        System.out.println("start...");
        File data = new File("/Volumes/infomation/gitResource/wuhao/Geolife Trajectories 1.3/Data");
        File[] files = data.listFiles();
        for (File file : files) {
            // 第一层遍历必定是文件夹，获取该文件夹名称并作为用户id，继续第二层遍历

            String id = file.getName();
            if(".DS_Store".equals(id)) continue;
            System.out.println("id: "+ id);
            File personal = new File(file.getAbsolutePath());
            // 判断遍历内容是否为名为Trajectory的目录，如果是进行第三层遍历
            File[] persons = personal.listFiles();
            for (File person : persons) {
                if("Trajectory".equals(person.getName()) && person.isDirectory()) {
                    File dataPackage = new File(person.getAbsolutePath());
                    File[] lastDatas = dataPackage.listFiles();
                    for (File lastData : lastDatas) {
                        try {

                            BufferedReader br = new BufferedReader(new FileReader(lastData.getAbsolutePath()));
                            String line = null;
                            int index = 1;
                            while( (line = br.readLine()) != null) {
                                index++;
                                if(index > 7) dataInsert(line,id);
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }


        // 在第三层遍历中将所有文件中第七行开始的数据保存到数据库中，提取数据格式如下
        // 39.984702,116.318417,0,492,39744.1201851852,2008-10-23,02:53:04
        // 经度，维度，0，高度，不标准时间,日期，时间
        // 删除0字段，加上id字段，值是文件名
    }

    public void dataInsert(String line,String id) {
        String pre = line.trim();
        String[] data = pre.split(",");
        Record record = new Record(id, data[0], data[1], data[3], data[5], data[6]);
        recordMapper.insert(record);
    }

    @Test
    public void select() {
        Record record = new Record();
        record.setId("000");
        record.setCurTime("00:00:00");
        List<Record> records = recordMapper.selectByIdAndTime(record);
        System.out.println(records);
    }

}
