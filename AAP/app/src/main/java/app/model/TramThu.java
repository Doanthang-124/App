package app.model;

import java.io.Serializable;

public class TramThu  implements Serializable {
    private  String diaChi;
    private  int iconNhietDo;
    private  int iconDoAm;
    private  int iconBui;
    private  int iconCo2;

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getIconNhietDo() {
        return iconNhietDo;
    }

    public void setIconNhietDo(int iconNhietDo) {
        this.iconNhietDo = iconNhietDo;
    }

    public int getIconDoAm() {
        return iconDoAm;
    }

    public void setIconDoAm(int iconDoAm) {
        this.iconDoAm = iconDoAm;
    }

    public int getIconBui() {
        return iconBui;
    }

    public void setIconBui(int iconBui) {
        this.iconBui = iconBui;
    }

    public int getIconCo2() {
        return iconCo2;
    }

    public void setIconCo2(int icoCo2) {
        this.iconCo2 = icoCo2;
    }

    public TramThu(String diaChi, int iconNhietDo, int iconDoAm, int iconBui, int iconCo2) {
        this.diaChi = diaChi;
        this.iconNhietDo = iconNhietDo;
        this.iconDoAm = iconDoAm;
        this.iconBui = iconBui;
        this.iconCo2 = iconCo2;
    }

    public TramThu() {
    }
}
