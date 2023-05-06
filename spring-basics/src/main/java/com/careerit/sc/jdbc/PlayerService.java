package com.careerit.sc.jdbc;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PlayerService {

    private final PlayerDao playerDao;

    public void showPlayerCount(){
        System.out.println("Player count :"+playerDao.count());
    }
}
