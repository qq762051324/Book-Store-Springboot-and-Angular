package com.yiwen.demo.Entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name="t_book")
public class Book {
    /**
     * strategy : identity 由于mysql自动增长所以它传null就好 sequence 序列 底层数据库支持序列 适用于oracle(无自增)
     *              table 通过一张数据表的形式 auto 由程序自动帮我们生成主键
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="unit_price")
    private BigDecimal unitPrice;
    @Column(name="created_on")
    private Date createdOn;
    @Column(name = "img_url")
    private String imgUrl;
    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false)
    private BookCategory category;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public BookCategory getCategory() {
        return category;
    }

    public void setCategory(BookCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                ", createdOn=" + createdOn +
                ", imgUrl='" + imgUrl + '\'' +
                ", category=" + category +
                '}';
    }
}
