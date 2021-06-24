package ru.sibiryakov.project.model;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "securities")
public class InfoAboutSecurities {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "secid")
    private String secId;
    @Column(name = "regnumber")
    private String regNumber;
    @Column(name = "name")
    private String name;
    @Column(name = "emitent_title")
    private String emitentTitle;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "secid")
    List<TradingHistory> listHistory;

    public InfoAboutSecurities(int id, String secId, String regNumber, String name, String emitentTitle) {
        this.id = id;
        this.secId = secId;
        this.regNumber = regNumber;
        this.name = name;
        this.emitentTitle = emitentTitle;
    }

    public List<TradingHistory> getListHistory() {
        return listHistory;
    }

    public void setListHistory(List<TradingHistory> listHistory) {
        this.listHistory = listHistory;
    }

    public void addHistoryOfSecurities(TradingHistory history) {
        if (listHistory == null) {
            listHistory = new ArrayList<>();
        }
        listHistory.add(history);

    }


    public InfoAboutSecurities() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSecId() {
        return secId;
    }

    public void setSecId(String secId) {
        this.secId = secId;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmitentTitle() {
        return emitentTitle;
    }

    public void setEmitentTitle(String emitentTitle) {
        this.emitentTitle = emitentTitle;
    }

//    @Override
//    public String toString() {
//        return "InfoAboutSecurities{" +
//                "id=" + id +
//                ", secId='" + secId + '\'' +
//                ", regNumber='" + regNumber + '\'' +
//                ", name='" + name + '\'' +
//                ", emitentTitle='" + emitentTitle + '\'' +
//                ", listHistory=" + listHistory +
//                '}';
//    }
}
