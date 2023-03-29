package service;

public class IdGenerator {
    private static IdGenerator idGenerator;
    private IdGenerator(){}
    private int id = 1;

    public static IdGenerator getIdGenerator(){
        if(idGenerator == null){
            synchronized (IdGenerator.class){
                if(idGenerator == null){
                    idGenerator = new IdGenerator();
                }
            }
        }
        return idGenerator;
    }

    public int generateId(){
        return id++;
    }
}
