package org.lanqiao.test;

import java.util.Arrays;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CourseTest {
    MongoClient client = null;
    MongoDatabase db = null;

    @Before
    public void before(){
        // 连接 MongoDB 服务器的地址
        String uri = "mongodb://localhost:27017/?maxPoolSize=20&w=majority";
        // 根据 uri 获取 MongoClient 对象
        client = MongoClients.create(uri);
        // 获取（创建）指定的数据库对象 MongoDatabase
        db = client.getDatabase("lanqiao");
    }

    @After
    public void after(){
        // 关闭 MongoClient 对象
        client.close();
    }

    @Test
    public void findManyDocument(){
        // 获取集合对象
        MongoCollection<Document> col = db.getCollection("course");
        // 查询 员工编号为 “10002、10004、10006‘ 课程的 “课程编号、课程名称、老师”
        Bson pFields = Projections.fields(Projections.include("cno", "cname", "teacher"), Projections.excludeId());
        MongoCursor<Document> docs = col.find(Filters.in("cno",Arrays.asList("10002","10004","10006")))
                                        .projection(pFields).iterator();
        while (docs.hasNext()) {
            System.out.println(docs.next().toJson());
        }
        docs.close();
    }

    @Test
    public void findManyDocumentBySort(){
        // 获取集合对象
        MongoCollection<Document> col = db.getCollection("course");
        // 将教师为 “乔峰” 的课程信息查询出来并按课程编号降序排序。
        MongoCursor<Document> docs = col.find(Filters.eq("teacher","乔峰")).sort(Sorts.descending("cno")).iterator();
        while (docs.hasNext()) {
            System.out.println(docs.next().toJson());
        }
        docs.close();
    }

    @Test
    public void insertOneDocument(){
        // 获取集合对象
        MongoCollection<Document> col = db.getCollection("course");
        // 准备需要添加的数据信息
        Document document = new Document()
            .append("cno", "10008")
            .append("cname", "Linux 基础开发")
            .append("description", "这是Linux入门课程")
            .append("teacher", "李四");
        InsertOneResult result = col.insertOne(document);
        System.out.println("添加数据成功之后，返回新增的 _id：" + result.getInsertedId());

        // 获取新增的数据
        Document doc = col.find(Filters.in("cno", "10008")).first();
        System.out.println(doc);
    }

    @Test
    public void deleteOneDocument(){
        // 获取集合对象
        MongoCollection<Document> col = db.getCollection("course");

        DeleteResult result = col.deleteMany(Filters.in("cno", "10008"));

        System.out.println("删除数据影响的行数："+result.getDeletedCount());

        // 获取集合中所有的数据
        MongoCursor<Document> docs = col.find().iterator();

        while (docs.hasNext()) {
            System.out.println(docs.next().toJson());
        }
        docs.close();
    }
}