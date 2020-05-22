package com.example.demo.dao;

import com.example.demo.entity.Game;
import java.util.List;

public interface GameMapper {

    int deleteGameById(String id);

    int addGame(Game record);

    List<Game> selectAllGameList();

    int updateById(Game record);

    Game selectGameById(String id);
}