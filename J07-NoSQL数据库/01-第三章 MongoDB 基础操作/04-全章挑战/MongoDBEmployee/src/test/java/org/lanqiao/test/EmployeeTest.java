package org.lanqiao.test;

import java.util.Arrays;
import java.util.List;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertManyResult;
import com.mongodb.client.result.UpdateResult;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmployeeTest {
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
    public void findThreeDocument(){
        // 获取集合对象
        MongoCollection<Document> col = db.getCollection("employee");
        // 查询 sid 为 1006、1008、1010 的员工信息
        MongoCursor<Document> docs = col.find(Filters.in("sid", Arrays.asList("1006","1008","1010"))).iterator();
        while (docs.hasNext()) {
            System.out.println(docs.next().toJson());
        }
        docs.close();
    }

    @Test
    public void findOneDocument(){
        // 获取集合对象
        MongoCollection<Document> col = db.getCollection("employee");
        // 查询 年龄最大的员工的 姓名、年龄、地址 
        Bson pFields = Projections.fields(Projections.include("sname", "age", "address"), Projections.excludeId());
        Document doc = col.find().projection(pFields).sort(Sorts.descending("age")).first();
        System.out.println(doc);
    }

    @Test
    public void findManyDocument(){
        // 获取集合对象
        MongoCollection<Document> col = db.getCollection("employee");
        // 查询所有的男员工信息并按年龄升序排序
        MongoCursor<Document> docs = col.find(Filters.eq("gender","male")).sort(Sorts.ascending("age")).iterator();
        while (docs.hasNext()) {
            System.out.println(docs.next().toJson());
        }
        docs.close();
    }

    @Test
    public void insertManyDocument(){
        // 获取集合对象
        MongoCollection<Document> col = db.getCollection("employee");
        // 准备需要添加的数据信息
        List<Document> lists = Arrays.asList(
            new Document().append("sid", "1011")
            .append("sname", "xiaolan")
            .append("age", 40)
            .append("gender", "female")
            .append("phone", "13988642087")
            .append("address", Arrays.asList(new Document().append("city", "HangZhou").append("district", "yuhang"))),
            new Document().append("sid", "1012")
            .append("sname", "yunke")
            .append("age", 30)
            .append("gender", "male")
            .append("phone", "13988642088")
            .append("address", Arrays.asList(new Document().append("city", "HangZhou").append("district", "yuhang"))));
        // 添加文档信息
        InsertManyResult result = col.insertMany(lists);
        System.out.println("添加数据成功之后，返回新增的 _id：" + result.getInsertedIds());

        // 获取新增的数据
        MongoCursor<Document> docs = col.find(Filters.in("sid", Arrays.asList("1011","1012"))).iterator();

        while (docs.hasNext()) {
            System.out.println(docs.next().toJson());
        }
        docs.close();
    }

    @Test
    public void updateDocument(){
        // 获取集合对象
        MongoCollection<Document> col = db.getCollection("employee");

        // 更新文档信息
        Bson query = Filters.eq("sid",  "1005");  //查询条件
        // 设置需要修改的内容
        Bson updates = Updates.combine(
            Updates.set("age", 30),
            Updates.set("address", Arrays.asList(new Document().append("city", "BeiJing").append("district", "chaoyang"))));
        UpdateResult result = col.updateOne(query, updates);

        System.out.println("修改数据影响的行数："+result.getModifiedCount());
        // 获取集合中更新的数据
        Document document = col.find(Filters.eq("sid", "1005")).first();

        System.out.println(document);
    }

    @Test
    public void deleteManyDocument(){
        // 获取集合对象
        MongoCollection<Document> col = db.getCollection("employee");

        DeleteResult result = col.deleteMany(Filters.in("sid", Arrays.asList("1011","1012")));

        System.out.println("删除数据影响的行数："+result.getDeletedCount());

        // 获取集合中所有的数据
        MongoCursor<Document> docs = col.find().iterator();

        while (docs.hasNext()) {
            System.out.println(docs.next().toJson());
        }
        docs.close();
    }



}