package A;

import java.io.Serializable;
import java.util.ArrayList;

public class RewardProgram implements Manage<RewardProgram>, Serializable {

    private String Id;
    private int Ordre_Numbers;
    private String GiftName;
    private DatabaseFile Database = new DatabaseFile();
    private static final String REWARD_PROGRAM_FILE_PATH = "RewardPrograms.bin";
    private static ArrayList<RewardProgram> RewardPrograms = new ArrayList();

    public RewardProgram() {
    }

    public RewardProgram(String Id, int Ordre_Numbers, Gift Prize) {
        this.Id = Id;
        this.Ordre_Numbers = Ordre_Numbers;

    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public int getOrdre_Numbers() {
        return Ordre_Numbers;
    }

    public void setOrdre_Numbers(int Ordre_Numbers) {
        this.Ordre_Numbers = Ordre_Numbers;
    }

    public String getGiftName() {
        return GiftName;
    }

    public void setGiftName(String GiftName) {
        this.GiftName = GiftName;
    }

    @Override
    public boolean putInFile() {
        return Database.input(REWARD_PROGRAM_FILE_PATH, RewardPrograms);
    }

    @Override
    public void getFromFile() {
        RewardPrograms = (ArrayList<RewardProgram>) Database.output(REWARD_PROGRAM_FILE_PATH);
        if (RewardPrograms == null) {
            RewardPrograms = new ArrayList();
        }
    }

    @Override
    public void add() {
        //getFromFile();
        RewardPrograms.add(this);
        putInFile();
    }

    @Override
    public int search(String Id) {
        getFromFile();
        for (int i = 0; i < RewardPrograms.size(); i++) {
            if (RewardPrograms.get(i).getId().equals(Id)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean delete(String Reward_Program_Id) {
        int index = search(Reward_Program_Id);
        if (index != -1) {
            RewardPrograms.remove(index);
            return putInFile();
        }
        return false;
    }

    @Override
    public void update(String Old_RewardProgram_Id, RewardProgram New_Data) {
        RewardPrograms.get(search(Old_RewardProgram_Id)).delete(Old_RewardProgram_Id);
        New_Data.add();

    }

    @Override
    public ArrayList<RewardProgram> list() {
        getFromFile();
        return RewardPrograms;
    }

    public RewardProgram getRewardProgram(String id) {
        int index = search(id);
        if (index != -1) {
            return RewardPrograms.get(index);
        }
        return null;
    }

}
