package be.ipeters.mbcrudweb.mappers;


import be.ipeters.mbcrudweb.entity.Actor;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ActorMapper {

    @Insert("INSERT INTO ACTOR(first_name, last_name, last_update) VALUES(#{firstName},#{lastName}, #{lastUpdate})")
    @Options(useGeneratedKeys=true, keyProperty="actorId")
    public void insertActor(Actor actor);

    @Select("SELECT actor_id AS actorId, first_name as firstName, last_name as lastName, last_update as lastUpdate FROM ACTOR WHERE actor_id=#{actorId}")
    public Actor getActorById(Integer actorId);

    @Select("SELECT * FROM ACTOR ")
    @Results({
            @Result(id=true, property="actorId", column="actor_id"),
            @Result(property="firstName", column="first_name"),
            @Result(property="lastName", column="last_name"),
            @Result(property="lastUpdate", column="last_update")
    })
    public List<Actor> getAllActors();

    @Update("UPDATE ACTOR SET first_name=#{firstName}, last_name=#{lastName}, last_update=#{lastUpdate} WHERE actor_id=#{actorId}")
    public void updateACTOR(Actor actor);

    @Delete("DELETE FROM ACTOR WHERE actor_id=#{actorId}")
    public void deleteActor(Integer actorId);
}
