package com.example.demo.service.impl;

import com.example.demo.dao.GameMapper;
import com.example.demo.entity.Game;
import com.example.demo.service.GameService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: gtli
 * Date: 2020-05-22
 * Time: 09:10
 * Description: No Description
 */
@Service
public class gameServiceImpl implements GameService {

    @Resource
    private GameMapper gameMapper;

    @Override
    public List<Game> getGameList() {
        return gameMapper.selectAllGameList();
    }

    @Override
    public boolean delGameById(String id) {
        int result = gameMapper.deleteGameById(id);
        if (result > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean addGame(Game game) {
        Game addGame = new Game();
        String id = UUID.randomUUID().toString();
        BeanUtils.copyProperties(game, addGame);
        addGame.setId(id);
        int result = gameMapper.addGame(addGame);
        if (result > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean editGame(Game game) {
        int result = gameMapper.updateById(game);
        if (result > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Game getGameById(String id) {
        return gameMapper.selectGameById(id);
    }
}
