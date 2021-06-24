package ru.sibiryakov.project.model;

import javax.persistence.*;


@Entity
@Table(name = "history")
public class TradingHistory {

    @Id
    @Column(name = "secid")
    private String secId;
    @Column(name = "tradedate")
    private String tradeDate;
    @Column(name = "numtrades")
    private String numTrades;
    @Column(name = "open")
    private String open;
    @Column(name = "close")
    private String close;

    public TradingHistory(String secId, String tradeDate, String numTrades, String open, String close) {
        this.secId = secId;
        this.tradeDate = tradeDate;
        this.numTrades = numTrades;
        this.open = open;
        this.close = close;
    }

    public TradingHistory() {
    }


    public String getSecId() {
        return secId;
    }

    public void setSecId(String secId) {
        this.secId = secId;
    }

    public String getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }

    public String getNumTrades() {
        return numTrades;
    }

    public void setNumTrades(String numTrades) {
        this.numTrades = numTrades;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    @Override
    public String toString() {
        return "secId='" + secId + '\'' +
                ", tradeDate='" + tradeDate + '\'' +
                ", numTrades='" + numTrades + '\'' +
                ", open='" + open + '\'' +
                ", close='" + close + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(o instanceof TradingHistory){
        TradingHistory history =(TradingHistory) o;
        return history.getSecId().equals(secId) && history.getTradeDate().equals(tradeDate)
                && history.getNumTrades().equals(numTrades) && history.getOpen().equals(open)
                && history.close.equals(close); }
        return false;

    }

}
