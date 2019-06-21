package models;

public class ZipcodeDTO {

    private String zipcode;
    private String si;
    private String gugun;
    private String dong;
    private String building;
    private String address;

    public ZipcodeDTO() {
    }

    public ZipcodeDTO(String zipcode, String si, String gugun, String dong, String building, String address) {
        this.zipcode = zipcode;
        this.si = si;
        this.gugun = gugun;
        this.dong = dong;
        this.building = building;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getSi() {
        return si;
    }

    public void setSi(String si) {
        this.si = si;
    }

    public String getGugun() {
        return gugun;
    }

    public void setGugun(String gugun) {
        this.gugun = gugun;
    }

    public String getDong() {
        return dong;
    }

    public void setDong(String dong) {
        this.dong = dong;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }


    @Override
    public String toString() {
        return "ZipcodeDTO{" +
                "zipcode='" + zipcode + '\'' +
                ", si='" + si + '\'' +
                ", gugun='" + gugun + '\'' +
                ", dong='" + dong + '\'' +
                ", building='" + building + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
