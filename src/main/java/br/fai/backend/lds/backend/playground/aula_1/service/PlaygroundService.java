package br.fai.backend.lds.backend.playground.aula_1.service;

import br.fai.backend.lds.backend.playground.aula_1.UserPlayground1;
import br.fai.backend.lds.backend.playground.aula_1.dao.PlaygroundDao;

public class PlaygroundService {

    PlaygroundDao playgroundDao = new PlaygroundDao();

    public UserPlayground1 find(){
        UserPlayground1 user = playgroundDao.fetchData();

        user.setId(user.getId() + 100);
        user.setName(user.getName() + " joao da silva");
        user.setEmail("email alterado" + user.getEmail());

        return user;
    }
}
