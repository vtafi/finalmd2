package respon;

import entity.Mobile;
import entity.MobileCH;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MobileCHrespon {
    public static final String MOBILES_CSV = "src/main/java/data/mobiles.csv";
    public List<MobileCH> findAll() {
        File file = new File(MOBILES_CSV);
        List<MobileCH> mobileCHs = new ArrayList<>();
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            String[] temp;
            while ((line = bufferedReader.readLine()) != null) {
                temp = line.split(",");
                try {
                    int dateBh = Integer.parseInt(temp[5]);
                    String pvBh = temp[6];

                    MobileCH mobileCH = new MobileCH(
                            Integer.parseInt(temp[0]),
                            temp[1],
                            Integer.parseInt(temp[2]),
                            Integer.parseInt(temp[3]),
                            temp[4],
                            dateBh,
                            pvBh
                    );
                    mobileCHs.add(mobileCH);
                } catch (NumberFormatException e) {
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file.");
        } catch (IOException e) {
            System.out.println("Lỗi đọc file.");
        }
        return mobileCHs;
    }
    public void save(MobileCH mobileCH) {
        File file = new File(MOBILES_CSV);
        try(FileWriter fileWriter = new FileWriter(file,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){
            bufferedWriter.write(mobileChtoString(mobileCH));
            bufferedWriter.newLine();
        } catch (IOException e) {
            System.out.println("Loi ghi file");
        }
    }
    private String mobileChtoString(MobileCH mobileCH){
        return mobileCH.getId()+","+mobileCH.getName()+","+mobileCH.getPrice()+","+mobileCH.getNumber()+","+mobileCH.getProduction()+","+mobileCH.getDateBh()+","+mobileCH.getPvBh();
    }
    public MobileCH findByID(int id){
        List<MobileCH> mobileCHs = findAll();
        for (MobileCH mobileCH : mobileCHs){
            if (mobileCH.getId() == id){
                return mobileCH;
            }
        }
        return null;
    }
    public List<MobileCH> findByName(String name) {
        List<MobileCH> mobileCHs = findAll();
        List<MobileCH> newMobilech = new ArrayList<>();
        for (MobileCH mobileCH : mobileCHs) {
            if (mobileCH.getName().contains(name)) {
                newMobilech.add(mobileCH);
            }
        }
        return newMobilech;
    }
    public void remove(int id){
        List<MobileCH> mobileCHs = findAll();
        mobileCHs.removeIf(mobileCH -> mobileCH.getId() == id);
        writeFile(mobileCHs,false);
    }
    public void writeFile(List<MobileCH> mobileCHs,boolean t ) {
        File file = new File(MOBILES_CSV);
        try(FileWriter fileWriter = new FileWriter(file,t);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (MobileCH mobileCH : mobileCHs){
                bufferedWriter.write(mobileChtoString(mobileCH));
                bufferedWriter.newLine();
            }
        }catch (IOException e) {
            System.out.println("Loi ghi file");
        }
    }
}
