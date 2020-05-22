package com.example.demo.service;

import com.example.demo.entity.Game;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: gtli
 * Date: 2020-05-21
 * Time: 21:45
 * Description: No Description
 */
public interface GameService {

    List<Game> getGameList();

    boolean delGameById(String id);

    boolean addGame(Game game);

    boolean editGame(Game game);

    Game getGameById(String id);
}
