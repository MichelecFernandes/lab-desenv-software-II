package br.fai.backend.lds.backend.main.dao.fake;

import br.fai.backend.lds.backend.main.domain.UserModel;
import br.fai.backend.lds.backend.main.port.dao.user.UserDao;
import org.apache.catalina.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserFakeDaoImpl implements UserDao {
    private static List<UserModel> users = new ArrayList<>();

    private static int ID = 0;
    private int getNextId(){
        ID += 1;
        return ID;
    }

    public UserFakeDaoImpl(){
        System.out.println("Instanciua de user fake dao obtida");

        UserModel user1 = new UserModel();
        user1.setId(getNextId());
        user1.setEmail("fessor@fessor.com");
        user1.setFullName("fessor0000");
        user1.setPassword("0000");

        UserModel user2 = new UserModel();
        user2.setId(getNextId());
        user2.setEmail("fessor@1111.com");
        user2.setFullName("fessor1111");
        user2.setPassword("1111");

        UserModel user3 = new UserModel();
        user3.setId(getNextId());
        user3.setEmail("fessor@2222.com");
        user3.setFullName("fessor2222");
        user3.setPassword("2222");

        UserModel user4 = new UserModel();
        user4.setId(getNextId());
        user4.setEmail("fessor@3333.com");
        user4.setFullName("fessor3333");
        user4.setPassword("3333");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

    }


    @Override
    public int add(UserModel entity) {
        final int id = getNextId();
        entity.setId(id);
        users.add(entity);
        return id;
    }

    @Override
    public void remove(int id) {
        int itemIndex = -1;

        for(int i = 0; i < users.size(); i++){
            UserModel user = users.get(i);
            if(user.getId() == id) {
                itemIndex = i;
                break;
            }

        }

    if(itemIndex == -1){
        return;
    }

    UserModel removeEntity = users.remove(itemIndex);
    System.out.println("O usuario " + removeEntity.getFullName() + " foi removido. ID do usuario removido: " + removeEntity.getId());

    }

    @Override
    public UserModel readyById(int id) {
        for(UserModel user: users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    @Override
    public List<UserModel> readAll() {
        return users;
    }

    @Override
    public void updateInformation(int id, UserModel entity) {
        UserModel user = readyById(id);
        user.setFullName(entity.getFullName());


    }

    @Override
    public UserModel readByEmail(String email) {
        for(UserModel user : users){
            if(user.getEmail().equalsIgnoreCase((email))){
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean updatePassword(int id, String newPassword) {
        UserModel user = readyById(id);
        user.setPassword(newPassword);
        return true;
    }
}
