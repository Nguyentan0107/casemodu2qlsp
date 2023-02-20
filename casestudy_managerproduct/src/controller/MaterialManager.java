package controller;

import model.Phone;
import storage.ReadWriteFile;
import java.io.IOException;
import java.util.List;

public class MaterialManager {
    List<Phone> materialList = ReadWriteFile.readFile();

    public MaterialManager() {
        this.materialList = materialList;
    }

    public List<Phone> getMaterialList() {
        return materialList;
    }

    public void setMaterialList(List<Phone> materialList) {
        this.materialList = materialList;
    }
//Thêm sản phẩm vào arraylist.
    public void addNewMaterial(Phone material) throws IOException {
        this.materialList.add(material);
        ReadWriteFile.writeFile(materialList);
    }
//Hiển thị sản phẩm.
    public void showMaterial() {
        for (Phone o: materialList) {
            System.out.println(o);
        }
    }
//Xóa sản phẩm.
    public void deleteProductByID(String id) throws IOException {
        for (Phone o : materialList) {
            if (id.equals(o.getId())) {
                System.out.println(o);
                materialList.remove(o);
                ReadWriteFile.writeFile(materialList);
                break;
            }
        }
    }

//Tìm sản phẩm theo id.
    public void findProduct(String id) throws IOException {
        for (Phone o : materialList) {
            if (id.equals(o.getId())) {
                System.out.println(o);
            }
        }
    }
//Sửa sản phẩm.
    public void editProduct(String id, Phone phone) throws IOException {
        for (int i = 0; i < materialList.size(); i++) {
            if(id.equals(materialList.get(i).getId())){
                System.out.println(i);
                materialList.set(i,phone);
                System.out.println(i);

            }

        }
        ReadWriteFile.writeFile(materialList);
    }
}
