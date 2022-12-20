package PonyLand.PonyLand.service;

import PonyLand.PonyLand.dao.GameDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    GameDAO dao;
}
