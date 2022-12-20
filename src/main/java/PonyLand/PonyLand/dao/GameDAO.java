package PonyLand.PonyLand.dao;

import PonyLand.PonyLand.Mapper.GameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GameDAO {

    @Autowired
    GameMapper GameMapper;
}
