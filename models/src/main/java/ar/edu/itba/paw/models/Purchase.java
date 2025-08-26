package ar.edu.itba.paw.models;

import lombok.Getter;

import java.util.Date;

@Getter
public class Purchase {
    private final long id;
    private final Buyer buyer;
    private final Vinyl vinyl;
    private final String status;
    private final float price;
    private final Date createdAt;
    private final Date paidAt;
    private final Date paymentReceivedAt;
    private final Date sentAt;
    private final Date deliveredAt;
    public Purchase(long id, Buyer buyer, Vinyl vinyl, String status, float price, Date createdAt, Date paidAt, Date paymentReceivedAt, Date sentAt, Date deliveredAt) {
        this.id = id;
        this.buyer = buyer;
        this.vinyl = vinyl;
        this.status = status;
        this.price = price;
        this.createdAt = createdAt;
        this.paidAt = paidAt;
        this.paymentReceivedAt = paymentReceivedAt;
        this.sentAt = sentAt;
        this.deliveredAt = deliveredAt;
    }
}
