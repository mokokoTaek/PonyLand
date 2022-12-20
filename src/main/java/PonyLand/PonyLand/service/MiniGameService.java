package PonyLand.PonyLand.service;

import PonyLand.PonyLand.dao.MiniGameDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MiniGameService {

    @Autowired
    MiniGameDAO dao;
}
