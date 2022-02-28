package org.lanqiao.test;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-redis.xml")
public class SpringRedisTest {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void getAllMovieList(){
      List<String> movies = redisTemplate.opsForList().range("movie", 0, -1);
        movies.forEach(m -> System.out.println(m));  
    }

    @Test
    public void insertMovieToRightList(){
        long l = redisTemplate.opsForList().rightPush("movie", "肖生克的救赎");
        System.out.println( l>0 ? "添加成功":"添加失败");
        List<String> movies = redisTemplate.opsForList().range("movie", 0, -1);
        movies.forEach(m -> System.out.println(m));
    }

    @Test
    public void updateMovieList(){
        redisTemplate.opsForList().set("movie",1, "八佰");
        List<String> movies = redisTemplate.opsForList().range("movie", 0, -1);
        movies.forEach(m -> System.out.println(m));
    }


    @Test
    public void deleteActorFromZSet(){
        long l = redisTemplate.opsForZSet().remove("actor", "贾玲");
        System.out.println( l>0 ? "删除成功":"删除失败");
        Set<TypedTuple<String>> actors = redisTemplate.opsForZSet().rangeWithScores("actor", 0, -1);
        actors.forEach(a -> System.out.println(a.getValue()+":"+a.getScore()));
    }



}