package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Game;
import com.example.demo.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: gtli
 * Date: 2020-05-22
 * Time: 09:19
 * Description: GameController
 */
@Controller
@RequestMapping("/game")
public class GameController extends BaseController {

    @Autowired
    private GameService gameService;

    @RequestMapping(value = "/getGameList", method = RequestMethod.GET)
    public @ResponseBody
    JSONObject getGameList() {
        List<Game> gameList = gameService.getGameList();
        return getSuccess(gameList);
    }

    @RequestMapping(value = "/delGame", method = RequestMethod.GET)
    public @ResponseBody
    JSONObject delGame(String id) {
        boolean flag = gameService.delGameById(id);
        return getSuccess(flag);
    }

    @RequestMapping(value = "/addGame")
    public @ResponseBody
    JSONObject addGame(@RequestBody Game game) {
        boolean flag = gameService.addGame(game);
        return getSuccess(flag);
    }

    @RequestMapping(value = "/editGame", method = RequestMethod.POST)
    public @ResponseBody
    JSONObject editGame(@RequestBody Game game) {
        boolean flag = gameService.editGame(game);
        return getSuccess(flag);
    }

    @RequestMapping(value = "/getGameById")
    public @ResponseBody
    JSONObject getGameById(String id) {
        Game game = gameService.getGameById(id);
        return getSuccess(game);
    }
}
