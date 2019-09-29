package be.ipeters.mbcrudweb;

import be.ipeters.mbcrudweb.dao.SysDateMapper;
import be.ipeters.mbcrudweb.entity.Actor;
import be.ipeters.mbcrudweb.mappers.ActorMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        MyBatisUtil myBatisUtil = new MyBatisUtil();
        SqlSession session = null;
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            session = sqlSessionFactory.openSession();
            SysDateMapper sdmapper = session.getMapper(SysDateMapper.class);
            Date date = sdmapper.getCurrentDateAndTime();
            System.out.println("output= " + date.toString());
            ActorMapper actorMapper = session.getMapper(ActorMapper.class);
            List<Actor> allActors = actorMapper.getAllActors();
            for (Actor actor:allActors)
            {
                System.out.println(actor.toString());
            }
            Actor actor = actorMapper.getActorById(1);
            System.out.println("Actor 1: "+ actor.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {    // Always close session if no longer needed
            if (session != null) {
                session.close();
            }
        }

    }
}
