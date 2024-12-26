package respon;

import entity.MobileXT;
import entity.MobileXT;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MobileXTrespon {
    public static final String MOBILES_CSV = "src/main/java/data/mobiles.csv";
    public List<MobileXT> findAll() {
        File file = new File(MOBILES_CSV);
        List<MobileXT> mobileXTs = new ArrayList<>();
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            String[] temp;
            while ((line = bufferedReader.readLine()) != null) {
                temp = line.split(",");
                try {
                    if (temp.length >= 7) {
                        int id = Integer.parseInt(temp[0]);
                        String name = temp[1];
                        int price = Integer.parseInt(temp[2]);
                        int number = Integer.parseInt(temp[3]);
                        String production = temp[4];
                        String country = temp[5];
                        String status = temp[6];

                        MobileXT mobileXT = new MobileXT(id, name, price, number, production, country, status);
                        mobileXTs.add(mobileXT);
                    } else {
                        System.out.println("Dòng không đủ dữ liệu, bỏ qua: " + line);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Dòng không hợp lệ, bỏ qua: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file.");
        } catch (IOException e) {
            System.out.println("Lỗi đọc file.");
        }
        return mobileXTs;
    }

    public void save(MobileXT mobileXT) {
        File file = new File(MOBILES_CSV);
        try(FileWriter fileWriter = new FileWriter(file,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){
            bufferedWriter.write(mobileChtoString(mobileXT));
            bufferedWriter.newLine();
        } catch (IOException e) {
            System.out.println("Loi ghi file");
        }
    }
    private String mobileChtoString(MobileXT mobileXT){
        return mobileXT.getId()+","+mobileXT.getName()+","+mobileXT.getPrice()+","+mobileXT.getNumber()+","+mobileXT.getProduction()+","+mobileXT.getCountry()+","+mobileXT.getStatus();
    }
    public MobileXT findByID(int id){
        List<MobileXT> mobileXTs = findAll();
        for (MobileXT mobileXT : mobileXTs){
            if (mobileXT.getId() == id){
                return mobileXT;
            }
        }
        return null;
    }
    public List<MobileXT> findByName(String name) {
        List<MobileXT> mobileXTs = findAll();
        List<MobileXT> newMobilext = new ArrayList<>();
        for (MobileXT mobileCH : mobileXTs) {
            if (mobileCH.getName().contains(name)) {
                newMobilext.add(mobileCH);
            }
        }
        return newMobilext;
    }
    public void remove(int id){
        List<MobileXT> mobileXTs = findAll();
        mobileXTs.removeIf(mobileCH -> mobileCH.getId() == id);
        writeFile(mobileXTs,false);
    }
    public void writeFile(List<MobileXT> mobileXTs,boolean t ) {
        File file = new File(MOBILES_CSV);
        try(FileWriter fileWriter = new FileWriter(file,t);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (MobileXT mobileXT : mobileXTs){
                bufferedWriter.write(mobileChtoString(mobileXT));
                bufferedWriter.newLine();
            }
        }catch (IOException e) {
            System.out.println("Loi ghi file");
        }
    }
}
