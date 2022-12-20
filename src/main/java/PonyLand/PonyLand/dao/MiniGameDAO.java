package PonyLand.PonyLand.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MiniGameDAO {

    @Autowired
    PonyLand.PonyLand.Mapper.MiniGameMapper MiniGameMapper;
}
